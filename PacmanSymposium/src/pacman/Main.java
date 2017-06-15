package pacman;

public class Main extends gui.practice.GUIApplication{
	public static void main(String[] args) {
		Main mainGame = new Main();
		Thread game = new Thread(mainGame);
		game.start();
	}

	@Override
	protected void initScreen() {
//		Intro story = new Intro(1200,730);
//		setScreen(story);
		Game pacman = new Game(1200, 730);
		setScreen(pacman);
	}

}
