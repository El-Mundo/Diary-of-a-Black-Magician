package enemy;

import java.awt.image.BufferedImage;

import display.Image;
import game.Game;
import game.Main;
import game.Sound;

public class WickieBird extends Enemy {
	private boolean targetKorriel;
	private boolean up;
	private int spawnPoint;
	private double acceleration;
	private int range;
	private static int soundTimer = 0;
	private final static BufferedImage s1 = Image.readImage("res/Enemies/Seagull(Maybe)-1.png");
	private final static BufferedImage s2 = Image.readImage("res/Enemies/Seagull(Maybe)-2.png");
	private final static BufferedImage s3 = Image.readImage("res/Enemies/Seagull(Maybe)-3.png");
	private final static BufferedImage s4 = Image.readImage("res/Enemies/Seagull(Maybe)-4.png");
	
	public WickieBird(int y, double s, int range) {
		super(256,y,10,24,38,46,16,16,3);
		hSpeed=-s*r;
		vSpeed=0;
		spawnPoint=y*r;
		acceleration=0.05*r;
		this.range = range*r;
	}
	public void move() {
		frames++;
		if(immune>0) {immune--;}
		y+=vSpeed;
		x+=hSpeed;
		vSpeed+=acceleration;
		if(vSpeed>2*r) {vSpeed=2*r;}
		if(vSpeed<-2*r) {vSpeed=-2*r;}
		if(this.y>=spawnPoint+range) {acceleration=-0.08*r;}
		if(this.y<=spawnPoint-range) {acceleration=0.08*r;}
		if((x>266*r)||(x<-10*r-this.w)||(y>236*r)||(y<-10*r-this.h)) {Game.enemies.remove(this);}
	}
	public void defeat() {
		Game.score+=20;
		Game.enemies.remove(this);
		Main.sounds.play(Sound.poomSound);
	}
	public BufferedImage wave() {
		if(frames<=5) {return s1;}
		else if(frames<=10) {return s2;}
		else if(frames<=15) {return s3;}
		else if(frames<=20) {return s4;}
		else if(frames<=25) {return s3;}
		else if(frames<30) {return s2;}
		else {frames=0;return s2;}
	}
}
