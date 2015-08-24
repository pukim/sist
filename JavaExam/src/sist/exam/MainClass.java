package sist.exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainClass {
	
	static BufferedReader fin;
	
	public String parseUrl(String s) {
		//List<NameValuePair> params = URLEncodedUtils.parse(new URI(s), "UTF-8");
		String[] query = s.split("\\?");
		String key="";
		String value="";
		
		if(query.length == 2) {
			String[] params = query[1].split("&");
			for(String keys : params) {
				String[] keyValue = keys.split("=");
				
				if("key".equals(keyValue[0])) {
					key   = keyValue[0];
					value = keyValue[1];
					
					break;
				}
			}
		} else {
			//System.out.println("wrong ....");
		}

		return value;
		//System.out.println(match.group(0));
	}
	
	public String parsePatern(String regx, String str) {
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(str);
		String rtnVal   = "";
		
		
		if(matcher.find()) {
			//rtnVal = matcher.group() + "=" + String.valueOf(matcher.start()) + ", " + String.valueOf(matcher.end());
			rtnVal = matcher.group(2) + ", " + matcher.group(1) + ", " + matcher.group(0);
		} 
		return rtnVal;
		
	}
	
	
	public String parseDate(String s) {
		return s.substring(0, 13);
	}
	
	
	public HashMap<String,String> setData(StringTokenizer st, int tokenLen, ReadData rd) {
		
		HashMap<String, String> readData = new HashMap<String, String>();
		
		for(int i=0; i<tokenLen; i++) {
			String s = st.nextToken();
			
			switch(i) {
					case 0 : 
						     readData.put("state"   , s);
						     rd.stateKey.add(s);
					         break;
					case 1 : 
						     String parseString = parseUrl(s);
				     	     readData.put("url"     , parseString); 
				     	     System.out.println( s + " ==> " + parsePatern("(key=)([a-zA-Z0-9]+)",s));
						     rd.urlKey.add(parseString);
						     break;
					case 2 : 
						     readData.put("browser", s);
						     rd.browserKey.add(s);
						     break;
					case 3 : 
							String ps = parseDate(s);
							readData.put("connDate", ps);
							rd.connDateKey.add(ps);
					        break;
			}
		}
		return readData;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		MainClass mc = new MainClass();
		ReadData  rd = new ReadData();
		
		List<HashMap<String,String>>  lt = new ArrayList<HashMap<String,String>>();
		
		String fileName = "";
		
		if(args.length == 0) {
			fileName = "c://work//data//sist_input.log";
		} else {
			fileName = args[0];
		}
		
		try {
			fin = new BufferedReader(new FileReader(fileName));
			
			String s;
			int tokenLen=0;
			
			// file read.
			while ((s = fin.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(s, "[]", false);
				tokenLen = st.countTokens();
				
				if(tokenLen == 4) {
					lt.add(mc.setData(st, tokenLen, rd));
				} else {
					// 에러 로그
				}
		    }
			
			// state count
			System.out.println("total : " + lt.size());
			
			/*
			for(String skey : rd.stateKey) {
				System.out.println("key :" + skey);
			}
			
			System.out.println("------------------------------\n");
			
			for(String skey : rd.browserKey) {
				System.out.println("key :" + skey);
			}
			
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
			*/
			
			rd.genStatics(lt, rd.stateKey  , "state");
			rd.genStatics(lt, rd.browserKey, "browser");
			rd.genStatics(lt, rd.urlKey    , "url");
			rd.genStatics(lt, rd.connDateKey, "connDate");
			
			//rd.genBrowser(lt, rd.browserKey, "browser");
			
		} catch (IOException e) {
			System.out.println("file open error !!!");
	        System.err.println(e);  
	    } finally {
	    	fin.close();
	    }
	}
}
