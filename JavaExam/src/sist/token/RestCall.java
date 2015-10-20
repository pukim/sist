/**
 * 
 */
package sist.token;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.apache.http.HttpException;
import org.apache.http.client.HttpClient;


/**
 * @author owner
 *
 */
public class RestCall {
	
	
	public static void main(String[] args) {
		String apiUrl = "http://openapi.airport.kr/openapi/service/StatusOfCargoArrivalsKR/getCargoArrivalsKR";

		String ServiceKey = "yPo3PuvE1sQkpdCvurcISjsT4fLb1ELGDxfNWCO5Lc3e5n5JN7sehR0FKB408%2BnNiKCH38hGFLwl%2F7FIIAi6WQ%3D%3D";
		String from_time = "0000";
		String to_time = "2400";
		String airport = "HKG";
		String flight_id = "KE847";
		String airline = "KE";
		String lang = "";
		
		apiUrl += "?ServiceKey="+ServiceKey+"&from_time="+from_time+"&to_time="+to_time+"&airport="+airport+"&flight_id="+flight_id+"&airline="+airline;
		
		HttpClient httpClient = new HttpClient();
		
	//	httpClient.getParams().setContentCharset("utf-8");
		//httpClient.setParams(params);
		
	
		
		//GetMethod  httpGet = new GetMethod(apiUrl);
		GetMethod  httpGet = new GetMethod(apiUrl);
		
	//	httpGet.addRequestHeader("accept", "application/xml");

		int status=-100;
		InputStream instream = null;
		PrintStream prtStream = null;
		
		int retByte = 0;
		byte[] buffer = new byte[4096];
		
		try {
			status = httpClient.executeMethod(httpGet);
			
			 System.out.println("status :" + status);
			 if(status == 200) {
				 String s = httpGet.getResponseBodyAsString();
				 System.out.println(s);
				 
				 instream = httpGet.getResponseBodyAsStream();
				 InputStreamReader isr = new InputStreamReader(instream);
				 BufferedReader reader = new BufferedReader(isr);
				 
				 String line="";
				 StringBuffer result = new StringBuffer();

				 while((line = reader.readLine()) != null){
					result.append(line);
				 }
				 
				 System.out.println(result.toString());
				 
			 }
			 
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 
		

	}
}
