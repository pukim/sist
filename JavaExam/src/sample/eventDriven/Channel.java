/**
 * 
 */
package sample.eventDriven;

public interface Channel<E extends Message> {
    public void dispatch(E message);
}
