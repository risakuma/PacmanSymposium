package pacman;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Timer;

import gui.components.Action;
import gui.components.Button;
import gui.components.Graphic;
import gui.components.Visible;
import gui.practice.Screen;

//where you would put it all together

public class Game extends Screen implements Runnable, KeyListener, MouseListener{
	
	private Player player;
	private Enemy enemy;
	private PlayerStat stat;
	private boolean gameStart;
	private Map map;
	
	private ArrayList<Player> playerList;
	private ArrayList<Enemy> enemyList;
	private ArrayList<int[]> mapCoordinates;
	private ArrayList<Food> foodList;
	
	private int cntr;
	private boolean power;
	
	private int enemyCntr;
	
	private Button again;
	
	boolean upPressed;
	boolean downPressed;
	boolean leftPressed;
	boolean rightPressed;
	
	public static final int ENEMY_START_X = 385;
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
		enemyList = new ArrayList<Enemy>();
		foodList = new ArrayList<Food>();
		stat = new PlayerStat(MAP_POSITION_X,MAP_POSITION_Y,200, 650);
		
//		System.out.println("Enter player name.");
//		Scanner s = new Scanner(System.in);
//		String name = s.nextLine();
		this.gameStart = true;
		
		map = new Map(MAP_POSITION_X, MAP_POSITION_Y, MAP_WIDTH, MAP_HEIGHT);
		viewObjects.add(map);
		mapCoordinates = map.getCoordinates();
		int cntr = 1;
		for(int i = 0; i < mapCoordinates.size(); i+=4){
			if(mapCoordinates.get(i)[3] == 2){
				viewObjects.add(new Food(mapCoordinates.get(i)[0] + MAP_POSITION_X, mapCoordinates.get(i)[1] + MAP_POSITION_Y, "resource/Strawberry.png", 0.04, false, 30));
				foodList.add(new Food(mapCoordinates.get(i)[0] + MAP_POSITION_X, mapCoordinates.get(i)[1] + MAP_POSITION_Y, "resource/Strawberry.png", 0.04, false, 30));
				stat.increaseNumOfFood(cntr);
				cntr++;
			}
		}
		

		for(int i = 0; i < 10; i++){
			int rndNum = (int) (Math.random() *mapCoordinates.size());
			if(mapCoordinates.get(rndNum)[3] == 2  && i <= 3){
				for(Food f : foodList){
					if(f.getX() - MAP_POSITION_X == mapCoordinates.get(rndNum)[0] && f.getY() - MAP_POSITION_Y == mapCoordinates.get(rndNum)[1]){
						System.out.println("!");
						viewObjects.remove(f);
						foodList.remove(f);
						viewObjects.add(new Food(mapCoordinates.get(rndNum)[0] + MAP_POSITION_X, mapCoordinates.get(rndNum)[1] + MAP_POSITION_Y, "resource/milk.png", 0.04, true, 50));
						foodList.add(new Food(mapCoordinates.get(rndNum)[0] + MAP_POSITION_X, mapCoordinates.get(rndNum)[1] + MAP_POSITION_Y, "resource/milk.png", 0.04, true, 50));
						break;
					}
				}
			}else if(mapCoordinates.get(rndNum)[3] == 2){
						for(Food f : foodList){
							if(f.getX() - MAP_POSITION_X == mapCoordinates.get(rndNum)[0] && f.getY() - MAP_POSITION_Y == mapCoordinates.get(rndNum)[1]){
								System.out.println("?");
								viewObjects.remove(f);
								foodList.remove(f);
								viewObjects.add(new Food(mapCoordinates.get(rndNum)[0] + MAP_POSITION_X, mapCoordinates.get(rndNum)[1] + MAP_POSITION_Y, "resource/cake.png", 0.04, false, 100));
								foodList.add(new Food(mapCoordinates.get(rndNum)[0] + MAP_POSITION_X, mapCoordinates.get(rndNum)[1] + MAP_POSITION_Y, "resource/cake.png", 0.04, false, 100));
								break;
							}
						}
			}
		}
		
		player = new Player("name", 0, 405, 465);
		viewObjects.add(player);
		
		
		
