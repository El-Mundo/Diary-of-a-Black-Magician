package display;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import enemy.Enemy;
import game.*;
import misc.Block;
import protagonist.*;
import test.*;

public class Sprite2P extends JPanel {
	public static Korriel korriel = Game.korriel;
	public static Mariutza mariutza = Game.mariutza;
	public static Sp2Thread sp2Thread;
	public static MultiGameThread mgt;
	private PBullet pBullet;
	private P2Bullet p2Bullet;
	private Hissatsu his;
	private P2Bomb bomb;
	private Block block;
	private Effect ef;
	private static int r = Main.rate;
	
	public Sprite2P() {
		super();
		sp2Thread = new Sp2Thread(this);
		mgt = new MultiGameThread();
		mgt.start();
		sp2Thread.start();
		this.setBackground(Color.black);
	}
	public void paint(Graphics g) {
		super.paint(g);
		
		Game.level.background(g);
		
		Game.level.layerTwo(g);
		
		g.drawImage(korriel.wave(),(int)(korriel.x),(int)(korriel.y),korriel.w,korriel.h,this);
		g.drawImage(mariutza.wave(),(int)(mariutza.x),(int)(mariutza.y),mariutza.w,mariutza.h,this);
		for(int i = 0;i<Game.pbullets.size();i++) {
			pBullet = Game.pbullets.get(i);
			g.drawImage(pBullet.wave(),(int)(pBullet.x),(int)(pBullet.y),pBullet.w,pBullet.h,this);}
		for(int i = 0;i<Game.p2bullets.size();i++) {
			p2Bullet = Game.p2bullets.get(i);
			g.drawImage(p2Bullet.wave(),(int)(p2Bullet.x),(int)(p2Bullet.y),p2Bullet.w,p2Bullet.h,this);}
		if(Game.hissatsu!=null) {
			his = Game.hissatsu;
			g.drawImage(his.wave(),(int)(his.x),(int)(his.y),his.w,his.h,this);}
		if(Game.bomb!=null) {
			bomb = Game.bomb;
			g.drawImage(bomb.wave(),(int)(bomb.x),(int)(bomb.y),bomb.w,bomb.h,this);}
		
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
		g.drawImage(mariutza.icon(),100*r, 192*r, 28*r, 28*r, null);
		for(int i=0;i<mariutza.maxHP;i++) {g.drawImage(Effect.heart1,135*r+9*i*r, 202*r, 8*r, 8*r,null);}
		if(mariutza.hp>0){for(int i=0;i<mariutza.hp;i++) {g.drawImage(Effect.heart2,135*r+9*i*r, 202*r, 8*r, 8*r,null);}}
		g.drawImage(Effect.SCORE,79*r,6*r,50*r,8*r,null);
		Effect.paintScore(Game.score, g, 129*r, 6*r);
		
		if(Game.pause==true) {g.drawImage(Effect.PAUSE,106*r,105*r,44*r,14*r,this);}
	}
	

}

class Sp2Thread extends Thread {
	private Sprite2P pane;
	public Sp2Thread(Sprite2P jp) {
		this.pane = jp;
	}
	public void run() {
		while(true){try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
				pane.repaint();}
	}
}

