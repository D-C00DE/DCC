package dcc;

import dcc.dcfg.CFG;

public class DCboot {
    DCoutputH log;
    CFG SYScf;

    DCboot(DCoutputH logI,CFG SYScfI) {
        log = logI;
        SYScf = SYScfI;
    }
        public void start(){
		String version = info_DC.ver;
		log.println("D-CODE core " + version + " booting up now");
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

}
