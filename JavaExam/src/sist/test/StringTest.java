package sist.test;


public class StringTest {
	public static void main(String[] args) {
		String s = "012345AZaz";
		char[] c = {48, 49, 50, 65, 66, 67, 91,92,93,97 } ;//{'0','1','2','3','4','5'};
		String ss = "";
	
		int sum = 0;
		for(int i=0; i<s.length(); i++) {
			char cc = (s.charAt(i));
			 
			//System.out.printf("%c, %d\n", s.charAt(i), (int)s.charAt(i));
			System.out.printf("%d, %c --> %d [%d]\n", Character.getNumericValue(s.charAt(i)), cc, (int)cc, s.codePointAt(i));
			//System.out.printf("%d, ", (int)cc);
			ss += cc;
			sum += cc - '0';
		}
		System.out.println("string : " + ss + ", sum :" + sum);
		System.out.println("----------------------------------\n");
		 
		for(int i=0; i<c.length; i++) {
			System.out.printf("%c, %d\n", c[i], (int)c[i]);
		}
		 
	}
}
