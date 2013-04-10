package dcc;

import dcc.dcfg.CFG;
import dcc.frame.minis.DFaskTF;
import dcc.sApp.Loop;
import java.io.File;
import java.net.URL;

/**
 * @author dusakus
 */
public class DCC {

    public static void main(String[] args) {
        //boot-time log creation
        DCoutputH log = new DCoutputH(0L);
        StData.setLog(log);
        //Setting up home directory
        File HomeDir = new File(System.getProperty("user.dir")+"/stuD10/sys/DCC");
        if(!HomeDir.isDirectory()){
            log.println("Woho, new install :)");
            dcc.sify.siFile.mkdir(System.getProperty("user.dir")+"/stuD10/sys/DCC");
            dcc.sify.siFile.extract(ClassLoader.getSystemResource("dcc/DATA/defCfg.dcf"), new File(HomeDir.getPath()+"/config.dcf"), true);
        }
        StData.setHomeDir(HomeDir);
        //accessing core configuration file
        File SYScff = null;
        byte gfC = 0;
        File aSYScff = new File(System.getProperty("user.dir")+"/stuD10/sys/DCC/config.dcf");
        if (aSYScff.canRead()){if(aSYScff.isFile()){SYScff = aSYScff;}}
        //If not avaiable ask for one
        else{
        while(SYScff == null){
        SYScff = dcc.frame.minis.getfile.one(log, "CORE config file, please");
        if(SYScff == null){log.println("Hey, i asked you for a dcf file, didn't I?");gfC++;}
        if(gfC > 2){
            log.println("Maybe you want to use defaults?");
            DFaskTF ask = new DFaskTF();
            boolean got = ask.ask("Maybe you want to use defaults?", "If you press YES core will be started with default settings. After clicking NO you will be able to select dcf file (again)");
            if (got == true){
                URL url = ClassLoader.getSystemResource("dcc/DATA/defCfg.dcf");
                SYScff = new File(url.getFile()); //I hope this will work
                break;
            }
            else{gfC = 0;}
        }
        }
        }
        //prasing it
        CFG SYScf = new CFG(SYScff, log);
        //Resetting DCoutputH
        switch (SYScf.getS("OutputMode")){
            case("D"):
                log = new DCoutputH(true);
            default:
                break;
        }
        //Setting up and INIT
        StData.setCC(SYScf);
        StData.GO(new Loop(log), false);
        log.END("BYE");
    }
}

