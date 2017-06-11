package pacman;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import gui.components.Component;

public class Map extends Component{
	
	private ArrayList<int[]> coordinates;
	private int width;
	private int height;
	private static int  size = 30;
	
	public static final int[] SPACE_TOP_COORD = {(12*size), (14*size), 25}; //between x1 and x2 and above y1
	public static final int[] SPACE_BOTTOM_COORD = {(12*size), (14*size), (23*size)}; //between x1 and x2 and below y1
	public static final int[] SPACE_RIGHT_COORD = {(10*size), (13*size), (26*size)}; //between y1 and y2 and greater than x1
	public static final int[] SPACE_LEFT_COORD = {(10*size), (13*size), 0}; //between y1 and y2 and less than x1
	
	private final int _SPACE = 0;
	private final int _WALL = 1;
//	private final int _FOOD = 2;
	
	
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
				
				coordinates.add(new int[] {x, y, size, _WALL});
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
				
				coordinates.add(new int[] {x, y, size, _WALL});
				
			}		
		}
		
		for(int i = 0; i < 26; i++){
			//bottom
			if(i != 12 && i != 13){
				x = size*i;
				y = size * 21;
				g.drawRect(x, y, size, size);
				
				coordinates.add(new int[] {x, y, size, _WALL});
			}		
		}
		
		for(int i = 0; i < 21; i++){
			//right
			if(i != 10 && i != 11){
				x = size * 25;
				y = size*i;
				g.drawRect(x, y, size, size);
				
				coordinates.add(new int[] {x, y, size, _WALL});
			}	
		}
		
		
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 6; j++){
				if(i == 0){
					x = 3*size;
					y = (3*size) + (size*j);
					g.drawRect(x, y, size, size);
					coordinates.add(new int[] {x, y, size, _WALL});
				}
				if(i == 1){
					x = 3*size;
					y = (13*size) + (size*j);
					g.drawRect(x, y, size, size);
					coordinates.add(new int[] {x, y, size, _WALL});
				}
				if(i == 2){
					x = 22*size;
					y = (3*size) + (size*j);
					g.drawRect(x, y, size, size);
					coordinates.add(new int[] {x, y, size, _WALL});
				}
				if(i == 3){
					x = 22*size;
					y = (13*size) + (size*j);
					g.drawRect(x, y, size, size);
					coordinates.add(new int[] {x, y, size, _WALL});
				}
			}
		}
		
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 6; j++){
				if(i == 0){
					x = (3*size) + (size*j);
					y = 8*size;
					g.drawRect(x, y, size, size);
					coordinates.add(new int[] {x, y, size, _WALL});
				}
				if(i == 1){
					x = (3*size) + (size*j);
					y = 13*size;
					g.drawRect(x, y, size, size);
					coordinates.add(new int[] {x, y, size, _WALL});
				}
				if(i == 2){
					x = (22*size) - (size*j);
					y = 8*size;
					g.drawRect(x, y, size, size);
					coordinates.add(new int[] {x, y, size, _WALL});
				}
				if(i == 3){
					x = (22*size) - (size*j);
					y = 13*size;
					g.drawRect(x, y, size, size);
					coordinates.add(new int[] {x, y, size, _WALL});
				}
			}
		}
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 2; j++){
				if(i == 0){
					x = 6*size;
					y = (4*size) + (size*j);
					g.drawRect(x, y, size, size);
					coordinates.add(new int[] {x, y, size, _WALL});
				}
				if(i == 1){
					x = 6*size;
					y = (16*size) + (size*j);
					g.drawRect(x, y, size, size);
					coordinates.add(new int[] {x, y, size, _WALL});
				}
				if(i == 2){
					x = 19*size;
					y = (4*size) + (size*j);
					g.drawRect(x, y, size, size);
					coordinates.add(new int[] {x, y, size, _WALL});
				}
				if(i == 3){
					x = 19*size;
					y = (16*size) + (size*j);
					g.drawRect(x, y, size, size);
					coordinates.add(new int[] {x, y, size, _WALL});
				}
			}
		}
		
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 2; j++){
				if(i == 0){
					x = 9*size;
					y = (4*size) + (size*j);
					g.drawRect(x, y, size, size);
					coordinates.add(new int[] {x, y, size, _WALL});
				}
				if(i == 1){
					x = 9*size;
					y = (16*size) + (size*j);
					g.drawRect(x, y, size, size);
					coordinates.add(new int[] {x, y, size, _WALL});
				}
				if(i == 2){
					x = 16*size;
					y = (4*size) + (size*j);
					g.drawRect(x, y, size, size);
					coordinates.add(new int[] {x, y, size, _WALL});
				}
				if(i == 3){
					x = 16*size;
					y = (16*size) + (size*j);
					g.drawRect(x, y, size, size);
					coordinates.add(new int[] {x, y, size, _WALL});
				}
			}
		}
		
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 2; j++){
				if(j == 0){
					x = 11*size;
					y = (8*size) + (size*i);
					g.drawRect(x, y, size, size);
					coordinates.add(new int[] {x, y, size, _WALL});
				}
				if(j == 1){
					x = 14*size;
					y = (8*size) + (size*i);
					g.drawRect(x, y, size, size);
					coordinates.add(new int[] {x, y, size, _WALL});
				}
			}	
		}
		
		for(int i = 0; i < 3; i++){
			x = (11*size) + (size*i);
			y = 13*size;
			g.drawRect(x, y, size, size);
			coordinates.add(new int[] {x, y, size, _WALL});
		}
		
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 2; j++){
				if(j == 0){
					x = 12*size;
					y = 8*size + (size*i);
					coordinates.add(new int[] {x, y, size, _SPACE});
				}
				if(j == 1){
					x = 13*size;
					y = 8*size + (size*i);
					coordinates.add(new int[] {x, y, size, _SPACE});
				}
			}
		}
		
		
		//tryna figure out how i can add the coordinates that are not already in the ArrayList and label it with _FOOD so that if i check
		//that spot later and it equals to _FOOD then in the food class i just place food
//		for(int i = 0; i < coordinates.size(); i++){
//			int[] temp = coordinates.get(i);
//			if(temp[0]){
//				
//			}
//		}
		
	}
	
	public ArrayList<int[]> getCoordinates(){
		return coordinates;
	}

}
