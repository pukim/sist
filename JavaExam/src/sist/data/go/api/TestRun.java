/**
 * 
 */
package sist.data.go.api;

import java.util.HashMap;
import java.util.Properties;

/**
 * @author owner
 *
 */
public class TestRun {
 	
	public void incheonAirportAPI() {
		try {
			String host = "openapi.airport.kr";
			int port    = 80;
			HashMap<String, Object> hm  = new HashMap<String, Object>();
			
			hm.put("from_time", "0000");
			hm.put("to_time"  , "2400");
			hm.put("airport"  , "PEK");
			hm.put("flight_id", "KE854");
			hm.put("airline"  , "KE");
			hm.put("lang"     , "K");
			  
			
			RestfullRead rfr = new RestfullRead(host, port, hm);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			rfr.getValue("openapi/service/StatusOfPassengerArrivalsEN", "getPassengerArrivalsEN");
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			rfr.getValue("openapi/service/StatusOfPassengerArrivalsKR", "getPassengerArrivalsKR");
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

			rfr.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void otherAPI() {
		try {
			String host = "openapi.cpf.go.kr";
			int port    = 80;
			HashMap<String, Object> hm  = new HashMap<String, Object>();
			
			hm.put("ciInstallSt", "2013-01-01");
			hm.put("ciInstallEt", "2013-07-31");
			hm.put("code4", "C001");
			hm.put("code21", "C002");
			hm.put("code15", "Q002");
			hm.put("code1", "A003");
			hm.put("searchArea1", "1100000000");
			hm.put("searchArea2", "1121500000");
			hm.put("statuteYn", "Y");
			
			
			RestfullRead rfr = new RestfullRead(host, port, hm);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			rfr.getValue("openapi/service/rest/ChildPlyFcltSafeInspctStatsInfoService", "getSafeInspctStatsInfo");
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			
			rfr.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		TestRun tr = new TestRun();
		
		tr.incheonAirportAPI();
		tr.otherAPI();
		
	}
}
