package dcc.sApp;

import dcc.DCoutputH;
import dcc.sApp.parts.TickMe;
import dcc.sify.boxes.LongB;

public class Loop implements DCif{

    public boolean isRunning = false;
    private int tps = 0; 
    private DCoutputH log;
    private TickMe tbt;
	
    public Loop(DCoutputH logI){
        log = logI;
        tps = 12;
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
        final int planned = 1000/tps;
        int tick;
	isRunning = true;
	while (isRunning){
            //Sped controll system ;)
            now = (int) (System.currentTimeMillis() - last);
            last = System.currentTimeMillis();
            tick = planned - now;
            if (tick > 0){
                try{Thread.sleep(tick);} 
                catch(Exception e){log.println("Error in Loop, failed to sleep for "+tick+"ms", "E1");} 
            } else { 
            }
            ticks++;
            //real tick here:
            if (tick() == true){break;}
            //END if finished
            if (max>0){if (max<ticks){break;}}
            
        }
        tbt.tickE();
        log.println("Loop just Stopped, it did "+ ticks +" ticks, and worked for "+ (System.currentTimeMillis() - started) +" miliseconds", "D");
    }
    @Override
    public boolean tick(){
        return tbt.tick();
    }
    public void kill(LongB tk){
        tbt.killQ.add(tk);
    }
    public LongB add(DCec in){
        return tbt.Add(in);
    }

    @Override
    public boolean init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean stop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
