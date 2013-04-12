package dcc.sApp;

import dcc.DCoutputH;
import dcc.sApp.parts.TInfo;

/**
 * @author dusakus
 */
public class DCec implements DCif{
    public String name = "untitled";
    public TInfo info = new TInfo();
    
    @Override
    public boolean tick(){
        return false;
        
    }
    @Override
    public boolean init(){
        return false;
        
    }
    @Override
    public boolean stop(){
        return false;
    }
}
