package pacman;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import gui.components.Component;
/**
 * @author Risa
 *
 */
public class PlayerStat{

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

}
