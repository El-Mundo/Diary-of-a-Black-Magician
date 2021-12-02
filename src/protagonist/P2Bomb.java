package protagonist;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import display.GameFrame;
import display.Image;
import display.Effect;
import enemy.Enemy;
import game.Game;
import game.Main;
import game.Sound;
import effects.Explosion;
import effects.Explosion2;
import effects.Puff;
import effects.Puffie;

public class P2Bomb {
	private static int r = Main.rate;
	public double x;
	public double y;
	public int w;
	public int h;
	public double hSpeed;
	public double vSpeed;
	public int frames;
	final private static BufferedImage s1 = Image.readImage("res/Fireball-1.png");
	final private static BufferedImage s2 = Image.readImage("res/Fireball-2.png");
	final private static BufferedImage s3 = Image.readImage("res/Fireball-3.png");
	final private static BufferedImage s4 = Image.readImage("res/Fireball-4.png");
	public P2Bomb() {
		y = Game.mariutza.y+10*r;
		x = Game.mariutza.x+26*r;
		w = 8*r;
		h = 9*r;
		vSpeed = -3*r;
		if(Game.mariutza.getHSpeed()>0) {hSpeed = Game.mariutza.getHSpeed()+2*r;}else {hSpeed = 2*r;}
	}
	
	public BufferedImage wave() {
		if(frames<=6) {return s1;
		}else if(frames<12) {return s2;
		}else if(frames<18) {return s3;
		}else if(frames<24) {return s4;
		}else{frames=0;return s4;}
	}
	public void move() {
		x+=hSpeed;
		y+=vSpeed;
		vSpeed+=0.3*r;
		frames++;
		if(y>260*r) {Game.bomb=null;}
	}
	public Rectangle toRect() {
		Rectangle rect = new Rectangle((int)x,(int)y,w,h);
		return rect;
	}
	public void defeat(Enemy e) {
		if(e.toRect().intersects(this.toRect())) {
			if(e.immune<=0) {
				 e.hp-=3;
				Game.effects.add(new Puffie(x,y));
				this.y=260*r;e.damage();Game.score+=15;
				Main.sounds.play(Sound.puruSound);
				}else {
					Game.effects.add(new Puff(x,y));
					this.x=260*r;
					Main.sounds.play(Sound.pomSound);
				}
			}
		if(e.hp<=0) {Game.effects.add(new Explosion2(e.x,e.y));e.defeat();}
	}

}
