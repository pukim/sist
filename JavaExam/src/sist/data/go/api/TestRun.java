/**
 * 
 */
package sist.data.go.api;

import java.util.Properties;

/**
 * @author owner
 *
 */
public class TestRun {
	private static Constants cons = Constants.getInstance();
	
	public static void main(String[] args) {
		try {
			Properties props = cons.getProperties();
			

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
