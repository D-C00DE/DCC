/**
 * 
 */
package dcc.gaeng.map;

import java.awt.image.BufferedImage;
import dcc.DCoutputH;

/**
 * @author dusakus
 *
 */
public class LoadMap {
	private static MapOBJ map;
	static BufferedImage mapfile;
	
	public LoadMap(BufferedImage gmapfile){
		mapfile = gmapfile;
		map = new MapOBJ(mapfile, mapfile.getRGB(1, 1));
		generateMap();
		
	}
	public MapOBJ getMap() {
		return map;
	}
	void generateMap(){
		
	}
	void readMapData(){
            
	}
	String readString(int x, int y){
		return null;
		
	}
	String readCharTile(int x, int y){
		return null;
		
	}

}
