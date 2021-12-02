package effects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import display.Effect;
import display.GameFrame;
import display.Image;
import game.Game;
import game.Main;

public class HighestScore extends JPanel {
	private final static BufferedImage menuScore = Image.readImage("res/Background/TestTitle.png");
	private static int r = Main.rate;
	private int h;
	private int s;
	private boolean nr;
	private static BlackScreen bse = new BlackScreen(true,30);
	private static BlackScreen bso = new BlackScreen(false,30);
	private int i;
	private boolean over;
	
	public HighestScore() {
		if(Game.levelNumber!=0) {
			h = Main.save[4];
			s = Game.score;
			if(s>h) {nr=true;}
		}else if(Game.twoPlayer==true) {
			h = Main.save[3];
			s = Game.score;
			if(s>h) {nr=true;}
		}else {
			h = Main.save[2];
			s = Game.score;
			if(s>h) {nr=true;}
		}
		Game.highestScore();
		this.i=0;
		this.over=false;
		this.setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(menuScore, 0,0,256*r,224*r, this);
		g.setColor(Color.black);
		g.drawString("Highest:"+h, 30, 50);
		g.drawString("Score:"+s, 30, 80);
		if(nr==true) {g.drawString("New Record", 100, 100);}
		g.drawImage(bse.titleWave(),0,0,256*r,224*r,this);
		if((GameFrame.J==true)||(GameFrame.Enter==true)) {GameFrame.J=false;
		GameFrame.Enter=false;over=true;}
		if(over==true) {
			g.drawImage(bso.titleWave(),0,0,256*r,224*r,this);
			i++;
			if(i==50) {
				GameFrame.lostGame();
				bse.restart();
				bso.restart();
				this.setVisible(false);
				Main.frame.remove(this);
			}
		}
		try {
			Thread.sleep(17);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.repaint();
	}
}
