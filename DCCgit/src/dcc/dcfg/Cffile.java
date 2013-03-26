package dcc.dcfg;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class Cffile {
    
    public File file;
    
    public String app;
    public String appver;
    
    public List names;
    public List Data;
    
    public Cffile(){
        names = new ArrayList();
        Data = new ArrayList();
        names.add(0, "null");
        Data.add(0, new Cob("null", "null"));
        Cob nul = (Cob) Data.get(0);
        nul.valueD = 0.0;
        nul.valueI = 0;
        nul.valueB = false;
        nul.valueS = "null";
    }
    
    public void add(Cob in){
            names.add(in.name);
            Data.add(in);
            System.out.println("A new data was added at " + names.size() + " called " + in.name);       
    }
    public Cob get(String name){
        int addr = 0;
        addr = find(name);
        return (Cob) Data.get(addr);
    }
    private int find(String find){
        System.out.println("Now looking for " + find);
        boolean run = true;
        int id = 0;
        String checking;
        boolean found = false;
        while (run){
            id++;
            System.out.println("now looking at " + id);
            if(id > names.size()){
                run = false;
                return 0;
            }
            else{
                checking = (String) names.get(id);
            if (checking.equalsIgnoreCase(find)){
                System.out.println("found data titled " + find);
                run = false;
            }
        //return if found
            if(found == true){
                run = false;
                return id;
            }
        //continue
            System.out.println(find + " wasn't found at " + id);
            
            }
        }
        return 0;
    }
    public void remove(String name){
        
    }
    public void test(){
        System.out.println(this.get("null").valueS);
    }
}
