package protagonist;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import display.GameFrame;
import display.Image;
import effects.Explosion;
import effects.Explosion2;
import effects.Puff;
import enemy.Enemy;
import game.Game;
import game.Main;
import game.Sound;

public class PBullet {
	public double x;
	public double y;
	public int w = 16*r;
	public int h = 16*r;
	public double vSpeed;
	public double hSpeed = 3.6*r;
	public int frames;
	private static int r = Main.rate;
	final private static BufferedImage s1 = Image.readImage("res/Star-5.png");
	final private static BufferedImage s2 = Image.readImage("res/Star-6.png");
	final private static BufferedImage s3 = Image.readImage("res/Star-7.png");
	final private static BufferedImage s4 = Image.readImage("res/Star-8.png");
	
	
	public PBullet(int vSpeed) {
		this.x = Game.korriel.x+28*r;
		this.y = Game.korriel.y+7*r;
		this.vSpeed=vSpeed*3/4;
		this.frames = 0;
	}
	public void move() {
		x+=hSpeed;
		y+=vSpeed;
		frames++;
		if(x>258*r) {Game.pbullets.remove(this);}
	}
	public BufferedImage wave() {
		if(frames<=8) {return s1;
		}else if(frames<16) {return s2;
		}else if(frames<24) {return s3;
		}else if(frames<32) {return s4;
		}else{frames=0;return s4;}
	}
	public Rectangle toRect() {
		Rectangle rect = new Rectangle((int)x,(int)y,w,h);
		return rect;
	}
	
	public void defeat(Enemy e) {
		if(e.toRect().intersects(this.toRect())) {
			if(e.immune<=0) {
				e.hp-=2;
				e.damage();
				Game.effects.add(new Puff(x,y));
				this.x=260*r;
				Game.score+=10;
				Main.sounds.play(Sound.pomSound);
			}else {
				Game.effects.add(new Puff(x,y));
				this.x=260*r;
				Main.sounds.play(Sound.pomSound);
			}
		}
		if(e.hp<=0) {
			Game.effects.add(new Explosion2(e.x,e.y));
			e.defeat();
			Main.sounds.play(Sound.poomSound);}
	}

}
