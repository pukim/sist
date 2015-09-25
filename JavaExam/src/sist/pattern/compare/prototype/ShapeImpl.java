/**
 * 
 */
package sist.pattern.compare.prototype;

public class ShapeImpl extends Shape {

   public ShapeImpl(String s){
      setShape(s);
   }

   @Override
   public void draw() {
      System.out.println("Inside " + getShape() + "::draw() method. fill " + color);
   }
}