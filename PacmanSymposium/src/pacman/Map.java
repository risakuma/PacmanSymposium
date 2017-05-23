package pacman;

import java.awt.Color;
import java.awt.Graphics2D;

import gui.components.Component;

public class Map extends Component{
	
	private int[][] coordinates;
	
	public Map(int x, int y, int w, int h) {
		//width and height is divisible by 75
		super(x, y, w, h);
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.black);
		for(int i = 0; i < 25; i++){
			g.drawRect(30*i + 10, 30, 30, 30);
		}
		for(int i = 1; i < 20; i++){
			g.drawRect(10, 30*i + 30, 30, 30);
		}
		for(int i = 0; i < 25; i++){
			g.drawRect(30*i + 10, 630, 30, 30);
		}
		for(int i = 1; i < 20; i++){
			g.drawRect(730, 30*i + 30, 30, 30);
		}
	}

}
