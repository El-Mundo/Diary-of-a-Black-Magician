package game;

import display.GameFrame;
import display.MariutzaSprite;
import display.Sprite2P;

public class MariutzaThread extends Thread {
	public static int Wt = 0;
	public static int St = 0;
	public static int At = 0;
	public static int Dt = 0;
	public void run() {
		while(true){try {
			Thread.sleep(17);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(Game.pause==false) {
			Game.level.levelStart();
			if(Game.start==false){Game.mariutza.y=100*Main.rate;}
			Game.level.obstacle();
			Game.level.spawnEnemy();
			Game.level.screenControl();
			if(GameFrame.A==true) {At++;}else {At = 0;}
			if(GameFrame.W==true) {Wt++;}else {Wt = 0;}
			if(GameFrame.S==true) {St++;}else {St = 0;}
			if(GameFrame.D==true) {Dt++;}else {Dt = 0;}
			if(GameFrame.K==true) {Game.mariutza.hissatsu();}
			for(int i = 0;i<Game.p2bullets.size();i++) {
				for(int n = 0;n<Game.enemies.size();n++) {Game.p2bullets.get(i).defeat(Game.enemies.get(n));}
				for(int g = 0;g<Game.blocks.size();g++) {Game.blocks.get(g).stopBullet2(Game.p2bullets.get(i));}
				Game.p2bullets.get(i).move();}
			if(Game.bomb!=null) {
				for(int n = 0;n<Game.enemies.size();n++) {Game.bomb.defeat(Game.enemies.get(n));}
				for(int g = 0;g<Game.blocks.size();g++) {Game.blocks.get(g).stopBomb(Game.bomb);}
				Game.bomb.move();}
			MariutzaSprite.mariutza.move();
			for(int n = 0;n<Game.enemies.size();n++) {
				Game.enemies.get(n).hurt2P(Game.mariutza);
				Game.enemies.get(n).move();}
			MariutzaSprite.mariutza.initializeCollision();
			for(int i = 0;i<Game.blocks.size();i++) {
				Game.blocks.get(i).move();
				Game.blocks.get(i).stop2P(Game.mariutza);
			}
			for(int n = 0;n<Game.effects.size();n++) {
				Game.effects.get(n).move();}
			Game.screenX+=Game.screenHSpeed;
			Game.screenY+=Game.screenVSpeed;
			Game.gameTime++;
	}}}

}
