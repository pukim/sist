/**
 * 통계 작성 클래스
 */
package sist.exam2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import sist.exam.UserCompare;

/**
 * @author Administrator
 *
 */
public abstract class Statics implements Comparator<String> {
	Set<String> elementKeys = new HashSet<String>();   // 유형별 처리할 키
    HashMap<String, Integer> elementCount              // 유혈별 카운트
                            = new HashMap<String,Integer>(); 
	Map<String, Integer> map;				           // 정렬 처리를 위해
	FileReadData         readData;
	String               name;               
	
    public Statics() {}
    
    public Statics(FileReadData frd, String nm) {
    	readData = frd;
    	name     = nm;
    }
    
    // 파싱 필요한 경우
    public void doParshing(String s) {}

    // 통계 생성
    public void genStatics() {
    	for(HashMap<String, String> rdata : readData.fdata) {
			String key = rdata.get(name);
			for(String s : elementKeys) {
				if(key.equals(s)) {
					elementCount.put(s, elementCount.get(s)+1);
				}
			}
		}
		
		
		
		TreeMap<String, Integer> sortedMap = SortByValue(stateStatic);  
		System.out.println("----------------------------------------------");
		System.out.println("Max Key : " + sortedMap.firstEntry());
    }
    
    //
    public void printData() {
    	for(String s : elementKeys) {
			System.out.format("%-10s  %5d ( %5.2f %s) \n", "".equals(s) ? "기타" : s, elementCount.get(s), elementCount.get(s).floatValue()/readData.fdata.size()*100.0f,"%");
		}
    }
    
    /*
	public Statics(Map<String,Integer> base) {
        this.map = base;
    }

	
	// sort를 위해서
	public int compare(String a, String b) {
		if (map.get(a) >= map.get(b)) {
		   return -1;
        } else {
            return 1;
        }
	}
	
	
	// Sorts
	public static TreeMap<String, Integer> SortByValue(HashMap<String, Integer> map) {
		UserCompare uc =  new UserCompare(map);
		TreeMap<String,Integer> sortedMap = new TreeMap<String,Integer>(uc);
		sortedMap.putAll(map);
		return sortedMap;
	}
	*/
}
