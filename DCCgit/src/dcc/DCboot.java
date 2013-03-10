package dcc;
import dcc.controll.DCcheck;
public class DCboot {
    DCoutputH log = new DCoutputH();
        public void main(){
		String version = info_DC.ver;
		log.println("D-CODE core " + version + " booting up now");
		if (DCcheck.corestate(log) == true){
			log.println("now loading . . .");
                        switch (info_DC.mode){
                            case "gameC":
                                dcc.gaeng.Launch.start(log);
                                log.println("Thanks for playing :)");
                            default:
                                log.println("invalid mode selected");
                                System.exit(1);
                        }
                        
		}
		else{
			log.println("Init Aborted, BYE");
                        System.exit(1);
		}

	}

}
