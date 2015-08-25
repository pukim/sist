/**
 * 
 */
package RoundRobin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 *
 */
/* implement this class for all three strategies */
public abstract class AllocationStrategy {
    protected List<Job> Jobs;
    protected ArrayList<Job> Queue;
    
    public AllocationStrategy(List<Job> jobs) {
        super();
        Jobs = jobs;
    }
    
    public abstract void run();
    // update current job by 1 tick
    // check if the job queue might need to be changed.
    // check for jobs to add to the queue
}
