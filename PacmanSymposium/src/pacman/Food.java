package pacman;

import gui.components.Graphic;

/**
 * @author Katherine
 *
 */

public class Food extends Graphic implements FoodInterface{

	//food randomly appears at different spots, the more times yo collect, the more appears each time
	//powerups dissapear within time
	
	private String foodName; 
	private int foodPoint;
	private boolean powerUp = false;
	
	public Food(int x, int y, String imageLocation, String f, int p) {
		super(x, y, .03, imageLocation);
		foodName = f;
		foodPoint = p;
	}

	@Override
	public int increasePoints() {
		return this.foodPoint;
	}

	@Override
	public boolean isAPowerUp() {
		return this.powerUp;
	}

}
