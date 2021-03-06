package dcc.dcfg;

import dcc.DCoutputH;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class Cffile {
    
    public File file;
    public String fileVer;
    
    public String app;
    public String appver;
    
    public List names;
    public List data;
    
    private final DCoutputH log;
    
    public Cffile(DCoutputH logI){
        log = logI;
        names = new ArrayList();
        data = new ArrayList();
        names.add(0, "null");
        data.add(0, new Cob("null", "null"));
        Cob nul = (Cob) data.get(0);
        nul.valueD = 0.0;
        nul.valueI = 0;
        nul.valueB = false;
        nul.valueS = "null";
    }
    
    public void add(Cob in){
            names.add(in.name);
            data.add(in);
            if (names.size() == data.size()){
                 log.println("A new data was added at " + names.size() + " called " + in.name, "D");
            }
            else{
                 log.println("Something went terribly wrong :" + names.size() + " is not same as  " + in.name, "E5");
            }
    }
    public Cob get(String name){
        int addr = 0;
        addr = find(name);
        return (Cob) data.get(addr);
    }
    private int find(String find){
        log.println("====]Now looking for " + find, "D");
        boolean run = true;
        int id = 0;
        String checking = "NULL";
        boolean found = false;
        while (run){
            id++;
            log.println("==]now looking at " + id, "D");
            if(id > names.size()){
                run = false;
                return 1;
            }
            else{
                try{checking = (String) names.get(id);}
                catch(IndexOutOfBoundsException ex){run = false;log.println("Reached end of list", "D");}
                log.println("==]" +checking, "D");
            if (checking.equalsIgnoreCase(find)){
                log.println("==]found data titled " + find, "D");
                run = false;
            }
            else{log.println("==]" +find + " wasn't found at " + id, "D");}
        //return if found
            if(found == true){run = false;return id;}
            }
        }
        return 1;
    }
    public void remove(String name){
        
    }
    public void test(){
        log.println(this.get("PAR").name, "D");
    }
}
