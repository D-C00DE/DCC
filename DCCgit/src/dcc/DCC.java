package dcc;

import dcc.dcfg.CFG;

/**
 * @author dusakusD
 */
public class DCC {

    public static void main(String[] args) {
        DCoutputH log = new DCoutputH();
        CFG SYScf = new CFG(dcc.m.system.getfile.one(log, "CORE config file, please"), log);
        switch (SYScf.getS("OutputMode")){
            case("D"):
                log = new DCoutputH(true);
            default:
                break;
        }
        DCboot run = new dcc.DCboot(log,SYScf);
        run.start();
    }
}
