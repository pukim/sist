/**
 * 
 */
package sist.test;

import java.math.BigDecimal;

/**
 * @author owner
 *
 */
public class BigNumber {
	
	public void step1() {
		double da = 2.00;
		double db = 1.10;
		
		System.out.println("double : " + (da - db));
		
		float fa = 2.00f;
		float fb = 1.10f;
		
		System.out.println("float : " + (fa - fb));
		
		BigDecimal ba = new BigDecimal(2.00);
		BigDecimal bb = new BigDecimal(1.10);
		
		System.out.println("big decimal : " + ba.subtract(bb));
		
		BigDecimal b1 = new BigDecimal("2.00");
		BigDecimal b2 = new BigDecimal("1.10");
		
		System.out.println(b1.subtract(b2));
		
		BigDecimal b11 = new BigDecimal(2.00f);
		BigDecimal b21 = new BigDecimal(1.10f);
		
		System.out.println(b11.subtract(b21));
		
		System.out.println(1.0/3.0);
		System.out.println(1.0f/3.0f);
		
		int    im = 1000;
		float  ft = 0.1f;
		
		System.out.println(im/(1.0f+ft));
	}
	
	public void step2(int val) {
		long  amnt = Math.round(val / 1.1f);
		long  vat  = val - amnt;
		
		System.out.println("amount : " + amnt + ", " + val / 1.1f);
		System.out.println("vat    : " + vat);
		System.out.println("Total  : " + (amnt + vat));
	}
	
	public static void main(String[] args) {
		BigNumber bn = new BigNumber();
		
		//bn.step1();
		bn.step2(7210);
		
	}
}
