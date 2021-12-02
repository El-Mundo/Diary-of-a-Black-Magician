package misc;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import display.Effect;
import display.Image;
import game.Game;
import game.Main;
import game.Sound;

public abstract class Item extends Effect {
	private double acceleration;
	private boolean mari;
	private final static BufferedImage tomato = Image.readImage("res/Effects/Tomato.png");
	private final static BufferedImage strawberry = Image.readImage("res/Effects/Strawberry.png");
	private final static BufferedImage cookie = Image.readImage("res/Effects/Cookie.png");
	
	public static class mgcBall extends Item {
		public mgcBall(int x, int y) {
			super(x, y,12,12);
		}
		public void P1get() {
			Game.korriel.mgcRecover();
			Game.effects.remove(this);
			Main.sounds.play(Sound.SMWitemSound);
		}
		public void P2get() {
			Game.effects.remove(this);
			Main.sounds.play(Sound.SMWitemSound);
		}
	}
	public static class Strawberry extends Item {
		public Strawberry(int x, int y) {
			super(x, y,16,16);
		}
		public void P1get() {
			Game.korriel.heal();
			Game.effects.remove(this);
			Main.sounds.play(Sound.SMWPower);
		}
		public void P2get() {
			Game.mariutza.heal();
			Game.effects.remove(this);
			Main.sounds.play(Sound.SMWPower);
		}
		public BufferedImage wave() {
			return strawberry;
		}
	}
	public static class Tomato extends Item {
		public Tomato(int x, int y) {
			super(x, y,16,16);
		}
		public void P1get() {
			Game.korriel.hp=Game.korriel.maxHP;
			Game.effects.remove(this);
			Main.sounds.play(Sound.SMWPower);
		}
		public void P2get() {
			Game.mariutza.hp=Game.mariutza.maxHP;
			Game.effects.remove(this);
			Main.sounds.play(Sound.SMWPower);
		}
		public BufferedImage wave() {
			return tomato;
		}
	}
	public static class Cookie extends Item {
		public Cookie(int x, int y) {
			super(x, y,16,16);
		}
		public void P1get() {
			Game.korriel.maxHP++;
			Game.korriel.heal();
			Game.effects.remove(this);
			Main.sounds.play(Sound.SMWPower);
		}
		public void P2get() {
			Game.mariutza.maxHP++;
			Game.mariutza.heal();
			Game.effects.remove(this);
			Main.sounds.play(Sound.SMWPower);
		}
		public BufferedImage wave() {
			return cookie;
		}
	}
	
	public Item(int x, int y,int w,int h) {
		super(x,y,w*r,h*r,0,-r,true);
		vSpeed=-r;
		acceleration=0.02*r;
		mari=Game.mari;
	}
	public void move() {
		if(vSpeed>r) {vSpeed=r;}
		if(vSpeed<-r) {vSpeed=-r;}
		if(vSpeed>=r) {acceleration=-0.05*r;}
		if(vSpeed<=-r) {acceleration=0.05*r;}
		this.vSpeed+=acceleration;
		this.y+=this.vSpeed-Game.screenVSpeed;
		this.x-=Game.screenHSpeed;
		if(mari==false) {
			if(this.toRect().intersects(Game.korriel.toRect())) {
				this.P1get();
			}
		}else {
			if(this.toRect().intersects(Game.mariutza.toRect())) {
				this.P2get();
			}
		}
		if((x>266*r)||(x<-10*r-this.w)||(y>236*r)||(y<-10*r-this.h)) {Game.enemies.remove(this);}
	}
	public BufferedImage wave() {
		return mgcBall;
	}
	public void P1get() {
		Game.korriel.heal();
		Game.effects.remove(this);
		Main.sounds.play(Sound.SMWitemSound);
	}
	public void P2get() {
		Game.mariutza.heal();
		Game.effects.remove(this);
		Main.sounds.play(Sound.SMWitemSound);
	}
	public Rectangle toRect() {
		return new Rectangle((int)x,(int)y,w,h);
	}

}
