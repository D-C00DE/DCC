package dcc.sify;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author dusakus
 */
public class siFile {
    public static boolean create(String what){
        File w = new File(what);
        try{
            w.createNewFile();
        }
        catch(IOException e){
            mkdir(SimString.rmFrom(what, '/'));
        }
        try{
            w.createNewFile();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        if (w.exists()){
           return true; 
        }
        return false;
    }
    public static void mkdir(String what){
        File w = new File(what);
        w.mkdirs();
    }
    public static void extract(URL what, File toWhere, boolean overwrite){
        try{
            if(toWhere.exists()){
                if(overwrite){
                    toWhere.delete();
                    toWhere.createNewFile();
                    SimStream.copy(what, toWhere);
                }
            }
            else{
                toWhere.createNewFile();
                SimStream.copy(what, toWhere);
            }
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
    }
}
