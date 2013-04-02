package dcc;

import dcc.dcfg.CFG;
import dcc.frame.minis.DFaskTF;
import java.io.File;
import java.net.URL;

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
        if(gfC > 2){
            log.println("Maybe you want to use defaults?");
            DFaskTF ask = new DFaskTF();
            boolean got = ask.ask("Maybe you want to use defaults?", "If you press YES core will be started with default settings. After clicking NO you will be able to select dcf file (again)");
            if (got == true){
                URL url = ClassLoader.getSystemResource("dcc/DATA/defCfg.dcf");
                SYScff = new File(url.getFile()); //Put in-jar-config-file here
                break;
            }
            else{gfC = 0;}
        }
        }
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

