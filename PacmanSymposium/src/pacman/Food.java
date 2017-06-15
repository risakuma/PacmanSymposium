package pacman;

import gui.components.Graphic;

/**
 * @author Katherine
 *
 */

public class Food extends Graphic implements FoodInterface{

	//food randomly appears at different spots, the more times yo collect, the more appears each time
	//powerups dissapear within time
	
	private int foodPoint;
	private boolean powerUp;
	
	private int x;
	private int y;
	
	public Food(int x, int y, String imageLocation, boolean b, int p) {
		super(x, y, .03, imageLocation);
		powerUp = b;
		foodPoint = p;
		this.x = x;
		this.y = y;
	}

	@Override
	public int increasePoints() {
		return this.foodPoint;
	}

	@Override
	public boolean isAPowerUp() {
		return this.powerUp;
	}
	
	public int getPosX(){
		return x;
	}

	public int getPosY(){
		return y;
	}

}
