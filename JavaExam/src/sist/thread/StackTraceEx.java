/**
 * 
 */
package sist.thread;

import java.util.Iterator;
import java.util.Map;

/**
 * @author owner
 *
 */
public class StackTraceEx {
	public static void main(String[] args) throws Exception {
		ThreadEx_1 t1 = new ThreadEx_1("thread1");
		ThreadEx_2 t2 = new ThreadEx_2("thread2");
		
		t1.start();
		t2.start();
	}
}

class ThreadEx_1 extends Thread {
	ThreadEx_1(String name) {
		super(name);
	}
	
	public void run() {
		try {
			sleep(5*1000);
		}catch(InterruptedException e) {}
	}
}

class ThreadEx_2 extends Thread {
	ThreadEx_2(String name) {
		super(name);
	}
	
	public void run() {
		Map map = getAllStackTraces();
		Iterator it = map.keySet().iterator();
		
		int x = 0;
		while(it.hasNext()) {
			Object obj = it.next();
			Thread t = (Thread)obj;
			StackTraceElement[] ste = (StackTraceElement[])(map.get(obj));
			
			System.out.println("[" + ++x + "] name : " + t.getName()
			                + ", group :" + t.getThreadGroup().getName()
			                + ", daemon : " + t.isDaemon());
			
			for(int i=0; i < ste.length; i++) {
				System.out.println(ste[i]);
			}
			System.out.println();
		}
	}
}
