package pacman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

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

	private static int points;
	private int foodLeft;
	private final int space = 20;
	
	public void addPoints(int p){
		points += p;
	}
	
	public static int getPoints(){
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
		//clear();
		int x = 10;
		int y = 35;
		
		g.setColor(new Color(255, 102, 102));
		g.fillRect(0, 0, 330, 661);
		g.setColor(new Color(25, 51, 0));
		g.fillRect(5, 5, 320, 651);
		
		g.setFont(new Font("Courier", Font.BOLD, 20));
		g.setColor(new Color(255, 102, 102));
		g.drawString("Help Alice find all the", x + 20, y);
		y += space;
		g.drawString("strawberries in the", x + 40, y);
		y += space;
		g.drawString("Haunted Forest!", x + 65, y);
		
		y += space*2;
		g.setColor(Color.white);
		g.setFont(new Font("Courier", Font.BOLD, 15));
		g.drawString("Number of Strawberries Left: ", x + 30, y);
		g.setFont(new Font("Courier", Font.PLAIN, 15));
		g.drawString("" + foodLeft, x + 285, y + 1);
		y += space + 1;
		g.setFont(new Font("Courier", Font.BOLD, 15));
		g.drawString("Points: " , x + 30, y);
		g.setFont(new Font("Courier", Font.PLAIN, 15));
		g.drawString("" + points, x + 100, y + 1);
		
		y += space + 5;
		
		g.setColor(new Color(255, 102, 102));
		g.setFont(new Font("Courier", Font.BOLD, 15));
		g.drawString("Directions: ", x, y);
		y += space;
		
		g.setFont(new Font("Courier", Font.PLAIN, 15));
		g.drawString("* the strawberries are hidden all", x + 10, y);
		y += space;
		g.drawString("over the place! Find them!", x + 10, y);
		y += space;
		g.drawString("* don't let the ghosts touch", x + 10, y);
		y += space;
		g.drawString("Alice!" , x + 10, y);
		y += space;
		g.drawString("* Alice can gain the ability to", x + 10, y);
		y += space;
		g.drawString("fight back against the ghosts for", x + 10, y);
		y += space;
		g.drawString("a short period of time!", x + 10, y);
		y += space;
		g.drawString("...sometimes", x + 10, y);
		
		y += space + 10;
		
		g.setFont(new Font("Courier", Font.BOLD, 15));
		g.drawString("Strawberry: ", x + 50, y);
		g.setFont(new Font("Courier", Font.PLAIN, 15));
		g.drawString("30pts", x + 155, y);
		y += space + 19;
		g.setFont(new Font("Courier", Font.BOLD, 15));
		g.drawString("Milk: ", x + 50, y);
		g.setFont(new Font("Courier", Font.PLAIN, 15));
		g.drawString("gives Alice a power up", x + 100, y);
		y += space;
		g.drawString("50pts", x + 100, y);
		y += space + 3;
		g.setFont(new Font("Courier", Font.BOLD, 15));
		g.drawString("Cake: ", x + 50, y);
		g.setFont(new Font("Courier", Font.PLAIN, 15));
		g.drawString("gives higher points", x + 100, y);
		y += space;
		g.drawString("100pts", x + 100, y);
		
		y += space*2 + 5;
		
		g.setFont(new Font("Courier", Font.BOLD, 15));
		g.drawString("Alice", x + 50, y);
		y += space*2 + 8;
		g.setFont(new Font("Courier", Font.BOLD, 15));
		g.drawString("Alice: ", x + 50, y);
		g.setFont(new Font("Courier", Font.PLAIN, 15));
		g.drawString("powered up", x + 110, y);
		
		y += space*2 + 8;
		
		g.setFont(new Font("Courier", Font.BOLD, 15));
		g.drawString("Ghost", x + 50, y);
		y += space*2;
		g.setFont(new Font("Courier", Font.BOLD, 15));
		g.drawString("Ghost: ", x + 50, y);
		g.setFont(new Font("Courier", Font.PLAIN, 15));
		g.drawString("running away", x + 110, y);
	}

}
