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

    public TickMe(DCoutputH logI) {
        log = logI;
        this.tbt = new ArrayList<DCob>();
    }
    public void Add(DCob in){
        tbt.add(in);
    }
    public boolean tick(){
        boolean stop = false;
        for(DCob t : tbt){
            if (t != null){
                if (t.tick() != false){
                return true;
                }
            }
            else{log.println("tried to tick null !", "D");}
        }
        return false;
    }
}
