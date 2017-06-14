/**
 * 
 */
package pacman;

import java.util.ArrayList;

import gui.components.Graphic;

/**
 * @author Risa
 *
 */
public class Enemy extends Graphic implements EnemyInterface{

	private boolean onScreen;
	
	private int BASE_X;
	private int BASE_Y;
	
	private int x;
	private int y;
	private boolean eaten;
	
	private final int TOP = 0;
	private final int LEFT = 1;
	private final int BOTTOM = 2;
	private final int RIGHT = 3;
	
	private int MAP_POSITION_X;
	private int MAP_POSITION_Y;
	
	//make ghost go through some of the boxes
	
	public Enemy(int x, int y, int mapX, int mapY){
		super(x, y, .09, "resource/Pacman-Ghost.png");
		this.x = x;
		this.y = y;
		eaten = false;
		
		BASE_X = x;
		BASE_Y = y;
		
		MAP_POSITION_X = mapX;
		MAP_POSITION_Y = mapY;
	}
	
	public void moveToPlayer(Player p, ArrayList<int[]> map){
		int playerPosX = p.getPosX();
		int playerPosY = p.getPosY();
	
		if(!p.canEat()){
			if(playerPosX >= x && canMove(map, x + 5, y, RIGHT)){
				x += 5;
				setX(x);
			}
			if(playerPosX <= x && canMove(map, x - 5, y, LEFT)){
				x -= 5;
				setX(x);
			}
			if(playerPosY >= y && canMove(map, x, y + 5, BOTTOM)){
				y += 5;
				setY(y);
			}
			if(playerPosY <= y && canMove(map, x, y - 5, TOP)){
				y -= 5;
				setY(y);
			}
		}
		
		if(p.canEat()){
			if(playerPosX >= x){
				x -= 5;
				setX(x);
			}
			if(playerPosX <= x){
				x += 5;
				setX(x);
			}
			if(playerPosY >= y){
				y -= 5;
				setY(y);
			}
			if(playerPosX <= y){
				y += 5;
				setY(y);
			}
		}
	}
	
	@Override
	public boolean isEaten(Player p) {
		if(p.canEat() && x == p.getPosX() && y == p.getPosY())
			eaten = true;
		return eaten;
	}

	@Override
	public void backToBase() {
		if(eaten){
			x = BASE_X;
			y = BASE_Y;
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
	
	public void setOnScreen(boolean b){
		onScreen = b;
	}
	
	public boolean getOnScreen(){
		return onScreen;
	}
	
}
