package pacman;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import gui.components.Button;
import gui.components.Visible;
import gui.practice.Screen;

public class IntroScreen extends Screen implements MouseMotionListener, MouseListener{
	
	private Button gameButton;

	public IntroScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
//		gameButton = new Button(0, 0, 0, 0, "Start Game", Color.blue, new Action(){
//			public void act(){
//				Intro.game.setScreen(Intro.gameScreen);
//			}
//		});
		viewObjects.add(gameButton);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(gameButton.isHovered(e.getX(), e.getY()))
			gameButton.act();
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
