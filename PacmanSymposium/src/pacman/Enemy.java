/**
 * 
 */
package pacman;

import java.util.ArrayList;

/**
 * @author Risa
 *
 */
public class Enemy implements EnemyInterface{

	private final int BASE_X = 100;
	private final int BASE_Y = 300;
	
	private int x;
	private int y;
	private boolean eaten;
	
	public Enemy(int x, int y){
		this.x = x;
		this.y = y;
		eaten = false;
	}
	
	public void distanceToPlayer(Player p, ArrayList<Images> imageList){
		int playerPosX = p.getPosX();
		int playerPosY = p.getPosY();
		
		
		
	}

	public void move(int width, int height){
		if(!eaten){
			x += width;
			y += height;
		}
	}
	
	@Override
	public boolean isEaten(Player p) {
		if(p.canEat() && x == p.getPosX() && y == p.getPosY())
			eaten = true;
		return eaten;
	}

	@Override
	public void backToBase() {
		if(eaten){
			x = BASE_X;
			y = BASE_Y;
		}
	}
	
	
	
}