		makeEnemy();
		for(Enemy e: enemyList){
			viewObjects.add(e);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			e.moveToPlayer(player, map.getCoordinates());
		}
	}
	
	private void makeEnemy(){
		int enemyCount = 0;
		while(enemyCount < 4){
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
			cntr++;
			
			if(cntr > 40){
				player.setEat(false);
				power = false;
			}
			
			if(upPressed){
				player.update("UP", map.getCoordinates());
				if(isGameOver()){
					gameStart = false;
					break;
				}
				checkFood();
			}
			if(downPressed){
				player.update("DOWN", map.getCoordinates());
				if(isGameOver()){
					gameStart = false;
					break;
				}
				checkFood();
			}
			if(leftPressed){
				player.update("LEFT", map.getCoordinates());
				if(isGameOver()){
					gameStart = false;
					break;
				}
				checkFood();
			}
			if(rightPressed){
				player.update("RIGHT", map.getCoordinates());
				if(isGameOver()){
					gameStart = false;
					break;
				}
				checkFood();
			}
			
			for(Enemy e: enemyList){
				e.moveToPlayer(player, map.getCoordinates());
			}
			
			if(foodList.isEmpty())
				gameStart = false;

		}
		
		if(!gameStart){
			youWinText(viewObjects);
		}
		if(!gameStart && isGameOver()){
			gameOverButton(viewObjects);
		}
	}
	
	//player won't know which food they already have,it is part of the game for the player to figure out where the left over food is 
	private void checkFood(){
		A: for(int i = 0; i < foodList.size(); i++){
			Food f = foodList.get(i);
			for(int a = f.getTopCoordinates()[0]; a <= f.getTopCoordinates()[1]; a++){
				if(a >= player.getBottomCoordinates()[0] && a <= player.getBottomCoordinates()[1] && 
						f.getTopCoordinates()[2] >= player.getTopCoordinates() [2] + 5 && f.getTopCoordinates()[2] <= player.getBottomCoordinates()[2] - 5){
					if(f.isAPowerUp()){
						cntr = 0;
						power = true;
						player.setEat(true);
					}
					stat.addPoints(f.getPoints());
					stat.decreaseNumOfFodd(1);
					foodList.remove(f);
					
					break A;
				}
			}
			
			for(int b = f.getBottomCoordinates()[0]; b <= f.getBottomCoordinates()[1]; b++){
				if(b >= player.getTopCoordinates()[0] && b <= player.getTopCoordinates()[1] && 
						f.getBottomCoordinates()[2] >= player.getTopCoordinates()[2] + 5 && f.getBottomCoordinates()[2] <= player.getBottomCoordinates()[2] - 5){
					if(f.isAPowerUp()){
						System.out.println("p");
						cntr = 0;
						power = true;
						player.setEat(true);
					}
					stat.addPoints(f.getPoints());
					stat.decreaseNumOfFodd(1);
					foodList.remove(f);
					
					break A;
				}
			}
			
			for(int c = f.getRightCoordinates()[0]; c <= f.getRightCoordinates()[1]; c++){
				if(c >= player.getLeftCoordinates()[0] && c <= player.getLeftCoordinates()[1] &&
						f.getRightCoordinates()[2] >= player.getLeftCoordinates()[2] + 5 && f.getRightCoordinates()[2] <=player.getRightCoordinates()[2] - 5){
					if(f.isAPowerUp()){
						System.out.println("p");
						cntr = 0;
						power = true;
						player.setEat(true);
					}
					stat.addPoints(f.getPoints());
					stat.decreaseNumOfFodd(1);
					foodList.remove(f);
					
					break A;
				}
			}
			
			for(int d = f.getLeftCoordinates()[0]; d <= f.getLeftCoordinates()[1]; d++){
				if(d >= player.getRightCoordinates()[0] && d <= player.getRightCoordinates()[1] && 
						f.getLeftCoordinates()[2] >= player.getLeftCoordinates()[2] + 5 && f.getLeftCoordinates()[2] <= player.getRightCoordinates()[2] - 5){
					if(f.isAPowerUp()){
						cntr = 0;
						power = true;
						player.setEat(true);
					}
					stat.addPoints(f.getPoints());
					stat.decreaseNumOfFodd(1);
					foodList.remove(f);
					
					break A;
				}
			}
		}
	}
	
	private boolean isGameOver(){
		for(Enemy e : enemyList){
			for(int i = e.getTopCoordinates()[0] + 3; i <= e.getTopCoordinates()[1] - 3; i++){
				if(!player.canEat() && i >= player.getBottomCoordinates()[0] && i <= player.getBottomCoordinates()[1] && 
						e.getTopCoordinates()[2] >= player.getTopCoordinates() [2] + 5 && e.getTopCoordinates()[2] <= player.getBottomCoordinates()[2] - 5){
					return true;
				}
			}
			
			for(int i = e.getBottomCoordinates()[0] + 3; i <= e.getBottomCoordinates()[1] - 3; i++){
				if(!player.canEat() && i >= player.getTopCoordinates()[0] && i <= player.getTopCoordinates()[1] && 
						e.getBottomCoordinates()[2] >= player.getTopCoordinates()[2] + 5 && e.getBottomCoordinates()[2] <= player.getBottomCoordinates()[2] - 5){
					return true;
				}
			}
			
			for(int i = e.getRightCoordinates()[0] + 3; i <= e.getRightCoordinates()[1] - 3; i++){
				if(!player.canEat() && i >= player.getLeftCoordinates()[0] && i <= player.getLeftCoordinates()[1] &&
						e.getRightCoordinates()[2] >= player.getLeftCoordinates()[2] + 5 && e.getRightCoordinates()[2] <=player.getRightCoordinates()[2] - 5){
					return true;
				}
			}
			
			for(int i = e.getLeftCoordinates()[0]; i <= e.getLeftCoordinates()[1]; i++){
				if(!player.canEat() && i >= player.getRightCoordinates()[0] && i <= player.getRightCoordinates()[1] && 
						e.getLeftCoordinates()[2] >= player.getLeftCoordinates()[2] + 5 && e.getLeftCoordinates()[2] <= player.getRightCoordinates()[2] - 5){
					return true;
				}
			}
		}
		return false;
		
	}
	
//	//			//if(player.getPosX() == e.getPosX() && player.getPosY() == e.getPosY() && player.canEat()){
//	e.setEaten(true);
//	e.backToBase(ENEMY_START_X, ENEMY_START_Y);
//	e.setEaten(false);
	
	private void gameOverButton(ArrayList<Visible> viewObjects){
		again = new Button(40, 20, 150, 60, "Play Again", Color.blue, new Action(){
			public void act(){
				System.out.println("DONE!");
			}
		});
		viewObjects.add(again);
		
	}
	
	private void youWinText(ArrayList<Visible> viewObjects){
		System.out.println("win!");
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
	
	public void mouseClicked(MouseEvent e) {
		if(again.isHovered(e.getX(), e.getY()))
			again.act();
	}
	
	public MouseListener getMouseListener(){
		return this;
	}
	
	public static int getMapWidth(){
		return MAP_WIDTH;
	}
	
	public static int getMapHeight(){
		return MAP_HEIGHT;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
