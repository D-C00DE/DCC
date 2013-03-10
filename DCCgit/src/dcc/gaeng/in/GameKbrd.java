package dcc.gaeng.in;

import dcc.gaeng.GameWindow;
import java.awt.Component;
import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKbrd implements KeyListener, KeyEventDispatcher {
	
	public boolean keys[];
	Component c;
	
	public GameKbrd(Component cd) 
    { 
            cd.addKeyListener(this); 
    } 

	@Override
	public boolean dispatchKeyEvent(KeyEvent arg0) {
		return false;
	}
	
	public boolean isK(int keyCode) 
    { 
            if (keyCode > 0 && keyCode < 256) 
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

	public void create(GameWindow cd) {
		cd.addKeyListener(this);
		int x = 0;
		while (x < 257){
			keys[x] = false;
			x++;
		}
		
	}

}
