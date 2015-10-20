/**
 * 
 */
package sist.rest.example;

import java.net.URLEncoder;

import org.apache.http.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

@SuppressWarnings("deprecation")
public class ApacheHttpRestClient1 {
	 
	  public static void main(String[] args) {
	    DefaultHttpClient httpclient = new DefaultHttpClient();
	    try {
	     	HttpHost target = new HttpHost("openapi.airport.kr", 80, "http");
	    	
	    	String ServiceKey = "yPo3PuvE1sQkpdCvurcISjsT4fLb1ELGDxfNWCO5Lc3e5n5JN7sehR0FKB408%2BnNiKCH38hGFLwl%2F7FIIAi6WQ%3D%3D";
	     	//String ServiceKey = "YcoW7BSLwCQSZej0ziSIdrK6udQyleQhp7fvTpKM3iRDD3Ox4dEnOhD4BsraHoFhvMxBx%2FZjZRDfozLZlQCm2g%3D%3D";
			String from_time  = "0000";
			String to_time    = "2400";
			String airport    = "HKG";
			String flight_id  = "KE846";
			String airline    = "KE";
			String lang = "K";
			
			String serviceId = "/openapi/service/StatusOfCargoArrivalsKR/getCargoArrivalsKR";
			//String serviceId = "/openapi/service/StatusOfPassengerArrivalsEN/getPassengerArrivalsEN";
			
			ServiceKey = URLEncoder.encode(ServiceKey, "UTF-8");
			String apiParams = serviceId+"?ServiceKey="+ServiceKey+"&from_time="+from_time+"&to_time="+to_time+"&airport="+airport+"&flight_id="+flight_id+"&airline="+airline;
		
			
	      // specify the get request
	      HttpGet getRequest = new HttpGet(apiParams);
	 
	      System.out.println("executing request to " + target);
	 
	      HttpResponse httpResponse = httpclient.execute(target, getRequest);
	      HttpEntity entity = httpResponse.getEntity();
	 
	      System.out.println("----------------------------------------");
	      System.out.println(httpResponse.getStatusLine());
	      Header[] headers = httpResponse.getAllHeaders();
	      for (int i = 0; i < headers.length; i++) {
	        System.out.println(headers[i]);
	      }
	      System.out.println("----------------------------------------");
	 
	      if (entity != null) {
	        System.out.println(EntityUtils.toString(entity));
	      }
	 
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      // When HttpClient instance is no longer needed,
	      // shut down the connection manager to ensure
	      // immediate deallocation of all system resources
	      httpclient.getConnectionManager().shutdown();
	    }
	  }
	}
