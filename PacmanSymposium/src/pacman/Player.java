package pacman;

import java.util.ArrayList;

import gui.components.Graphic;
import gui.components.Visible;

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
	private final static double scale = 0.87;
	
	private boolean canEat;
	private boolean isEaten;
	private static final int MAP_POS_X = 20;
	private static final int MAP_POS_Y = 40;
	
	private final int TOP = 0;
	private final int LEFT = 1;
	private final int BOTTOM = 2;
	private final int RIGHT = 3;
	
	public Player(String n, int s, int x, int y){
		super(x, y, scale, "resource/alice_down.PNG");
		name = n;
		score = s;
		posX = x;
		posY = y;
	}
	
	public void update(String move, ArrayList<int[]> map){
		if(move.equals("UP")){
			//System.out.println("Player moved UP");
			setImage("resource/alice_up.png", scale);
			if(canMove(map, posX, posY - 5, TOP)){
				posY -= 5;
				setY(posY);
			}
			if(posX >= Map.SPACE_TOP_COORD[0] && posX <= Map.SPACE_TOP_COORD[1] && posY <= Map.SPACE_TOP_COORD[2]){
				posY = Map.SPACE_BOTTOM_COORD[2];
				setY(posY);
			}
		}
		if(move.equals("DOWN")){
			//System.out.println("Player moved DOWN");
			setImage("resource/alice_down.png", scale);
			if(canMove(map, posX, posY + 5, BOTTOM)){
				posY += 5;
				setY(posY);
			}
			if(posX >= Map.SPACE_BOTTOM_COORD[0] && posX <= Map.SPACE_BOTTOM_COORD[1] && posY >= Map.SPACE_BOTTOM_COORD[2]){
				posY = Map.SPACE_TOP_COORD[2];
				setY(posY);
			}
		}
		if(move.equals("LEFT")){
			//System.out.println("Player moved LEFT");
			setImage("resource/alice_left.png", scale);
			if(canMove(map, posX - 5, posY, LEFT)){
				posX -= 5;
				setX(posX);
			}
			if(posY >= Map.SPACE_LEFT_COORD[0] && posY <= Map.SPACE_LEFT_COORD[1] && posX <= Map.SPACE_LEFT_COORD[2]){
				posX = Map.SPACE_RIGHT_COORD[2];
				setX(posX);
			}
		}
		if(move.equals("RIGHT")){
			//System.out.println("Player moved RIGHT");
			setImage("resource/alice_right.png", scale);
			if(canMove(map, posX + 5, posY, RIGHT)){
				posX += 5;
				setX(posX);
			}
			if(posY >= Map.SPACE_RIGHT_COORD[0] && posY <= Map.SPACE_RIGHT_COORD[1] && posX >= Map.SPACE_RIGHT_COORD[2]){
				posX = Map.SPACE_LEFT_COORD[2];
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
	
	public int[] getTopCoordinates(){
		return new int[]{posX, (posX + getWidth()), posY};
	}
	
	public int[] getBottomCoordinates(){
		return new int[]{posX, (posX + getWidth()), (posY + getHeight())};
	}
	
	public int[] getRightCoordinates(){
		return new int[]{posY, (posY + getHeight()), (posX + getWidth())};
	}
	
	public int[] getLeftCoordinates(){
		return new int[]{posY, (posY + getHeight()), posX};
	}
	
	@Override
	public boolean canEat() {
		return canEat;
	}
	
	public void setEat(boolean b){
		canEat = b;
	}
	public void setScore(int p){
		score += p;
	}
	
	private boolean canMove(ArrayList<int[]> map, int newX, int newY, int direction){
		for(int i = 0; i < map.size(); i++){
			int[] coordinates = map.get(i);
			if(direction == TOP && newX + getWidth() >= coordinates[0] + MAP_POS_X && newX <= coordinates[0] + coordinates[2] + MAP_POS_X 
					&& newY >= coordinates[1] + MAP_POS_Y && newY <= coordinates[1] + coordinates[2] + MAP_POS_Y 
					&& coordinates[3] == 1){
				return false;
			}
			if(direction == RIGHT && newX + getWidth() >= coordinates[0] + MAP_POS_X && newX + getWidth() <= coordinates[0] + coordinates[2] + MAP_POS_X 
					&& newY +getHeight() >= coordinates[1] + MAP_POS_Y && newY <= coordinates[1] + coordinates[2] + MAP_POS_Y 
					&& coordinates[3] == 1){
				return false;
			}
			if(direction == LEFT && newX >= coordinates[0] + MAP_POS_X && newX <= coordinates[0] + coordinates[2] + MAP_POS_X 
					&& newY + getHeight() >= coordinates[1] + MAP_POS_Y && newY <= coordinates[1] + coordinates[2] + MAP_POS_Y 
					&& coordinates[3] == 1){
				return false;
			}
			if(direction == BOTTOM && newX + getWidth() >= coordinates[0] + MAP_POS_X && newX <= coordinates[0] + coordinates[2] + MAP_POS_X 
					&& newY + getHeight() >= coordinates[1] + MAP_POS_Y && newY <= coordinates[1] + coordinates[2] + MAP_POS_Y 
					&& coordinates[3] == 1){
				return false;
			}
		}
		return true;
	}
}
