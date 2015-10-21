/**
 * 
 */
package sist.token;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetClientGet {

	// http://localhost:8080/RESTfulExample/json/product/get
	public static void main(String[] args) {

	  try {
		  
		  /*
		String addr = "http://openapi.cpf.go.kr/openapi/service/rest/ChildPlyFcltSafeInspctStatsInfoService/getSafeInspctStatsInfo"+"?ServiceKey=";
		String serviceKey = "YcoW7BSLwCQSZej0ziSIdrK6udQyleQhp7fvTpKM3iRDD3Ox4dEnOhD4BsraHoFhvMxBx%2FZjZRDfozLZlQCm2g%3D%3D";		
		String parameter="";
		
		parameter = parameter + "&" + "ciInstallSt = 2013-01-01";
		parameter = parameter + "&" + "ciInstallEt = 2013-07-31";
		parameter = parameter + "&" + "code4       = C001";
		parameter = parameter + "&" + "code21      = C002";
		parameter = parameter + "&" + "code15      = Q002";
		parameter = parameter + "&" + "code1       = A003";
		parameter = parameter + "&" + "searchArea1 = 1100000000";
		parameter = parameter + "&" + "searchArea2 = 1121500000";
		parameter = parameter + "&" + "statuteYn   = Y";
		 */
		  
		String addr = "http://openapi.airport.kr/openapi/service/StatusOfPassengerArrivalsEN/getPassengerArrivalsEN"+"?ServiceKey=";
		String serviceKey = "YcoW7BSLwCQSZej0ziSIdrK6udQyleQhp7fvTpKM3iRDD3Ox4dEnOhD4BsraHoFhvMxBx%2FZjZRDfozLZlQCm2g%3D%3D";
		String parameter="";
		
			parameter = parameter + "&" + "from_time = 0000";
			parameter = parameter + "&" + "to_time   = 2400";
			parameter = parameter + "&" + "airport   = HKG";
			parameter = parameter + "&" + "flight_id = KE846";
			parameter = parameter + "&" + "airline   = KE";
			 
		
		addr = addr + serviceKey + parameter;
				  

		//URL url = new URL("http://localhost:8080/RESTfulExample/json/product/get");
		URL url = new URL(addr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/xml");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }

	}

}
