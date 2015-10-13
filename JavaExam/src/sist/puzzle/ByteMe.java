/**
 * 
 */
package sist.puzzle;

/**
 * @author Administrator
 *
 */
class ByteMe {
	public static void main(String[] args) {
		
		System.out.println("byte min :" + Byte.MIN_VALUE + ", max : " + Byte.MAX_VALUE);
		
		for (byte b = Byte.MIN_VALUE;
				b < Byte.MAX_VALUE; b++) {
			if (b == 0x90) // (b == 144)
				System.out.print("Byte me! ");
			/*
			if (b == (byte)0x90)
				System.out.print("Byte me! ");
			if ((b & 0xff) == 0x90)
				System.out.println("Byte me!");
			*/	
		}
	} // but (byte)0x90 = -112
}
