/**
 * 
 */
package kr.co.sist.utils;

import java.text.DecimalFormat;

/**
 * @author Administrator
 *
 */
public class ElapsedTime {
	private final static ElapsedTime instance = new ElapsedTime();
	private long start;
	private long end;
    
	public static String unit = "M";  // M:milli second, S: second
	
	// creator
	private ElapsedTime() {}
	
	public static ElapsedTime getInstance() {
		return instance;
	}
	
	public void start() {
		start = System.currentTimeMillis();
	}
	
	public void stop() {
		end   = System.currentTimeMillis();
	}
	
	public void reSet() {
		start = 0;
		end   = 0;
	}
	
	public long runTime() {
		long runTime = end - start;
		
		if("S".equals(unit)) {
			runTime /= 1000.0;
		} 
		return runTime;
	}
	
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00");
		String        fs = df.format(runTime()); 
		
		return fs + ("M".equals(unit) ? " ms" : " s");
	}
}
