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

/**
 * @author Katherine
 *
 */

public class IntroScreen extends Screen implements MouseMotionListener, MouseListener{
	
	private ClickableGraphic startBG;
	private ClickableGraphic textBox;
	private Graphic alice;
	private Graphic rabbit;
	private Graphic cheshire;
	private Graphic storyBG1;
	private Graphic storyBG2;
	private Graphic storyBG3;
	private TextLabel title;
	private TextLabel startText;
	private TextLabel story;
	private TextLabel extra;
	private Button gameButton;
	
	private int scene;

	public IntroScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		startBG = new ClickableGraphic(20, 40, 1200, 730, "resource/AliceInWonderland.jpg");	
		viewObjects.add(startBG);
		
		title = new TextLabel(375, 300, 185, 100, "Alice");
		title.setColor(Color.white);
		title.setSize(84);
		title.setFont("Century Gothic");
		viewObjects.add(title);
		
		startText = new TextLabel(450, 350, 225, 100, "(Click To Continue)");
		startText.setColor(Color.white);
		startText.setSize(24);
		startText.setFont("Helvetica");
		viewObjects.add(startText);
		
		startBG.setAction(new Action(){
			public void act(){
				viewObjects.remove(startBG);
				viewObjects.remove(title);
				viewObjects.remove(startText);
				
				storyBG1 = new Graphic(20, 40, 1200, 730, "resource/BlackScreen.jpeg");
				viewObjects.add(storyBG1);
				
				textBox = new ClickableGraphic(40, 550, 1140, 150, "resource/textbox.png");
				viewObjects.add(textBox);
				
				story = new TextLabel(40, 450, 1160, 150, "...Alice found herself helplessly plummeting into darkness until"
						+ " a ray of light beneath her began to glow. (Next).");
				story.setColor(Color.black);
				viewObjects.add(story);
				
				if(scene == 0){
					textBox.setAction(new Action(){
						public void act(){
							viewObjects.remove(storyBG1);
							viewObjects.remove(textBox);
							viewObjects.remove(story);
							
							storyBG2 = new Graphic(20, 40, 1200, 730, "resource/Woodland.jpg");
							viewObjects.add(storyBG2);
							
							viewObjects.add(textBox);
							
							story.setText("Then a bright flash of green illuminated the surrounding and birds could be heard"
									+ " chirping melodious tunes. (Next)");
							viewObjects.add(story);
							
							scene++;
							}
						});
				}
				if(scene == 1){						
					textBox.setAction(new Action(){
						public void act(){	
							viewObjects.remove(storyBG1);
							viewObjects.remove(storyBG2);
							viewObjects.remove(textBox);
							viewObjects.remove(story);
							
							storyBG2 = new Graphic(20, 40, 1200, 730, "resource/Woodland.jpg");
							viewObjects.add(storyBG2);
							
							viewObjects.add(textBox);
							
							story = new TextLabel(40, 450, 1160, 150, "Alice slowly opened her eyes and found herself in a forest. (Next)");
							story.setColor(Color.black);
							viewObjects.add(story);	
							
							scene++;
						}
					});
				}
				if(scene == 2){
					textBox.setAction(new Action(){
						public void act(){	
							viewObjects.remove(storyBG1);
							viewObjects.remove(storyBG2);
							viewObjects.remove(textBox);
							viewObjects.remove(story);
							
							storyBG2 = new Graphic(20, 40, 1200, 730, "resource/Woodland.jpg");
							viewObjects.add(storyBG2);
							
							alice = new Graphic(1000, 210, 245, 300, "resource/AliceA.png");
							viewObjects.add(alice);
							
							viewObjects.add(textBox);
									
							story.setText("Alice: H-huh? Where am I? How did I become so tiny? (Next)");
							viewObjects.add(story);
							
							scene++;
						}
					});
				}
				if(scene == 3){
					textBox.setAction(new Action(){
						public void act(){	
							viewObjects.remove(storyBG1);
							viewObjects.remove(storyBG2);
							viewObjects.remove(textBox);
							viewObjects.remove(story);
							viewObjects.remove(alice);
							
							storyBG2 = new Graphic(20, 40, 1200, 730, "resource/Woodland.jpg");
							viewObjects.add(storyBG2);
							
							cheshire = new Graphic(65, 300, 180, 150, "resource/Cheshire2.jpg");
							viewObjects.add(cheshire);
							
							alice = new Graphic(1000, 230, 245, 300, "resource/AliceA.png");
							viewObjects.add(alice);	
							
							viewObjects.add(textBox);
							
							story = new TextLabel(40, 450, 1160, 150, "Cheshire: Are you lost? (Next)");
							story.setColor(Color.black);
							viewObjects.add(story);
							
							scene++;
						}
					});
				}
				if(scene == 4){
					textBox.setAction(new Action(){
						public void act(){	
							viewObjects.remove(storyBG1);
							viewObjects.remove(storyBG2);
							viewObjects.remove(textBox);
							viewObjects.remove(story);
							viewObjects.remove(alice);
							
							storyBG2 = new Graphic(20, 40, 1200, 730, "resource/Woodland.jpg");
							viewObjects.add(storyBG2);
							
							alice = new Graphic(710, 285, 245, 300, "resource/AliceA.png");
							viewObjects.add(alice);
							
							viewObjects.add(textBox);
									
							story.setText("Alice: What? No, I'm not. I mean...wait you can talk? (Next)");
							viewObjects.add(story);
							
							scene++;
						}
					});
				}
				if(scene == 5){
					textBox.setAction(new Action(){
						public void act(){	
							viewObjects.remove(storyBG1);
							viewObjects.remove(storyBG2);
							viewObjects.remove(textBox);
							viewObjects.remove(story);
							viewObjects.remove(alice);
							
							storyBG2 = new Graphic(20, 40, 1200, 730, "resource/Woodland.jpg");
							viewObjects.add(storyBG2);
							
							cheshire = new Graphic(325, 350, 150, 120, "resource/Cheshire2.jpg");
							viewObjects.add(cheshire);
							
							alice = new Graphic(600, 300, 245, 300, "resource/AliceA.png");
							viewObjects.add(alice);	
							
							viewObjects.add(textBox);
							
							story = new TextLabel(40, 450, 1160, 150, "Cheshire: Well yes, but if you think that's more important than escaping this forest"
									+ " I guess we can go talking forever... Or you ");
							extra = new TextLabel(40, 500, 1160, 150, "can follow the White Rabbit over there. (Next)");
							story.setColor(Color.black);
							extra.setColor(Color.black);
							viewObjects.add(story);			
							viewObjects.add(extra);
							
							scene++;
						}
					});
				}
				if(scene == 6){
					textBox.setAction(new Action(){
						public void act(){	
							viewObjects.remove(storyBG1);
							viewObjects.remove(storyBG2);
							viewObjects.remove(textBox);
							viewObjects.remove(story);
							viewObjects.remove(alice);
							viewObjects.remove(cheshire);
							viewObjects.remove(extra);
							
							storyBG2 = new Graphic(20, 40, 1200, 730, "resource/Woodland.jpg");
							viewObjects.add(storyBG2);
							
							cheshire = new Graphic(325, 350, 150, 120, "resource/Cheshire2.jpg");
							viewObjects.add(cheshire);
							
							alice = new Graphic(600, 300, 245, 300, "resource/AliceA.png");
							viewObjects.add(alice);
							
							rabbit = new Graphic(575, 275, 50, 50, "resource/Rabbit.jpg");
							viewObjects.add(rabbit);
							
							viewObjects.add(textBox);
									
							story.setText("White Rabbit: I'm late I'm late I'm late! (Next)");
							viewObjects.add(story);
							
							scene++;
						}
					});
				}
				if(scene == 7){
					textBox.setAction(new Action(){
						public void act(){	
							viewObjects.remove(storyBG1);
							viewObjects.remove(storyBG2);
							viewObjects.remove(textBox);
							viewObjects.remove(story);
							viewObjects.remove(alice);
							viewObjects.remove(cheshire);
							viewObjects.remove(rabbit);
							
							storyBG3 = new Graphic(20, 40, 1200, 730, "resource/Castle.jpg");
							viewObjects.add(storyBG3);
							
							alice = new Graphic(1000, 300, 220, 275, "resource/AliceA.png");
							viewObjects.add(alice);	
							
							textBox = new ClickableGraphic(40, 550, 1140, 150, "resource/textbox.png");
							viewObjects.add(textBox);
							
							story = new TextLabel(40, 450, 1160, 150, "Following the words of the Cheshire Cat, Alice followed the White Rabbit into a"
									+ " grand castle. (Next)");
							story.setColor(Color.black);
							viewObjects.add(story);	
							
							scene++;
						}
					});
				}
				if(scene == 8){
					textBox.setAction(new Action(){
						public void act(){	
							viewObjects.remove(storyBG1);
							viewObjects.remove(storyBG3);
							viewObjects.remove(textBox);
							viewObjects.remove(story);
							viewObjects.remove(alice);
							
							storyBG3 = new Graphic(20, 40, 1200, 730, "resource/Castle.jpg");
							viewObjects.add(storyBG3);
							
							viewObjects.add(textBox);
							
							story.setText("Queen: Who dares to enter without my permission? Off with her head! (Next)");
							viewObjects.add(story);
							
							scene++;
						}
					});
				}
				if(scene == 9){
					textBox.setAction(new Action(){
						public void act(){	
							viewObjects.remove(storyBG1);
							viewObjects.remove(storyBG3);
							viewObjects.remove(textBox);
							viewObjects.remove(story);
							
							storyBG3 = new Graphic(20, 40, 1200, 730, "resource/Castle.jpg");
							viewObjects.add(storyBG3);	
							
							viewObjects.add(textBox);
							
							story = new TextLabel(40, 450, 1160, 150, "The guards took Alice each by her hands and marched towards the dungeon."
									+ " The Cheshire Cat, who had been watching afar,");
							extra = new TextLabel(40, 500, 1160, 150, " comes forward and proposes a deal with the queen. (Next)");
							story.setColor(Color.black);
							extra.setColor(Color.black);
							viewObjects.add(story);		
							viewObjects.add(extra);
							
							scene++;
						}
					});
				}
				if(scene == 10){
					textBox.setAction(new Action(){
						public void act(){	
							viewObjects.remove(storyBG1);
							viewObjects.remove(storyBG3);
							viewObjects.remove(textBox);
							viewObjects.remove(story);
							viewObjects.remove(extra);
							
							storyBG3 = new Graphic(20, 40, 1200, 730, "resource/Castle.jpg");
							viewObjects.add(storyBG3);	
							
							viewObjects.add(textBox);
							
							story.setText("Cheshire: If Alice can bring you your favorite strawberries from the Haunted Forest, will you"
									+ " let her leave?");
							viewObjects.add(story);
							
							gameButton = new Button(1000, 650, 150, 40, "Start Game", new Color(204, 255, 255), new Action(){
								public void act(){
									Intro.intro.setScreen(Intro.gameScreen);
								}
							});
							viewObjects.add(gameButton);
						}
					});
				}
			}
		
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(startBG.isHovered(e.getX(), e.getY())){
			startBG.act();
		}
		if(textBox.isHovered(e.getX(), e.getY())){
			textBox.act();
		}
		if(gameButton.isHovered(e.getX(), e.getY()))
			gameButton.act();
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
	
//	startBG = new ClickableGraphic(20, 40, 1200, 730, "resource/AliceInWonderland.jpg");	
//	viewObjects.add(startBG);
//	
//	title = new TextLabel(375, 300, 185, 100, "Alice");
//	title.setColor(Color.white);
//	title.setSize(84);
//	title.setFont("Century Gothic");
//	viewObjects.add(title);
//	
//	startText = new TextLabel(450, 350, 225, 100, "(Click To Continue)");
//	startText.setColor(Color.white);
//	startText.setSize(24);
//	startText.setFont("Helvetica");
//	viewObjects.add(startText);
//	
//	startBG.setAction(new Action(){
//		public void act(){
//			viewObjects.remove(startBG);
//			viewObjects.remove(title);
//			viewObjects.remove(startText);
//			
//			storyBG1 = new Graphic(20, 40, 1200, 730, "resource/BlackScreen.jpeg");
//			viewObjects.add(storyBG1);
//			
//			textBox = new ClickableGraphic(40, 550, 1140, 150, "resource/textbox.png");
//			viewObjects.add(textBox);
//			
//			story = new TextLabel(40, 450, 1160, 150, "...Alice found herself helplessly plummeting into darkness until"
//					+ " a ray of light beneath her began to glow...(Next).");
//			story.setColor(Color.black);
//			viewObjects.add(story);
//			
//			textBox.setAction(new Action(){
//				public void act(){
//					viewObjects.remove(storyBG1);
//					
//					storyBG2 = new Graphic(20, 40, 1200, 730, "resource/Woodland.jpg");
//					viewObjects.add(storyBG2);
//					
//					story.setText("...Then a bright flash of green illuminated the surrounding and birds could be heard"
//							+ " chirping melodious tunes... (Next)");
//					viewObjects.add(story);
//				}
//			});
//		}
//	
//	});
//	startBG.setAction(new Action(){
//		public void act(){
//			storyBG2 = new Graphic(20, 40, 1200, 730, "resource/Woodland.jpg");
//			viewObjects.add(storyBG2);
//			
//			textBox = new ClickableGraphic(40, 550, 1140, 150, "resource/textbox.png");
//			viewObjects.add(textBox);
//			
//			story = new TextLabel(40, 450, 1160, 150, "...Alice slowly opened her eyes and found herself in a forest... (Next)");
//			story.setColor(Color.black);
//			viewObjects.add(story);		
//			
//			textBox.setAction(new Action(){
//				public void act(){		
//					alice = new Graphic(1000, 210, 245, 300, "resource/AliceA.png");
//					viewObjects.add(alice);
//							
//					story.setText("Alice: H-huh? Where am I? How did I become so tiny? (Next)");
//					viewObjects.add(story);
//				}
//			});
//		}
//	});
//	startBG.setAction(new Action(){
//		public void act(){
//			storyBG2 = new Graphic(20, 40, 1200, 730, "resource/Woodland.jpg");
//			viewObjects.add(storyBG2);
//			
//			cheshire = new Graphic(65, 300, 180, 150, "resource/Cheshire2.jpg");
//			viewObjects.add(cheshire);
//			
//			alice = new Graphic(1000, 230, 220, 275, "resource/AliceA.png");
//			viewObjects.add(alice);	
//			
//			textBox = new ClickableGraphic(40, 550, 1140, 150, "resource/textbox.png");
//			viewObjects.add(textBox);
//			
//			story = new TextLabel(40, 450, 1160, 150, "Cheshire: Are you lost? (Next)");
//			story.setColor(Color.black);
//			viewObjects.add(story);									
//			
//			textBox.setAction(new Action(){
//				public void act(){
//					viewObjects.remove(alice);
//					
//					alice = new Graphic(710, 285, 245, 300, "resource/AliceA.png");
//					viewObjects.add(alice);
//							
//					story.setText("Alice: What? No, I'm not. I mean...wait you can talk? (Next)");
//					viewObjects.add(story);
//				}
//			});
//		}
//	});
//	startBG.setAction(new Action(){
//		public void act(){
//			storyBG2 = new Graphic(20, 40, 1200, 730, "resource/Woodland.jpg");
//			viewObjects.add(storyBG2);
//			
//			cheshire = new Graphic(325, 350, 150, 120, "resource/Cheshire2.jpg");
//			viewObjects.add(cheshire);
//			
//			alice = new Graphic(600, 300, 245, 300, "resource/AliceA.png");
//			viewObjects.add(alice);	
//			
//			textBox = new ClickableGraphic(40, 550, 1140, 150, "resource/textbox.png");
//			viewObjects.add(textBox);
//			
//			story = new TextLabel(40, 450, 1160, 150, "Cheshire: Well yes, but if you think that's more important than escaping this forest"
//					+ " I guess we can go talking forever... Or you ");
//			TextLabel extra = new TextLabel(40, 500, 1160, 150, "can follow the White Rabbit over there. (Next)");
//			story.setColor(Color.black);
//			extra.setColor(Color.black);
//			viewObjects.add(story);			
//			viewObjects.add(extra);
//			
//			textBox.setAction(new Action(){
//				public void act(){	
//					viewObjects.remove(extra);
//					
//					rabbit = new Graphic(575, 275, 50, 50, "resource/Rabbit.jpg");
//					viewObjects.add(rabbit);
//							
//					story.setText("White Rabbit: I'm late I'm late I'm late! (Next)");
//					viewObjects.add(story);
//				}
//			});
//		}
//	});
//	startBG.setAction(new Action(){
//		public void act(){
//			viewObjects.remove(storyBG2);
//			viewObjects.remove(rabbit);
//			viewObjects.remove(cheshire);
//			viewObjects.remove(alice);
//			
//			storyBG3 = new Graphic(20, 40, 1200, 730, "resource/Castle.jpg");
//			viewObjects.add(storyBG3);
//			
//			alice = new Graphic(1000, 300, 220, 275, "resource/AliceA.png");
//			viewObjects.add(alice);	
//			
//			textBox = new ClickableGraphic(40, 550, 1140, 150, "resource/textbox.png");
//			viewObjects.add(textBox);
//			
//			story = new TextLabel(40, 450, 1160, 150, "Following the words of the Cheshire Cat, Alice followed the White Rabbit into a"
//					+ " grand castle. (Next)");
//			story.setColor(Color.black);
//			viewObjects.add(story);									
//			
//			textBox.setAction(new Action(){
//				public void act(){	
//					viewObjects.remove(alice);
//					
//					story.setText("Queen: Who dares to enter without my permission? Off with her head! (Next)");
//					viewObjects.add(story);
//				}
//			});
//		}
//	});
//	startBG.setAction(new Action(){
//		public void act(){	
//			storyBG3 = new Graphic(20, 40, 1200, 730, "resource/Castle.jpg");
//			viewObjects.add(storyBG3);	
//			
//			textBox = new ClickableGraphic(40, 550, 1140, 150, "resource/textbox.png");
//			viewObjects.add(textBox);
//			
//			story = new TextLabel(40, 450, 1160, 150, "The guards took Alice each by her hands and marched towards the dungeon."
//					+ " The Cheshire Cat, who had been watching afar,");
//			TextLabel extra = new TextLabel(40, 500, 1160, 150, " comes forward and proposes a deal with the queen. (Next)");
//			story.setColor(Color.black);
//			extra.setColor(Color.black);
//			viewObjects.add(story);		
//			viewObjects.add(extra);
//			
//			textBox.setAction(new Action(){
//				public void act(){			
//					viewObjects.remove(extra);
//					
//					story.setText("Cheshire: If Alice can bring you your favorite strawberries from the Haunted Forest, will you"
//							+ " let her leave?");
//					viewObjects.add(story);
//					
//					gameButton = new Button(1000, 650, 150, 40, "Start Game", new Color(204, 255, 255), new Action(){
//						public void act(){
//							Intro.intro.setScreen(Intro.gameScreen);
//						}
//					});
//					viewObjects.add(gameButton);
//				}
//			});
//		}
//	});

}
