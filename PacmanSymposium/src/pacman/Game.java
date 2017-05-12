package pacman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Scanner;

import gui.components.Graphic;
import gui.components.Visible;
import gui.practice.Screen;

//where you would put it all together

public class Game extends Screen implements Runnable, KeyListener{
	
	private Player player;
	private boolean gameStart = false;
	private Graphic pic;
	
	private ArrayList<Player> playerList;
	private ArrayList<Enemy> enemyList;
	
	public Game(int width, int height){
		super(width, height);
		Thread game = new Thread(this);
		game.start();
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		playerList = new ArrayList<Player>();
		
		System.out.println("Enter player name.");
		Scanner s = new Scanner(System.in);
		String name = s.nextLine();
		gameStart = true;
		
		player = new Player(name, 0, 0, 0);
		
		pic = new Graphic(10, 10, "resource/Pacman-Player.gif");
		viewObjects.add(pic);
		
		enemyList = new ArrayList<Enemy>();
		makeEnemy();	
	}
	
	public void makeEnemy(){
		int enemyCount = 0;
		while(enemyCount > 5){
			enemyList.add(new Enemy(0, 0));
			enemyCount++;
		}
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(gameStart == true){
			if(e.getKeyCode() == KeyEvent.VK_UP){
				player.update("UP");
			}
			if(e.getKeyCode() == KeyEvent.VK_DOWN){
				player.update("DOWN");
			}
			if(e.getKeyCode() == KeyEvent.VK_LEFT){
				player.update("LEFT");
			}
			if(e.getKeyCode() == KeyEvent.VK_RIGHT){
				player.update("RIGHT");
			}
		}
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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
