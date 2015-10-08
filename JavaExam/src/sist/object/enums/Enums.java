/**
 * 
 */
package sist.object.enums;

enum Gender {
	MALE(1), FEMALE(2); // private static.

	private final int value;

	Gender(int value) { // private
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static Gender valueOf(int value) {
		switch(value) {
			case 1: return Gender.MALE;
			case 2: return Gender.FEMALE;
			default: throw new AssertionError("Unknown gender: " + value);
		}
	}
}


public class Enums {
	
	public static void genPrint(Gender g) {
		switch(g) {
			case MALE   : System.out.println("남자 싫어."); break;
			case FEMALE : System.out.println("여자 좋아."); break;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("male   : " + Gender.MALE);
		System.out.println("female : " + Gender.FEMALE);
		
		
		System.out.println("1 : " + Gender.valueOf(1));
		System.out.println("2 : " + Gender.valueOf(2));
		
		Gender[] gender = Gender.values();
		
		for(Gender g : gender) {
			System.out.println(g + ", " + g.getValue());
		}
		
		genPrint(Gender.MALE);
		
	}
}
