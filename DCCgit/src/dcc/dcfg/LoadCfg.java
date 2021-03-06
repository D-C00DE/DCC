package dcc.dcfg;

import java.io.File;
import dcc.DCoutputH;
import dcc.sify.MultiString;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import dcc.sify.SimString;

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
        cfg = new Cffile(log);
        cfg.file = fileI;
        try {
            readF();
        } catch (IOException ex) {
            log.println("!!! Something went wrong !!!");
            MultiString err = new MultiString(2);
            err.addL("An exception occured during reading data from");
            err.addL(fileI.toString());
            log.print(err, "E3");
        }
       return cfg;
    }
    public void readF() throws IOException{
        boolean a = false;
            a = readH();
        if (a == true){
            BufferedReader read = null;
            read = new BufferedReader(new FileReader(cfg.file));
            String line;
            line = read.readLine();
            line = read.readLine();
            line = read.readLine();
            line = read.readLine();
            boolean xend = true;
            while (xend){
                line = read.readLine();
                if (line == null){
                    break;
                }
                readL(line);
        }
            read.close();
        }
        else {
            log.println("looks like the header of this file is broken","E3");
        }
        
        
    }

    private boolean readH() throws IOException {
        log.println("Begin to read header of " + cfg.file, "D");
        log.println("=================================");
        char sf = '<';
        char ef = '>';
        boolean ver;
        BufferedReader read = null;
        read = new BufferedReader(new FileReader(cfg.file));
        String line;
        line = read.readLine();
        line = SimString.rmTo(line, sf);
        line = SimString.rmFrom(line, ef);
        cfg.fileVer = line;
        ver = Info.supported.contains(line);
            log.println(line);
        line = read.readLine();
        line = SimString.rmTo(line, sf);
        line = SimString.rmFrom(line, ef);
        cfg.app = line;
            log.println(line);
        line = read.readLine();
        line = SimString.rmTo(line, sf);
        line = SimString.rmFrom(line, ef);
        cfg.appver = line;
            log.println(line);
        read.close();
        log.println("=============[done]=============");
        return ver;
    }
    private boolean readL(String line) throws IOException {
        if(readLineCheck(line)){
            //put line reading code here
           line = SimString.rmFrom(line, '#');
           String typeS = SimString.rmFrom(line, ':');
           typeS = typeS.trim();
           String name = SimString.rmTo(line, ':');
           name = SimString.rmFrom(name, '=');
           name = name.trim();
           String valueS = SimString.rmTo(line, '=');
           valueS = valueS.trim();
           Cob out = new Cob(name);
            switch (typeS) {
                case "B":
                    if(valueS.equalsIgnoreCase("true")){out.valueB = true;      log.println("Wrote value true of type boolean as " + name + " to data tabble", "D");}
                    else{out.valueB = false;                                    log.println("Wrote value false of type boolean as " + name + " to data tabble", "D");}
                    break;
                case "I":
                    out.valueI = Integer.parseInt(valueS);
                    log.println("Wrote value "+out.valueI+" of type Integer to data tabble", "D");
                    break;
                case "D":
                    out.valueD = Double.parseDouble(valueS);
                    log.println("Wrote value "+out.valueD+" of type Double to data tabble", "D");
                    break;
                case "S":
                    out.valueS = valueS.trim();
                    log.println("Wrote value |"+out.valueS+"| of type String to data tabble", "D");
                    break;
                default:
                    MultiString err = new MultiString(5);
                    err.addL("Unrecognized Type : " + typeS);
                    err.addL("You should check what's wrong with your dcf file");
                    err.addL("It might be created for a newer version of Dcfg");
                    err.addL("Currently supported Types are : B, I, D and S");
                    err.addL("Your Dcfg version is: "+ dcc.dcfg.Info.ver +" and file is "+ cfg.fileVer);
                    log.print(err, "E1");
            }
           cfg.add(out);
           return true;
        }
        else{
            log.println("Skipping comment/invalid line", "D");
            return false;
        }
 
    }
    private boolean readLineCheck(String line){
        boolean a; boolean b; boolean c; boolean d; boolean e;
        log.println("===> Now validating: " + line, "D");
        a = line.startsWith("#");
        String lineb = line;
        lineb = SimString.rmTo(line, ':');
        b = lineb.contains(":");
        lineb = line;
        lineb = SimString.rmTo(line, '=');
        c = lineb.contains("=");
        d = line.contains(":");
        e = line.contains("=");
        if (a == false){
            if (b == false){
                if (c == false){
                    if (d){
                        if (e){
                            log.println("===> Passed", "D");
                            return true;
                        }
                        else{
                            log.println("===> Invalid line", "D");
                            return false;
                        }
                        }
                        else{
                            log.println("===> Invalid line", "D");
                            return false;
                    }
                    }
                        else{
                            log.println("===> Invalid line", "D");
                            return false;
                }
                }
                        else{
                            log.println("===> Invalid line", "D");
                            return false;
            }
            }
                        else{
                            log.println("===> Invalid line", "D");
                            return false;
        }
        
    }
    

}
