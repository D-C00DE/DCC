package dcc.gaeng.map;

import java.awt.image.BufferedImage;

public class MapOBJ {
	
        BufferedImage base;
	int type;
	MapLayer layers[];
	
	public MapOBJ(BufferedImage baseI, int typeI){
            base = baseI;
            type = typeI;

	}
	public void AddLayer(MapLayer I){
		int a = layers.length;
		a++;
		layers[a] = I; 
	}
}
