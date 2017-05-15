package pacman;

/**
 * @author Katherine
 *
 */

public class Player implements PlayerInterface{
	
	//list of player names and highscores
	
	private String name;
	private int score;
	private int posX;
	private int posY;
	private boolean canEat = false;
	private boolean isEaten = false;
	
	public Player(String n, int s, int x, int y){
		name = n;
		score = s;
		posX = x;
		posY = y;
	}
	
	public void update(String move){
		if(move.equals("UP")){
			System.out.println("Player moved UP");
			posY += 5;
		}
		if(move.equals("DOWN")){
			System.out.println("Player moved DOWN");
			posY -= 5;
		}
		if(move.equals("LEFT")){
			System.out.println("Player moved LEFT");
			posX -= 5;
		}
		if(move.equals("RIGHT")){
			System.out.println("Player moved RIGHT");
			posX += 5;
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

}
