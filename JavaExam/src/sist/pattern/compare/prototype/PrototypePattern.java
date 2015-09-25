/**
 * 
 */
package sist.pattern.compare.prototype;

/**
 * @author Administrator
 *
 */
public class PrototypePattern {
	public static void main(String[] args) {
	      ShapeCache.loadCache();
	
	      Shape clonedShape = (Shape) ShapeCache.getShape("Circle");
	      clonedShape.setColor("Red");
	      clonedShape.draw();
	    //  System.out.println("Shape : " + clonedShape.getShape() + ", \t color :" + clonedShape.getColor());		
	
	      Shape clonedShape2 = (Shape) ShapeCache.getShape("Rectangle");
	      clonedShape2.setColor("Blue");
	      clonedShape2.draw();
	      //System.out.println("Shape : " + clonedShape2.getShape() + ", \t color :" + clonedShape2.getColor());		
	
	      Shape clonedShape3 = (Shape) ShapeCache.getShape("Square");
	      clonedShape3.setColor("Green");
	      clonedShape3.draw();
	      //System.out.println("Shape : " + clonedShape3.getShape() + ", \t color :" + clonedShape3.getColor());		
   }
}
