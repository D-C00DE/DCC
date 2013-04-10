package dcc;

import dcc.sify.MultiString;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DCoutputH {
    
    boolean debug = false;
    Date time;
    DateFormat timed;
    File logfile;
    private boolean toFile = false;
    PrintWriter FO;

    public DCoutputH(){
        timed = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
	time = new Date();
        logfile = new File(System.getProperty("user.dir")+"/stuD10/sys/DCC/CoreLog.dcl");
	logfileC();
    }
    
    public DCoutputH(boolean debugI){
        timed = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
	time = new Date();
	debug = debugI;
        logfile = new File(System.getProperty("user.dir")+"/stuD10/sys/DCC/CoreLog.dcl");
	logfileC();
    }
    public DCoutputH(boolean debugI,String where){
        timed = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
	time = new Date();
	debug = debugI;
        logfile = new File(where);
	logfileC();
        
    }
     public DCoutputH(long jtbd){
        timed = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
	time = new Date();
     }
    private void logfileC(){
        println("Setting up log file as "+ logfile.toString());
        try{
            if (logfile.exists()){
                println(logfile.toString() + " already exist, clearing");
            }
            else{
                println("creating new log file");
                logfile.createNewFile();
            }
            if (logfile.canWrite()){
                FO = new PrintWriter(logfile);
            }
            else{
                println("Whops, no write acces");
            }
            
            toFile = true;
        }
        catch(IOException e){
            e.printStackTrace();
            toFile = false;
            println("logging to file disabled");
        }
    }
    public boolean println (String input){
		System.out.println("[" + timed.format(time) + "] " + input);
                if (toFile){
                    FO.println("[" + timed.format(time) + "] " + input);
                }
		return true;
	}
    public void print (String pre,MultiString input){
		for (int c = 1;c-1<input.lines;c++){
                this.println(pre + (String) input.line.get(c));
                }
    }
    public void print (MultiString input){
		for (int c = 1;c-1<input.lines;c++){
                this.println((String) input.line.get(c));
                }
    }
    public boolean println (String input,String mode){
		switch (mode) {
                    case "N":
                        this.println(input);
                        break;
                    case "E1":
                        //for a little error
                        this.println("[E1] Whops ...");
                        this.println("[E1]=> " + input);
                        this.println("[E1] of course it's still working :)");
                        break;
                    case "E2":
                        this.println("[E2] Something went wrong ...");
                        this.println("[E2]=> " + input);
                        this.println("[E2] but it didn't crashed yet ;)");
                        break;
                    case "E3":
                        this.println("[E3] I have very bad news");
                        this.println("[E3]=> " + input);
                        this.println("[E3] <Skips the problematic thingy>");
                        break;
                    case "E4":
                        this.println("[E4] Oh, it hurts so much");
                        this.println("[E4]=> " + input);
                        this.println("[E4] i'm dying !");
                        this.println("BZZt Bzzt bzz...");
                        System.exit(2);
                    case "E5":
                        this.println("[E5] Critical error ocured:");
                        this.println("[E5]=> " + input);
                        this.println("[E5] Killing in NOW");
                        this.println("!!!ERROR!!!");
                        System.exit(2);
                    case "D":
                        if(debug){this.println("[Debug]=> " + input);}
                        break;
                    case "debug":
                        if(debug){this.println("[Debug]=> " + input);}
                        break;
                    case "E6S":
                        this.println("[E6] Sorry, but "+ input);
                        this.println("[E6] You might try again ;)");
                        break;
                    default:
                        this.println(input);

    }
                return true;
	}
    public boolean print (MultiString input,String mode){
		switch (mode) {
                    case "N":
                        this.print("",input);
                        break;
                    case "E1":
                        //for a little error
                        this.println("[E1] Whops ...");
                        this.print("[E1]=> ",input);
                        this.println("[E1] of course it's still working :)");
                        break;
                    case "E2":
                        this.println("[E2] Something went wrong ...");
                        this.print("[E2]=> ",input);
                        this.println("[E2] but it didn't crashed yet ;)");
                        break;
                    case "E3":
                        this.println("[E3] I have very bad news");
                        this.print("[E3]=> ",input);
                        this.println("[E3] <Skips the problematic thingy>");
                        break;
                    case "E4":
                        this.println("[E4] Oh, it hurts so much");
                        this.print("[E4]=> ",input);
                        this.println("[E4] i'm dying !");
                        this.println("BZZt Bzzt bzz...");
                        System.exit(2);
                    case "E5":
                        this.println("[E5] Critical error ocured:");
                        this.print("[E5]=> ",input);
                        this.println("[E5] Killing in NOW");
                        this.println("!!!ERROR!!!");
                        System.exit(2);
                    case "D":
                        if(debug){this.print("[Debug]=> ",input);}
                        break;
                    case "debug":
                        if(debug){this.print("[Debug]=> ",input);}
                        break;
                    default:
                        this.print("",input);

    }
                return true;
	}

    //So funny, INTeger input = INTput
    public boolean printint(int INTput) {
                println(INTput + "");
		
		return true;
    }
    public void END(String smthng){
        println(smthng);
        println("   <===[ This is the end ]===>    ");
        FO.close();
    }
}
