package dcc.image;

import dcc.image.parts.Pixel;
import dcc.sApp.DCec;
import java.awt.image.BufferedImage;

/**
 * @author dusakus
 */
public class DCimgObj extends DCec{
	BufferedImage img;
        Pixel[][] pixels;
	public DCimgObj (BufferedImage imgI){
		img = imgI;
                pixels = new Pixel[img.getWidth()][img.getHeight()];
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
    private void readIMG(){
        //Image will be loaded to pixels[][] here
    }

    @Override
    public boolean tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
