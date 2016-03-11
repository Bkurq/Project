package client;

import java.net.*;
import java.io.*;

import javax.net.SocketFactory;
import javax.net.ssl.*;
import javax.security.cert.X509Certificate;

import recordManagement.Record;
import usermanagement.User;

import java.security.KeyStore;
import java.security.cert.*;
import java.util.ArrayList;
import java.util.Scanner;

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
	private Socket socket;

	public void logIn(String host, int port) throws IOException {
		 /* set up a key manager for client authentication */
			// SSLSocketFactory factory = null;
			// try {
			// char[] password = "password".toCharArray();
			// KeyStore ks = KeyStore.getInstance("JKS");
			// KeyStore ts = KeyStore.getInstance("JKS");
			// KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
			// TrustManagerFactory tmf =
			// TrustManagerFactory.getInstance("SunX509");
			// SSLContext ctx = SSLContext.getInstance("TLS");
			// //ks.load(new FileInputStream("clientkeystore"), password); //
			// keystore password (storepass)
			//
			// //Laddar keystoren med namn ks_username med userns password.
			// ks.load(new
			// FileInputStream("e:\\Documents\\Skola\\Datas�kerhet\\Project\\Project2\\src\\client\\ks_"+args[2]),args[3].toCharArray());
			// //keystore password = userpassword
			// ts.load(new
			// FileInputStream("e:\\Documents\\Skola\\Datas�kerhet\\Project\\Project2\\src\\client\\ts_"+args[2]),args[3].toCharArray());
			// // truststore password (storepass);
			// //kmf.init(ks, password); // user password (keypass)
			// kmf.init(ks,args[3].toCharArray());
			// tmf.init(ts); // keystore can be used as truststore here
			// ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
			// factory = ctx.getSocketFactory();
			// } catch (Exception e) {
			// throw new IOException(e.getMessage());
			// }
			// SSLSocket socket = (SSLSocket)factory.createSocket(host, port);
			socket = new Socket("localhost", port);

			/*
			 * send http request
			 *
			 * See SSLSocketClient.java for more information about why there is
			 * a forced handshake here when using PrintWriters.
			 */
			// socket.startHandshake();
			//
			// SSLSession session = socket.getSession();
			// X509Certificate cert =
			// (X509Certificate)session.getPeerCertificateChain()[0];
			// String subject = cert.getSubjectDN().getName();

			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
			System.out.println("Connection established");
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
	
	public String getLog() {
		try {
			out.writeObject("getlog");
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
			out.writeObject(record);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveNewRecord(Record record) {
		try {
			out.writeObject("savenewrecord");
			out.writeObject(record);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void logUpdate(String action) {
		try {
			out.writeObject("logupdate");
			out.writeObject(action);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void logOut() {
		try {
			out.writeObject("end");
			in.close();
			out.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
