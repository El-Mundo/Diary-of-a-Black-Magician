package enemy;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import display.Image;
import effects.Puff;
import game.Game;
import game.Main;
import game.Sound;
import protagonist.*;

public class Enemy {
	public double x;
	public double y;
	public int w;
	public int h;
	public int rx;
	public int ry;
	public int rw;
	public int rh;
	public int hp;
	public Rectangle rect;
	public int immune;
	public double hSpeed;
	public double vSpeed;
	protected int frames;
	protected static int r = Main.rate;
	private final static BufferedImage e1 = Image.readImage("res/Fireball-1.png");
	private final static BufferedImage e2 = Image.readImage("res/Fireball-3.png");
	public Enemy(int x, int y, int rx, int ry, int w, int h, int rw, int rh, int hp) {
		this.x = x*r;
		this.y = y*r;
		this.rx = rx*r;
		this.ry = ry*r;
		this.w = w*r;
		this.h = h*r;
		this.rw = rw*r;
		this.rh = rh*r;
		this.hp = hp;
		this.immune = 0;
		this.frames = 0;
	}
	
	public void move() {
		if(immune>0) {immune--;}
		frames++;
		x-=r;
		y+=vSpeed;
		if((x>266*r)||(x<-10*r-this.w)||(y>236*r)||(y<-10*r-this.h)) {Game.enemies.remove(this);}
	}
	public BufferedImage wave() {
		if(this.frames<=12) {return e1;}
		else if(frames<24) {return e2;}
		else {frames=0;return e2;}
	}
	public Rectangle toRect() {
		rect = new Rectangle((int)(x+rx),(int)(y+ry),rw,rh);
		return rect;
	}
	public void hurt1P(Korriel k) {
		if(this.toRect().intersects(k.toRect())) {
			k.changeHSpeed(k.x+k.w/2-this.x-this.w/2);
			k.changeVSpeed(k.y+k.h/2-this.y-this.h/2);
		k.damage();
	}
	}
	public void hurt2P(Mariutza m) {
		if(this.toRect().intersects(m.toRect())) {
			m.damage();
			m.changeHSpeed(m.x+m.w/2-this.x-this.w/2);
			m.changeVSpeed(m.y+m.h/2-this.y-this.h/2);
		}
	}
	public void hurtMP(Korriel k, Mariutza m) {
		if(this.toRect().intersects(k.toRect())) {
				k.changeHSpeed(k.x+k.w/2-this.x-this.w/2);
				k.changeVSpeed(k.y+k.h/2-this.y-this.h/2);
			k.damage();
		}
		if(this.toRect().intersects(m.toRect())) {
			m.damage();
			m.changeHSpeed(m.x+m.w/2-this.x-this.w/2);
			m.changeVSpeed(m.y+m.h/2-this.y-this.h/2);
		}
	}
	public static void removeAllEnemies(ArrayList<Enemy> es) {
		Enemy e;
		for(int i=0;i<es.size();i++) {
			e = es.get(i);
			es.remove(i);
			Game.effects.add(new Puff(e.x,e.y));
		}
	}
	public void defeat() {
		Game.score+=20;
		Game.enemies.remove(this);
		Main.sounds.play(Sound.poomSound);
	}
	public void damage() {
		
	}
	

}
