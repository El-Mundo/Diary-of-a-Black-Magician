package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import display.Effect;
import display.GameFrame;
import enemy.Enemy;
import game.Game;
import game.Main;
import game.Sound;

public class LevelFive extends Level {
	private static int r = Main.rate;
	private final static BufferedImage b1 = null;
	
	public LevelFive() {
		super();
	}
	public void obstacle() {
		
	}
	public void screenControl() {
		
	}
	public void spawnEnemy() {
		
	}
	public void background(Graphics g) {
		
	}
	public void layerTwo(Graphics g) {
		
	}
	public void layerThree(Graphics g) {
		
	}
	public void bgmStart() {
		Main.sounds.changeBGM(2);
		Main.sounds.loopBGM();
	}

}
