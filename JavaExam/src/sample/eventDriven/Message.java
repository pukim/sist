/**
 * 
 */
package sample.eventDriven;

public interface Message {
    public Class<? extends Message> getType();
}