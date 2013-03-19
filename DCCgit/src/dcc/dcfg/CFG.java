package dcc.dcfg;

import dcc.DCoutputH;
import java.io.File;
/**
 *
 * @author dusakusD
 */
public class CFG {
    public Cffile cfg;
    DCoutputH log;
    
    public CFG(File file, DCoutputH logI){
        //TODO Cfg manager structure
        log = logI;
        LoadCfg loader = new LoadCfg();
        cfg = loader.load(file, log);
        loader = null;
    }
}
