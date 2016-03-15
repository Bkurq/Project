package server;
import java.io.*;
import java.net.*;
import java.security.KeyStore;
import java.util.ArrayList;

import javax.net.*;
import javax.net.ssl.*;
import javax.security.cert.X509Certificate;

import recordManagement.Log;
import recordManagement.Record;
import recordManagement.RecordManager;
import usermanagement.DoctorUser;
import usermanagement.GovernmentUser;
import usermanagement.NurseUser;
import usermanagement.PatientUser;
import usermanagement.User;

public class Server implements Runnable {
    private ServerSocket serverSocket = null;
    private RecordManager recordManager;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Log log;
    private ArrayList<Record> sent;
    private User user;

    public Server(ServerSocket ss) throws IOException {
    	log = new Log("log.txt");
    	serverSocket = ss;
        run();
	}

	public void run() {
		while (true) {
			try {
				recordManager = new RecordManager("records", log);
				SSLSocket socket = (SSLSocket) serverSocket.accept();
				SSLSession session = socket.getSession();
				X509Certificate cert = (X509Certificate) session.getPeerCertificateChain()[0];
				String subject = cert.getSubjectDN().getName();
				String[] parts = subject.split("\\s+");
				parts[0] = parts[0].substring(3);
				parts[2] = parts[2].substring(0, parts[2].length() - 1);
				if (parts[0].equals("gov")) {
					user = new GovernmentUser("gov");
				} else if (parts[0].equals("doctor2") && parts[2].equals("diagnostik")) {
					user = new DoctorUser("doctor1", "diagnostik");
				} else if (parts[0].equals("doctor2") && parts[2].equals("medicin")) {
					user = new DoctorUser("doctor2", "medicin");
				} else if (parts[1].equals("NURSE")) {
					user = new NurseUser(parts[0], parts[2]);
				} else if (parts[1].equals("PATIENT")) {
					user = new PatientUser(parts[0]);
				}
				if (user == null) {
					System.out.println("user null");
				}

				out = new ObjectOutputStream(socket.getOutputStream());
				in = new ObjectInputStream(socket.getInputStream());
				out.writeObject(user);
				out.flush();
				System.out.println("Handling request");
				Object message = null;
				while (true) {
					message = in.readObject();
					System.out.println(message);
					if (message instanceof String) {
						message = (String) message;
						if (message.equals("getrecords")) {
							sent = recordManager.getRecords(user);
							out.writeObject(sent);
							out.flush();
						} else if (message.equals("getrecord")) {
							int index = (int) in.readObject();
							out.writeObject(recordManager.getRecordAtIndex(user, index));
							out.flush();
						} else if (message.equals("deleterecord")) {
							int index = (int) in.readObject();
							recordManager.deleteRecordAtIndex(user, index);
							recordManager.writeFiles();
						} else if (message.equals("saverecord")) {
							Record record = (Record) in.readObject();
							recordManager.update(user, record);
							recordManager.writeFiles();
						} else if (message.equals("savenewrecord")) {
							Record record = (Record) in.readObject();
							recordManager.addNewRecord(user, record);
							recordManager.writeFiles();
						} else if (message.equals("getlog")) {
							out.writeObject(log.getLog());
							out.flush();
						} else if (message.equals("end")) {
							break;
						}
					}

				}
				in.close();
				out.close();
				socket.close();
			} catch (IOException e) {
				System.out.println("Client died: " + e.getMessage());
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("Class not found");
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("A pirate be messing with da server");
				e.printStackTrace();
			}
		}
	}

    public static void main(String args[]) {
        System.out.println("\nServer Started" + "\n");
        int port = -1;
        if (args.length >= 1) {
            port = Integer.parseInt(args[0]);
        }
        String type = "TLS";
        try {
            ServerSocketFactory ssf = getServerSocketFactory(type);
            ServerSocket ss = ssf.createServerSocket(port);
            ((SSLServerSocket)ss).setNeedClientAuth(true);
            new Server(ss);
        } catch (IOException e) {
            System.out.println("Unable to start Server: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static ServerSocketFactory getServerSocketFactory(String type) {
        if (type.equals("TLS")) {
            SSLServerSocketFactory ssf = null;
            try { // set up key manager to perform server authentication
                SSLContext ctx = SSLContext.getInstance("TLS");
                KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
                TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
                KeyStore ks = KeyStore.getInstance("JKS");
				KeyStore ts = KeyStore.getInstance("JKS");
                char[] password = "password".toCharArray();

                ks.load(new FileInputStream("src/server/serverkeystore2"), password);  // keystore password (storepass)
                ts.load(new FileInputStream("src/server/servertruststore2"), password); // truststore password (storepass)
                kmf.init(ks, password); // certificate password (keypass)
                tmf.init(ts);  // possible to use keystore as truststore here
                ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
                ssf = ctx.getServerSocketFactory();
                return ssf;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            return ServerSocketFactory.getDefault();
        }
        return null;
    }
}
