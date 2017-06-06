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
	
//	private final int _SPACE = 0;
//	private final int _FOOD = 1;
//	private final int _WALL = 2;
	
	public Map(int x, int y, int w, int h) {
		super(x, y, w, h);
		this.width = w;
		this.height = h;
	}

	@Override
	public void update(Graphics2D g) {
		coordinates = new ArrayList<int[]>();
		//remember to add coordinates and label 1, 2, 3
		g.setColor(Color.black);
		
		int x;
		int y;
		
		for(int i = 0; i < 26; i++){
			//top
			if(i != 12 && i != 13){
				x = size*i;
				y = 0;
				g.drawRect(x, y, size, size);
				
				coordinates.add(new int[] {x, y, size});
			}
			
			
			//make an else statement add on the coordinates for the space so that player knows its a space that
			//can go to the other side
		}
		
		for(int i = 0; i < 22; i++){
			//left
			if(i != 10 && i != 11){
				x = 0;
				y = size*i;
				g.drawRect(x, y , size, size);
				
				coordinates.add(new int[] {x, y, size});
				
			}		
		}
		
		for(int i = 0; i < 26; i++){
			//bottom
			if(i != 12 && i != 13){
				x = size*i;
				y = size * 21;
				g.drawRect(x, y, size, size);
				
				coordinates.add(new int[] {x, y, size});
			}		
		}
		
		for(int i = 0; i < 21; i++){
			//right
			if(i != 10 && i != 11){
				x = size * 25;
				y = size*i;
				g.drawRect(x, y, size, size);
				
				coordinates.add(new int[] {x, y, size});
			}	
		}
		
		
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 6; j++){
				if(i == 0){
					x = 90;
					y = 90 + (30*j);
					g.drawRect(x, y, size, size);
					coordinates.add(new int[] {x, y, size});
				}
				if(i == 1){
					x = 90;
					y = 390 + (30*j);
					g.drawRect(x, y, size, size);
					coordinates.add(new int[] {x, y, size});
				}
				if(i == 2){
					x = 660;
					y = 90 + (30*j);
					g.drawRect(x, y, size, size);
					coordinates.add(new int[] {x, y, size});
				}
				if(i == 3){
					x = 660;
					y = 390 + (30*j);
					g.drawRect(x, y, size, size);
					coordinates.add(new int[] {x, y, size});
				}
			}
		}
		
		for(int i = 0; i < 6; i++){
			x = 90 + (30*i);
			y = 240;
			g.drawRect(x, y, size, size);
			coordinates.add(new int[] {x, y, size});
		}
		
		for(int i = 0; i < 2; i++){
			x = 180;
			y = 120 + (30*i);
			g.drawRect(x, y, size, size);
			coordinates.add(new int[] {x, y, size});
		}
		
		for(int i = 0; i < 2; i++){
			x = 270;
			y = 120 + (30*i);
			g.drawRect(x, y, size, size);
			coordinates.add(new int[] {x, y, size});
		}
		
	}
	
	public ArrayList<int[]> getCoordinates(){
		return coordinates;
	}

}
