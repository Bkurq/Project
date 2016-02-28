package client;
import java.net.*;
import java.io.*;

import javax.net.SocketFactory;
import javax.net.ssl.*;
import javax.security.cert.X509Certificate;
import java.security.KeyStore;
import java.security.cert.*;
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

    public static void main(String[] args) throws Exception {
        String host = null;
        int port = -1;
        for (int i = 0; i < args.length; i++) {
           System.out.println("args[" + i + "] = " + args[i]);
        }
        if (args.length < 2) {
            System.out.println("USAGE: java client host port");
            System.exit(-1);
        }
        try { /* get input parameters */
            host = args[0];
            port = Integer.parseInt(args[1]);
        } catch (IllegalArgumentException e) {
            System.out.println("USAGE: java client host port");
            System.exit(-1);
        }

        try { /* set up a key manager for client authentication */
            //SSLSocketFactory factory = null;
//            try {
//                char[] password = "password".toCharArray();
//                KeyStore ks = KeyStore.getInstance("JKS");
//                KeyStore ts = KeyStore.getInstance("JKS");
//                KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
//                TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
//                SSLContext ctx = SSLContext.getInstance("TLS");
//                //ks.load(new FileInputStream("clientkeystore"), password);  // keystore password (storepass)
//                
//                //Laddar keystoren med namn ks_username med userns password.
//                ks.load(new FileInputStream("e:\\Documents\\Skola\\Datas�kerhet\\Project\\Project2\\src\\client\\ks_"+args[2]),args[3].toCharArray()); //keystore password = userpassword
//				ts.load(new FileInputStream("e:\\Documents\\Skola\\Datas�kerhet\\Project\\Project2\\src\\client\\ts_"+args[2]),args[3].toCharArray()); // truststore password (storepass);
//				//kmf.init(ks, password); // user password (keypass)
//				kmf.init(ks,args[3].toCharArray());
//				tmf.init(ts); // keystore can be used as truststore here
//				ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
//                factory = ctx.getSocketFactory();
//            } catch (Exception e) {
//                throw new IOException(e.getMessage());
//            }
            //SSLSocket socket = (SSLSocket)factory.createSocket(host, port);
            Socket socket = new Socket("localhost", port);
            System.out.println("\nsocket before handshake:\n" + socket + "\n");

            /*
             * send http request
             *
             * See SSLSocketClient.java for more information about why
             * there is a forced handshake here when using PrintWriters.
             */
//            socket.startHandshake();
//
//            SSLSession session = socket.getSession();
//            X509Certificate cert = (X509Certificate)session.getPeerCertificateChain()[0];
//            String subject = cert.getSubjectDN().getName();
            
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Scanner input = new Scanner(System.in);
            Object message = null;
            while (true) {
                System.out.print(">:");
                String s = input.nextLine();
                System.out.print("sending '" + s + "' to server...");
                out.writeObject(s);
                out.flush();
                message = in.readObject();
                if(message instanceof String) {
			    	message = (String) message;
			    	System.out.println("received '" + message + "' from server\n");
			    	if(message.equals("break"))
			    		break;
			    } else {
			    	System.out.println("Answer not a string");
			    }
            }
            in.close();
			out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
