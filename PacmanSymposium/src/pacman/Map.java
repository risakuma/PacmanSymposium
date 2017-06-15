package pacman;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import gui.components.Component;

public class Map extends Component{
	
	private ArrayList<int[]> coordinates; //{x, y, size, type}
	private static final int WIDTH = Game.getMapWidth() - 1;
	private static final int HEIGHT = Game.getMapHeight() - 1;
	private static final int VERTICAL_TRANSPORT = WIDTH / 60;
	private static final int HORIZONTAL_TRANSPORT = HEIGHT / 60;
	private static final int  SIZE = 30;
	
	public static final int[] SPACE_TOP_COORD = {(VERTICAL_TRANSPORT - 1)*SIZE, (VERTICAL_TRANSPORT + 1)*SIZE, 25}; //between x1 and x2 and above y1
	public static final int[] SPACE_BOTTOM_COORD = {(VERTICAL_TRANSPORT - 1)*SIZE, (VERTICAL_TRANSPORT + 1)*SIZE, HEIGHT + SIZE}; //between x1 and x2 and below y1
	public static final int[] SPACE_RIGHT_COORD = {(HORIZONTAL_TRANSPORT - 1)*SIZE, (HORIZONTAL_TRANSPORT + 2)*SIZE, WIDTH}; //between y1 and y2 and greater than x1
	public static final int[] SPACE_LEFT_COORD = {(HORIZONTAL_TRANSPORT - 1)*SIZE, (HORIZONTAL_TRANSPORT + 2)*SIZE, 0}; //between y1 and y2 and less than x1
	
