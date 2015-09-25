/**
 * 
 */
package sist.pattern.compare.prototype2;

public class ShapeImpl extends Shape {

   public ShapeImpl(String s){
      setShape(s);
   }

   @Override
   public void draw() {
      System.out.println("Inside " + getShape() + "::draw() method.");
   }
}