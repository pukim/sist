/**
 * 
 */
package sist.pattern.compare.prototype2;

import java.util.Hashtable;

/**
 * @author Administrator
 *
 */
public class ColorCache {
   private static Hashtable<String, Color> colorMap  = new Hashtable<String, Color>();

   public static Color getColor(String color) {
	  Color cachedColor = colorMap.get(color);
	  return (Color) cachedColor.clone();
   }

   public static void loadCache() {
      ColorImpl red = new ColorImpl("Red");
      colorMap.put(red.getColor(), red);

      ColorImpl blue = new ColorImpl("Blue");
      colorMap.put(blue.getColor(), blue);
      
      ColorImpl green = new ColorImpl("Green");
      colorMap.put(green.getColor(), green);
   }
}
