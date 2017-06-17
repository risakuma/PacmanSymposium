package pacman;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import gui.components.Action;
import gui.components.Button;
import gui.components.ClickableGraphic;
import gui.components.Graphic;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.practice.Screen;

//where you would put it all together
/**
 * @author Risa
 *
 */
public class Game extends Screen implements Runnable, KeyListener, MouseListener{
	
	private Player player;
	private Enemy enemy;
	private PlayerStat stat;
	private boolean gameStart;
	private Map map;
	
	private ArrayList<Enemy> enemyList;
	private ArrayList<int[]> mapCoordinates;
	private ArrayList<Food> foodList;
	
	private int cntr;
	private boolean power;
	
	private int enemyCntr;
	private int enemyIndx;
	
	private int deadCntr;
	private boolean dead;
	
//	private Button again;
	private ClickableGraphic box;
	private boolean start;
	private boolean game;
	
	private boolean upPressed;
	private boolean downPressed;
	private boolean leftPressed;
	private boolean rightPressed;
	
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
		enemyList = new ArrayList<Enemy>();
		foodList = new ArrayList<Food>();
		stat = new PlayerStat(MAP_POSITION_X + MAP_WIDTH + 50, MAP_POSITION_Y, 350, MAP_HEIGHT);
		viewObjects.add(stat);
		
		this.gameStart = true;
		game = true;
		
		map = new Map(MAP_POSITION_X, MAP_POSITION_Y, MAP_WIDTH, MAP_HEIGHT);
		viewObjects.add(map);
		mapCoordinates = map.getCoordinates();
		
		int num = ((int)(Math.random() * mapCoordinates.size()));
		int n = 0;
		while(n < num){
			int r = (int)(Math.random() * mapCoordinates.size());	
			if(mapCoordinates.get(r)[3] == 2 && !foodExists(r)){
				//viewObjects.add(new Food(mapCoordinates.get(r)[0] + MAP_POSITION_X, mapCoordinates.get(r)[1] + MAP_POSITION_Y, "resource/Strawberry.png", 0.04, false, 30));
				foodList.add(new Food(mapCoordinates.get(r)[0] + MAP_POSITION_X, mapCoordinates.get(r)[1] + MAP_POSITION_Y, "resource/Strawberry.png", 0.04, false, 30));
				stat.increaseNumOfFood(1);
			}
			n++;
		}
		
//		foodList.add(new Food(mapCoordinates.get(24)[0] + MAP_POSITION_X, mapCoordinates.get(24)[1] + MAP_POSITION_Y, "resource/Strawberry.png", 0.04, false, 30));
//		stat.increaseNumOfFood(1);
		

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
		
		enemy = new Enemy(ENEMY_START_X, ENEMY_START_Y, MAP_POSITION_X, MAP_POSITION_Y);
		viewObjects.add(enemy);
		
		makeEnemy();
		
		Graphic strawberry = new Graphic(MAP_POSITION_X + MAP_WIDTH + 60, MAP_POSITION_Y + 97, .07, "resource/Strawberry.png");
		viewObjects.add(strawberry);
		
		Graphic points = new Graphic(MAP_POSITION_X + MAP_WIDTH + 60, MAP_POSITION_Y + 120, .07, "resource/Strawberry.png");
		viewObjects.add(points);
		
		Graphic s = new Graphic(MAP_POSITION_X + MAP_WIDTH + 65, MAP_POSITION_Y + 330, .085, "resource/Strawberry.png");
		viewObjects.add(s);
		
		Graphic milk = new Graphic(MAP_POSITION_X + MAP_WIDTH + 67, MAP_POSITION_Y + 370, .07, "resource/milk.png");
		viewObjects.add(milk);
		
		Graphic cake = new Graphic(MAP_POSITION_X + MAP_WIDTH + 67, MAP_POSITION_Y + 415, .075, "resource/cake.png");
		viewObjects.add(cake);
		
		Graphic alice1 = new Graphic(MAP_POSITION_X + MAP_WIDTH + 60, MAP_POSITION_Y + 470, 1.1, "resource/alice_down.png");
		viewObjects.add(alice1);
		
		Graphic alice2 = new Graphic(MAP_POSITION_X + MAP_WIDTH + 65, MAP_POSITION_Y + 520, 1, "resource/alice_power_down.png");
		viewObjects.add(alice2);
		
		Graphic ghost1 = new Graphic(MAP_POSITION_X + MAP_WIDTH + 60, MAP_POSITION_Y + 570, .3, "resource/ghost_left.png");
		viewObjects.add(ghost1);
		
