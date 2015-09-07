/**
 * 
 */
package sist.thread;

/**
 * @author owner
 *
 */
public class JoinEx {
	static long startTime = 0;
	
	public static void main(String[] args) {
		JoinEx_1 t1 = new JoinEx_1();
		JoinEx_2 t2 = new JoinEx_2();
		
		t1.start();
		//t2.start();
		
		startTime = System.currentTimeMillis();
		
		try {
			t1.join();
			//t2.join();
		} catch(InterruptedException e) {
			System.out.println("Running time :" + 
		                 (System.currentTimeMillis() - JoinEx.startTime));
		}
		t2.start();
	}
}

class JoinEx_1 extends Thread {
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("-");
		}
	}
}

class JoinEx_2 extends Thread {
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("|");
		}
	}
}