package sist.exam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

public class ReadData {
	HashMap<String, Integer> stateStatic   = new HashMap<String, Integer>();
	
	HashSet<String> stateKey   = new HashSet<String>();
	HashSet<String> urlKey     = new HashSet<String>();
	HashSet<String> browserKey = new HashSet<String>();
	HashSet<String> connDateKey= new HashSet<String>();
	
	
	public HashSet<String> getHashKey(List<HashMap<String,String>> li, String key) {
		HashSet<String> hs = new HashSet<String>();
		
		for(HashMap<String,String>hm : li) {
			String s = hm.get(key);
			hs.add(s);
		}
		return hs;
	}
	
	public HashMap<String, Integer> initHashMap(HashSet<String> hs) {
		HashMap<String, Integer> rtnHm = new HashMap<String, Integer>();
		for(String s : hs) {
			rtnHm.put(s, 0);
		}
		
		return rtnHm;
	}
	
	public static TreeMap<String, Integer> SortByValue(HashMap<String, Integer> map) {
		UserCompare uc =  new UserCompare(map);
		TreeMap<String,Integer> sortedMap = new TreeMap<String,Integer>(uc);
		sortedMap.putAll(map);
		return sortedMap;
	}

	
	public void genStatics(List<HashMap<String,String>> li, HashSet<String> hs, String str) {
		//HashMap<String, Integer> hm   = new HashMap<String, Integer>();
		stateStatic = initHashMap(hs);
				
		for(HashMap<String, String> hm : li) {
			String key = hm.get(str);
			for(String s : hs) {
				if(key.equals(s)) {
					stateStatic.put(s, stateStatic.get(s)+1);
				}
			}
		}
		
		for(String s : hs) {
			System.out.format("%-10s  %5d ( %5.2f %s) \n", "".equals(s) ? "기타" : s, stateStatic.get(s), stateStatic.get(s).floatValue()/li.size()*100.0f,"%");
		}
		
		TreeMap<String, Integer> sortedMap = SortByValue(stateStatic);  
		System.out.println("----------------------------------------------");
		System.out.println("Max Key : " + sortedMap.firstEntry());
		
		/*
		for(String s : hs) {
			System.out.format("%-10s  %5d ( %3.2f ) \n", "".equals(s) ? "기타" : s, sortedMap.get(s), sortedMap.get(s).floatValue()/li.size()*100.0f);
		}
		*/
		
		System.out.println("\n");
	}
}
