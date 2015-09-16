/**
 * 
 */
package sist.innclass.example.anonymous;

/**
 * @author owner
 *
 */
public class TestAnonymous {
	public void useFly(Fly f) {
		System.out.println(f.speed());
		System.out.println(f.height());
	}
	
	public static void main(String[] args) {
		TestAnonymous ta = new TestAnonymous();
		ta.useFly(new Fly() {
			public String speed() {
				return "Speed";
			}
			
			public String height() {
				return "Height";
			}
		});
	}
}
