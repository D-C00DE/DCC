package dcc.sify;

/**
 * @author dusakusD
 */
public class SimString {
    public static String rmTo(String in, int c){
        int crop = in.indexOf(c);
        String out = in;
        if(crop != -1){out = in.substring(crop + 1);}
        return out;
    }
    public static String rmFrom(String in, int c){
        int crop = in.lastIndexOf(c);
        String out = in;
        if(crop != -1){out = in.substring(0, crop);}
        return out;
    }
    public static String rmFT(String in, int c){
        String a = rmTo(in, c);
        String out = rmFrom(a, c);
        
        return out;
    }
    public static String rmTo(String in, char c){
        int crop = in.indexOf(c);
        String out = in;
        if(crop != -1){out = in.substring(crop + 1);}
        return out;
    }
    public static String rmFrom(String in, char c){
        int crop = in.lastIndexOf(c);
        String out = in;
        if(crop != -1){out = in.substring(0, crop);}
        return out;
    }
    public static String rmFT(String in, char c){
        String a = rmTo(in, c);
        String out = rmFrom(a, c);
        
        return out;
    }
}
