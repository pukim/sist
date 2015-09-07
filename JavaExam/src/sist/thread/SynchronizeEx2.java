/**
 * 
 */
package sist.thread;

/**
 * @author Administrator
 *
 */
public class SynchronizeEx2 {
	public static void main(String[] args) {
		Runnable r = new RunWait();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
	}
}

class Account2 {
	int balance = 1000;
	
	//public void withdraw(int money) {
	public synchronized void withdraw(int money) {
		if(balance < money) {
			try {
				wait();
			} catch(Exception e) {}
			
			balance -= money;
			
		}
	}
	
	public synchronized void deposit(int money) {
		balance += money;
		notify();
	}
}

class RunWait implements Runnable {
	Account2 acc = new Account2();
	
	public void run() {
		while(acc.balance > 0) {
			int money = (int)(Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			
			System.out.println("balance : " + acc.balance);
		}
	}
}