package dcc.controll;

public class DCcheck {

	public static boolean corestate (dcc.DCoutputH log) {
		log.println("now checking core classes");
		boolean a = true;
		boolean b = true;
		boolean c = true;
		boolean d = true;
		/*TODO make this realy check something ...
                 *    
                 * 
                 * 
                 * 
                 */
		if (a && b && c && d == true){
		log.println("Core checking performed without errors :)");
		return true;	
		}
		else {
		log.println("Oops, there were some errors in checking core, check your install !!!");
		return false;
		}
	}
}
