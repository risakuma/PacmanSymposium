package pacman;

import gui.practice.GUIApplication;

/**
 * @author Risa
 *
 */
public class Intro extends GUIApplication{
	
	public static Intro intro;
	public static IntroScreen screen;
	public static Game gameScreen;

	public static void main(String[] args){
		intro = new Intro();
		Thread app = new Thread(intro);
		app.start();
	}

	@Override
	protected void initScreen() {		
		screen = new IntroScreen(1200, 730);
		setScreen(screen);
		
		gameScreen = new Game(1200, 730);
	}

}
