package pacman;

import java.util.ArrayList;

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
	
	public Player(String n, int s, int x, int y){
		super(x, y, .15, "resource/Pacman-Player.png");
		name = n;
		score = s;
		posX = x;
		posY = y;
	}
	
	public void update(String move, ArrayList<int[]> map){
		if(move.equals("UP")){
			//System.out.println("Player moved UP");
			posY -= 5;
			setY(posY);
		}
		if(move.equals("DOWN")){
			//System.out.println("Player moved DOWN");
			posY += 5;
			setY(posY);
		}
		if(move.equals("LEFT")){
			//System.out.println("Player moved LEFT");
			posX -= 5;
			setX(posX);
		}
		if(move.equals("RIGHT")){
			//System.out.println("Player moved RIGHT");
			posX += 5;
			setX(posX);
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
	
	private boolean canMove(ArrayList<int[]> map){
		for(int i = 0; i < map.size(); i++){
			int[] temp = map.get(i);
			if(){
				return false;
			}
		}
		return true;
	}
	
	private boolean checkX(){
		
		return true;
	}
	
	private boolean checkY(){
		
		return true;
	}

}
