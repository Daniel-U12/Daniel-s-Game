package com.game.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{
	
	private static final long serialVersionUID = -1478604005915452565L;
	
	//Creates a window that will display your game
	public Window(int width, int height, String title, GameMain game){
		
		//Keywords that create window argument is the windows title
		JFrame frame = new JFrame(title);
		
		//Setting size of window
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		//Setting exit on close (stop program on x click)
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Setting window to not resizable
		frame.setResizable(false);
		//Window will open in middle of screen
		frame.setLocationRelativeTo(null);
		//Adds game class to window
		frame.add(game);
		//Makes window visible
		frame.setVisible(true);
		//Runs start function
		game.start();
		frame.setFocusable(true);

	}
}
