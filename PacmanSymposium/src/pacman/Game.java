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
	private boolean gameStart;
	private Graphic pic;
	
	private ArrayList<Player> playerList;
	private ArrayList<Enemy> enemyList;
	
	private int _DIRECTION;
	
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
		this.gameStart = true;
		
		player = new Player(name, 0, 0, 0);
		
		pic = new Graphic(150, 100, "resource/Pacman-Player.png");
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
		//initialize all keys as false
		boolean _KEY1 = false;
		boolean _KEY2 = false;
		boolean _KEY3 = false;
		boolean _KEY4 = false;
		if(gameStart){
			if(e.getKeyCode() == KeyEvent.VK_UP){
				//player.update("UP");
		
				//doesn't break while loop.
//				_KEY1 = true;
//				while(_KEY1 && !_KEY2 && !_KEY3 && !_KEY4){
//						player.update("UP");
//						
//				}
			
			}
			if(e.getKeyCode() == KeyEvent.VK_DOWN){
				_KEY2 = true;
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
	
//	private int checkKey(){
//		if(e.getKeyCode)
//		return _DIRECTION;
//	}

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
