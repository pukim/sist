/**
 * 
 */
package sist.pattern.compare.prototype2;

public class ColorImpl extends Color {

   public ColorImpl(String s){
      setColor(s);
   }

   @Override
   public void fill() {
      System.out.println("Inside " + getColor() + "::fill() method.");
   }
}