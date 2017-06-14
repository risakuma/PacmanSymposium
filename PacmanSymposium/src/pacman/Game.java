package pacman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import gui.components.Graphic;
import gui.components.Visible;
import gui.practice.Screen;

//where you would put it all together

public class Game extends Screen implements Runnable, KeyListener{
	
	private Player player;
	private boolean gameStart;
	private Map map;
	
	private ArrayList<Player> playerList;
	private ArrayList<Enemy> enemyList;
	private ArrayList<int[]> mapCoordinates;
	
	boolean upPressed;
	boolean downPressed;
	boolean leftPressed;
	boolean rightPressed;
	
	public static final int ENEMY_START_X = 390;
	public static final int ENEMY_START_Y = 330;
	
	public static final int MAP_POSITION_X = 20;
	public static final int MAP_POSITION_Y = 40;
	
	public static final int MAP_WIDTH = 781;
	public static final int MAP_HEIGHT = 661;
	
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
		
		player = new Player("name", 0, 390, 460);
		viewObjects.add(player);
		
		map = new Map(MAP_POSITION_X, MAP_POSITION_Y, MAP_WIDTH, MAP_HEIGHT);
		mapCoordinates = map.getCoordinates();
		for(int[] coordinate: mapCoordinates){
			if(coordinate[3] == 2){
				viewObjects.add(new Food(coordinate[0] + MAP_POSITION_X, coordinate[1] + MAP_POSITION_Y, "resource/cookie.png", "a", 2));
			}
		}
		
		enemyList = new ArrayList<Enemy>();
		makeEnemy();
		for(Enemy e: enemyList){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			viewObjects.add(e);
			e.setOnScreen(true);
		}
		
		viewObjects.add(map);
	}
	
	public void makeEnemy(){
		int enemyCount = 0;
		while(enemyCount < 5){
			enemyList.add(new Enemy(ENEMY_START_X, ENEMY_START_Y, MAP_POSITION_X, MAP_POSITION_Y));
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
				upPressed = false;
				downPressed = true;
				rightPressed = false;
				leftPressed = false;
			}
			if(key == KeyEvent.VK_LEFT){
				upPressed = false;
				downPressed = false;
				rightPressed = false;
				leftPressed = true;
			}
			if(key == KeyEvent.VK_RIGHT){
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
				e.printStackTrace();
			}
			if(upPressed){
				player.update("UP", map.getCoordinates());
			}
			if(downPressed){
				player.update("DOWN", map.getCoordinates());
			}
			if(leftPressed){
				player.update("LEFT", map.getCoordinates());
			}
			if(rightPressed){
				player.update("RIGHT", map.getCoordinates());
			}
			
			for(Enemy e: enemyList){
				if(e.getOnScreen()){
					e.moveToPlayer(player, map.getCoordinates());
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println("Key was released");	
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		//System.out.println("Key was typed");	
	}
	
	public KeyListener getKeyListener() {
		return this;
	}
	
	public static int getMapWidth(){
		return MAP_WIDTH;
	}
	
	public static int getMapHeight(){
		return MAP_HEIGHT;
	}
	
}
