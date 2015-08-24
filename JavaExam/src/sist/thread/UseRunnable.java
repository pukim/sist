package sist.thread;

/**
 *	Runnable interface�� �����Ͽ� Thread ���
 * @author owner
 */
//1. Runnable�� ����
public class UseRunnable 
		implements Runnable{
	//2. run method Override
	@Override
	public void run(){
		//���ÿ� ó���Ǿ���� �ڵ�
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
		//3. Ŭ������ ��üȭ
		UseRunnable ur=new UseRunnable();
		//4. Thread Ŭ������ has a ����� ��üȭ 
		Thread thread=new Thread( ur );
		//5. Thread�� start method ȣ��
		 thread.start();
		 
		 for( int i= 0 ; i < 500 ; i++){
		System.out.println("main i======"+i);
		 }//end for
		
	}//main

}//class
