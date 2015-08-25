/**
 * 
 */
package sist.puzzle;

class Dog {
	public static void bark() {
		System.out.print("woof ");
	}
}

class Basenji extends Dog {
	public static void bark() {
		// No dynamic dispatch on static methods
		// Static methods can¡¯t be overridden
		System.out.print("x");
	}
}

public class Bark {
	public static void main(String args[]) {
		Dog woofer = new Dog();
		Dog nipper = new Basenji();
		
		woofer.bark();
		nipper.bark();
		
		Dog.bark();
		Basenji.bark();
	}
}
