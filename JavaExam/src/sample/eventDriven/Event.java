/**
 * 
 */
package sample.eventDriven;


public class Event implements Message {
    @Override
    public Class<? extends Message> getType() {
        return getClass();
    }
}
