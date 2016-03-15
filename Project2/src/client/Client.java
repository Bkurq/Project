package client;

import java.io.*;

import javax.net.ssl.*;
import javax.security.cert.X509Certificate;

import recordManagement.Record;
import usermanagement.*;

import java.security.KeyStore;
import java.util.ArrayList;

/*
 * This example shows how to set up a key manager to perform client
 * authentication.
 *
 * This program assumes that the client is not inside a firewall.
 * The application can be modified to connect to a server outside
 * the firewall by following SSLSocketClientWithTunneling.java.
 */
public class Client {
	private ObjectOutputStream out; 
	private ObjectInputStream in;
	private SSLSocket socket;

	public User logIn(String host, int port, String userName, char[] password) throws IOException, ClassNotFoundException {
		/* set up a key manager for client authentication */
		SSLSocketFactory factory = null;
		try {
			KeyStore ks = KeyStore.getInstance("JKS");
			KeyStore ts = KeyStore.getInstance("JKS");
			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
			TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
			SSLContext ctx = SSLContext.getInstance("TLS");
			// ks.load(new FileInputStream("clientkeystore"), password);
			// //keystore password (storepass)
			// Laddar keystoren med namn ks_username med userns password.
			ks.load(new FileInputStream("src/client/ks_" + userName), password);
			// keystore password = userpassword
			ts.load(new FileInputStream("src/client/ts_" + userName), password);
			// truststore password (storepass);
			// kmf.init(ks, password); // user password (keypass)
			kmf.init(ks, password);
			tmf.init(ts); // keystore can be used as truststore here
			ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
			factory = ctx.getSocketFactory();
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}
		socket = (SSLSocket) factory.createSocket(host, port);

		/*
		 * send http request
		 *
		 * See SSLSocketClient.java for more information about why there is a
		 * forced handshake here when using PrintWriters.
		 */
		socket.startHandshake();

		SSLSession session = socket.getSession();
		X509Certificate cert = (X509Certificate) session.getPeerCertificateChain()[0];
		System.out.println(cert.getSubjectDN().getName());
		out = new ObjectOutputStream(socket.getOutputStream());
		in = new ObjectInputStream(socket.getInputStream());
		return (User) in.readObject();
	}
	
	public ArrayList<Record> getRecords() {
		try {
			out.writeObject("getrecords");
			out.flush();
			System.out.println("Requesting files");
			return (ArrayList<Record>) in.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Files recieved");
		return null;
	}
	
	public Record getRecord(int index) {
		try {
			out.writeObject("getrecord");
			out.flush();
			out.writeObject(index);
			out.flush();
			return (Record) in.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getLog() {
		try {
			out.writeObject("getlog");
			out.flush();
			return (String) in.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void saveRecord(Record record) {
		try {
			out.writeObject("saverecord");
			out.flush();
			out.writeObject(record);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveNewRecord(Record record) {
		try {
			out.writeObject("savenewrecord");
			out.flush();
			out.writeObject(record);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteRecord(int index) {
		try {
			out.writeObject("deleterecord");
			out.flush();
			out.writeObject(index);
			out.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void logOut() {
		try {
			out.writeObject("end");
			out.flush();
			in.close();
			out.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
