package display;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import enemy.Enemy;
import game.Game;
import game.GameThread;
import game.Main;
import misc.Block;
import protagonist.*;
import test.*;

public class Sprite extends JPanel {
	public static Korriel korriel = Game.korriel;
	public static SpThread spThread;
	public static GameThread gt;
	private PBullet pBullet;
	private Hissatsu his;
	private Block block;
	private Effect ef;
	private static int r = Main.rate;
	private static Graphics2D g2d;
	public static AffineTransform transformation; 
	public static int framePerSecond = 60;
	public static int frameNumber = 0;
	
	public Sprite() {
		super();
		spThread = new SpThread(this);
		gt = new GameThread();
		gt.start();
		spThread.start();
		this.setBackground(Color.black);
		transformation = AffineTransform.getScaleInstance(4, 4);
		FrameRateThread frt = new FrameRateThread();
		frt.start();
	}
	public void paint(Graphics g) {
		super.paint(g);
		
		Game.level.background(g);
		
		Game.level.layerTwo(g);
		
		g.drawImage(korriel.wave(),(int)(korriel.x),(int)(korriel.y),korriel.w,korriel.h,this);
		for(int i = 0;i<Game.pbullets.size();i++) {
			pBullet = Game.pbullets.get(i);
			g.drawImage(pBullet.wave(),(int)(pBullet.x),(int)(pBullet.y),pBullet.w,pBullet.h,this);}
		if(Game.hissatsu!=null) {
			his = Game.hissatsu;
			g.drawImage(his.wave(),(int)(his.x),(int)(his.y),his.w,his.h,this);}
		
		g.setColor(Color.WHITE);
		for(int i = 0;i<Game.blocks.size();i++) {
			block = Game.blocks.get(i);
			g.fillRect(block.x, block.y, block.width, block.height);
		}
		
		if(Game.enemies.size()>0) {
			for(int n = 0;n<Game.enemies.size();n++) {Enemy e = Game.enemies.get(n);g.drawImage(e.wave(),(int)(e.x), (int)(e.y), e.w, e.h,this);}}
		
		Game.level.layerThree(g);
		
		for(int i = 0;i<Game.effects.size();i++) {
			ef = Game.effects.get(i);
			g.drawImage(ef.wave(), (int)(ef.x), (int)(ef.y), ef.w, ef.h, this);
		}
		
		g.drawImage(korriel.icon(), 15*r, 192*r, 28*r, 28*r, null);
		for(int i=0;i<korriel.maxHP;i++) {g.drawImage(Effect.heart1,52*r+9*i*r, 198*r, 8*r, 8*r,null);}
		if(korriel.hp>0){for(int i=0;i<korriel.hp;i++) {g.drawImage(Effect.heart2,52*r+9*i*r, 198*r, 8*r, 8*r,null);}}
		g.drawImage(Effect.mgcBall,52*r, 208*r, 8*r, 8*r,null);
		Effect.paintHissatsu(korriel.getMg(),g,61*r, 208*r);
		g.drawImage(Effect.SCORE,79*r,6*r,50*r,8*r,null);
		Effect.paintScore(Game.score, g, 129*r, 6*r);
		if(Game.pause==true) {g.drawImage(Effect.PAUSE,106*r,105*r,44*r,14*r,this);}
		frameNumber++;g.setFont(new Font("ËÎÌו",Font.BOLD,30));g.drawString(""+framePerSecond, 20, 30);
	}
}

class SpThread extends Thread {
	private Sprite pane;
	public SpThread(Sprite jp) {
		this.pane = jp;
	}
	public void run() {
		while(true){try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
				pane.repaint();
			}
	}
}

