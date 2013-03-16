package dcc.dcfg;

import java.io.File;
import dcc.DCoutputH;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author dusakusD
 * 
 * Most of logging here is for debug only
 */
public class LoadCfg {
    DCoutputH log;
    Cffile cfg;
    public Cffile load(File fileI, DCoutputH logI){
        log = logI;
        cfg = new Cffile();
        cfg.file = fileI;
        readF();
       return cfg;
    }
    public void readF(){
        try {
            readH();
        } catch (IOException ex) {
            log.println("Failed to read config file header [E]");
        }
        
    }

    private boolean readH() throws IOException {
        log.println("Begin to read header of " + cfg.file);
        log.println("=================================");
        char sf = '<';
        char ef = '>';
        boolean ver;
        BufferedReader read = null;
        try {
            read = new BufferedReader(new FileReader(cfg.file));
        } catch (FileNotFoundException ex) {
            log.println("Failed to read config file header [I]");
        }
        String line;
        line = read.readLine();
        line = dcc.sify.SimString.rmTo(line, sf);
        line = dcc.sify.SimString.rmFrom(line, ef);
        ver = Info.supported.contains(line);
            log.println(line);
        line = read.readLine();
        line = dcc.sify.SimString.rmTo(line, sf);
        line = dcc.sify.SimString.rmFrom(line, ef);
        cfg.app = line;
            log.println(line);
        line = read.readLine();
        line = dcc.sify.SimString.rmTo(line, sf);
        line = dcc.sify.SimString.rmFrom(line, ef);
        cfg.appver = line;
            log.println(line);
        read.close();
        log.println("=============[done]=============");
        return ver;
    }
    

}
