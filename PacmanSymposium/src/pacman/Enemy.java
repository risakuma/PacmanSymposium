/**
 * 
 */
package pacman;

import java.util.ArrayList;

import gui.components.Graphic;
import gui.components.Visible;

/**
 * @author Risa
 *
 */
public class Enemy extends Graphic implements EnemyInterface{

	private boolean onScreen;
	
	private int x;
	private int y;
	private static double scale = 0.25;
	
	private boolean eaten;
	
	private final int TOP = 0;
	private final int LEFT = 1;
	private final int BOTTOM = 2;
	private final int RIGHT = 3;
	
	private int MAP_POSITION_X;
	private int MAP_POSITION_Y;
	
	public Enemy(int x, int y, int mapX, int mapY){
		super(x, y, scale, "resource/ghost_down.png");
		this.x = x;
		this.y = y;
		eaten = false;
		
		MAP_POSITION_X = mapX;
		MAP_POSITION_Y = mapY;
	}
	
	public void moveToPlayer(Player p, ArrayList<int[]> map){
		int playerPosX = p.getPosX();
		int playerPosY = p.getPosY();
	

		
		if(!p.canEat()){
			if(playerPosX >= x && canMove(map, x + 5, y, RIGHT)){
				setImage("resource/ghost_right.png", scale);
				x += 5;
				setX(x);
			}
			if(playerPosX <= x && canMove(map, x - 5, y, LEFT)){
				setImage("resource/ghost_left.png", scale);
				x -= 5;
				setX(x);
			}
			if(playerPosY >= y && canMove(map, x, y + 5, BOTTOM)){
				setImage("resource/ghost_down.png", scale);
				y += 5;
				setY(y);
			}
			if(playerPosY <= y && canMove(map, x, y - 5, TOP)){
				setImage("resource/ghost_up.png", scale);
				y -= 5;
				setY(y);
			}
		}
		
		if(p.canEat()){
			if(playerPosX >= x && canMove(map, x - 5, y, LEFT)){
				setImage("resource/ghost_run_left.png", scale);
				x -= 5;
				setX(x);
			}
			if(playerPosX <= x && canMove(map, x + 5, y, RIGHT)){
				setImage("resource/ghost_run_right.png", scale);
				x += 5;
				setX(x);
			}
			if(playerPosY >= y&& canMove(map, x, y - 5, TOP)){
				setImage("resource/ghost_run_up.png", scale);
				y -= 5;
				setY(y);
			}
			if(playerPosX <= y && canMove(map, x, y + 5, BOTTOM)){
				setImage("resource/ghost_run_up.png", scale);
				y += 5;
				setY(y);
			}
		}
	}
	
	@Override
	public boolean isEaten() {
		return eaten;
	}
	
	@Override
	public void setEaten(boolean b){
		eaten = b;
	}

	@Override
	public void backToBase(int x, int y) {
		if(eaten){
			this.x = x;
			this.y = y;
			setX(x);
			setY(y);
		}
	}
	
	private boolean canMove(ArrayList<int[]> map, int newX, int newY, int direction){
		for(int i = 0; i < map.size(); i++){
			int[] coordinates = map.get(i);
			if(direction == TOP && newX + getWidth() >= coordinates[0] + MAP_POSITION_X && newX <= coordinates[0] + coordinates[2] + MAP_POSITION_X 
					&& newY >= coordinates[1] + MAP_POSITION_Y && newY <= coordinates[1] + coordinates[2] + MAP_POSITION_Y && coordinates[3] == 1){
				return false;
			}
			if(direction == RIGHT && newX + getWidth() >= coordinates[0] + MAP_POSITION_X && newX + getWidth() <= coordinates[0] + coordinates[2] + MAP_POSITION_X 
					&& newY +getHeight() >= coordinates[1] + MAP_POSITION_Y && newY <= coordinates[1] + coordinates[2] + MAP_POSITION_Y && coordinates[3] == 1){
				return false;
			}
			if(direction == LEFT && newX >= coordinates[0] + MAP_POSITION_X && newX <= coordinates[0] + coordinates[2] + MAP_POSITION_X 
					&& newY + getHeight() >= coordinates[1] + MAP_POSITION_Y && newY <= coordinates[1] + coordinates[2] + MAP_POSITION_Y && coordinates[3] == 1){
				return false;
			}
			if(direction == BOTTOM && newX + getWidth() >= coordinates[0] + MAP_POSITION_X && newX <= coordinates[0] + coordinates[2] + MAP_POSITION_X 
					&& newY + getHeight() >= coordinates[1] + MAP_POSITION_Y && newY <= coordinates[1] + coordinates[2] + MAP_POSITION_Y && coordinates[3] == 1){
				return false;
			}
		}
		return true;
	}
	
