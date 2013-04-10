package dcc.sApp;

import dcc.DCoutputH;

/**
 * @author dusakus
 */
public interface DCob{
    public String name = "Unknown Object";
    public abstract boolean tick();
        //put your ticking code here
        //return true if Loop should stop or this thread should be stopped
    public abstract boolean init();
        //Your initialization code for thread or loop part
    public abstract boolean stop();
        //STOP ALL THE THINGS
        // after calling this method this object will be DESTROYED
    
}
