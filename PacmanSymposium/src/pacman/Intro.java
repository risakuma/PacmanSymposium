package pacman;

import java.util.ArrayList;

import gui.components.TextLabel;
import gui.components.Visible;
import gui.practice.Screen;

public class Intro extends Screen{
	
	private TextLabel text;

	public Intro(int width, int height) {
		super(width, height);
		Thread game = new Thread();
		game.start();
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		text = new TextLabel(0, 0, 100, 100, "hello");
		viewObjects.add(text);
		Game pacman = new Game(1200, 730);
		setScreen(pacman);
	}

	private void setScreen(Game pacman) {
		// TODO Auto-generated method stub
		
	}

}
