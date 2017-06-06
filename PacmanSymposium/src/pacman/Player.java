package pacman;

import java.util.ArrayList;
import java.util.Arrays;

import gui.components.Graphic;

/**
 * @author Katherine
 *
 */

public class Player extends Graphic implements PlayerInterface{
	
	//list of player names and highscores
	
	private String name;
	private int score;
	private int posX;
	private int posY;
	private boolean canEat = false;
	private boolean isEaten = false;
	private static final int MAP_POS_X = 20;
	private static final int MAP_POS_Y = 40;
	
	private final int TOP = 0;
	private final int LEFT = 1;
	private final int BOTTOM = 2;
	private final int RIGHT = 3;
	
	public Player(String n, int s, int x, int y){
		super(x, y, .85, "resource/Alice-Down.PNG");
		name = n;
		score = s;
		posX = x;
		posY = y;
	}
	
	public void update(String move, ArrayList<int[]> map){
		if(move.equals("UP")){
			//System.out.println("Player moved UP");
			if(canMove(map, posX, posY - 5, TOP)){
				posY -= 5;
				setY(posY);
			}	
		}
		if(move.equals("DOWN")){
			//System.out.println("Player moved DOWN");
			if(canMove(map, posX, posY + 5, BOTTOM)){
				posY += 5;
				setY(posY);
			}		
		}
		if(move.equals("LEFT")){
			//System.out.println("Player moved LEFT");
			if(canMove(map, posX - 5, posY, LEFT)){
				posX -= 5;
				setX(posX);
			}		
		}
		if(move.equals("RIGHT")){
			//System.out.println("Player moved RIGHT");
			if(canMove(map, posX + 5, posY, RIGHT)){
				posX += 5;
				setX(posX);
			}	
		}
	}
	
	public boolean isEaten(){
		return this.isEaten;
	}

	@Override
	public int getPosX() {
		return this.posX;
	}

	@Override
	public int getPosY() {
		return this.posY; 
	}

	@Override
	public boolean canEat() {
		return this.canEat;
	}
	
	public void setScore(int p){
		score += p;
	}
	
	private boolean canMove(ArrayList<int[]> map, int newX, int newY, int direction){
		for(int i = 0; i < map.size(); i++){
			int[] coordinates = map.get(i);
			if(direction == TOP && newX + getWidth() >= coordinates[0] + MAP_POS_X && newX <= coordinates[0] + coordinates[2] + MAP_POS_X 
					&& newY >= coordinates[1] + MAP_POS_Y && newY <= coordinates[1] + coordinates[2] + MAP_POS_Y){
				return false;
			}
			if(direction == RIGHT && newX + getWidth() >= coordinates[0] + MAP_POS_X && newX + getWidth() <= coordinates[0] + coordinates[2] + MAP_POS_X 
					&& newY +getHeight() >= coordinates[1] + MAP_POS_Y && newY <= coordinates[1] + coordinates[2] + MAP_POS_Y){
				return false;
			}
			if(direction == LEFT && newX >= coordinates[0] + MAP_POS_X && newX <= coordinates[0] + coordinates[2] + MAP_POS_X 
					&& newY + getHeight() >= coordinates[1] + MAP_POS_Y && newY <= coordinates[1] + coordinates[2] + MAP_POS_Y){
				return false;
			}
			if(direction == BOTTOM && newX + getWidth() >= coordinates[0] + MAP_POS_X && newX <= coordinates[0] + coordinates[2] + MAP_POS_X 
					&& newY + getHeight() >= coordinates[1] + MAP_POS_Y && newY <= coordinates[1] + coordinates[2] + MAP_POS_Y){
				return false;
			}
		}
		return true;
	}
}
