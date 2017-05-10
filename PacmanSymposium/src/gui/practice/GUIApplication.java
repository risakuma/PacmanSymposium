package gui.practice;

import java.awt.Graphics;

import javax.swing.JFrame;

public abstract class GUIApplication extends JFrame implements Runnable{
	
 /**
 * you cannot instantiate/create an abstract class
 */
	
	private Screen currentScreen;

	public GUIApplication() {
		// TODO Auto-generated constructor stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(false); //borders
		int x = 40;
		int y = 40;
		int width = 600;
		int height = 400;
		setBounds(x, y, width, height);
		initScreen();
		setVisible(true);
	}
	
	// method for creating and setting the starting screen
	protected abstract void initScreen();
	
	public void setScreen(Screen screen){
		//stop controls from last screen
		if(currentScreen != null){
			if(currentScreen.getMouseListener() != null){
				removeMouseListener(currentScreen.getMouseListener());
			}
			if(currentScreen.getMouseMotionListener() != null){
				removeMouseMotionListener(currentScreen.getMouseMotionListener());
			}
			if(currentScreen.getKeyListener() != null){
				removeKeyListener(currentScreen.getKeyListener());
			}
		}
		
		//now set new screen
		currentScreen = screen;	
		
		//add controls for new screen
		if(currentScreen != null){
			addMouseListener(currentScreen.getMouseListener());
			addMouseMotionListener(currentScreen.getMouseMotionListener());
			addKeyListener(currentScreen.getKeyListener());
		}
	}
	
	public void paint(Graphics g){
		g.drawImage(currentScreen.getImage(), 0, 0, null);
	}
	
	public void run(){
		while(true){
			currentScreen.update();
			//updates the Window
			repaint();
			try{
				Thread.sleep(40);
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

}

