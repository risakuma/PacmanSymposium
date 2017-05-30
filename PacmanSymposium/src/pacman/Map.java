package pacman;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import gui.components.Component;

public class Map extends Component{
	
	private ArrayList<int[]> coordinates;
	private int width;
	private int height;
	private final int  size = 30;
	
	private final int _SPACE = 0;
	private final int _FOOD = 1;
	private final int _WALL = 2;
	
	public Map(int x, int y, int w, int h) {
		//width and height is divisible by 75
		super(x, y, w, h);
		this.width = w;
		this.height = h;
	}

	@Override
	public void update(Graphics2D g) {
		coordinates = new ArrayList<int[]>();
		//remember to add coordinates and label 1, 2, 3
		g.setColor(Color.black);
		System.out.println(_WALL);
		
		int x;
		int y;
		
		for(int i = 0; i < 25; i++){
			//top
			if(i != 13){
				x = size*i;
				y = 0;
				g.drawRect(x, y, size, size);
				
				coordinates.add(new int[] {x + 20, y + 40, _WALL});
				
			}		
		}
		
		for(int i = 1; i < 20; i++){
			//left
			if(i != 10){
				x = 0;
				y = size*i;
				g.drawRect(x, y , size, size);
				
				coordinates.add(new int[] {x + 20, y + 40, _WALL});
				
			}		
		}
		
		for(int i = 0; i < 25; i++){
			//bottom
			if(i != 13){
				x = size*i;
				y = size * 20;
				g.drawRect(x, y, size, size);
				
				coordinates.add(new int[] {x + 20, y + 40, _WALL});
			}		
		}
		
		for(int i = 1; i < 20; i++){
			//right
			if(i != 10){
				x = size * 24;
				y = size*i;
				g.drawRect(x, y, size, size);
				
				coordinates.add(new int[] {x + 20, y + 40, _WALL});
			}	
		}
		
	}
	
	public ArrayList<int[]> getCoordinates(){
		return coordinates;
	}
	
	public int getSize(){
		return size;
	}

}
