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
	
	private int x;
	private int y;
	private static double scale = .25;
	
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
