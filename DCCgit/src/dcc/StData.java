package dcc;

import dcc.dcfg.CFG;
import dcc.sApp.Loop;
import dcc.sApp.MTcore;
import java.io.File;

/**
 *
 * @author dusakus
 * 
 * This is going to be a static data storage, so
 * i won't need to pass so many things betwen objects/methods
 */
public class StData {
    static DCoutputH log;
    static CFG coreCfg;
    static File homeDir;
    static Loop mainLoop;
    static MTcore mainTM;
    
    
    public static void setLog(DCoutputH a){
        log = a;
    }
    public static void setHomeDir(File a){
        homeDir = a;
    }
    public static void GO(Object a,boolean MT){
        if (MT){
            mainTM = (MTcore) a;
        }
        else{
            mainLoop = (Loop) a;
            mainLoop.add(new DCmainL());
            mainLoop.start(-1);
        }
    }
    public static void setCC(CFG a){
        coreCfg = a;
    }
}
