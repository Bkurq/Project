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
    	recordManager = new RecordManager("records", log);
    	user = user = new DoctorUser("Doctor5", "Division1");
        serverSocket = ss;
        newListener();
    }

    public void run() {
		while (true) {
			Socket socket;
			try {
				// SSLSocket socket=(SSLSocket)serverSocket.accept();
				// SSLSession session = socket.getSession();
				// X509Certificate cert =
				// (X509Certificate)session.getPeerCertificateChain()[0];
				// String subject = cert.getSubjectDN().getName();
				socket = serverSocket.accept();
				System.out.println("client connected");
				// System.out.println("client name (cert subject DN field): " +
				// subject);

				out = new ObjectOutputStream(socket.getOutputStream());
				in = new ObjectInputStream(socket.getInputStream());

				Object message = null;
				while (true) {
					if (message instanceof String) {
						message = (String) message;
						if(message.equals("getrecords")) {
							sent = recordManager.getRecords(user);
							out.writeObject(sent);
						} else if(message.equals("saverecord")) {
							Record record = (Record) in.readObject();
							recordManager.update(user, record);
						} else if(message.equals("savenewrecord")) {
							Record record = (Record) in.readObject();
							recordManager.addNewRecord(user, record);
						} else if(message.equals("getlog")) {
							out.writeObject(log.getLog());
						} else if(message.equals("logupdate")) {
							log.log((String)in.readObject(), user);
						} else if(message.equals("end")) {
							break;
						}
					}
					recordManager.writeFiles();
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

    private void newListener() { (new Thread(this)).start(); } // calls run()

    public static void main(String args[]) {
        System.out.println("\nServer Started\n");
        int port = -1;
        if (args.length >= 1) {
            port = Integer.parseInt(args[0]);
        }
        String type = "TLS";
        try {
            //ServerSocketFactory ssf = getServerSocketFactory(type);
            //ServerSocket ss = ssf.createServerSocket(port);
            //((SSLServerSocket)ss).setNeedClientAuth(true);
            new Server(new ServerSocket(port));
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

                ks.load(new FileInputStream("e:\\Documents\\Skola\\Datas�kerhet\\Project\\Project2\\src\\server\\serverkeystore2"), password);  // keystore password (storepass)
                ts.load(new FileInputStream("e:\\Documents\\Skola\\Datas�kerhet\\Project\\Project2\\src\\server\\servertruststore2"), password); // truststore password (storepass)
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
