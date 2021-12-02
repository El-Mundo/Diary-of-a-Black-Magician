package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import display.GameFrame;
import effects.BlackScreen;
import enemy.Enemy;
import game.Game;
import game.Main;
import game.Sound;

public abstract class Level {
	private static int r = Main.rate;
	private final static BufferedImage b1 = null;
	protected boolean activated;
	protected boolean inactivated;
	protected int fr;
	
	public Level() {this.activated=false;this.inactivated=false;Game.start=false;}
	public void obstacle() {
		
	}
	public void screenControl() {
		if((Game.start==true)&&(Game.screenX<=10)) {Game.screenHSpeed=0.6*r;}
	}
	public void spawnEnemy() {

	}
	public void levelStart() {
		if(Game.start==false){
			if(this.activated == false) {Game.effects.add(new BlackScreen(true,40));this.bgmStart();}
			this.activated = true;
			Game.korriel.controllable=false;
			Game.korriel.changeHSpeed(1*r);
			Game.mariutza.controllable=false;
			Game.mariutza.changeHSpeed(1*r);
			if((Game.korriel.x>=8*r)||(Game.mariutza.x>=8*r)) {Game.korriel.controllable=true;Game.mariutza.controllable=true;
			Game.start=true;}}
		if(Game.end==true) {
			Enemy.removeAllEnemies(Game.enemies);
			Game.korriel.changeVSpeed(0);
			Game.korriel.changeHSpeed(0);
			Game.mariutza.changeVSpeed(0);
			Game.mariutza.changeHSpeed(0);
			Game.korriel.controllable=false;
			Game.mariutza.controllable=false;
			fr++;
			if(this.inactivated==false) {Main.sounds.stopBGM();Main.sounds.changeBGM(0);this.inactivated=true;}
			if(fr==300) {Game.effects.add(new BlackScreen(false,120));}
			if(fr==350) {GameFrame.exitGame();fr=0;}
		}
		if(Game.over==true) {
			Game.korriel.lose();
			Game.mariutza.lose();
			fr++;
			if(this.inactivated==false) {Main.sounds.stopBGM();Main.sounds.changeBGM(0);this.inactivated=true;}
			if(fr==240) {Game.effects.add(new BlackScreen(false,120));}
			if(fr==290) {GameFrame.scoreMenu();fr=0;}
		}
	}
	public void background(Graphics g) {
		
	}
	public void layerTwo(Graphics g) {
		
	}
	public void layerThree(Graphics g) {
		
	}
	public void levelEnd() {
		Game.blocks.clear();
		Game.pbullets.clear();
		Game.p2bullets.clear();
		Game.bomb=null;
		Game.hissatsu=null;
		Game.enemies.clear();
		Game.screenX=0;
		Game.screenY=0;
		Game.screenHSpeed=0;
		Game.screenVSpeed=0;
		Game.end=false;
		Game.start=false;
		Game.over=false;
		Game.korriel.initialize();
		Game.mariutza.initialize();
	}
	public static void nextLevel() {
		if((Game.levelNumber>0)&&(Game.levelNumber<5)) {Game.levelNumber++;}
	}
	public void bgmStart() {
		Main.sounds.changeBGM(1);
		Main.sounds.loopBGM();
	}

}
