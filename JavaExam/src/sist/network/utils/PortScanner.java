/**
 * 
 */
package sist.network.utils;

import java.net.Socket;

/**
 * @author Administrator
 *
 */
public class PortScanner {
	public static void main(String[] args) {
		int startPort = 0;
		int endPort   = 2000;
		
		for(int i = startPort; i <= endPort; i++) {
			try {
				Socket s = new Socket("127.0.0.1", i);
				System.out.println("Opend : " + i);
				s.close();
			} catch(Exception e) {}
		}
	}
}
