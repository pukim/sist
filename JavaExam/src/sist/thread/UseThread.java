package sist.thread;

/**
 *	Thread Ŭ������ ��ӹ޾� ����ϱ�
 * @author owner
 */
//1. Thread ��� �޴´�.
public class UseThread extends Thread{
	//2. run method override
	@Override
	public void run(){
		// ���ÿ� �����ų�ڵ�
		for(int i= 0 ; i < 500 ; i++){
			System.out.println( i );
		}//end for
	}//run

	public static void main(String[] args) {
		//3. ��üȭ
		UseThread ut=new UseThread();
		//4. start method�� ȣ���Ͽ� run����
		//�ڵ尡 ���ÿ� ó���ǵ��� �Ѵ�. 
		ut.start();// run�� ���� ȣ���ϸ� thread ��
		//ó������ �ʴ´�.
		for(int i=0 ; i < 500 ; i++){
		System.out.println("---------- main i"+i);
		}//end for
	}//main

}//class
