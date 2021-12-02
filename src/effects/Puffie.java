package effects;

import java.awt.image.BufferedImage;

import display.Effect;
import display.Image;
import game.Game;

public class Puffie extends Effect {
	private final static BufferedImage smallSmog1 = Image.readImage("res/Effects/puffie-1.png");
	private final static BufferedImage smallSmog2 = Image.readImage("res/Effects/puffie-2.png");
	private final static BufferedImage smallSmog3 = Image.readImage("res/Effects/puffie-3.png");

	public Puffie(double x, double y) {
		super(x, y, 8*r, 8*r, 0, 0, true);
	}
	public BufferedImage wave() {
		if(frames<=4) {
			return smallSmog1;
		}else if(frames<8) {
			return smallSmog2;
		}else if(frames<12) {
			return smallSmog3;
		}else {frames=0;
		Game.effects.remove(this);
		return smallSmog3;}
	}
}
