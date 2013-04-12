package dcc.sApp.parts;

import dcc.DCoutputH;
import dcc.sApp.DCec;
import dcc.sApp.DCif;
import dcc.sify.boxes.LongB;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author dusakus
 * This is the core of the ticking system.
 * It can tick any DCob added to it
 */
public class TickMe {
    DCoutputH log;
    private ArrayList<DCec> tbt;
    private ArrayList<DCec> addQueue = new ArrayList<DCec>();
    private ArrayList<TInfo> ids = new ArrayList<TInfo>();
    public ArrayList<LongB> killQ = new ArrayList<LongB>();

    public TickMe(DCoutputH logI) {
        log = logI;
        this.tbt = new ArrayList<DCec>();
    }
    public LongB Add(DCec in){
        addQueue.add(in);
        in.init();
        long a = System.currentTimeMillis();
        LongB a1 = new LongB(a);
        in.info = new TInfo(in.name, a1, in);
        ids.add(in.info);
        return a1;
    }
    public boolean tick(){
        ArrayList<DCec> killQ1;
        boolean stop = false;
        for(DCec t : tbt){
            if (t != null){
                if (t.tick()){
                    log.println("Stopping as asked by " + t.info.name, "D");
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
        if(!killQ.isEmpty()){
            killQ1 = new ArrayList<DCec>();
            for(LongB a : killQ){
                log.println("attempted to kill "+a.a, "D");
                for(DCec b : tbt){
                    log.println("Trying on "+b.info.id.a , "D");
                        if(a == b.info.id){
                            b.stop();
                            killQ1.add(b);
                            ids.remove(b.info);
                            log.println("process killed", "D"); 
                            break;
                    }
                    
                    
                }
            }
            for(DCec a : killQ1){
                tbt.remove(a);
            }
            killQ1 = null;
            killQ.clear();
        }
        return false;
    }
    public void tickE(){
        for(DCec t : tbt){
            if (t != null){
                t.stop();
            }
        }
    }
}
