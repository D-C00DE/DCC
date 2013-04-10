package dcc.sify;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

/**
 *
 * @author dusakus
 */
public class SimStream {
    public synchronized static void copy(URL in, File out) throws IOException{
        String line = null;
        BufferedReader Ain = new BufferedReader(new FileReader(in.getFile()));
        line = Ain.readLine();
        PrintWriter Aout = new PrintWriter(out);
        while (line != null){
            Aout.println(line);
            line = Ain.readLine();
        }
        Aout.close();
    }
}
