/**
 * 
 */
package sist.token;

import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.io.CachedOutputStream;

public class CallRestWS {
	private String restClient() throws Exception{
		             
		String parameter = "";
		//String addr = "http://openapi.airport.kr/openapi/service/StatusOfPassengerFlights/getPassengerDepartures"+"?ServiceKey=";
		String addr = "/openapi/service/StatusOfPassengerArrivalsEN/getPassengerArrivalsEN";
		String serviceKey = "YcoW7BSLwCQSZej0ziSIdrK6udQyleQhp7fvTpKM3iRDD3Ox4dEnOhD4BsraHoFhvMxBx%2FZjZRDfozLZlQCm2g%3D%3D";
//	    String serviceKey =	"YcoW7BSLwCQSZej0ziSIdrK6udQyleQhp7fvTpKM3iRDD3Ox4dEnOhD4BsraHoFhvMxBx/ZjZRDfozLZlQCm2g==";

		//addr = "http://openapi.airport.kr/openapi/service/StatusOfCargoFlights/getCargoArrivals"+"?ServiceKey=";
		//serviceKey = "yPo3PuvE1sQkpdCvurcISjsT4fLb1ELGDxfNWCO5Lc3e5n5JN7sehR0FKB408%2BnNiKCH38hGFLwl%2F7FIIAi6WQ%3D%3D";

		
		//인증키(서비스키) url인코딩
		//serviceKey = URLEncoder.encode(serviceKey, "UTF-8");
		
		/* 
		parameter = parameter + "&" + "from_time = 0000";
		parameter = parameter + "&" + "to_time   = 2400";
		parameter = parameter + "&" + "airport   = HKG";
		parameter = parameter + "&" + "flight_id = KE846";
		parameter = parameter + "&" + "airline   = KE";
		parameter = parameter + "&" + "lang      = K";  
		*/

		
		// 놀이 시설 
		/*
		String addr = "http://openapi.cpf.go.kr/openapi/service/rest/ChildPlyFcltSafeInspctStatsInfoService/getSafeInspctStatsInfo"+"?ServiceKey=";
		String serviceKey = "YcoW7BSLwCQSZej0ziSIdrK6udQyleQhp7fvTpKM3iRDD3Ox4dEnOhD4BsraHoFhvMxBx%2FZjZRDfozLZlQCm2g%3D%3D";		
		
		
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
		
		addr = addr + serviceKey + parameter;
		
		URL url = new URL(addr);
		InputStream in = url.openStream(); 
		CachedOutputStream bos = new CachedOutputStream();
		IOUtils.copy(in, bos);
		in.close();
		bos.close();
		return bos.getOut().toString();
	}
	
	public static void main(String[] args) {
		try {
			CallRestWS call = new CallRestWS();
			System.out.println(call.restClient());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
