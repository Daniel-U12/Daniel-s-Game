package com.game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

class GameMain extends Canvas implements Runnable{

	private static final long serialVersionUID = 1525197236839639085L;
	
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	//Setting width/height of game window
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	
	//Main function, calls window class
	public GameMain() {
		handler = new Handler();
		
		new Window(WIDTH, HEIGHT, "Daniel's Game", this);
		
		this.addKeyListener(new GameKeyListener(handler));
		
		handler.addObject(new Player(100, 50, ID.Player));
		//handler.addObject(new BasicEnemy(0, 50, ID.basicEnemy));
		
	}
	
	//synchronized - can only be executed by a single thread at one time
	public synchronized void start(){
		//thread is a path that executes a program
		thread = new Thread(this);
		thread.start();
		running = true;
		
	}
	public synchronized void stop(){
		try{
			thread.join();
			running = false;
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1){
				tick();
				delta--;
			}
			if(running){
				render();
			}
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS" + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick(){
		handler.tick();
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		handler.render(g);
		g.dispose();
		bs.show();		
	}
	//int main() [C++ reference]
	public static void main(String args[]){
		//creates a new GameMain
		new GameMain();
			
		}
}
