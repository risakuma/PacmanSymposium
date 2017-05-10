package pacman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import gui.components.Visible;
import gui.practice.Screen;

//where you would put it all together

public class Game extends Screen implements Runnable, KeyListener{
	
	private Player player;
	
	public Game(int width, int height){
		super(width, height);
		Thread game = new Thread(this);
		game.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		//ask player for name
		player = new Player();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		//System.out.println("Key was pressed");
		player.update();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		//System.out.println("Key was released");
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		//System.out.println("Key was typed");
		
	}
	
	public KeyListener getKeyListener() {
		return this;
	}
	
}
