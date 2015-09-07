/**
 * 
 */
package sist.thread;

/**
 * @author owner
 *
 */
public class DaemonEx implements Runnable {
	static boolean autoSave = false;
	
	public static void main(String[] args) {
		Thread t = new Thread(new DaemonEx());
		t.setDaemon(true);
		t.start();
		
		for(int i = 1; i <= 20; i++) {
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) { }
			
			System.out.println(i);
			if(i == 5) autoSave = true;
		}
		
		System.out.println("Program exit.");
	}
	
	public void autoSave() {
		System.out.println("saved working file.");
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(3*1000);
			} catch(InterruptedException e) {}
			
			if(autoSave) {
				autoSave();
			}
		}
		
	}
}
