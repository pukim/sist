/**
 * 
 */
package sist.data.go.api;

import java.util.HashMap;

import org.apache.http.impl.client.CloseableHttpClient;

/**
 * @author owner
 *
 */
public class RestfullRead {
	private CloseableHttpClient     httpClient;
	private HashMap<String, Object> params;
	
	RestfullRead(CloseableHttpClient httpClient, HashMap<String, Object>params) {
		this.httpClient = httpClient;
		this.params     = params;
	}
	
	private String paramToUrl() {
		String parameters="";
		
		
		return parameters;
	}
	
	public String getData() {
		
		
		return paramToUrl();
	}
}
