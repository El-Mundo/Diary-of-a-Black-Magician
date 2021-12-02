package levels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import display.Effect;
import display.GameFrame;
import display.Image;
import effects.BlackScreen;
import enemy.Enemy;
import enemy.InfiniteFire;
import game.Game;
import game.Main;
import game.Sound;
import misc.Block;
import misc.Save;

public class InfiniteLevel extends Level {
	private static int r = Main.rate;
	private final static BufferedImage b1 = Image.skyBlue;
	private final static BufferedImage l21 = Image.clouds;
	private static double x;
	private int spawnSpan;
	public static boolean kover;
	public static boolean mover;
	
	public InfiniteLevel() {
		super();
		spawnSpan = 350;
		kover = false;
		mover = false;
	}
	public void obstacle() {
		
	}
	public void screenControl() {
		if((Game.start==true)&&(inactivated==false)) {
			if(Game.screenX<=10*r) {Game.screenHSpeed=0.6*r;}else {if(Game.screenHSpeed<5*r) {Game.screenHSpeed+=0.0003*r;}}}
		if(inactivated==true) {if(Game.screenHSpeed>0) {Game.screenHSpeed-=Game.screenHSpeed/100;}else {Game.screenHSpeed=0;}}
	}
	public void levelStart() {
		if(Game.korriel.hp<=0) {kover=true;}
		if(Game.mariutza.hp<=0) {mover=true;}
		if(kover==true) {Game.korriel.lose();}
		if(mover==true) {Game.mariutza.lose();}
		if((kover==true)&&(mover==true)) {Game.over=true;}
		if(Game.start==false){
			if(this.activated == false) {Game.effects.add(new BlackScreen(true,30));this.bgmStart();}
			this.activated = true;
			Game.korriel.controllable=false;
			Game.korriel.changeHSpeed(1*r);
			Game.mariutza.controllable=false;
			Game.mariutza.changeHSpeed(1*r);
			if((Game.korriel.x>=8*r)||(Game.mariutza.x>=8*r)) {Game.korriel.controllable=true;Game.mariutza.controllable=true;
			Game.start=true;}}
		if(Game.over==true) {
			Game.korriel.lose();
			Game.mariutza.lose();
			fr++;
			if(this.inactivated==false) {Main.sounds.stopBGM();Main.sounds.changeBGM(0);this.inactivated=true;}
			if(fr==240) {Game.effects.add(new BlackScreen(false,120));}
			if(fr==290) {GameFrame.scoreMenu();fr=0;}
		}
	}
	public void spawnEnemy() {
		if(this.inactivated==false) {
			if(Game.gameTime%spawnSpan==0) {
				if(Game.gameTime>240) {
					int i = (int)(Math.random()*198+4);
					int n = (int)(Math.random()*198+4);
					Game.enemies.add(new InfiniteFire(i));
					if((n<i-32)||(n>i+32)) {Game.enemies.add(new InfiniteFire(n));}
					}
			}
		}
		if(Game.gameTime%1200==0) {if(spawnSpan>50) {spawnSpan-=50;}}
	}
	public void background(Graphics g) {
		g.drawImage(b1, 0, 0, 256*r, 144*r, null);
	}
	public void layerTwo(Graphics g) {
		g.drawImage(l21, (int) x, 0, 512*r, 224*r, null);
		g.drawImage(l21, (int) x+512*r, 0, 512*r, 224*r, null);
		if(Game.pause==false) {
			x-=Game.screenHSpeed;
			if((int)x<=-512*r) {x=0;}}
	}
	public void layerThree(Graphics g) {
		
	}
	public void bgmStart() {
		Main.sounds.changeBGM(3);
		Main.sounds.loopBGM();
	}

}
