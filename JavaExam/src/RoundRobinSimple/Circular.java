/**
 * 
 */
package RoundRobinSimple;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Circular<T> {

    private final HashSet<T> counter;
    private final Iterator<T> elements;

    public Circular(final List<T> elements) {
        this.counter  = new HashSet();
        this.elements = elements.iterator(); // Iterables.cycle(elements).iterator();
    }

    public T getOne() {
        final T element = this.elements.next();
        this.counter.add(element);
        return element;
    }

    public int getCount(final T element) {
        //return this.counter.count(element);
    	int i = 0;
    	for(T t : counter) {
    		if(t.equals(element)) {
    			System.out.println("Ok : " + t + ", " + element);
    			i++;
    		} else {
    			System.out.println("Fail : " + t + ", " + element);
    		}
    	}
    	return i;
    }

    public static void main(final String[] args) {
        //final Circular<String> circular = new Circular<>(Lists.newArrayList("A", "B", "C"));
    	ArrayList lt = new ArrayList<String>();
    	lt.add("A");
    	lt.add("B");
    	lt.add("C");
    	lt.add("A");
    	lt.add("E");
    	lt.add("F");
    	lt.add("G");
    	
    	final Circular<String> circular = new Circular<>(lt);
        for (int i = 0; i < 7; i++) {
            System.out.println(circular.getOne());
        }
        System.out.println("Count for A: " + circular.getCount("A"));
    }
} 