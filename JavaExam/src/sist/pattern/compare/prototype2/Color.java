/**
 * 
 */
package sist.pattern.compare.prototype2;

/**
 * @author Administrator
 *
 */
public abstract class Color implements Cloneable {
	private   String color;
	
	abstract void fill();

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public Object clone() {
		Object clone = null;

		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
	         e.printStackTrace();
	    }
	    return clone;
	}
}
