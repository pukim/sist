/**
 * 
 */
package sist.event.sample1;

import java.util.EventListener;

public interface NumberReadListener extends EventListener {
    public void numberRead(NumberReadEvent numberReadEvent);
    public void numberStreamTerminated(NumberReadEvent numberReadEvent);
}

