/**
 * 
 */
package sist.pattern.compare.prototype2;

/**
 * @author Administrator
 *
 */
public class PrototypePattern {
	public static void main(String[] args) {
	      ShapeCache.loadCache();
	      ColorCache.loadCache();
	      
	      Shape clonedShape = (Shape) ShapeCache.getShape("Circle");
	      Color clonedColor = (Color) ColorCache.getColor("Red");
	      clonedShape.draw();
	      clonedColor.fill();
	
	      Shape clonedShape2 = (Shape) ShapeCache.getShape("Rectangle");
	      Color clonedColor2 = (Color) ColorCache.getColor("Blue");
	      clonedShape2.draw();
	      clonedColor2.fill();		
	
	      Shape clonedShape3 = (Shape) ShapeCache.getShape("Square");
	      Color clonedColor3 = (Color) ColorCache.getColor("Green");
	      clonedShape3.draw();
	      clonedColor3.fill();		
   }
}
