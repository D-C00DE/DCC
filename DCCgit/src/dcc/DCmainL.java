package dcc;

import dcc.sApp.DCec;
import dcc.sApp.parts.TInfo;
import dcc.sify.boxes.LongB;

/**
 *
 * @author dusakus
 */
public class DCmainL extends DCec{
    
    
    int a = 0;
    DCoutputH log = StData.log;
    private LongB tk;
    
    @Override
    public boolean init() {
        info = new TInfo();
        log.println("Init phrase done" ,"q");
        return true;
    }
    
    @Override
    public boolean tick() {
        if(a == 40){tk = StData.mainLoop.add(new DCmainL());}
        if(a == 50){StData.mainLoop.kill(tk);}
        if(a>100){return true;}else{a++;log.println("tick "+a,"q");return false;}
        
    }
    
    @Override
    public boolean stop() {
        return true;
    }
    
}
