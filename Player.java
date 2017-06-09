package com.game.main;

import java.awt.Color;
import java.awt.Graphics;


public class Player extends GameObject {

	public Player(int x, int y, ID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
  
	}

	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		System.out.println("tick");
	}

	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.blue);
		g.fillRect(x, y, 10, 10);
		System.out.println("render");
		
		
	}
	
	


}
