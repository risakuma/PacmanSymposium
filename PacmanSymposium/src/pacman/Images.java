package pacman;

public class Images {
	
	private boolean wall;
	private boolean food;
	private boolean powerUp;
	private String imageSrc;
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	public Images(String imageSrc, boolean wall, boolean food, boolean powerUp, int x, int y, int width, int height){
		this.wall = wall;
		this.imageSrc = imageSrc;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public boolean ifFood(){
		return food;
	}
	
	public boolean ifPowerUp(){
		return powerUp;
	}
	
	public boolean ifWall(){
		return wall;
	}
	
	public String getImage(){
		return imageSrc;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	
}
