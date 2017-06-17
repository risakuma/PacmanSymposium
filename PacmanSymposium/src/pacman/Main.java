package pacman;

public class Main extends gui.practice.GUIApplication{
	
	public static Main mainGame;
	public static Game pacman;
	public static IntroScreen screen;
	public static GoodEndScreen goodEnd;
	
	public static void main(String[] args) {
		mainGame = new Main();
		Thread game = new Thread(mainGame);
		game.start();
	}

	@Override
	protected void initScreen() {
		screen = new IntroScreen(1200, 730);
		goodEnd = new GoodEndScreen(1200, 730);
		
		pacman = new Game(1200, 720);
		setScreen(pacman);
	}

}
