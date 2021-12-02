package enemy;

import java.awt.image.BufferedImage;

import display.Image;
import effects.Puff;
import game.Game;
import game.Main;
import game.Sound;

public class ¾¿¼«ÎÞµÐÔÓÃ«¹Ö extends Enemy {
	private final static BufferedImage e1 = Image.readImage("res/Enemies/Est-1.png");
	private final static BufferedImage e2 = Image.readImage("res/Enemies/Est-2.png");
	private boolean mari;
	private int state;
	private int attackTimer;
	private int targetTime;
	private int hurt;
	private boolean anger;
	
	public ¾¿¼«ÎÞµÐÔÓÃ«¹Ö(int x, int y) {
		super(x,y,0,0,24,43,24,43,36);
		this.mari=Game.mari;
		hSpeed=-2*r;
		vSpeed=0;
		state=0;
		hurt = 0;
		attackTimer=0;
	}
	public void move() {
		if(immune>0) {immune--;}
		if(hurt>-40) {hurt--;}
		frames++;
		attackTimer++;
		if(state==0) {
			immune=5;
			this.hSpeed=-r*0.5;
			this.vSpeed=0;
			if(this.x<=212*r) {state++;Main.sounds.changeBGM(7);Main.sounds.loopBGM();targetTime=300;}
		}else if(state==1) {
			this.hSpeed=0;
			if(mari==false) {
				if(this.y<Game.korriel.y) {this.vSpeed+=0.05*r;}else if(this.y>Game.korriel.y) {this.vSpeed-=0.05*r;}
				if((y>=Game.korriel.y-16*r)&&(y<=Game.korriel.y+16*r)) {vSpeed=shift(vSpeed);}
			}else {
				if(this.y<Game.mariutza.y) {this.vSpeed+=0.05*r;}else if(this.y>Game.mariutza.y) {this.vSpeed-=0.05*r;}
				if((y>=Game.mariutza.y-16*r)&&(y<=Game.mariutza.y+16*r)) {vSpeed=shift(vSpeed);}
			}
			if(attackTimer==targetTime) {Game.enemies.add(new ÐþÌúºÚÍõµ¯((int)(x/r),(int)((y+10*r)/r),hSpeed));Main.sounds.play(Sound.fooSound);
				attackTimer=0;state++;}
			if(hp<=16) {state=2;attackTimer=500;anger=true;}
			if(vSpeed>r) {vSpeed=r;}
			if(vSpeed<-r) {vSpeed=-r;}
			if(this.ignored()==true) {state=4;}
		}else if(state==2) {
			this.hSpeed=0;
			this.vSpeed=0;
			if(attackTimer==80) {attackTimer=0;targetTime=(int) (Math.random()*60+80);state--;}
			if(attackTimer==550) {state++;attackTimer=0;}
		}else if(state==3) {
			if(mari==false) {
				if(this.x<Game.korriel.x) {this.hSpeed+=0.06*r;}else if(this.x>Game.korriel.x) {this.hSpeed-=0.06*r;}
				if(this.y<Game.korriel.y) {this.vSpeed+=0.06*r;}else if(this.y>Game.korriel.y) {this.vSpeed-=0.06*r;}
			}else {
				if(this.x<Game.mariutza.x) {this.hSpeed+=0.06*r;}else if(this.x>Game.mariutza.x) {this.hSpeed-=0.06*r;}
				if(this.y<Game.mariutza.y) {this.vSpeed+=0.06*r;}else if(this.y>Game.mariutza.y) {this.vSpeed-=0.06*r;}
			}
			if(hSpeed>2*r) {hSpeed=2*r;}
			if(hSpeed<-2*r) {hSpeed=-2*r;}
			if(vSpeed>2*r) {vSpeed=2*r;}
			if(vSpeed<-2*r) {vSpeed=-2*r;}
			if(attackTimer==200) {Game.enemies.add(new ÐþÌúºÚÍõµ¯((int)(x/r),(int)((y+10*r)/r),hSpeed));attackTimer=0;Main.sounds.play(Sound.fooSound);}
		}else if(state==4) {
			attackTimer=0;
			if(mari==false) {
				if(this.y<Game.korriel.y) {this.vSpeed+=0.05*r;}else if(this.y>Game.korriel.y) {this.vSpeed-=0.05*r;}
				if((y>=Game.korriel.y-16*r)&&(y<=Game.korriel.y+16*r)) {vSpeed=shift(vSpeed);}
			}else {
				if(this.y<Game.mariutza.y) {this.vSpeed+=0.05*r;}else if(this.y>Game.mariutza.y) {this.vSpeed-=0.05*r;}
				if((y>=Game.mariutza.y-16*r)&&(y<=Game.mariutza.y+16*r)) {vSpeed=shift(vSpeed);}
			}
			if(hp<=16) {state=2;attackTimer=500;anger=true;}
			if(vSpeed>r) {vSpeed=r;}
			if(vSpeed<-r) {vSpeed=-r;}
			if(this.ignored()==false) {state=1;}
		} 
		x+=hSpeed;
		y+=vSpeed;
	}
	public BufferedImage wave() {
		if(anger==true) {
			if(this.hSpeed>0) {return e2;}
			else {return e1;}
		}else {
			if(state==2) {
				if(this.hSpeed>0) {return e2;}
				else {return e1;}
			}else if(hurt>0){
				if(this.hSpeed>0) {return e2;}
				else {return e1;}
			}else if(state==4){
				if(this.hSpeed>0) {return e2;}
				else {return e2;}
			}else {
				if(this.hSpeed>0) {return e2;}
				else {return e1;}
			}
		}
	}
	public void defeat() {
		Game.score+=2000;
		Game.enemies.remove(this);
		Game.effects.add(new Puff(x,y));
		Game.effects.add(new Puff(x-16*r,y-16*r));
		Game.effects.add(new Puff(x-32*r,y-32*r));
		Game.effects.add(new Puff(x+16*r,y+16*r));
		Game.effects.add(new Puff(x+32*r,y+32*r));
		Game.effects.add(new Puff(x+16*r,y-16*r));
		Game.effects.add(new Puff(x+32*r,y-32*r));
		Game.effects.add(new Puff(x-16*r,y+16*r));
		Game.effects.add(new Puff(x-32*r,y+32*r));
		Main.sounds.play(Sound.poomSound);
	}
	public void damage() {
		if(hurt<=-40) {hurt=60;}
		Main.sounds.play(Sound.testSound2);
	}
	public static double shift(double i) {
		if(i!=0) {
			if((i>=-0.05*r)&&(i<=0.05*r)) {i=0;}else {
				if(i>0) {i-=0.05*r;}
				if(i<0) {i+=0.05*r;}}
	}
		return i;}
	public boolean ignored() {
		if(mari==false) {
			if(Game.korriel.x>210*r) {
				return true;
			}
		}else {
			if(Game.mariutza.x>210*r) {
				return true;
			}
		}
		return false;
	}
	
}
