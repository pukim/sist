/**
 * 
 */
package sist.pattern.compare.prototype;

/**
 * @author Administrator
 *
 */
public abstract class Shape implements Cloneable {
	private   String shape;
	protected String color;
	
	abstract void draw();

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

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
