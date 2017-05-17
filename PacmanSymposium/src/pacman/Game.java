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
	
	boolean upPressed;
	boolean downPressed;
	boolean rightPressed;
	boolean leftPressed;
	
	public Game(int width, int height){
		super(width, height);
		Thread game = new Thread(this);
		game.start();
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		playerList = new ArrayList<Player>();
		
//		System.out.println("Enter player name.");
//		Scanner s = new Scanner(System.in);
//		String name = s.nextLine();
		this.gameStart = true;
		
		player = new Player("name", 0, 0, 0);
		
		pic = new Graphic(75, 100, .15, "resource/Pacman-Player.png");
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
		if(gameStart){
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_UP){
				upPressed = true;
				downPressed = false;
				rightPressed = false;
				leftPressed = false;
			}
			if(key == KeyEvent.VK_DOWN){
				player.update("DOWN");
				upPressed = false;
				downPressed = true;
				rightPressed = false;
				leftPressed = false;
			}
			if(key == KeyEvent.VK_LEFT){
				player.update("LEFT");
				upPressed = false;
				downPressed = false;
				rightPressed = false;
				leftPressed = true;
			}
			if(key == KeyEvent.VK_RIGHT){
				player.update("RIGHT");
				upPressed = false;
				downPressed = false;
				rightPressed = true;
				leftPressed = false;
			}
		}
	}
	
	@Override
	public void run() {
		while(gameStart){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(upPressed){
				player.update("UP");
			}
			if(downPressed){
				player.update("DOWN");
			}
			if(rightPressed){
				player.update("RIGHT");
			}
			if(leftPressed){
				player.update("LEFT");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println("Key was released");	
//		int key = e.getKeyCode();
//		if(key == KeyEvent.VK_UP){
//			upPressed = false;
//		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		//System.out.println("Key was typed");	
	}
	
	public KeyListener getKeyListener() {
		return this;
	}
	
}
