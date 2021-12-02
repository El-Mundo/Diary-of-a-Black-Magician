package protagonist;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import display.GameFrame;
import display.Image;
import effects.Explosion;
import effects.Explosion2;
import effects.Puff;
import effects.Puffie;
import enemy.Enemy;
import game.Game;
import game.Main;
import game.Sound;
import test.*;

public class P2Bullet {
	public double x;
	public double y;
	public int w = 8*r;
	public int h = 8*r;
	public double hSpeed = 3.6*r;
	private static int r = Main.rate;
	public int frames;
	final private static BufferedImage s1 = Image.readImage("res/Magmaball-1.png");
	final private static BufferedImage s2 = Image.readImage("res/Magmaball-2.png");
	
	public P2Bullet(Mariutza cotton) {
		this.x = cotton.x+28*r;
		this.y = cotton.y+10*r;
		this.frames = 0;
	}
	public void move() {
		x+=hSpeed;
		frames++;
		if(x>258*r) {Game.p2bullets.remove(this);}
	}
	public BufferedImage wave() {
		if(frames<=6) {return s1;
		}else if(frames<12) {return s2;
		}else{frames=0;return s2;}
	}
	public Rectangle toRect() {
		Rectangle rect = new Rectangle((int)x,(int)y,w,h);
		return rect;
	}
	public void defeat(Enemy e) {
		if(e.toRect().intersects(this.toRect())) {
			if(e.immune<=0) {
			e.hp-=1;
			Game.effects.add(new Puffie(x,y));
			this.x=260*r;e.damage();Game.score+=5;
			Main.sounds.play(Sound.pomSound);
		}else {
			Game.effects.add(new Puff(x,y));
			this.x=260*r;
			Main.sounds.play(Sound.pomSound);
		}
		}
		if(e.hp<=0) {Game.effects.add(new Explosion2(e.x,e.y));e.defeat();Main.sounds.play(Sound.poomSound);}
	}

}
