package pacman;

import gui.practice.GUIApplication;

/**
 * @author Risa
 *
 */

// RUN THIS CLASS
public class Intro extends GUIApplication{
	
	public static Intro intro;
	public static IntroScreen screen = new IntroScreen(1200, 730);
	public static Game gameScreen = new Game(1200, 730);
	public static GoodEndScreen goodEnd = new GoodEndScreen(1200, 730);;

	public static void main(String[] args){
		intro = new Intro();
		Thread app = new Thread(intro);
		app.start();
	}

	@Override
	protected void initScreen() {		
		setScreen(screen);
	}

}
