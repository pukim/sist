package sist.exam;

import java.util.Comparator;
import java.util.Map;

public class UserCompare implements Comparator<String> {
	Map<String, Integer> map;
	
	public UserCompare(Map<String,Integer> base) {
        this.map = base;
    }

	public int compare(String a, String b) {
		if (map.get(a) >= map.get(b)) {
		   return -1;
        } else {
            return 1;
        }
	}
}
