package dcc.sApp.parts;

import dcc.DCoutputH;
import dcc.sApp.DCob;
import java.util.ArrayList;

/**
 * @author dusakus
 * This is the core of the ticking system.
 * It can tick any DCob added to it
 */
public class TickMe {
    DCoutputH log;
    private ArrayList<DCob> tbt;
    private ArrayList<DCob> addQueue = new ArrayList<DCob>();

    public TickMe(DCoutputH logI) {
        log = logI;
        this.tbt = new ArrayList<DCob>();
    }
    public void Add(DCob in){
        addQueue.add(in);
        in.init();
    }
    public boolean tick(){
        boolean stop = false;
        for(DCob t : tbt){
            if (t != null){
                if (t.tick()){
                    log.println("Stopping as asked by " + t.name, "D");
                    return true;
                }
            }
            else{log.println("tried to tick null !", "D");}
        }
        if(!addQueue.isEmpty()){
            tbt.addAll(addQueue);
            addQueue.clear();
            log.println("queue appended", "D");
        }
        return false;
    }
}
