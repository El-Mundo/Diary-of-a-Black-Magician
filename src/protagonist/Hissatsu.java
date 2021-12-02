package protagonist;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

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

public class Hissatsu {
	private static int r = Main.rate;
	public double x;
	public double y;
	public int w;
	public int h;
	public int frames;
	final private static BufferedImage rb1 = Image.readImage("res/RainbowBeam-1.png");
	final private static BufferedImage rb2 = Image.readImage("res/RainbowBeam-2.png");
	final private static BufferedImage rb3 = Image.readImage("res/RainbowBeam-3.png");
	final private static BufferedImage rb4 = Image.readImage("res/RainbowBeam-4.png");
	final private static BufferedImage rb5 = Image.readImage("res/RainbowBeam-5.png");
	final private static BufferedImage rb6 = Image.readImage("res/RainbowBeam-6.png");
	final private static BufferedImage rb7 = Image.readImage("res/RainbowBeam-7.png");
	public Hissatsu() {
		y = Game.korriel.y+2*r;
		x = Game.korriel.x+32*r;
		w = 1*r;
		h = 32*r;
	}
	public void move() {
		y = Game.korriel.y;
		x = Game.korriel.x+32*r;
		w+=4*r;
		frames++;
		if((w>1100*r)||(Game.korriel.hp<=0)) {Game.hissatsu=null;}
	}
	public BufferedImage wave() {
		int i = (int) (Math.random()*32-4);
		int n = (int) (Math.random()*32-4);
		int i3 = (int) (Math.random()*w+16);
		Game.effects.add(new Puffie(this.x-3*r,this.y+i*r));
		Game.effects.add(new Puffie(this.x-3*r,this.y+n*r));
			Game.effects.add(new Puff(this.x+i3*r-16*r,this.y+i*r));
			Game.effects.add(new Puff(this.x+i3*r-8*r,this.y+i*r));
			Game.effects.add(new Puff(this.x+i3*r,this.y+n*r));
		if(frames==0) {Main.sounds.play(Sound.ringringSound);}
		if(frames==4) {Main.sounds.play(Sound.ringringSound2);}
		if(frames==6) {Main.sounds.play(Sound.ringringSound3);}
		if(frames<=2) {return rb1;}
		else if(frames < 4){return rb2;}
		else if(frames < 6){return rb3;}
		else if(frames < 8){return rb4;}
		else if(frames < 10){return rb5;}
		else if(frames < 12){return rb6;}
		else if(frames < 14){return rb7;}
		else {frames=0;return rb7;}
	}
	public Rectangle toRect() {
		Rectangle rect = new Rectangle((int)x,(int)y,w,h);
		return rect;
	}
	public void defeat(Enemy e) {
		if(e.toRect().intersects(this.toRect())) {if(e.immune<=0) {e.hp-=5;e.immune=20;e.damage();Game.score+=25;Main.sounds.play(Sound.fooSound);}}
		if(e.hp<=0) {Game.effects.add(new Explosion2(e.x,e.y));e.defeat();}
	}

}
