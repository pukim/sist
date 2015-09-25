/**
 * https://geunhokim.wordpress.com/2013/06/15/deep-copy-shallow-copy/
 */
package sist.object.copy;

import java.util.ArrayList;

/**
 * @author Administrator
 *
 */

class route implements Cloneable {
	ArrayList<Integer> path;
	double             cost;
	
	public route clone() throws CloneNotSupportedException {
		route route = (route) super.clone();
		route.path  = (ArrayList<Integer>)path.clone();
		route.cost  = this.cost;
		
		return route;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(String.valueOf(cost) + ", size :" + path.size());
		sb.append("\nList____("+this.hashCode() + ")\n");
		for(Integer i : path) {
			sb.append(i+"\n");
		}
		return sb.toString();
	}
}

public class DeepCopy {
	
	public void print(route r) {
		//System.out.println(Thread.currentThread().getStackTrace());
		System.out.println(r);
		System.out.println("");
	}
	
	public void print(route r1, route r2) {
		System.out.println("r1 == r2      : " + (r1 == r2));
		System.out.println("r1.equals(r2) : " + r1.equals(r2));
		System.out.println("---------------------------------------------");
	}
	
	public void copy1() {
		route r1 = new route();
		route r2;
		
		r1.path = new ArrayList<Integer>();
		
		r1.path.add(10);
		r1.path.add(20);
		r1.path.add(30);
		
		r1.cost = 3.14;
		
		r2 = r1;
		
		System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
		
		r2.path.add(40);
		
		print(r1);
		print(r2);
		print(r1, r2);
		
	}
	
	public void copy2_1() {
		route r1 = new route();
		route r2 = new route();
		
		r1.path = new ArrayList<Integer>();
		
		r1.path.add(10);
		r1.path.add(20);
		r1.path.add(30);
		
		r1.cost = 3.14;
		
	
		r2.path = new ArrayList<Integer>();
		r2.path.add(40);
		
		System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println("before :" + r1.hashCode() + ", " + r2.hashCode());

		
		print(r1);
		print(r2);
		print(r1, r2);
		
		r2 = r1;
		
		System.out.println("after :" + r1.hashCode() + ", " + r2.hashCode());

		
		print(r1);
		print(r2);
		print(r1, r2);

	}
	
	public void copy2() {
		route r1 = new route();
		route r2 = new route();
		
		r1.path = new ArrayList<Integer>();
		
		r1.path.add(10);
		r1.path.add(20);
		r1.path.add(30);
		
		r1.cost = 3.14;
		
		//r2 = r1;
		r2.path = new ArrayList<Integer>();
		r2.path.add(40);
		
		System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
		System.out.println("before :" + r1.hashCode() + ", " + r2.hashCode());

		
		print(r1);
		print(r2);
		print(r1, r2);
	}

	public void copy3() {
		route r1 = new route();
		route r2 = new route();
		
		r1.path = new ArrayList<Integer>();
		
		r1.path.add(10);
		r1.path.add(20);
		r1.path.add(30);
		
		r1.cost = 3.14;
		
		try {
			r2 = r1.clone();
		} catch(Exception e) { e.printStackTrace(); }
		
		System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
		
		r2.path.add(40);
		
		print(r1);
		print(r2);
		print(r1, r2);
	}
	
	public void copy4() {
		route r1 = new route();
		route r2;
		
		r1.path = new ArrayList<Integer>();
		
		r1.path.add(10);
		r1.path.add(20);
		r1.path.add(30);
		
		r1.cost = 3.14;
		r2 = r1;
		
		try {
			r2 = r1.clone();
		} catch(Exception e) { e.printStackTrace(); }
		
		System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
		
		print(r1);
		print(r2);
		print(r1, r2);
	}
	
	public static void main(String[] args) {
		DeepCopy dc = new DeepCopy();
		
		dc.copy1();
		//dc.copy2();
		dc.copy2_1();
		
		dc.copy3();
		dc.copy4();
	}
}
