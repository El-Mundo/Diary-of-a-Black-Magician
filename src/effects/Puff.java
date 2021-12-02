package effects;

import java.awt.image.BufferedImage;

import display.Effect;
import display.Image;
import game.Game;

public class Puff extends Effect {
	private final static BufferedImage smog1 = Image.readImage("res/Effects/puff-1.png");
	private final static BufferedImage smog2 = Image.readImage("res/Effects/puff-2.png");
	private final static BufferedImage smog3 = Image.readImage("res/Effects/puff-3.png");

	public Puff(double x, double y) {
		super(x, y, 16*r, 16*r, 0, 0, true);
	}
	public BufferedImage wave() {
		if(frames<=4) {
			return smog1;
		}else if(frames<8) {
			return smog2;
		}else if(frames<12) {
			return smog3;
		}else {frames=0;
		Game.effects.remove(this);
		return smog3;}
	}
}
