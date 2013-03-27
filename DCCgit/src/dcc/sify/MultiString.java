package dcc.sify;

/**
 * @author dusakus
 */
public class MultiString {
    public final int lines;
    public String[] line;
    
    public MultiString(int linesI){
        lines = linesI;
        line = new String[lines];
    }
    public void addL(String linein){
        line[line.length + 1] = linein;
    }
}
