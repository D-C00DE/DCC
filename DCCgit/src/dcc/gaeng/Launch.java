package dcc.gaeng;

import java.io.File;

public class Launch {

	public static void start(dcc.DCoutputH log){
		log.println("GAME STARTING");
		File mapfile=dcc.m.system.getfile.one(log, "One map image file, please");
                Game game = new Game();
                game.setup(mapfile, log);
	}
}
