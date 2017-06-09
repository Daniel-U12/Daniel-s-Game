package com.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameKeyListener extends KeyAdapter{

	private Handler handler;
	
	
	public GameKeyListener(Handler handler){
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e){
		int keyDwn = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player){
				//All player key events go here
				System.out.println("input");
				if (keyDwn == KeyEvent.VK_W) tempObject.setVelY((-1));
				else if (keyDwn == KeyEvent.VK_S) tempObject.setVelY(1);
				else if (keyDwn == KeyEvent.VK_D) tempObject.setVelX(1);
				else if (keyDwn == KeyEvent.VK_A) tempObject.setVelX((-1));
			}
			
		}
	}
	public void keyReleased(KeyEvent e){
		int keyUp = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player){
				if (keyUp == KeyEvent.VK_W) tempObject.setVelY(0);
				else if (keyUp == KeyEvent.VK_S) tempObject.setVelY(0);
				else if (keyUp == KeyEvent.VK_D) tempObject.setVelX(0);
				else if (keyUp == KeyEvent.VK_A) tempObject.setVelX(0);
			}
		}
		
	}
}
