/**
 * 
 */
package sist.data.go.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author owner
 *
 */
public class RestfullRead {
	private Constants            cons       = Constants.getInstance();
	private CloseableHttpClient  httpClient;
	
	private String               host;
	private String               urlParams;
	private int                  port;
	
	
	RestfullRead(String host, int port, HashMap<String, Object>params) {
		this.host       = host;
		this.port       = port;
	    this.urlParams  = params2Url(params);
	    
	    this.httpClient = HttpClients.createDefault();
	}
	
	private String params2Url(HashMap<String, Object> params) {
		StringBuilder sb = new StringBuilder();
		
		for(Map.Entry<String, Object> entry : params.entrySet()) {
			String key = entry.getKey();
			String val = (String)entry.getValue();
			
			sb.append("&"+key+"="+val);
		}
			
		return sb.toString();
	}
	
	public String getValue(String servicePath, String method) throws ClientProtocolException, IOException {
		String       apiParams    = "/" + servicePath + "/" + method      + 
				                    cons.getServiceKey() + 
	                                this.urlParams;
		
		
		System.out.println(apiParams);
		
	    HttpHost     target       = new HttpHost(this.host, this.port, "http");
		HttpGet      getRequest   = new HttpGet(apiParams);
		
		HttpResponse httpResponse = httpClient.execute(target, getRequest);
	    HttpEntity   entity       = httpResponse.getEntity();
	    
	    String receiveString      = null;
	    
        System.out.println("----------------------------------------");
        System.out.println(httpResponse.getStatusLine());
        Header[] headers = httpResponse.getAllHeaders();
        
        for (int i = 0; i < headers.length; i++) {
           System.out.println(headers[i]);
        }
        
        System.out.println("----------------------------------------");
 
        if (entity != null) {
        	receiveString = EntityUtils.toString(entity, "UTF-8");
           System.out.println(receiveString);
        }
        
        return receiveString;
	}
	
	public void close() {
		try {
			httpClient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
