package dcc;

import dcc.sApp.DCob;

/**
 *
 * @author dusakus
 */
public class DCmainL implements DCob{
    
    int a = 0;
    DCoutputH log = StData.log;
    
    @Override
    public boolean init() {
        log.println("Init phrase done" ,"q");
        return true;
    }
    
    @Override
    public boolean tick() {
        if(a == 5){StData.mainLoop.add(new DCmainL());}
        if(a>100){return true;}else{a++;log.println("tick "+a,"q");return false;}
        
    }
    
    @Override
    public boolean stop() {
        log.println("You can't stop me!","q");
        return true;
    }
    
}
