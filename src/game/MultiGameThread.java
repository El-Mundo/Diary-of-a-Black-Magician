package game;

import display.GameFrame;
import display.Sprite2P;
import protagonist.*;

public class MultiGameThread extends Thread{
	public static int Wt = 0;
	public static int St = 0;
	public static int At = 0;
	public static int Dt = 0;
	public static int upT = 0;
	public static int downT = 0;
	public static int leftT = 0;
	public static int rightT = 0;
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
				Game.pbullets.get(i).move();}
			Sprite2P.korriel.multiMove(Game.mariutza);
			if(Game.hissatsu!=null) {for(int n = 0;n<Game.enemies.size();n++) {Game.hissatsu.defeat(Game.enemies.get(n));}Game.hissatsu.move();}
			if(GameFrame.up==true) {upT++;}else {upT = 0;}
			if(GameFrame.down==true) {downT++;}else {downT = 0;}
			if(GameFrame.left==true) {leftT++;}else {leftT = 0;}
			if(GameFrame.right==true) {rightT++;}else {rightT = 0;}
			if(GameFrame.three==true) {Game.mariutza.hissatsu();}
				for(int i = 0;i<Game.p2bullets.size();i++) {
					for(int n = 0;n<Game.enemies.size();n++) {Game.p2bullets.get(i).defeat(Game.enemies.get(n));}
					for(int g = 0;g<Game.blocks.size();g++) {Game.blocks.get(g).stopBullet2(Game.p2bullets.get(i));}
					Game.p2bullets.get(i).move();}
			if(Game.bomb!=null) {for(int n = 0;n<Game.enemies.size();n++) {Game.bomb.defeat(Game.enemies.get(n));}
			for(int g = 0;g<Game.blocks.size();g++) {Game.blocks.get(g).stopBomb(Game.bomb);}
			Game.bomb.move();}
			Sprite2P.mariutza.multiMove(Game.korriel);
			for(int n = 0;n<Game.enemies.size();n++) {
				Game.enemies.get(n).hurtMP(Game.korriel, Game.mariutza);
				Game.enemies.get(n).move();}
			Sprite2P.korriel.initializeCollision();
			Sprite2P.mariutza.initializeCollision();
			for(int i = 0;i<Game.blocks.size();i++) {
				Game.blocks.get(i).move();
				Game.blocks.get(i).stopMP(Game.korriel, Game.mariutza);
			}
			for(int n = 0;n<Game.effects.size();n++) {
				Game.effects.get(n).move();}
			Game.screenX+=Game.screenHSpeed;
			Game.screenY+=Game.screenVSpeed;
			Game.gameTime++;
	}}}

}
