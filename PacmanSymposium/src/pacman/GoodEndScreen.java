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

public class GoodEndScreen extends Screen implements MouseMotionListener, MouseListener{
	
	private Graphic endBG;
	private ClickableGraphic textBox;
	private ClickableGraphic whiteTextBox;
	private Graphic alice;
	private Graphic cheshire;
	private Graphic queen;
	private Graphic cHeart;
	private Graphic cSpade;
	private Graphic basket;
	private Graphic storyBG1;
	private Graphic storyBG3;
	private TextLabel allFound;
	private TextLabel endText;
	private TextLabel scoreText;
	private TextLabel score;
	private TextLabel story;
	private TextLabel extra;
	
//	private PlayerStat stat;
	private Button restartButton;
	
	private int scene;

	public GoodEndScreen(int width, int height) {
		super(width, height);
	}
	
	public void initObjects(ArrayList<Visible> viewObjects) {
		endBG = new Graphic(20, 40, 1200, 730, "resource/AliceTheme.jpg");	
		viewObjects.add(endBG);
		
		whiteTextBox = new ClickableGraphic(50, 50, 1125, 650, "resource/whiteTextBox.png");
		viewObjects.add(whiteTextBox);
		
		allFound = new TextLabel(115, 50, 1100, 100, "You found all of the Queen's strawberries!");
		allFound.setColor(Color.red);
		allFound.setSize(48);
		allFound.setFont("Century Gothic");
		viewObjects.add(allFound);
		
		scoreText = new TextLabel(465, 200, 1100, 100, "Your score is");
		scoreText.setColor(Color.black);
		scoreText.setSize(48);
		scoreText.setFont("Helvetica");
		viewObjects.add(scoreText);
		
		score = new TextLabel(575, 375, 1100, 100, "" + PlayerStat.getPoints());
		score.setColor(Color.black);
		score.setSize(100);
		score.setFont("Helvetica");
		viewObjects.add(score);
		
		endText = new TextLabel(500, 540, 225, 100, "(Click To Continue)");
		endText.setColor(Color.red);
		endText.setSize(24);
		endText.setFont("Helvetica");
		viewObjects.add(endText);
		
		cSpade = new Graphic(270, 540, 175, 175, "resource/Card-Spade.jpg");
		viewObjects.add(cSpade);
		
		cHeart = new Graphic(775, 540, 175, 175, "resource/Card-Heart.jpg");
		viewObjects.add(cHeart);
		
		whiteTextBox.setAction(new Action(){
			public void act(){
				viewObjects.remove(endBG);
				viewObjects.remove(whiteTextBox);
				viewObjects.remove(allFound);
				viewObjects.remove(scoreText);
				viewObjects.remove(score);
				viewObjects.remove(endText);
				viewObjects.remove(cSpade);
				viewObjects.remove(cHeart);				
				
				storyBG3 = new Graphic(20, 40, 1200, 730, "resource/Castle.jpg");
				viewObjects.add(storyBG3);
				
				alice = new Graphic(1000, 300, 220, 285, "resource/AliceA.png");
				viewObjects.add(alice);
				
				basket = new Graphic(1000, 460, 100, 100, "resource/Basket.png");
				viewObjects.add(basket);
				
				textBox = new ClickableGraphic(40, 550, 1140, 150, "resource/textbox.png");
				viewObjects.add(textBox);
				
				story = new TextLabel(40, 450, 1160, 150, "...Alice came back to the castle like she promised, with a basket full"
						+ " of the biggest and brightest strawberries she ever laid");
				extra = new TextLabel(40, 500, 1160, 150, " her eyes on. (Next)");
				story.setColor(Color.black);
				extra.setColor(Color.black);
				viewObjects.add(story);
				viewObjects.add(extra);
				
				if(scene == 0){
					textBox.setAction(new Action(){
						public void act() {
							viewObjects.remove(storyBG3);
							viewObjects.remove(textBox);
							viewObjects.remove(story);
							viewObjects.remove(extra);
							viewObjects.remove(cHeart);
							viewObjects.remove(cSpade);
							viewObjects.remove(alice);
							viewObjects.remove(basket);
							
							storyBG3 = new Graphic(20, 40, 1200, 730, "resource/Castle.jpg");
							viewObjects.add(storyBG3);
							
							alice = new Graphic(1000, 300, 220, 285, "resource/AliceA.png");
							viewObjects.add(alice);
							
							basket = new Graphic(1000, 460, 100, 100, "resource/Basket.png");
							viewObjects.add(basket);
							
							queen = new Graphic(150, 325, 225, 225, "resource/Queen.jpg");
							viewObjects.add(queen);
							
							textBox = new ClickableGraphic(40, 550, 1140, 150, "resource/textbox.png");
							viewObjects.add(textBox);
							
							story = new TextLabel(40, 450, 1160, 150, "The Queen, who had been playing chess with Cheshire, smiled"
									+ " with delight at the arrival of the strawberries. (Next)");
							story.setColor(Color.black);
							viewObjects.add(story);
							
							scene++;
						}
					});
				}
				if(scene == 1){
					textBox.setAction(new Action(){
						public void act() {
							viewObjects.remove(storyBG3);
							viewObjects.remove(textBox);
							viewObjects.remove(story);
							viewObjects.remove(extra);
							viewObjects.remove(alice);
							viewObjects.remove(basket);
							viewObjects.remove(queen);
							
							storyBG3 = new Graphic(20, 40, 1200, 730, "resource/Castle.jpg");
							viewObjects.add(storyBG3);
							
							alice = new Graphic(1000, 300, 220, 285, "resource/AliceA.png");
							viewObjects.add(alice);
							
							basket = new Graphic(1000, 460, 100, 100, "resource/Basket.png");
							viewObjects.add(basket);
							
							queen = new Graphic(150, 325, 225, 225, "resource/Queen.jpg");
							viewObjects.add(queen);
							
							textBox = new ClickableGraphic(40, 550, 1140, 150, "resource/textbox.png");
							viewObjects.add(textBox);
							
							story = new TextLabel(40, 450, 1160, 150, "Queen: Guards! Get them to me now! (Next)");
							story.setColor(Color.black);
							viewObjects.add(story);
							
							scene++;
						}
					});
				}
				if(scene == 2){
					textBox.setAction(new Action(){
						public void act() {
							viewObjects.remove(storyBG3);
							viewObjects.remove(textBox);
							viewObjects.remove(story);
							viewObjects.remove(extra);
							viewObjects.remove(alice);
							viewObjects.remove(basket);
							viewObjects.remove(queen);
							
							storyBG3 = new Graphic(20, 40, 1200, 730, "resource/Castle.jpg");
							viewObjects.add(storyBG3);
							
							alice = new Graphic(1000, 300, 220, 285, "resource/AliceA.png");
							viewObjects.add(alice);
							
							queen = new Graphic(150, 325, 225, 225, "resource/Queen.jpg");
							viewObjects.add(queen);
							
							basket = new Graphic(270, 460, 100, 100, "resource/Basket.png");
							viewObjects.add(basket);
							
							textBox = new ClickableGraphic(40, 550, 1140, 150, "resource/textbox.png");
							viewObjects.add(textBox);
							
							story = new TextLabel(40, 450, 1160, 150, "As soon as the Queen received the basket, she snatched"
									+ " a piece and eagerly took a bite. Cheshire patiently waits until the first ");
							extra = new TextLabel(40, 500, 1160, 150, "three pieces dissapeared before speaking up. (Next)");
							story.setColor(Color.black);
							extra.setColor(Color.black);
							viewObjects.add(story);
							viewObjects.add(extra);
							
							scene++;
						}
					});
				}
				if(scene == 3){
					textBox.setAction(new Action(){
						public void act() {
							viewObjects.remove(storyBG3);
							viewObjects.remove(textBox);
							viewObjects.remove(story);
							viewObjects.remove(extra);
							viewObjects.remove(alice);
							viewObjects.remove(basket);
							viewObjects.remove(queen);
							
							storyBG3 = new Graphic(20, 40, 1200, 730, "resource/Castle.jpg");
							viewObjects.add(storyBG3);
							
							alice = new Graphic(1000, 300, 220, 285, "resource/AliceA.png");
							viewObjects.add(alice);
							
							queen = new Graphic(150, 325, 225, 225, "resource/Queen.jpg");
							viewObjects.add(queen);
							
							basket = new Graphic(270, 460, 100, 100, "resource/Basket.png");
							viewObjects.add(basket);
							
							cheshire = new Graphic(100, 430, 150, 120, "resource/Cheshire2.jpg");
							viewObjects.add(cheshire);
							
							textBox = new ClickableGraphic(40, 550, 1140, 150, "resource/textbox.png");
							viewObjects.add(textBox);
							
							story = new TextLabel(40, 450, 1160, 150, "Cheshire: My Queen, about that promise... (Next)");
							story.setColor(Color.black);
							viewObjects.add(story);
							
							scene++;
						}
					});
				}
				if(scene == 4){
					textBox.setAction(new Action(){
						public void act() {
							viewObjects.remove(storyBG3);
							viewObjects.remove(textBox);
							viewObjects.remove(story);
							viewObjects.remove(extra);
							viewObjects.remove(alice);
							viewObjects.remove(queen);
							viewObjects.remove(basket);
							viewObjects.remove(cheshire);
							
							storyBG3 = new Graphic(20, 40, 1200, 730, "resource/Castle.jpg");
							viewObjects.add(storyBG3);
							
							alice = new Graphic(1000, 300, 220, 285, "resource/AliceA.png");
							viewObjects.add(alice);
							
							queen = new Graphic(150, 325, 225, 225, "resource/Queen.jpg");
							viewObjects.add(queen);
							
							basket = new Graphic(270, 460, 100, 100, "resource/Basket.png");
							viewObjects.add(basket);
							
							cheshire = new Graphic(190, 260, 125, 100, "resource/Cheshire2.jpg");
							viewObjects.add(cheshire);
							
							textBox = new ClickableGraphic(40, 550, 1140, 150, "resource/textbox.png");
							viewObjects.add(textBox);
							
							story = new TextLabel(40, 450, 1160, 150, "Silence followed. The Queen neither replies nor looks up,"
									+ " but with utter impatience, snaps her fingers. (Next)");
							story.setColor(Color.black);
							viewObjects.add(story);
							
							scene++;
						}
					});
				}
				if(scene == 5){
					textBox.setAction(new Action(){
						public void act() {
							viewObjects.remove(storyBG3);
							viewObjects.remove(textBox);
							viewObjects.remove(story);
							viewObjects.remove(extra);
							viewObjects.remove(alice);
							viewObjects.remove(queen);
							viewObjects.remove(basket);
							viewObjects.remove(cheshire);
							
							storyBG1 = new Graphic(20, 40, 1200, 730, "resource/BlackScreen.jpeg");
							viewObjects.add(storyBG1);
							
							textBox = new ClickableGraphic(40, 550, 1140, 150, "resource/textbox.png");
							viewObjects.add(textBox);
							
							story = new TextLabel(40, 450, 1160, 150, "Alice slowly began to feel drowsy. Her eyelids grew heavier and"
									+ " heavier until everything became pitch black... (Click to End Story)");
							story.setColor(Color.black);
							viewObjects.add(story);
							
							restartButton = new Button(1000, 650, 150, 40, "End Game", new Color(204, 255, 255), new Action(){
								public void act(){
									Intro.intro.setScreen(Intro.screen);
								}
							});
							viewObjects.add(restartButton);
						}
					});
				}
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(whiteTextBox.isHovered(e.getX(), e.getY())){
			whiteTextBox.act();
		}
		if(textBox.isHovered(e.getX(), e.getY())){
			textBox.act();
		}
		if(restartButton.isHovered(e.getX(), e.getY()))
			restartButton.act();
	}
	
	public MouseListener getMouseListener(){
		return this;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
