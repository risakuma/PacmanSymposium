package pacman;

import java.awt.Graphics2D;

import gui.components.Component;
/**
 * @author Risa
 *
 */
public class PlayerStat extends Component{

	public PlayerStat(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	private int points;
	private int foodLeft;
	
	public void addPoints(int p){
		points += p;
	}
	
	public int getPoints(){
		return points;
	}
	
	public void increaseNumOfFood(int n){
		foodLeft += n;
	}
	
	public void decreaseNumOfFodd(int n){
		foodLeft -= n;
	}
	
	public int getFoodLeft(){
		return foodLeft;
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

}
