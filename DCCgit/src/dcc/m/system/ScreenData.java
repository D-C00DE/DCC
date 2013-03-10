package dcc.m.system;

import java.awt.Dimension;
import java.awt.Toolkit;

public class ScreenData {
public static double get(String code){
	/*
	 * Possible codes:
	 * w - width
	 * h - height
	 * hc - w center
	 * wc - h center
	 */
	Toolkit toolkit =  Toolkit.getDefaultToolkit ();
	Dimension dim = toolkit.getScreenSize();
	if (code == "w"){
		return dim.getWidth();
	}
	else if (code == "h"){
		return dim.getHeight();
	}
	else if (code == "wc"){
		double c = dim.getWidth() / 2;
		return c;
	}
	else if (code == "hc"){
		double c = dim.getHeight() / 2;
		return c;
	}
	else{
		return 0;
	}
}
public static double get0point(String code,double w,double h){
	/*
	 * Possible codes:
	 * w - width
	 * h - height
	 */
	double o = 0.0;
    switch (code) {
        case "w":
            o = w/2;
            o = get("wc") - o;
            return o;
        case "h":
            o=h/2;
            o = get("hc") - o;
            return o;
        default:
            return 0;
    }
}
}
