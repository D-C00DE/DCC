package dcc.dcfg;

import java.io.File;
public class Cffile {
    
    public File file;
    
    public String app;
    public String appver;
    
    public String[] names;
    public Cob[] Data;
    
    public Cffile(){
        this.names = new String[100];
        this.Data = new Cob[100];
        
        names[0] = "null";
        Data[0] = new Cob("null", "null");
        Data[0].valueB = false;
        Data[0].valueD = 0.0;
        Data[0].valueI = 0;
    }
    
    public void add(Cob in){
        if (find(in.name) == 0){
            names[names.length + 1] = in.name;
            Data[names.length] = in;
        }
    }
    public Cob get(String name){
        int addr = 0;
        addr = find(name);
        return Data[addr];
    }
    private int find(String find){
        boolean run = true;
        int id = 0;
        boolean found = false;
        while (run){
        //Part where strings are compared
            found = names[id].equalsIgnoreCase(find);
        //return if found
            if(found == true){
                run = false;
                return id;
            }
        //continue
            id++;
            if(id > names.length){
                run = false;
                return 0;
            }
        
        }
        return 0;
    }
    public void remove(String name){
        
    }
}
