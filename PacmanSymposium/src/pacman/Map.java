package pacman;

import java.awt.Color;
import java.awt.Graphics2D;

import gui.components.Component;

public class Map extends Component{
	
	private int[][] coordinates;
	private int width;
	private int height;
	private int size;
	
	public Map(int x, int y, int w, int h) {
		//width and height is divisible by 75
		super(x, y, w, h);
		width = w;
		height = h;
	}

	@Override
	public void update(Graphics2D g) {
		size = 30;
		g.setColor(Color.black);
		for(int i = 0; i < 25; i++){
			if(i != 13){
				g.drawRect(30*i + 10, 30, size, size);
			}		
		}
		for(int i = 1; i < 20; i++){
			if(i != 10){
				g.drawRect(10, 30*i + 30, size, size);
			}		
		}
		for(int i = 0; i < 25; i++){
			if(i != 13){
				g.drawRect(30*i + 10, 630, size, size);
			}		
		}
		for(int i = 1; i < 20; i++){
			if(i != 10){
				g.drawRect(730, 30*i + 30, size, size);
			}	
		}
		
		
	}

}
