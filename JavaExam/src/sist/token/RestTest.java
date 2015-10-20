package sist.token;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

public class RestTest {
	public static void main(String[] args) 
	{
		
		String apiUrl = "http://openapi.airport.kr/openapi/service/StatusOfCargoArrivalsKR/getCargoArrivalsKR";
		String ServiceKey = "yPo3PuvE1sQkpdCvurcISjsT4fLb1ELGDxfNWCO5Lc3e5n5JN7sehR0FKB408%2BnNiKCH38hGFLwl%2F7FIIAi6WQ%3D%3D";
		/*
		String apiUrl = "http://openapi.airport.kr/openapi/service/StatusOfPassengerArrivalsEN/getPassengerArrivalsEN";
		String ServiceKey = "YcoW7BSLwCQSZej0ziSIdrK6udQyleQhp7fvTpKM3iRDD3Ox4dEnOhD4BsraHoFhvMxBx%2FZjZRDfozLZlQCm2g%3D%3D";
		*/
		String from_time = "0000";
		String to_time = "2400";
		String airport = "HKG";
		String flight_id = "KE846";
		String airline = "KE";
		//String lang = "";
		
		try {
			ServiceKey = URLEncoder.encode(ServiceKey, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		apiUrl += "?ServiceKey="+ServiceKey+"&from_time="+from_time+"&to_time="+to_time+"&airport="+airport+"&flight_id="+flight_id+"&airline="+airline;
		
		try {
			//REST API URL을 읽어들여 결과 출력한다
			URL url = new URL(apiUrl);
			
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is);	//인코딩
			BufferedReader reader = new BufferedReader(isr);
			StringBuffer buffer = new StringBuffer();
			String line = null;
			String tmpStr = null;
			while((line = reader.readLine()) != null){
				tmpStr = line.toString();
				tmpStr = tmpStr.replaceAll(" ", "");
				
				if(!tmpStr.equals("")) buffer.append(line).append("\r\n");
			}
			reader.close();
			
			//REST API 결과값
			String xmlResult = buffer.toString();
			
			System.out.println("RESULT => " + xmlResult);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
