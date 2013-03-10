package dcc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DCoutputH {

	public boolean println (String intput){
		DateFormat timed = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
		Date time = new Date();
		System.out.println("[" + timed.format(time) + "] " + intput);
		
		return true;
	}
}
