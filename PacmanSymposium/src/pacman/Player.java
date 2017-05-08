package pacman;

/**
 * @author Katherine
 *
 */

public class Player implements PlayerInterface{
	
	private String name;
	private int score;
	private int posX;
	private int posY;
	private boolean canEat = false;
	
	public Player(String n, int s, int x, int y){
		name = n;
		score = s;
		posX = x;
		posY = y;
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

}
