package com.game.main;

import java.awt.Color;
import java.awt.Graphics;

public class BasicEnemy extends GameObject {

	public BasicEnemy(int x, int y, ID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		
	}
	public BasicEnemy(int x, int y, ID id, double velY) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.velY = velY;
	}

	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		
	}

	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
	}
	
	

}
