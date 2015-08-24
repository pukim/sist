package sist.thread;

/**
 *	Runnable interface를 구현하여 Thread 사용
 * @author owner
 */
//1. Runnable을 구현
public class UseRunnable 
		implements Runnable{
	//2. run method Override
	@Override
	public void run(){
		//동시에 처리되어야할 코드
		for( int i=0 ; i < 10 ; i++){
			try {
				Thread.sleep( 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("run i="+i);
		}//end for
	}//run

	public static void main(String[] args) {
		//3. 클래스를 객체화
		UseRunnable ur=new UseRunnable();
		//4. Thread 클래스를 has a 관계로 객체화 
		Thread thread=new Thread( ur );
		//5. Thread의 start method 호출
		 thread.start();
		 
		 for( int i= 0 ; i < 500 ; i++){
		System.out.println("main i======"+i);
		 }//end for
		
	}//main

}//class
