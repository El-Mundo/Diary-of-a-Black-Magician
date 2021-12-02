package game;

import java.util.ArrayList;

import display.Effect;
import effects.HighestScore;
import enemy.*;
import levels.*;
import misc.Block;
import misc.Save;
import protagonist.*;

public class Game {
	public static Korriel korriel = new Korriel();
	public static ArrayList<PBullet> pbullets;
	public static Mariutza mariutza = new Mariutza();
	public static ArrayList<P2Bullet> p2bullets;
	public static P2Bomb bomb;
	public static Hissatsu hissatsu;
	public static boolean twoPlayer = false;
	public static boolean mari = false;
	public static ArrayList<Enemy> enemies;
	public static ArrayList<Effect> effects;
	public static boolean pause = false;
	public static double screenX = 0;
	public static double screenY = 0;
	public static double screenHSpeed = 0;
	public static double screenVSpeed = 0;
	public static ArrayList<Block> blocks;
	public static int score = 0;
	public static int levelNumber = 0;
	public static Level level;
	public static boolean start = false;
	public static boolean end = false;
	public static boolean over = false;
	public static int gameTime;
	
	public Game() {
		pbullets = new ArrayList<PBullet>();
		p2bullets = new ArrayList<P2Bullet>();
		enemies = new ArrayList<Enemy>();
		effects = new ArrayList<Effect>();
		screenX = 0;
		screenY = 0;
		blocks = new ArrayList<Block>();
		gameTime = 0;
		if(levelNumber==1) {level = new LevelOne();}
		else if(levelNumber==2) {level = new LevelTwo();}
		else if(levelNumber==3) {level = new LevelThree();}
		else if(levelNumber==4) {level = new LevelFour();}
		else if(levelNumber==5) {level = new LevelFive();}
		else {level = new InfiniteLevel();}
	}
	public static void highestScore() {
		if(Game.levelNumber!=0) {
			if(score>Main.save[4]) {Main.save[4]=score;Save.writeSav(Main.save);}
		}else {
			if(twoPlayer==false) {
				if(score>Main.save[2]) {Main.save[2]=score;Save.writeSav(Main.save);}
			}else {
				if(score>Main.save[3]) {Main.save[3]=score;Save.writeSav(Main.save);}
			}
		}
		score=0;
	}
}