	public static void littleGhostsMoving(ArrayList<Visible> viewObjects, String ghostRight, String ghostLeft, int startX, int endX){
		Graphic[] ghosts = new Graphic[3];
		
		int x = startX;
		int y = 510;
		
		boolean right0 = true;
		boolean left0 = false;
		
		boolean right1 = true;
		boolean left1 = false;
		
		boolean right2 = true;
		boolean left2 = false;
		
		for(int i = 0; i < 3; i++){
			ghosts[i] = new Graphic(x, y, .3, ghostRight);
			viewObjects.add(ghosts[i]);
			x -= 50;
		}
		
		while(true){
			for(int j = 0; j < ghosts.length; j++){
				if(j == 0){
					if(right0){
						x = ghosts[j].getX() + 5;
						try {
							Thread.sleep(70);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						ghosts[j].setX(x);
						if(x >= endX){
							right0 = false;
							left0 = true;
							ghosts[j].setImage(ghostLeft, .3);
						}
					}
					if(left0){
						x = ghosts[j].getX() - 5;
						try {
							Thread.sleep(70);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						ghosts[j].setX(x);
						if(x <= startX){
							right0 = true;
							left0 = false;
							ghosts[j].setImage(ghostLeft, 1.1);
						}
					}
					
				}
				
				if(j == 1){
					if(right1){
						x = ghosts[j].getX() + 5;
						try {
							Thread.sleep(70);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						ghosts[j].setX(x);
						if(x >= endX){
							right1 = false;
							left1 = true;
							ghosts[j].setImage(ghostLeft, .3);
						}
					}
					if(left1){
						x = ghosts[j].getX() - 5;
						try {
							Thread.sleep(70);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						ghosts[j].setX(x);
						if(x <= startX){
							right1 = true;
							left1 = false;
							ghosts[j].setImage(ghostLeft, 1.1);
						}
					}
					
				}
				
				if(j == 2){
					if(right2){
						x = ghosts[j].getX() + 5;
						try {
							Thread.sleep(70);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						ghosts[j].setX(x);
						if(x >= endX){
							right2 = false;
							left2 = true;
							ghosts[j].setImage(ghostLeft, .3);
						}
					}
					if(left2){
						x = ghosts[j].getX() - 5;
						try {
							Thread.sleep(70);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						ghosts[j].setX(x);
						if(x <= startX){
							right2 = true;
							left2 = false;
							ghosts[j].setImage(ghostLeft, 1.1);
						}
					}
					
				}
			}
		}
	}
	
	public void setOnScreen(boolean b){
		onScreen = b;
	}
	
	public boolean getOnScreen(){
		return onScreen;
	}
	
	public int getPosX(){
		return x;
	}
	
	public int getPosY(){
		return y;
	}
	
	public int[] getTopCoordinates(){
		return new int[]{x, (x + getWidth()), y};
	}
	
	public int[] getBottomCoordinates(){
		return new int[]{x, (x + getWidth()), (y + getHeight())};
	}
	
	public int[] getRightCoordinates(){
		return new int[]{y, (y + getHeight()), (x + getWidth())};
	}
	
	public int[] getLeftCoordinates(){
		return new int[]{y, (y + getHeight()), x};
	}
}
