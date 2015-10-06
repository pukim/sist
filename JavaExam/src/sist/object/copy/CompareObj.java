/**
 * 
 */
package sist.object.copy;

/**
 * @author owner
 *
 */
public class CompareObj {
	public void compare1() {
		int x = 100; 
		int y = 200; 
		int z = 100; 
		 
		String name1 = "eunsun"; 
		String name2 = "EUNSUN"; 
		String name3 = new String("eunsun"); 
		String name4 = "eunsun";
		
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
		
		System.out.println(x==y); //false
		System.out.println(x==z); //true
		
		System.out.println("name1==name2 : "+(name1==name2) + 
				           ", name1.equals(name2) : " + name1.equals(name2) + 
				           ", hash : [" + System.identityHashCode(name1) + "][" + System.identityHashCode(name2) + "]"); //false
		System.out.println("name1==name3 : "+(name1==name3) + 
		           ", name1.equals(name3) : " + name1.equals(name3) + 
		           ", hash : [" + System.identityHashCode(name1) + "][" + System.identityHashCode(name3) + "]"); //false
		
		System.out.println("name1==name2 : "+(name1==name4) + 
		           ", name1.equals(name2) : " + name1.equals(name4) + 
		           ", hash : [" + System.identityHashCode(name1) + "][" + System.identityHashCode(name4) + "]"); //true
		
	}
	
	public void compare2() {
	
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(new Object(){}.getClass().getEnclosingMethod().getName());
		
		CaseInsensitiveString x = new CaseInsensitiveString("Apple");
		String y = "apple";
		 
		System.out.println(x.equals(y)); //true 
		System.out.println(y.equals(x)); //false

	}
	
	public static void main(String[] args) {
		CompareObj co = new CompareObj();
		
		co.compare1();
		co.compare2();
		
	}
}

class CaseInsensitiveString {
	private String s;

    public CaseInsensitiveString(String s) {
        if (s == null)
        throw new NullPointerException();
        this.s = s;
    }

    public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString &&
        ((CaseInsensitiveString)o).s.equalsIgnoreCase(s);
    }

    private volatile int hashCode = 0;

    public int hashCode() {
        if (hashCode == 0)
        hashCode = s.toUpperCase().hashCode();

        return hashCode;
    }

    public String toString() {
        return s;
    }

}
