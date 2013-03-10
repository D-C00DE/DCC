package dcc.image;

import java.awt.image.BufferedImage;

/**
 * @author dusakus
 */
public class DCimgObj {
	BufferedImage img;
	public DCimgObj (BufferedImage imgI){
		img = imgI;
	}

	public byte gColor(String select, int x, int y){
		int in = img.getRGB(x,y);
                System.out.println(in);
		byte oa = (byte) ((in >>> 24) & 0xff);
		byte or = (byte) ((in >>> 16) & 0xff);
		byte og = (byte) ((in >>> 8) & 0xff);
		byte ob = (byte) (in & 0xff);
            switch (select) {
                case "a":
                    return oa;
                case "r":
                    return or;
                case "g":
                    return og;
                case "b":
                    return ob;
                default:
                    return 0;
            }
		
	}

}
