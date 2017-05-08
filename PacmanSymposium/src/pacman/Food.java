package pacman;

/**
 * @author Katherine
 *
 */

public class Food implements FoodInterface{
	
	private String foodName;
	private int foodPoint;
	private boolean powerUp = false;
	
	public Food(String f, int p){
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
