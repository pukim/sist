/**
 * 
 */
package sist.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author owner
 *
 */


public class ListSample {
	
	public static void main(String[] args) {
		List<FileLayout> lt = new ArrayList<FileLayout>();
		
		
		FileLayout f1       = new FileLayout();
		
		f1.setId("1");
		f1.setCode("IE");
		f1.setIp("3.3.3.3.3");
		f1.setDate("2015-08-11");
		lt.add(f1);
		
		FileLayout f2       = new FileLayout();
		
		f2.setId("2");
		f2.setCode("Chrome");
		f2.setIp("1.1.1.1.1");
		f2.setDate("2015-08-12");
		lt.add(f2);
		
		for(FileLayout ft : lt) {
			System.out.println(ft);
		}
	}
}
