package dcc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DCoutputH {
    
    boolean debug = false;
    Date time;
    DateFormat timed;

    public DCoutputH(){
        timed = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
	time = new Date();
	}
    
    public DCoutputH(boolean debugI){
        timed = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
	time = new Date();
	debug = debugI; 
    }
    public boolean println (String intput){
		System.out.println("[" + timed.format(time) + "] " + intput);
		return true;
	}
    public boolean println (String intput,String mode){
		switch (mode) {
                    case "N":
                        this.println(intput);
                    case "E1":
                        //for a little error
                        this.println("[E1] Whops ...");
                        this.println("[E1]=> " + intput);
                        this.println("[E1] of course it's still working :)");
                    case "E2":
                        this.println("[E2] Something went wrong ...");
                        this.println("[E2]=> " + intput);
                        this.println("[E2] but it didn't crashed yet ;)");
                    case "E3":
                        this.println("[E3] I have very bad news");
                        this.println("[E3]=> " + intput);
                        this.println("[E3] <hardly continues it's work>");
                    case "E4":
                        this.println("[E4] I'm so sorry...");
                        this.println("[E4]=> " + intput);
                        this.println("[E4] i'm dying !");
                        try {this.wait(1000);} catch (InterruptedException ex){}
                        this.println("BZZt Bzzt bzz...");
                        System.exit(2);
                    case "E5":
                        this.println("[E5] Critical error ocured:");
                        this.println("[E5]=> " + intput);
                        this.println("[E5] Killing in 1 second");
                        try {this.wait(1000);} catch (InterruptedException ex){}
                        this.println("!!!ERROR!!!");
                        System.exit(2);
                    case "D":
                        if(debug){this.println("[Debug]=> " + intput);}
                    case "Debug":
                        if(debug){this.println("[Debug]=> " + intput);}

    }
                return true;
	}

    public boolean println(int intput) {
                System.out.println("[" + timed.format(time) + "] " + intput);
		
		return true;
    }
}
