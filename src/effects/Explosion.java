package effects;

import java.awt.image.BufferedImage;

import display.Effect;
import display.Image;
import game.Game;

public class Explosion extends Effect {
	private final static BufferedImage exps1 = Image.readImage("res/Effects/sparkle-2.png");
	private final static BufferedImage exps2 = Image.readImage("res/Effects/sparkle-3.png");
	private final static BufferedImage exps3 = Image.readImage("res/Effects/sparkle-4.png");
	private final static BufferedImage exps4 = Image.readImage("res/Effects/sparkle-5.png");
	private final static BufferedImage exps5 = Image.readImage("res/Effects/sparkle-6.png");
	private final static BufferedImage exps6 = Image.readImage("res/Effects/sparkle-7.png");

	public Explosion(double x, double y) {
		super(x, y, 16*r, 16*r, 0, 0, false);
	}
	public BufferedImage wave() {
		if(frames<=4) {
			return exps1;
		}else if(frames<8) {
			return exps2;
		}else if(frames<12) {
			return exps3;
		}else if(frames<16) {
			return exps4;
		}else if(frames<20) {
			return exps5;
		}else if(frames<24) {
			return exps6;
		}else {frames=0;
		Game.effects.remove(this);
		return exps6;}
	}
}
