/**
 * ��� �ۼ� Ŭ����
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
	Set<String> elementKeys = new HashSet<String>();   // ������ ó���� Ű
    HashMap<String, Integer> elementCount              // ������ ī��Ʈ
                            = new HashMap<String,Integer>(); 
	Map<String, Integer> map;				           // ���� ó���� ����
	FileReadData         readData;
	String               name;               
	
    public Statics() {}
    
    public Statics(FileReadData frd, String nm) {
    	readData = frd;
    	name     = nm;
    }
    
    // �Ľ� �ʿ��� ���
    public void doParshing(String s) {}

    // ��� ����
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
			System.out.format("%-10s  %5d ( %5.2f %s) \n", "".equals(s) ? "��Ÿ" : s, elementCount.get(s), elementCount.get(s).floatValue()/readData.fdata.size()*100.0f,"%");
		}
    }
    
    /*
	public Statics(Map<String,Integer> base) {
        this.map = base;
    }

	
	// sort�� ���ؼ�
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
