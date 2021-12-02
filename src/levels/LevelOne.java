package levels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import display.Image;
import effects.Foreground;
import enemy.*;
import enemy.¾¿¼«ÎÞµÐÔÓÃ«¹Ö;
import game.Game;
import game.Main;
import misc.Block;
import misc.Item;

public class LevelOne extends Level {
	private static int r = Main.rate;
	private final static BufferedImage b1 = Image.readImage("res/Background/Starfox-2.png");
	private final static BufferedImage b2 = Image.readImage("res/Background/Starfox-3.png");
	private final static BufferedImage t1 = Image.readImage("res/Tiles/yiGardenGround.png");
	private final static BufferedImage l2 = Image.readImage("res/Background/Layer2/Clouds-Bottom.png");
	private double x;
	private double bgx;
	private double bg2x;
	private double l2x;
	private boolean fear;
	private static Color skyBlue = new Color(48,48,104);
	private static Color skyBlue2 = new Color(80,160,184);
	private ¾¿¼«ÎÞµÐÔÓÃ«¹Ö ÔÓÃ«;
	private ArrayList<Foreground> fr;
	private ArrayList<Foreground> bk;
	
	public LevelOne() {
		super();
		x=-1;
		l2x=-1;
		bgx=-1;
		fear=false;
		fr = new ArrayList<Foreground>();
		bk = new ArrayList<Foreground>();
	}
	public void obstacle() {
		if(this.fear==false) {
			Game.blocks.add(new Block(0,190,5000,48));
			fear=true;Game.screenHSpeed=1.2*r;}
		
		if(Game.pause==false) {
			x-=Game.screenHSpeed/3;
			if(x<=-256*r) {x=0;}
			bgx-=Game.screenHSpeed/2;
			if(bgx<=-512*r) {bgx=0;}
			bg2x-=Game.screenHSpeed;
			if(bg2x<=-256*r) {bg2x=0;}
			l2x-=Game.screenHSpeed*1.5;
			if(l2x<=-1024*r) {l2x=0;}
		}
		for(int i=0;i<fr.size();i++) {fr.get(i).move(fr);}
		for(int i=0;i<bk.size();i++) {bk.get(i).move(fr);}
		if(Game.gameTime==70) {fr.add(new Foreground.bigFlower(256*r, 80*r, 1.5));}
		if(Game.gameTime==130) {fr.add(new Foreground.smallFlower(256*r, 176*r, 2));}
		if(Game.gameTime==160) {bk.add(new Foreground.smallYellowFlower(256*r, 164*r, 1));}
		if(Game.gameTime==220) {bk.add(new Foreground.smallYellowFlower(256*r, 164*r, 1));}
		if(Game.gameTime==700) {bk.add(new Foreground.smallYellowFlower(256*r, 164*r, 1));}
		if(Game.gameTime==800) {bk.add(new Foreground.smallYellowFlower(256*r, 164*r, 1));}
		if(Game.gameTime==1000) {fr.add(new Foreground.bigFlower(256*r, 80*r, 1.5));}
		if(Game.gameTime==1100) {bk.add(new Foreground.smallYellowFlower(256*r, 164*r, 1));}
		if(Game.gameTime==1400) {fr.add(new Foreground.smallForeCloud(256*r, 40*r, 1.5));}
		if(Game.gameTime==1470) {fr.add(new Foreground.bigForeCloud(256*r, 20*r, 1.5));fr.add(new Foreground.bigForeCloud(170*r, -80*r, 1.5));}
		if(Game.gameTime==2220) {fr.add(new Foreground.smallForeCloud(256*r, 40*r, 1.5));fr.add(new Foreground.smallForeCloud(280*r, 170*r, 1.5));}
	}
	public void screenControl() {
		if(inactivated==true) {if(Game.screenHSpeed>0) {Game.screenHSpeed-=Game.screenHSpeed/100;}else {Game.screenHSpeed=0;}}
		if((Game.gameTime>=1350)&&(Game.gameTime<=1450)) {Game.screenVSpeed-=0.01*r;}
		if((Game.gameTime>=1710)&&(Game.gameTime<=1760)) {Game.screenVSpeed+=0.02*r;if(Game.screenVSpeed>0) {Game.screenVSpeed=0;}}
		if(Game.gameTime==1720) {l2x=0;}
	}
	public void spawnEnemy() {
		if(Game.gameTime==340) {Game.enemies.add(new WickieBird(80,1,10));}
		if(Game.gameTime==390) {Game.enemies.add(new WickieBird(80,1,10));}
		if(Game.gameTime==440) {Game.enemies.add(new WickieBird(80,1,10));}
		if(Game.gameTime==740) {Game.enemies.add(new Piewee(236,-16));}
		if(Game.gameTime==880) {Game.enemies.add(new Piewee(220,-16));}
		if(Game.gameTime==1130) {Game.enemies.add(new Tosser(158));}
		if(Game.gameTime==1790) {Game.enemies.add(new WickieBird(100,1,10));}
		if(Game.gameTime==1940) {Game.enemies.add(new WickieBird(30,1.4,5));Game.enemies.add(new WickieBird(100,1.4,5));}
		if(Game.gameTime==1990) {Game.enemies.add(new WickieBird(30,1.4,5));Game.enemies.add(new WickieBird(100,1.4,5));}
		if(Game.gameTime==2040) {Game.enemies.add(new WickieBird(30,1.4,5));Game.enemies.add(new WickieBird(100,1.4,5));}
		if(Game.gameTime==2250) {Game.effects.add(new Item.Tomato(296*r, 100*r));}
		if(Game.gameTime==2530) {ÔÓÃ«=new ¾¿¼«ÎÞµÐÔÓÃ«¹Ö(280,100);Game.enemies.add(ÔÓÃ«);Main.sounds.stopBGM();Main.sounds.changeBGM(0);}
		if(ÔÓÃ«!=null) {if(ÔÓÃ«.hp<=0) {Game.end=true;}}
	}
	public void background(Graphics g) {
		if(Game.gameTime<1585) {g.setColor(skyBlue2);}
		else {g.setColor(skyBlue);}
			g.fillRect(0, 0, 256*r, 224*r);
		if(Game.gameTime<1900) {
			g.drawImage(b1, (int)bg2x, 115*r-(int)Game.screenY, 512*r, 100*r, null);
			g.drawImage(b2, (int)x, -220*r-(int)Game.screenY, 512*r, 318*r, null);
		}
	}
	public void layerTwo(Graphics g) {
		if(Game.gameTime>1400) {
			g.drawImage(l2, (int)bgx, -300*r-(int)Game.screenY, 512*r, 224*r, null);
			g.drawImage(l2, (int)bgx+512*r, -300*r-(int)Game.screenY, 512*r, 224*r, null);
		}
		for(int i=0;i<bk.size();i++) {
			Foreground fore = bk.get(i);
			g.drawImage(fore.wave(), (int)fore.x, (int)fore.y, fore.w, fore.h, null);
		}
	}
	public void layerThree(Graphics g) {
		if(Game.gameTime>1720) {g.drawImage(l2, (int)l2x+512*r, 80*r, 512*r, 244*r, null);}
		for(int i=0;i<20;i++) {
		g.drawImage(t1, -(int) Game.screenX+256*i*r, 180*r-(int)Game.screenY, 256*r, 46*r, null);}
		for(int i=0;i<fr.size();i++) {
			Foreground fore = fr.get(i);
			g.drawImage(fore.wave(), (int)fore.x, (int)fore.y, fore.w, fore.h, null);
		}
	}
	public void bgmStart() {
		Main.sounds.changeBGM(6);
		Main.sounds.loopBGM();
	}

}
