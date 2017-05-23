/**
 * 
 */
package pacman;

import java.util.ArrayList;

import gui.components.Graphic;

/**
 * @author Risa
 *
 */
public class Enemy extends Graphic implements EnemyInterface{

	private final int BASE_X = 100;
	private final int BASE_Y = 300;
	
	private int x;
	private int y;
	private boolean eaten;
	
	public Enemy(int x, int y){
		super(x, y, .1, "resource/Pacman-Ghost.png");
		this.x = x;
		this.y = y;
		eaten = false;
	}
	
	public void moveToPlayer(Player p){
		int playerPosX = p.getPosX();
		int playerPosY = p.getPosY();
	
		if(!p.canEat()){
			if(playerPosX >= x){
				x += 5;
				setX(x);
			}
			if(playerPosX <= x){
				x -= 5;
				setX(x);
			}
			if(playerPosY >= y){
				y += 5;
				setY(y);
			}
			if(playerPosX <= y){
				y -= 5;
				setY(y);
			}
		}
		
		if(p.canEat()){
			if(playerPosX >= x){
				x -= 5;
				setX(x);
			}
			if(playerPosX <= x){
				x += 5;
				setX(x);
			}
			if(playerPosY >= y){
				y -= 5;
				setY(y);
			}
			if(playerPosX <= y){
				y += 5;
				setY(y);
			}
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
