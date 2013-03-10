package dcc.dcfg;

import java.io.File;
/**
 *
 * @author dusakusD
 */
public class CFG {
    Cffile cfg;
    
    public CFG(File file){
        //TODO Cfg manager structure
        cfg = LoadCfg.load(file);
    }
}
