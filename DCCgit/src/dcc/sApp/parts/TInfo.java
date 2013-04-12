package dcc.sApp.parts;

import dcc.sApp.DCif;
import dcc.sify.boxes.LongB;

/**
 *
 * @author dusakusD
 */
public class TInfo {
    public String name = "Unknown Object";
    public LongB id;
    public DCif proc;
    
    public TInfo(){}
    public TInfo(String name, LongB id, DCif proc){
        this.name = name;
        this.id = id;
        this.proc = proc;
    }
    
}
