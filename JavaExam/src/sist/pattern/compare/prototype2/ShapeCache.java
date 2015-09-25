/**
 * 
 */
package sist.pattern.compare.prototype2;

import java.util.Hashtable;

/**
 * @author Administrator
 *
 */
public class ShapeCache {
   private static Hashtable<String, Shape> shapeMap  = new Hashtable<String, Shape>();

   public static Shape getShape(String shapeId) {
	  Shape cachedShape = shapeMap.get(shapeId);
	  return (Shape) cachedShape.clone();
   }

   public static void loadCache() {
      ShapeImpl circle = new ShapeImpl("Circle");
      shapeMap.put(circle.getShape(),circle);

      ShapeImpl square = new ShapeImpl("Square");
      shapeMap.put(square.getShape(),square);
      
      ShapeImpl rectangle = new ShapeImpl("Rectangle");
      shapeMap.put(rectangle.getShape(),rectangle);
   }
}
