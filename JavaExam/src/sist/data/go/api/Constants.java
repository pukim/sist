/**
 * 
 */
package sist.data.go.api;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 * @author owner
 *
 */
public class Constants {
	private static Constants   instance = null;
	private final  String      configFileName = "sist/data/go/api/config.properties";
	private final  Properties  prop = new Properties();
	
	Constants() {
		init();
	}
	
	private void init() {
		
		InputStream inputStream = null;
		
		try {
			
			inputStream = getClass().getClassLoader().getResourceAsStream(configFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + configFileName + "' not found in the classpath");
			}
 
			Date time = new Date(System.currentTimeMillis());
 
			String version    = prop.getProperty("version");
			String serviceKey = prop.getProperty("serviceKey");
 
			System.out.println("\nProgram Ran on " + time + "\n\n ver =" + version);
			System.out.println("key :" + serviceKey);
			
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static Constants getInstance() {
		if(instance == null) {
			instance = new Constants();
		}
		return instance;
	}
	
	public Properties getProperties() {
		return prop;
	}
	
	public String toString() {
		return String.valueOf(this.hashCode());
	}
	
	
}
