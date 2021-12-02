package effects;

import java.awt.image.BufferedImage;

import display.Effect;
import display.Image;
import game.Game;

public class RainbowRoot extends Effect {
	private final static BufferedImage rr1 = Image.readImage("res/Effects/RainbowRoot-1.png");
	private final static BufferedImage rr2 = Image.readImage("res/Effects/RainbowRoot-2.png");
	private int time;

	public RainbowRoot() {
		super(Game.korriel.x+29*r, Game.korriel.y, 8*r, 32*r, 0, 0, true);
		this.time = 0;
	}
	
	public void move() {
		this.x = Game.korriel.x+29*r;
		this.y = Game.korriel.y;
		frames++;
		if(Game.korriel.hp<=0) {Game.effects.remove(this);}
	}
	public BufferedImage wave() {
		if(frames<=6) {
			return rr1;
		}else if(frames<12) {
			return rr2;
		}else {frames=0;
		time++;
		if(time==23) {Game.effects.remove(this);}
		return rr2;}
	}
}