		Graphic ghost2 = new Graphic(MAP_POSITION_X + MAP_WIDTH + 60, MAP_POSITION_Y + 610, .3, "resource/ghost_run_left.png");
		viewObjects.add(ghost2);
	}
	
	private boolean foodExists(int r){
		for(Food food : foodList){
			if(mapCoordinates.get(r)[0] + MAP_POSITION_X == food.getPosX() &&
					mapCoordinates.get(r)[1] + MAP_POSITION_Y == food.getPosY()){
				return true;
			}
		}
		return false;
	}
	
	private void makeEnemy(){
		int enemyCount = 0;
		while(enemyCount < 7){
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
			enemyCntr++;
			deadCntr++;
			
			if(cntr > 100 && power){
				cntr = 0;
				player.setEat(false);
				power = false;
			}
			
			if(deadCntr > 25 && dead){
				deadCntr = 0;
				dead = false;
			}
			
			if(enemyCntr % 35 == 0 && enemyIndx < enemyList.size()){
				viewObjects.add(enemyList.get(enemyIndx));
				enemyList.get(enemyIndx).setOnScreen(true);
				enemyIndx++;
			}
			
			if(upPressed){
				player.update("UP", map.getCoordinates());
				if(isGameOver()){
					gameStart = false;
					break;
				}
				checkFood();
				isGhostDead();
			}
			if(downPressed){
				player.update("DOWN", map.getCoordinates());
				if(isGameOver()){
					gameStart = false;
					break;
				}
				checkFood();
				isGhostDead();
			}
			if(leftPressed){
				player.update("LEFT", map.getCoordinates());
				if(isGameOver()){
					gameStart = false;
					break;
				}
				checkFood();
				isGhostDead();
			}
			if(rightPressed){
				player.update("RIGHT", map.getCoordinates());
				if(isGameOver()){
					gameStart = false;
					break;
				}
				checkFood();
				isGhostDead();
			}
			
			if(deadCntr == 0){
				enemy.moveToPlayer(player, map.getCoordinates());
			
				for(Enemy e: enemyList){
					if(e.getOnScreen())
						e.moveToPlayer(player, map.getCoordinates());
				}
			}
			
			stat.clear();
			stat.update();
			
			if(foodList.isEmpty())
				gameStart = false;

		}
		
		if(!gameStart && isGameOver()){
			Graphic gameOverBG = new Graphic(0, 0, 1200, 720, "resource/gameOver.jpg");
			Graphic gameOver = new Graphic((getWidth()/2) - 170, (getHeight()/2) - 140, 400, 300, "resource/GO.png");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			viewObjects.add(gameOverBG);
			viewObjects.add(gameOver);
			
			ClickableGraphic textBox = new ClickableGraphic(40, 550, 1140, 150, "resource/textbox.png");
			viewObjects.add(textBox);
			
			TextLabel story = new TextLabel(40, 450, 1160, 150, "...Exhausted, Alice fell into an eternal slumber in the Haunted Forest... ");
			story.setColor(Color.black);
			viewObjects.add(story);
			
			littleAliceAndGhosts(viewObjects, "resource/alice_right.png", "resource/alice_left.png", -100, "resource/ghost_right.png", "resource/ghost_left.png", -160, 1300);
			
		}else if(!gameStart){	
			Graphic finishBG = new Graphic(0, 0, 1200, 720, "resource/BlackScreen.jpeg");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			viewObjects.add(finishBG);
			
			box = new ClickableGraphic(40, 550, 1140, 150, "resource/textbox.png");
			viewObjects.add(box);
			
			TextLabel text = new TextLabel(40, 450, 1160, 150, "... (Next)");
			text.setColor(Color.black);
			viewObjects.add(text);
			
			box.setAction(new Action(){

				@Override
				public void act() {
					Intro.intro.setScreen(Intro.goodEnd);
				}
				
			});
			game = false;
			
			littleAliceAndGhosts(viewObjects, "resource/alice_power_right.png", "resource/alice_power_left.png", -160, "resource/ghost_run_right.png", "resource/ghost_run_left.png", -100, 1300);	
		}
	}
	
	private void littleAliceAndGhosts(ArrayList<Visible> viewObjects, String aliceRight, String aliceLeft, int aliceStartX, String ghostRight, String ghostLeft, int ghostStartX,int endX){
		Graphic alice = new Graphic(aliceStartX, 510, 1.1, aliceRight);
		Graphic ghost = new Graphic(ghostStartX, 510, .3, ghostRight);
		viewObjects.add(alice);
		viewObjects.add(ghost);
		
		int aX = aliceStartX;
		int gX = ghostStartX;
		
		alice.setY(510);
		ghost.setY(510);
		
		boolean rightA = true;
		boolean leftA = false;
		
		boolean rightG = true;
		boolean leftG = false;
		
		start = true;
		
		while(start){
			
			if(!game){
				box.setAction(new Action(){
	
					@Override
					public void act() {
						System.out.println(2);
						start = false;
						Intro.intro.setScreen(Intro.goodEnd);
					}
					
				});
			}
			
			if(rightA){
				aX += 5;
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				alice.setX(aX);
				if(aX >= endX){
					rightA = false;
					leftA = true;
					alice.setImage(aliceLeft, 1.1);
				}
			}
			
			if(rightG){
				gX += 5;
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ghost.setX(gX);
				if(gX >= endX){
					rightG = false;
					leftG = true;
					ghost.setImage(ghostLeft, .3);
				}
			}
			
			if(leftA){
				aX -= 5;
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				alice.setX(aX);
				if(aX <= aliceStartX){
					rightA = true;
					leftA = false;
					alice.setImage(aliceRight, 1.1);
				}
			}
			
			if(leftG){
				gX -= 5;
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ghost.setX(gX);
				if(gX <= aliceStartX){
					rightG = true;
					leftG = false;
					ghost.setImage(ghostRight, .3);
				}
			}
			
			
		}
	}
	
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
	
	private void isGhostDead(){
		for(Enemy e : enemyList){
			for(int i = e.getTopCoordinates()[0] + 3; i <= e.getTopCoordinates()[1] - 3; i++){
				if(player.canEat() && i >= player.getBottomCoordinates()[0] && i <= player.getBottomCoordinates()[1] && 
						e.getTopCoordinates()[2] >= player.getTopCoordinates() [2] + 5 && e.getTopCoordinates()[2] <= player.getBottomCoordinates()[2] - 5){
					e.backToBase(ENEMY_START_X, ENEMY_START_Y);
					dead = true;
				}else if (!dead){
					deadCntr = 0;
				}
			}
			
			for(int i = e.getBottomCoordinates()[0] + 3; i <= e.getBottomCoordinates()[1] - 3; i++){
				if(player.canEat() && i >= player.getTopCoordinates()[0] && i <= player.getTopCoordinates()[1] && 
						e.getBottomCoordinates()[2] >= player.getTopCoordinates()[2] + 5 && e.getBottomCoordinates()[2] <= player.getBottomCoordinates()[2] - 5){
					e.backToBase(ENEMY_START_X, ENEMY_START_Y);
					dead = true;
				}else if (!dead){
					deadCntr = 0;
				}
			}
			
			for(int i = e.getRightCoordinates()[0] + 3; i <= e.getRightCoordinates()[1] - 3; i++){
				if(player.canEat() && i >= player.getLeftCoordinates()[0] && i <= player.getLeftCoordinates()[1] &&
						e.getRightCoordinates()[2] >= player.getLeftCoordinates()[2] + 5 && e.getRightCoordinates()[2] <=player.getRightCoordinates()[2] - 5){
					e.backToBase(ENEMY_START_X, ENEMY_START_Y);
					dead = true;
				}else if (!dead){
					deadCntr = 0;
				}
			}
			
			for(int i = e.getLeftCoordinates()[0]; i <= e.getLeftCoordinates()[1]; i++){
				if(player.canEat() && i >= player.getRightCoordinates()[0] && i <= player.getRightCoordinates()[1] && 
						e.getLeftCoordinates()[2] >= player.getLeftCoordinates()[2] + 5 && e.getLeftCoordinates()[2] <= player.getRightCoordinates()[2] - 5){
					e.backToBase(ENEMY_START_X, ENEMY_START_Y);
					dead = true;
				}else if (!dead){
					deadCntr = 0;
				}
			}
		}
	}
	
//	private void gameOverButton(ArrayList<Visible> viewObjects){
//		again = new Button(1000, 650, 150, 40, "Play Again?", Color.red, new Action(){
//			public void act(){
//				start = false;
//				Intro.intro.setScreen(Intro.screen);
//			}
//		});
//		viewObjects.add(again);
//	}

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
//		if(again.isHovered(e.getX(), e.getY())){
//			again.act();
//		}
		if(box.isHovered(e.getX(), e.getY()))
			box.act();
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
