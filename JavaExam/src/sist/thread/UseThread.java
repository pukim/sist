package sist.thread;

/**
 *	Thread 클래스를 상속받아 사용하기
 * @author owner
 */
//1. Thread 상속 받는다.
public class UseThread extends Thread{
	//2. run method override
	@Override
	public void run(){
		// 동시에 실행시킬코드
		for(int i= 0 ; i < 500 ; i++){
			System.out.println( i );
		}//end for
	}//run

	public static void main(String[] args) {
		//3. 객체화
		UseThread ut=new UseThread();
		//4. start method를 호출하여 run안의
		//코드가 동시에 처리되도록 한다. 
		ut.start();// run을 직접 호출하면 thread 로
		//처리되지 않는다.
		for(int i=0 ; i < 500 ; i++){
		System.out.println("---------- main i"+i);
		}//end for
	}//main

}//class
