package dcc.sify;

import java.util.ArrayList;

/**
 * @author dusakus
 */
public class MultiString {
    public final int lines;
    public ArrayList line = new ArrayList();
    
    public MultiString(int linesI){
        lines = linesI;
        line.add(0, "null");
    }
    public void addL(String lineI){
        line.add(line.size(),lineI);
    }
}
