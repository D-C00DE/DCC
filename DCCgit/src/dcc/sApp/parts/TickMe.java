package dcc.sApp.parts;

import dcc.DCoutputH;
import dcc.sApp.DCob;
import java.util.ArrayList;

/**
 * @author dusakus
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
    public void tick(){
        for(DCob t : tbt){
            if (t != null){t.tick();}
            else{log.println("tried to tick null !", "D");}
        }
    }
}
