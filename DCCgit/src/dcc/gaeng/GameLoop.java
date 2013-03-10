package dcc.gaeng;

import java.io.File;

public class GameLoop {

	boolean isRunning = false;
	Game game = null;
        long time = 0;
        byte fps = 0; 
	
	public GameLoop(Game g, dcc.DCoutputH log){
		fps = 50;
                game = g;
        }
	public void start(){	
		isRunning = true;
		
		while (isRunning){
			isRunning = game.fin();
                        if(game.window.keys[81]=true){ isRunning = false; }
			time = (1000 / fps) - (System.currentTimeMillis() - time); 
            
                 if (time > 0) 
                    { 
                    try 
                        { 
                            Thread.sleep(time); 
                        } 
                        catch(Exception e){} 
                    }
                 game.tick();
                 
                }       
		
		
	}
	
}
