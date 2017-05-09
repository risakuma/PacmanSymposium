package pacman;

import guiPractice.GUIApplication;

//run this class

public class Main extends GUIApplication{
	public static void main(String[] args) {
		Main mainGame = new Main();
		Thread game = new Thread(mainGame);
		game.start();
	}

	@Override
	protected void initScreen() {
		Game pacman = new Game(getWidth(), getHeight());
		setScreen(pacman);
	}

}
