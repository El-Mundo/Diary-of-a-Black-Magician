package enemy;

import java.awt.image.BufferedImage;

import display.Image;
import game.Game;
import game.Main;
import game.Sound;
import misc.Item;
import protagonist.Player;

public class Tosser extends Enemy {
	private int state;
	private int moveTime;
	private int groundHeight;
	private final static BufferedImage s1 = Image.readImage("res/Enemies/Hammerbro-1.png");
	private final static BufferedImage s2 = Image.readImage("res/Enemies/Hammerbro-2.png");
	private final static BufferedImage s3 = Image.readImage("res/Enemies/Hammerbro-3.png");
	private final static BufferedImage s4 = Image.readImage("res/Enemies/Hammerbro-4.png");
	private final static BufferedImage h1 = Image.readImage("res/Enemies/Hammer-1.png");
	private final static BufferedImage h2 = Image.readImage("res/Enemies/Hammer-2.png");
	private final static BufferedImage h3 = Image.readImage("res/Enemies/Hammer-3.png");
	private final static BufferedImage h4 = Image.readImage("res/Enemies/Hammer-4.png");
	private boolean targetKorriel;
	
	public class Hammer extends Enemy {
		public Hammer(int x, int y,double s) {
			super(x/r,y/r,0,0,16,16,16,16,999999);
			vSpeed=-5*r;
			hSpeed=s;
			if(Game.mari==false) {targetKorriel=true;}
			else {targetKorriel=false;}
		}
		public void move() {
			frames++;
			immune=999;
			x+=hSpeed;
			y+=vSpeed;
			vSpeed+=0.3*r;
			if(y>248*r) {Game.enemies.remove(this);}
		}
		public BufferedImage wave() {
			if(frames<=6) {return h1;}
			else if(frames<=12) {return h2;}
			else if(frames<=18) {return h3;}
			else if(frames<24) {return h4;}
			else {frames=0;return h4;}
		}
	}
	
	public Tosser(int y) {
		super(256,y,8,2,38,29,20,27,8);
		state = 1;
		groundHeight = y*r;
	}
	public BufferedImage wave() {
		double i;
		if(targetKorriel==true) {i = Game.korriel.x;}
		else {i = Game.mariutza.x;}
			if(i>this.x) {
				if(state==0) {return s3;}
				else {return s4;}
			}else {
				if(state==0) {return s1;}
				else {return s2;}
			}
	}
	public void move() {
		frames++;
		if(immune>0) {immune--;}
		if(state==0) {
			moveTime++;
			if(moveTime==60) {state++;moveTime=0;}
		}else if(state==1) {
			this.vSpeed=-2*r;
			if(y<=groundHeight-48*r) {state++;this.toss();}
		}else if(state==2) {
			this.vSpeed=2*r;
			if(this.y>=groundHeight) {
				this.y=groundHeight;
				this.vSpeed=0;
				state=0;
			}
		}
		this.y+=vSpeed-Game.screenVSpeed;
		this.x-=Game.screenHSpeed;
		if((x>266*r)||(x<-10*r-this.w)||(y>236*r)||(y<-10*r-this.h)) {Game.enemies.remove(this);}
	}
	public void toss() {
		Main.sounds.play(Sound.SMWBurb);
		double i;
		if(targetKorriel==true) {i = Game.korriel.x;}
		else {i = Game.mariutza.x;}
		double distance = i-this.x;
		if(distance>60*r) {distance=60*r;}
		if(distance<-60*r) {distance=-60*r;}
		Game.enemies.add(new Hammer((int)x+12,(int)y+16,distance/20));
	}
	public void defeat() {
		Game.score+=80;
		Game.enemies.remove(this);
		Game.effects.add(new Item.mgcBall((int)x+15, (int)y));
		Main.sounds.play(Sound.SMWItem);
		Main.sounds.play(Sound.poomSound);
	}
}
