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
	
	public Food(int x, int y, String imageLocation, double scale, boolean b, int p) {
		super(x, y, scale, imageLocation);
		powerUp = b;
		foodPoint = p;
		this.x = x;
		this.y = y;
	}
	
	public void setImage(String location, double scale){
		super.setImage(location, scale);
	}

	@Override
	public int getPoints() {
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
