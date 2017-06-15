package pacman;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import gui.components.Action;
import gui.components.Button;
import gui.components.ClickableGraphic;
import gui.components.Graphic;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.practice.Screen;

public class IntroScreen extends Screen implements MouseMotionListener, MouseListener{
	
	private ClickableGraphic startBG;
	private Graphic storyBG1;
	private TextLabel text;
	private TextLabel text2;
	private TextLabel story;
	private Button textBox;
	private Button gameButton;

	public IntroScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		startBG = new ClickableGraphic(20, 40, 1200, 730, "resource/AliceInWonderland.jpg");	
		viewObjects.add(startBG);
		
		text = new TextLabel(375, 300, 185, 100, "Alice");
		text.setColor(Color.white);
		text.setSize(84);
		text.setFont("Century Gothic");
		viewObjects.add(text);
		
		text2 = new TextLabel(450, 350, 225, 100, "(Click To Continue)");
		text2.setColor(Color.white);
		text2.setSize(24);
		text2.setFont("Helvetica");
		viewObjects.add(text2);
		
		startBG.setAction(new Action(){
			public void act(){
				viewObjects.remove(startBG);
				viewObjects.remove(text);
				viewObjects.remove(text2);
				
				storyBG1 = new Graphic(20, 40, 1200, 730, "resource/BlackScreen.jpeg");
				viewObjects.add(storyBG1);
				
				textBox = new Button(40, 550, 1160, 150, "...Alice found herself helplessly plummeting into darkness. For how long"
						+ " she could not tell, but finally a ray of light beneath her began" 
						+ "\n" + " to glow increasingly brighter.", new Color(224, 224, 224), new Action(){
					public void act(){
						
					}
				});
				viewObjects.add(textBox);
			}
		});
		

		
		
		
		
//		gameButton = new Button(40, 200, 150, 40, "Start Game", Color.blue, new Action(){
//			public void act(){
//				Intro.intro.setScreen(Intro.gameScreen);
//			}
//		});
//		viewObjects.add(gameButton);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(startBG.isHovered(e.getX(), e.getY())){
			startBG.act();
		}
		if(textBox.isHovered(e.getX(), e.getY())){
			textBox.act();
		}
//		if(gameButton.isHovered(e.getX(), e.getY()))
//			gameButton.act();
	}
	
	public MouseListener getMouseListener(){
		return this;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
