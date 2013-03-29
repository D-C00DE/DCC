package dcc.sApp;

import dcc.DCoutputH;
import dcc.sApp.parts.TickMe;

public class Loop extends DCob{

    public boolean isRunning = false;
    private int tps = 0; 
    private DCoutputH log;
    private TickMe tbt;
	
    public Loop(DCoutputH logI){
        log = logI;
        tps = 1000;
        tbt = new TickMe(log);
        log.println("Tick system loaded","D");
    }
    public void start(long max){
        log.println("Loop just started", "D");
        //Speed controll variables
        long last = System.currentTimeMillis();
        int now;
        long ticks = 0;
        long started = System.currentTimeMillis();
        final int planned;
        planned = 1000/tps;
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
            if (tick() == true){
            break;
        }
            if (max>0){if (max<ticks){break;}}
            
        }
        log.println("Loop just Stopped, it did "+ ticks +" ticks, and worked for "+ (System.currentTimeMillis() - started) +" miliseconds", "D");
    }
    @Override
    public boolean tick(){
        return tbt.tick();
    }
    public void add(DCob in){
        tbt.Add(in);
    }
}
