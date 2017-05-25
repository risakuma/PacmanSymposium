package pacman;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import gui.components.Component;

public class Map extends Component{
	
	private ArrayList<int[]> coordinates;
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
		//remember to add coordinates and label 1, 2, 3
		size = 30;
		coordinates = new ArrayList<int[]>();
		g.setColor(Color.black);
		for(int i = 0; i < 25; i++){
			//top
			if(i != 13){
				g.drawRect(30*i + 20, 40, size, size);
				//coordinates.add([23,32,34,54]);
			}		
		}
		for(int i = 1; i < 20; i++){
			//left
			if(i != 10){
				g.drawRect(20, 30*i + 40, size, size);
			}		
		}
		for(int i = 0; i < 25; i++){
			//bottom
			if(i != 13){
				g.drawRect(30*i + 20, 640, size, size);
			}		
		}
		for(int i = 1; i < 20; i++){
			//right
			if(i != 10){
				g.drawRect(740, 30*i + 40, size, size);
			}	
		}
		
		
	}

}
