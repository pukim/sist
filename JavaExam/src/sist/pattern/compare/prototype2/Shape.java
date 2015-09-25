/**
 * 
 */
package sist.pattern.compare.prototype2;

/**
 * @author Administrator
 *
 */
public abstract class Shape implements Cloneable {
	private   String shape;
	
	abstract void draw();

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
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
