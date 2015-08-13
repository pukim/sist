// http://newstars.tistory.com/33

package sist.obj.generic;

public class MyVector<E> {
	public static final int ARRAY_SIZE = 10;
	private E[] elements;
	private int elementCount=0;
	
	@SuppressWarnings("unchecked")
	public MyVector() {
		elements = (E[])new Object[ARRAY_SIZE];
	}
	
	public void add(E value) {
		if(elementCount >= ARRAY_SIZE) {
			throw new IndexOutOfBoundsException("element count reached max size");
		}
		
		elements[elementCount++] = value;
	}
	
	public E get(int index) {
		if(index >= elementCount) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return elements[index];
	}
	
	public static void main(String[] args) {
		MyVector<Integer>vector = new MyVector<Integer>();
		
		for(int i=0; i<10; i++) {
			vector.add(i);
		}
		
		for(int i=0; i<10; i++) {
			System.out.println("[ " + i + " ]th value :" + vector.get(i));
		}
		
		MyVector<String>sVector = new MyVector<String>();
		
	}
}