	private static final int _SPACE = 0;
	private static final int _WALL = 1;
	private static final int _FOOD = 2;
	private static final int _TRANSPORT = 3;
	private static final int ENEMY_SPACE = 4;
	
	
	public Map(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override
	public void update(Graphics2D g) {
		coordinates = new ArrayList<int[]>();
		g.setColor(Color.black);

		//makes a grid
		for(int x = 0; x < WIDTH; x += SIZE){
			for(int y = 0; y < HEIGHT; y += SIZE){
				coordinates.add(new int[]{x, y, SIZE, _SPACE});
			}
		}
		
		//draws the borders and space where player can go through to go to the other side
		for(int[] coordinate: coordinates){
			if(coordinate[0] == 0 || coordinate[0] == WIDTH - SIZE || coordinate[1] == 0 || coordinate[1] == HEIGHT - SIZE){
				if(coordinate[0] == (SIZE*(VERTICAL_TRANSPORT - 1)) && coordinate[1] == 0 || coordinate[0] == (SIZE*(VERTICAL_TRANSPORT - 1)) && coordinate[1] == HEIGHT - SIZE ||
						coordinate[0] == (SIZE*VERTICAL_TRANSPORT) && coordinate[1] == 0 || coordinate[0] == (SIZE*VERTICAL_TRANSPORT) && coordinate[1] == HEIGHT - SIZE ||
							coordinate[0] == 0 && coordinate[1] == (SIZE * (HORIZONTAL_TRANSPORT - 1)) || coordinate[0] == 0 && coordinate[1] == SIZE * HORIZONTAL_TRANSPORT ||
								coordinate[0] == WIDTH - SIZE && coordinate[1] == (SIZE * (HORIZONTAL_TRANSPORT - 1)) || coordinate[0] == WIDTH - SIZE && coordinate[1] == SIZE * HORIZONTAL_TRANSPORT){
					coordinate[3] = _TRANSPORT;
				}else{
					g.drawRect(coordinate[0], coordinate[1], SIZE, SIZE);
					coordinate[3] = _WALL;
				}
			}
		}
		
		int numOfBoxX;
		int numOfBoxY;
		
		for(int[] coordinate: coordinates){
			if(coordinate[3] != _WALL && coordinate[3] != _TRANSPORT){
				//first piece
				numOfBoxX = 3;
				numOfBoxY = 3;
				if(coordinate[0] == numOfBoxX*SIZE && coordinate[1] >= numOfBoxY*SIZE && coordinate[1] <= (numOfBoxY + 5) * SIZE){
					g.drawRect(coordinate[0], coordinate[1], SIZE, SIZE);
					coordinate[3] = _WALL;
				}
				
				numOfBoxY = 13;
				if(coordinate[0] == numOfBoxX*SIZE && coordinate[1] >= numOfBoxY*SIZE && coordinate[1] <= (numOfBoxY + 5) * SIZE){
					g.drawRect(coordinate[0], coordinate[1], SIZE, SIZE);
					coordinate[3] = _WALL;
				}
				
				numOfBoxX = 22;
				numOfBoxY = 3;
				if(coordinate[0] == numOfBoxX*SIZE && coordinate[1] >= numOfBoxY*SIZE && coordinate[1] <= (numOfBoxY + 5) * SIZE){
					g.drawRect(coordinate[0], coordinate[1], SIZE, SIZE);
					coordinate[3] = _WALL;
				}
				
				numOfBoxY = 13;
				if(coordinate[0] == numOfBoxX*SIZE && coordinate[1] >= numOfBoxY*SIZE && coordinate[1] <= (numOfBoxY + 5) * SIZE){
					g.drawRect(coordinate[0], coordinate[1], SIZE, SIZE);
					coordinate[3] = _WALL;
				}
				
				//second piece
				numOfBoxX = 3;
				numOfBoxY = 8;
				if(coordinate[1] == numOfBoxY*SIZE && coordinate[0] >= numOfBoxX*SIZE && coordinate[0] <= (numOfBoxX + 5) * SIZE){
					g.drawRect(coordinate[0], coordinate[1], SIZE, SIZE);
					coordinate[3] = _WALL;
				}
				
				numOfBoxY = 13;
				if(coordinate[1] == numOfBoxY*SIZE && coordinate[0] >= numOfBoxX*SIZE && coordinate[0] <= (numOfBoxX + 5) * SIZE){
					g.drawRect(coordinate[0], coordinate[1], SIZE, SIZE);
					coordinate[3] = _WALL;
				}
				
				numOfBoxX = 17;
				numOfBoxY = 8;
				if(coordinate[1] == numOfBoxY*SIZE && coordinate[0] >= numOfBoxX*SIZE && coordinate[0] <= (numOfBoxX + 5) * SIZE){
					g.drawRect(coordinate[0], coordinate[1], SIZE, SIZE);
					coordinate[3] = _WALL;
				}
				
				numOfBoxY = 13;
				if(coordinate[1] == numOfBoxY*SIZE && coordinate[0] >= numOfBoxX*SIZE && coordinate[0] <= (numOfBoxX + 5) * SIZE){
					g.drawRect(coordinate[0], coordinate[1], SIZE, SIZE);
					coordinate[3] = _WALL;
				}
				
				//third piece
				numOfBoxX = 6;
				numOfBoxY = 4;
				if(coordinate[0] == numOfBoxX*SIZE && coordinate[1] >= numOfBoxY*SIZE && coordinate[1] <= (numOfBoxY + 1) * SIZE){
					g.drawRect(coordinate[0], coordinate[1], SIZE, SIZE);
					coordinate[3] = _WALL;
				}
				
				numOfBoxY = 16;
				if(coordinate[0] == numOfBoxX*SIZE && coordinate[1] >= numOfBoxY*SIZE && coordinate[1] <= (numOfBoxY + 1) * SIZE){
					g.drawRect(coordinate[0], coordinate[1], SIZE, SIZE);
					coordinate[3] = _WALL;
				}
				
				numOfBoxX = 19;
				numOfBoxY = 4;
				if(coordinate[0] == numOfBoxX*SIZE && coordinate[1] >= numOfBoxY*SIZE && coordinate[1] <= (numOfBoxY + 1) * SIZE){
					g.drawRect(coordinate[0], coordinate[1], SIZE, SIZE);
					coordinate[3] = _WALL;
				}
				
				numOfBoxY = 16;
				if(coordinate[0] == numOfBoxX*SIZE && coordinate[1] >= numOfBoxY*SIZE && coordinate[1] <= (numOfBoxY + 1) * SIZE){
					g.drawRect(coordinate[0], coordinate[1], SIZE, SIZE);
					coordinate[3] = _WALL;
				}
				
				//fourth piece
				numOfBoxX = 9;
				numOfBoxY = 3;
				if(coordinate[0] == numOfBoxX*SIZE && coordinate[1] >= numOfBoxY*SIZE && coordinate[1] <= (numOfBoxY + 2) * SIZE){
					g.drawRect(coordinate[0], coordinate[1], SIZE, SIZE);
					coordinate[3] = _WALL;
				}
				
				numOfBoxY = 16;
				if(coordinate[0] == numOfBoxX*SIZE && coordinate[1] >= numOfBoxY*SIZE && coordinate[1] <= (numOfBoxY + 2) * SIZE){
					g.drawRect(coordinate[0], coordinate[1], SIZE, SIZE);
					coordinate[3] = _WALL;
				}
				
				numOfBoxX = 16;
				numOfBoxY = 3;
				if(coordinate[0] == numOfBoxX*SIZE && coordinate[1] >= numOfBoxY*SIZE && coordinate[1] <= (numOfBoxY + 2) * SIZE){
					g.drawRect(coordinate[0], coordinate[1], SIZE, SIZE);
					coordinate[3] = _WALL;
				}
				
				numOfBoxY = 16;
				if(coordinate[0] == numOfBoxX*SIZE && coordinate[1] >= numOfBoxY*SIZE && coordinate[1] <= (numOfBoxY + 2) * SIZE){
					g.drawRect(coordinate[0], coordinate[1], SIZE, SIZE);
					coordinate[3] = _WALL;
				}
				
				//enemy base
				
				numOfBoxX = 11;
				numOfBoxY = 8;
				if(coordinate[0] == numOfBoxX*SIZE && coordinate[1] >= numOfBoxY*SIZE && coordinate[1] <= (numOfBoxY + 5) * SIZE){
					g.drawRect(coordinate[0], coordinate[1], SIZE, SIZE);
					coordinate[3] = _WALL;
				}
				
				numOfBoxX = 14;
				numOfBoxY = 8;
				if(coordinate[0] == numOfBoxX*SIZE && coordinate[1] >= numOfBoxY*SIZE && coordinate[1] <= (numOfBoxY + 5) * SIZE){
					g.drawRect(coordinate[0], coordinate[1], SIZE, SIZE);
					coordinate[3] = _WALL;
				}
				
				numOfBoxX = 11;
				numOfBoxY = 13;
				if(coordinate[1] == numOfBoxY*SIZE && coordinate[0] >= numOfBoxX*SIZE && coordinate[0] <= (numOfBoxX + 2) * SIZE){
					g.drawRect(coordinate[0], coordinate[1], SIZE, SIZE);
					coordinate[3] = _WALL;
				}
				
				numOfBoxY = 8;
				if(coordinate[0] >= (VERTICAL_TRANSPORT - 1)*SIZE && coordinate[0] < (VERTICAL_TRANSPORT + 1)*SIZE && coordinate[1] >= numOfBoxY*SIZE &&
						coordinate[1] < (numOfBoxY + 5)*SIZE){
					coordinate[3] = ENEMY_SPACE;
				}
				numOfBoxY = 14;
				if(coordinate[0] >= (VERTICAL_TRANSPORT - 1)*SIZE && coordinate[0] < (VERTICAL_TRANSPORT + 1)*SIZE && coordinate[1] >= numOfBoxY*SIZE &&
						coordinate[1] < (numOfBoxY + 1)*SIZE){
					coordinate[3] = ENEMY_SPACE;
				}
			}
		}
		
		for(int[] coordinate: coordinates){
			if(coordinate[3] == _SPACE){
				coordinate[0] += 10;
				coordinate[1] += 10;
				coordinate[3] = _FOOD;
			}
		}
		
		
		
//		int x;
//		int y;		
//		
//		//borders
//		for(int i = 0; i < 26; i++){
//			//top
//			if(i != 12 && i != 13){
//				x = SIZE*i;
//				y = 0;
//				g.drawRect(x, y, SIZE, SIZE);
//				coordinates.add(new int[] {x, y, SIZE, _WALL});
//			}
//			
//			
//			//make an else statement add on the coordinates for the space so that player knows its a space that
//			//can go to the other side
//		}
//		for(int i = 0; i < 26; i++){
//			//bottom
//			if(i != 12 && i != 13){
//				x = SIZE*i;
//				y = SIZE * 21;
//				g.drawRect(x, y, SIZE, SIZE);
//				coordinates.add(new int[] {x, y, SIZE, _WALL});
//			}		
//		}
//		for(int i = 0; i < 22; i++){
//			//left
//			if(i != 10 && i != 11){
//				x = 0;
//				y = SIZE*i;
//				g.drawRect(x, y , SIZE, SIZE);
//				coordinates.add(new int[] {x, y, SIZE, _WALL});
//				
//			}		
//		}
//		for(int i = 0; i < 21; i++){
//			//right
//			if(i != 10 && i != 11){
//				x = SIZE * 25;
//				y = SIZE*i;
//				g.drawRect(x, y, SIZE, SIZE);
//				coordinates.add(new int[] {x, y, SIZE, _WALL});
//			}	
//		}
//		
//		
//		//map pieces
//		for(int i = 0; i < 4; i++){
//			for(int j = 0; j < 6; j++){
//				//piece 1
//				if(i == 0){
//					x = 3*SIZE;
//					y = (3*SIZE) + (SIZE*j);
//					g.drawRect(x, y, SIZE, SIZE);
//					coordinates.add(new int[] {x, y, SIZE, _WALL});
//				}
//				if(i == 1){
//					x = 3*SIZE;
//					y = (13*SIZE) + (SIZE*j);
//					g.drawRect(x, y, SIZE, SIZE);
//					coordinates.add(new int[] {x, y, SIZE, _WALL});
//				}
//				if(i == 2){
//					x = 22*SIZE;
//					y = (3*SIZE) + (SIZE*j);
//					g.drawRect(x, y, SIZE, SIZE);
//					coordinates.add(new int[] {x, y, SIZE, _WALL});
//				}
//				if(i == 3){
//					x = 22*SIZE;
//					y = (13*SIZE) + (SIZE*j);
//					g.drawRect(x, y, SIZE, SIZE);
//					coordinates.add(new int[] {x, y, SIZE, _WALL});
//				}
//			}
//		}
//		for(int i = 0; i < 4; i++){
//			for(int j = 0; j < 6; j++){
//				//piece 2
//				if(i == 0){
//					x = (3*SIZE) + (SIZE*j);
//					y = 8*SIZE;
//					g.drawRect(x, y, SIZE, SIZE);
//					coordinates.add(new int[] {x, y, SIZE, _WALL});
//				}
//				if(i == 1){
//					x = (3*SIZE) + (SIZE*j);
//					y = 13*SIZE;
//					g.drawRect(x, y, SIZE, SIZE);
//					coordinates.add(new int[] {x, y, SIZE, _WALL});
//				}
//				if(i == 2){
//					x = (22*SIZE) - (SIZE*j);
//					y = 8*SIZE;
//					g.drawRect(x, y, SIZE, SIZE);
//					coordinates.add(new int[] {x, y, SIZE, _WALL});
//				}
//				if(i == 3){
//					x = (22*SIZE) - (SIZE*j);
//					y = 13*SIZE;
//					g.drawRect(x, y, SIZE, SIZE);
//					coordinates.add(new int[] {x, y, SIZE, _WALL});
//				}
//			}
//		}
//		for(int i = 0; i < 4; i++){
//			for(int j = 0; j < 2; j++){
//				//piece 3
//				if(i == 0){
//					x = 6*SIZE;
//					y = (4*SIZE) + (SIZE*j);
//					g.drawRect(x, y, SIZE, SIZE);
//					coordinates.add(new int[] {x, y, SIZE, _WALL});
//				}
//				if(i == 1){
//					x = 6*SIZE;
//					y = (16*SIZE) + (SIZE*j);
//					g.drawRect(x, y, SIZE, SIZE);
//					coordinates.add(new int[] {x, y, SIZE, _WALL});
//				}
//				if(i == 2){
//					x = 19*SIZE;
//					y = (4*SIZE) + (SIZE*j);
//					g.drawRect(x, y, SIZE, SIZE);
//					coordinates.add(new int[] {x, y, SIZE, _WALL});
//				}
//				if(i == 3){
//					x = 19*SIZE;
//					y = (16*SIZE) + (SIZE*j);
//					g.drawRect(x, y, SIZE, SIZE);
//					coordinates.add(new int[] {x, y, SIZE, _WALL});
//				}
//			}
//		}
//		for(int i = 0; i < 4; i++){
//			for(int j = 0; j < 2; j++){
//				//piece 4
//				if(i == 0){
//					x = 9*SIZE;
//					y = (4*SIZE) + (SIZE*j);
//					g.drawRect(x, y, SIZE, SIZE);
//					coordinates.add(new int[] {x, y, SIZE, _WALL});
//				}
//				if(i == 1){
//					x = 9*SIZE;
//					y = (16*SIZE) + (SIZE*j);
//					g.drawRect(x, y, SIZE, SIZE);
//					coordinates.add(new int[] {x, y, SIZE, _WALL});
//				}
//				if(i == 2){
//					x = 16*SIZE;
//					y = (4*SIZE) + (SIZE*j);
//					g.drawRect(x, y, SIZE, SIZE);
//					coordinates.add(new int[] {x, y, SIZE, _WALL});
//				}
//				if(i == 3){
//					x = 16*SIZE;
//					y = (16*SIZE) + (SIZE*j);
//					g.drawRect(x, y, SIZE, SIZE);
//					coordinates.add(new int[] {x, y, SIZE, _WALL});
//				}
//			}
//		}
//		
//		
//		//enemy zone
//		for(int i = 0; i < 6; i++){
//			for(int j = 0; j < 2; j++){
//				if(j == 0){
//					x = 11*SIZE;
//					y = (8*SIZE) + (SIZE*i);
//					g.drawRect(x, y, SIZE, SIZE);
//					coordinates.add(new int[] {x, y, SIZE, _WALL});
//				}
//				if(j == 1){
//					x = 14*SIZE;
//					y = (8*SIZE) + (SIZE*i);
//					g.drawRect(x, y, SIZE, SIZE);
//					coordinates.add(new int[] {x, y, SIZE, _WALL});
//				}
//			}	
//		}
//		for(int i = 0; i < 3; i++){
//			x = (11*SIZE) + (SIZE*i);
//			y = 13*SIZE;
//			g.drawRect(x, y, SIZE, SIZE);
//			coordinates.add(new int[] {x, y, SIZE, _WALL});
//		}
//		
//		
//		//label space in the enemy zone
//		for(int i = 0; i < 6; i++){
//			for(int j = 0; j < 2; j++){
//				if(j == 0){
//					x = 12*SIZE;
//					y = 8*SIZE + (SIZE*i);
//					coordinates.add(new int[] {x, y, SIZE, _SPACE});
//				}
//				if(j == 1){
//					x = 13*SIZE;
//					y = 8*SIZE + (SIZE*i);
//					coordinates.add(new int[] {x, y, SIZE, _SPACE});
//				}
//			}
//		}
//		
//		
//		//figuring out how i can add the coordinates that are not already in the coordinates ArrayList and label it with _FOOD 
//		//so that if i check that spot later and it equals to _FOOD then in the food class i just place food
//		ArrayList<int[]> temp = new ArrayList<int[]>();
//		for(int i = 0; i < 22; i++){
//			x = 0;
//			y = 0;
//			for(int j = 0 ; j < 26; j++){
//				x = SIZE*j;
//				y = SIZE*i;
//				temp.add(new int[] {x, y, SIZE, _FOOD});
//			}
//		}
//		for(int i = 0; i < coordinates.size(); i++){
//			for(int j = temp.size() - 1; 0 < j; j--){
//				int[] cArray = coordinates.get(i);
//				int[] tArray = temp.get(j);
//				if(cArray[0] == tArray[0] && cArray[1] == tArray[1]){
//					temp.remove(j);
//				}
//			}
//		}
//		coordinates.addAll(temp);	
	}
	
	public ArrayList<int[]> getCoordinates(){
		return coordinates;
	}

}
