package enemy;

import java.awt.image.BufferedImage;

import display.Image;
import game.Game;
import game.Main;
import game.Sound;
import protagonist.Player;

public class Piewee extends Enemy {
	private int state;
	private boolean targetKorriel;
	private int timer;
	private int targetAxis;
	private final static BufferedImage s1 = Image.readImage("res/Enemies/MechaKamek-1.png");
	private final static BufferedImage s2 = Image.readImage("res/Enemies/MechaKamek-2.png");
	private final static BufferedImage s3 = Image.readImage("res/Enemies/MechaKamek-3.png");
	private final static BufferedImage s4 = Image.readImage("res/Enemies/MechaKamek-4.png");
	
	public Piewee(int x, int y) {
		super(x,y,0,0,16,24,16,24,4);
		state=1;
		vSpeed=2*r;
		timer=0;
		if(Game.mari==false) {
			targetKorriel=true;
		}else {
			targetKorriel=false;
		}
		Main.sounds.play(Sound.YiRoar);
	}
	public void move() {
		frames++;
		if(immune>0) {immune--;}
		if(state==1) {
			y+=vSpeed;
			x-=0.75*r;
			if(targetKorriel==true) {
				if(y>=Game.korriel.y-36*r) {
					if(vSpeed>0) {vSpeed-=0.05*r;}else{vSpeed=0;}}
				if(vSpeed<=0) {state++;frames=0;}
			}else {
				if(y>=Game.mariutza.y-36*r) {
					if(vSpeed>0) {vSpeed-=0.05*r;}else{vSpeed=0;}}
				if(vSpeed<=0) {state++;}
			}
		}else if(state==2) {
			timer++;
			if(timer==20) {state++;}
		}else if(state==3) {
			this.x-=3*r;
		}
		if((x<-10*r-this.w)||(y>236*r)) {Game.enemies.remove(this);}
	}
	public BufferedImage wave() {
		if(state<2) {
			if(this.frames<=8) {return s1;}
			else if(frames<16) {return s2;}
			else if(frames<24) {return s3;}
			else if(frames<32) {return s4;}
			else {frames=0;return s4;}
		}else {
			if(this.frames<=4) {return s1;}
			else if(frames<8) {return s2;}
			else if(frames<12) {return s3;}
			else if(frames<24) {return s4;}
			else {frames=0;return s4;}
		}
	}
	public void defeat() {
		Game.score+=20;
		Game.enemies.remove(this);
		Main.sounds.play(Sound.poomSound);
	}

}
