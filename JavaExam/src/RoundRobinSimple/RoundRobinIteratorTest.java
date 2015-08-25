/**
 * 
 */
package RoundRobinSimple;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
 
import static junit.framework.TestCase.assertEquals;
 
public class RoundRobinIteratorTest {
 
    @Test
    public void roundRobinIteratorTest() {
 
        //Create 5 sample lists, some of which are empty for richer test cases.
        List<Integer> a = new LinkedList<>(Arrays.asList(1, 4, 7));
        List<Integer> b = new LinkedList<>(Arrays.asList(2, 5, 8));
        List<Integer> c = new LinkedList<>();
        List<Integer> d = new LinkedList<>(Arrays.asList(3, 6, 9, 10));
        List<Integer> e = new LinkedList<>();
 
        //Create a list of the iterators to each of the lists created above.
        List<Iterator<Integer>> iterators = new LinkedList<>();
        iterators.add(a.iterator());
        iterators.add(b.iterator());
        iterators.add(c.iterator());
        iterators.add(d.iterator());
        iterators.add(e.iterator());
 
        //Create a round-robin iterator over the list of iterators.
        RoundRobinIterator iter = new RoundRobinIterator(iterators);
 
        //Advance the round-robin-iterator to the end, making sure each
        //element matches up to what is expected between the 5 lists.
        Integer[] expectedOrder = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int resultIndex = 0;
        while(iter.hasNext()) {
            assertEquals(expectedOrder[resultIndex++], iter.next());
        }
    }
}
