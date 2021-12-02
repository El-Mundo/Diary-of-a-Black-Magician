package game;

import display.GameFrame;
import display.Sprite;
import display.Sprite2P;
import levels.InfiniteLevel;
import protagonist.Hissatsu;

public class GameThread extends Thread{
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
			Game.level.obstacle();
			Game.level.spawnEnemy();
			Game.level.screenControl();
			if(GameFrame.A==true) {At++;}else {At = 0;}
			if(GameFrame.W==true) {Wt++;}else {Wt = 0;}
			if(GameFrame.S==true) {St++;}else {St = 0;}
			if(GameFrame.D==true) {Dt++;}else {Dt = 0;}
			if(GameFrame.K==true) {Game.korriel.hissatsu();}
			for(int i = 0;i<Game.pbullets.size();i++) {
				for(int n = 0;n<Game.enemies.size();n++) {
					Game.pbullets.get(i).defeat(Game.enemies.get(n));}
				for(int g = 0;g<Game.blocks.size();g++) {Game.blocks.get(g).stopBullet(Game.pbullets.get(i));}
				Game.pbullets.get(i).move();
				}
			Sprite.korriel.move();
			if(Game.hissatsu!=null) {for(int n = 0;n<Game.enemies.size();n++) {Game.hissatsu.defeat(Game.enemies.get(n));}Game.hissatsu.move();}
			for(int n = 0;n<Game.enemies.size();n++) {
				Game.enemies.get(n).hurt1P(Game.korriel);
				Game.enemies.get(n).move();}
			Sprite.korriel.initializeCollision();
			for(int i = 0;i<Game.blocks.size();i++) {
				Game.blocks.get(i).move();
				Game.blocks.get(i).stop1P(Game.korriel);
			}
			for(int n = 0;n<Game.effects.size();n++) {
				Game.effects.get(n).move();}
			Game.screenX+=Game.screenHSpeed;
			Game.screenY+=Game.screenVSpeed;
			Game.gameTime++;
		}}}
}

