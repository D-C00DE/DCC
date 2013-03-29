package dcc.gaeng;

import dcc.gaeng.in.GameKbrd;
import dcc.DCoutputH;
import java.awt.image.BufferedImage;
import dcc.gaeng.map.LoadMap;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dcc.gaeng.map.MapOBJ;

public class Game {
	
	GameWindow window = new GameWindow();
	GameKbrd kbrd;
	MapOBJ map;
        DCoutputH log;
	
	public void setup(File mapfile, dcc.DCoutputH logI){
		log = logI;
                window.create(log);
		BufferedImage mapIMG = null;
		if (mapIMG != null){
                    try {mapIMG = ImageIO.read(mapfile);}
                    catch (IOException e) {log.println("I think I need an IMAGE (You know, some random colorfull dots)", "E6S");}
                    LoadMap MapLoader = new LoadMap(mapIMG);
                    map = MapLoader.getMap();
            }
                          else{
                              log.println("I need a file, not null", "E6");
                          }
	}
	public void tick(){
		window.fin();
	}
	public boolean fin() {
		if (window.isK(27) == true){
                    log.println("launch Aborted, BYE");
			return false;
		}

		return true;
	}
	
}
