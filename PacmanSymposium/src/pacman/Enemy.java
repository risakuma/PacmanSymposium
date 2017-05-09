/**
 * 
 */
package pacman;

/**
 * @author Risa
 *
 */
public class Enemy implements EnemyInterface{

	private final int BASE_X = 0;
	private final int BASE_Y = 0;
	
	private int x;
	private int y;
	private boolean eaten = false;
	
	public Enemy(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void findPlayer(Player p){
		int playerX = p.getPosX();
		int playerY = p.getPosY();
	}

	public void update(){
		
	}
	
	public void setEaten(boolean b){
		eaten = b;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	@Override
	public boolean isEaten(Player p) {
		if(p.canEat() && x == p.getPosX() && y == p.getPosY())
			eaten = true;
		return eaten;
	}

	@Override
	public void backToBase() {
		x = BASE_X;
		y = BASE_Y;
	}
	
	
	
}
