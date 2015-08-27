/**
 * 
 */
package sist.event.sample2;

import java.util.EventObject;
public class MoodEvent extends EventObject {
    private Mood _mood;
    
    public MoodEvent( Object source, Mood mood ) {
        super( source );
        _mood = mood;
    }
    public Mood mood() {
        return _mood;
    }
}
