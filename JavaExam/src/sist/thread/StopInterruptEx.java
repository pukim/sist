/**
 * 
 */
package sist.thread;

/**
 * @author Administrator
 *
 */
public class StopInterruptEx {
	public static void main(String[] args) {
		StopInterrupt t1 = new StopInterrupt("*");
		StopInterrupt t2 = new StopInterrupt("**");
		StopInterrupt t3 = new StopInterrupt("***");
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(2000);
			t1.suspend();
			Thread.sleep(2000);
			t2.suspend();
			Thread.sleep(3000);
			t1.resume();
			Thread.sleep(3000);
			t1.stop();
			t2.stop();
			Thread.sleep(2000);
			t3.stop();
		} catch (InterruptedException e) {}
		
		System.out.println("main stop");
	}
}


class StopInterrupt implements Runnable {
	boolean suspended = false;
	boolean stopped   = false;
	
	Thread th;
	
	StopInterrupt(String name) {
		th = new Thread(this, name);
	}
	
	public void run() {
		String name = Thread.currentThread().getName();
		
		while(!stopped) {
			if(!suspended) {
				System.out.println(name);
				try {
					Thread.sleep(1000);
				} catch(InterruptedException e) {
					System.out.println(name + " - interrupted");
				}
			} else {
				Thread.yield();
			}
		}
		System.out.println(name + " -  stopped");
	}
	
	public void suspend() {
		suspended = true;
		th.interrupt();
		System.out.println("interrupt() is suspend()");
	}
	
	public void resume() {
		suspended = false;
	}
	
	public void stop() {
		stopped = true;
		th.interrupt();
		System.out.println("interrupt() is stop");
	}
	
	public void start() {
		th.start();
	}
}