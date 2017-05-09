package pacman;

import java.util.ArrayList;

import guiPractice.Screen;
import guiPractice.components.Visible;

//where you would put it all together

public class Game extends Screen implements Runnable{
	
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
	public void initObjects(ArrayList<Visible> arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
