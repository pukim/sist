/**
 * 
 */
package sist.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author owner
 *
 */
public class RunExam {

	public void  listExample() {
		GetData gd = new GetData();
		
		ArrayList result = gd.getEmp("7345");
		
		if(result.size() > 0) {
			Iterator ie = result.iterator();
			while(ie.hasNext()) {
				HashMap hm = new HashMap();
				hm = (HashMap)ie.next();
				System.out.println(hm);
			}
		} else {
			System.out.println("not found.");
		}
	}
	
	public void  getMap(String s) {
		GetData gd = new GetData();
		
		HashMap hm = gd.getMap(s);
		
		System.out.println(hm);
		
	}
	
	public static void main(String[] args) {
		RunExam re = new RunExam();
		
	//	re.listExample();
		re.getMap("7369");
		
	}
	
}
