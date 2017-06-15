package pacman;

import gui.practice.GUIApplication;

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
		gameScreen = new Game(1200, 730);
		
		screen = new IntroScreen(getWidth(), getHeight());
		setScreen(screen);
	}

}
