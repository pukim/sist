/**
 * 
 */
package RoundRobinSimple;

import java.util.*;

public class RoundRobinIterator implements Iterator<Integer> {
 
    //Define the iterator position in the overall list of iterators
    //and the list of iterators itself.
    private Iterator<Iterator<Integer>> iter;
    private List<Iterator<Integer>> iterators;
 
    //The next value to be returned.  If null, the next value has
    //not been located yet.
    private Integer nextValue;
 
    public RoundRobinIterator(List<Iterator<Integer>> iterators) {
 
        //Gets an iterator over a list of iterators.
        iter = iterators.iterator();
        this.nextValue = null;
        this.iterators = iterators;
    }
 
    @Override
    public Integer next() {
        if (!hasNext())
            throw new NoSuchElementException();
        Integer n = nextValue;
        nextValue = null;
        return n;
    }
 
    @Override
    public boolean hasNext() {
        return nextValue != null || setNext();
    }
 
    private boolean setNext() {
 
        //If we've already found the next element, do nothing.
        if (nextValue != null) return true;
 
        //Loop until we determine the next element or that no elements remain.
        while (true) {
 
            //If we're at the end of the list of iterators, restart at the beginning, assuming
            //any of the contained lists have remaining elements.
            if (!iter.hasNext()) {
                if (!iterators.isEmpty()) iter = iterators.iterator();
                else return false;
            }
 
            //Get the next iterator from the list of iterators, assuming we're
            //not at the last one already.
            if (iter.hasNext()) {
                Iterator<Integer> currentIter = iter.next();
 
                //If the iterator we are positioned at has more elements left in its
                //sub-list, then take the next element and return it.  If no elements remain
                //then remove the iterator from the round-robin iterator list for good.
                if (currentIter.hasNext()) {
                    nextValue = currentIter.next();
                    return true;
                }
                else {
                    iter.remove();
                }
            }
        }
    }
}
