package dcc.sApp;

import dcc.DCoutputH;
import dcc.sApp.parts.TickMe;

public class Loop {

    public boolean isRunning = false;
    private byte tps = 0; 
    private DCoutputH log;
    private TickMe tbt;
	
    public Loop(DCoutputH logI){
        log = logI;
        tps = 50;
        tbt = new TickMe(log);
        log.println("Tick system loaded","D");
    }
    public void start(){
        log.println("Loop just started", "D");
        //Speed controll variables
        long last = System.currentTimeMillis();
        int now;
        long ticks = 0;
        final int planned;
        planned = 100/tps;
        int tick;
	isRunning = true;
	while (isRunning){
            //Sped controll system ;)
            now = (int) (last - System.currentTimeMillis());
            last = System.currentTimeMillis();
            tick = planned - now;
            if (tick > 0){ 
                try{Thread.sleep(tick);} 
                catch(Exception e){log.println("Error in Loop, failed to sleep for "+tick+"ms", "E1");} 
            }
            ticks++;
            //real tick here:
            tbt.tick();
            
        }
        log.println("Loop just Stopped", "D");
    }
}
