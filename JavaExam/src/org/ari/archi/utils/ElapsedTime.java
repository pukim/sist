/**
 * 코드의 실행  시간 측정을 위한  클래스이다. <BR>
 * 사용법은 다음과 같다.
 * <pre><code>
 * public class StringBuffer {
 *	public static void main(String[] args) {
 *		ElapsedTime et = ElapsedTime.getInstance();
 *		long startTime = System.nanoTime();
 *		
 *		et.start();
 *		
 *		for(long l=0; l<100000000; l++) {
 *			//String s = "test" + l;
 *			StringBuilder sb = new StringBuilder();
 *			sb.append("test").append(l);
 *		}
 *		
 *		et.stop();
 *		
 *		long endTime = System.nanoTime(); 
 *		System.out.println("run time : " + ((endTime - startTime)/1000000.0)); 
 *		System.out.println("run time : " + et);
 *		
 *		et.unit = "S";
 *		System.out.println("run time : " + et);
 *	}
 * }                                                             
 * </code>
 * 출력 유형 :
 *                                                                  
 * Symbol   Meaning                 Presentation        Example
 * ------   -------                 ------------        -------
 * M        milliseconds                                11200 ms
 * S        seconds                                     11.200 s
 *
 * </pre>
 * 주의 사항 : <BR>
 *
 * @version	1.0, 
 * @author	pukim
 * @see		System.currentTimeMillis
 */

package org.ari.archi.utils;

import java.text.DecimalFormat;

public class ElapsedTime {
	private final static ElapsedTime instance = new ElapsedTime();
	private long start;
	private long end;
    
	public static String unit = "M";  // M:milli second, S: second
	
	/**
	 * 클래스 생성자 
	 * 
	 * @param 
	 */
	private ElapsedTime() {}

	/**
	 * 싱글턴 패턴으로 생성된 클래스의 인스턴스를 반환 환다. 
	 * 
	 * @return 	ElapsedTime instance
	 */
	public static ElapsedTime getInstance() {
		return instance;
	}
	
	/**
	 * 시작 시각을 갖는다. 
	 * 
	 */
	public void start() {
		start = System.currentTimeMillis();
	}

	/**
	 * 종료 시각을 갖는다. 
	 * 
	 */
	public void stop() {
		end   = System.currentTimeMillis();
	}
	
	/**
	 * 시작, 종료 시각을 초기화 한다. 
	 * 
	 */
	public void reSet() {
		start = 0;
		end   = 0;
	}
	
	/**
	 * 코드의 실행  시간을 계산하여 계산 값을 반환 한다.  
	 * 
	 * @return 	계산된 시간
	 */
	public long runTime() {
		long runTime = end - start;
		
		if("S".equals(unit)) {
			runTime /= 1000.0;
		} 
		return runTime;
	}
	
	/**
	 * 코드의 실행  시간을 계산하여 계산 값을 문자열로 반환 한다.  
	 * 
	 * @return 	계산된 시간
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00");
		String        fs = df.format(runTime()); 
		
		return fs + ("M".equals(unit) ? " ms" : " s");
	}
}
