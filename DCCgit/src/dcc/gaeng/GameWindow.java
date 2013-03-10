package dcc.gaeng;

import dcc.DCoutputH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class GameWindow extends JFrame implements KeyListener,
        ActionListener{
    public boolean[] keys = new boolean[260];
    DCoutputH log;

	/**TODO Game window code
	 * 
	 */
	private static final long serialVersionUID = 285935409014967314L;
	
	public void create(dcc.DCoutputH logI){
	this.setTitle("TEST"); 
        this.setSize(800, 600); 
        this.setResizable(false);
        this.addKeyListener(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        this.setVisible(true);
        this.setFocusable( true );
        log = logI;
        //pastein
        
}	
	public boolean isK(int keyCode) { 
            if (keyCode > 0 && keyCode < 260) 
            { 
                    return keys[keyCode]; 
            } 
            
            return false; 
    } 

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() > 0 && e.getKeyCode() < 256) 
        { 
                keys[e.getKeyCode()] = true;
                log.println("Detected that key no. " + e.getKeyCode() + " is pressed");
        } 
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() > 0 && e.getKeyCode() < 256) 
        { 
            keys[e.getKeyCode()] = false; 
        } 
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        public void fin(){
            if ( keys[27] == true){
                log.println("launch Aborted, BYE");
                System.exit(0);
            }
        }
 
}
