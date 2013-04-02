package dcc;

import dcc.dcfg.CFG;
import java.io.File;

/**
 * @author dusakusD
 */
public class DCC {

    public static void main(String[] args) {
        DCoutputH log = new DCoutputH();
        File SYScff = null;
        byte gfC = 0;
        while(SYScff == null){
        SYScff = dcc.frame.minis.getfile.one(log, "CORE config file, please");
        if(SYScff == null){log.println("Hey, i asked you for a dcf file, didn't I?");gfC++;}
        }
        if(gfC > 5){log.println("Maybe you want to use defaults?");}
        CFG SYScf = new CFG(SYScff, log);
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
