package effects;

import java.awt.image.BufferedImage;

import display.Effect;
import display.Image;
import game.Game;

public class BlackScreen extends Effect {
	private final static BufferedImage b1 = Image.readImage("res/Effects/Black-1.png");
	private final static BufferedImage b2 = Image.readImage("res/Effects/Black-2.png");
	private final static BufferedImage b3 = Image.readImage("res/Effects/Black-3.png");
	private final static BufferedImage b4 = Image.readImage("res/Effects/Black-4.png");
	private final static BufferedImage b5 = Image.readImage("res/Effects/Black-5.png");
	private final static BufferedImage b6 = Image.readImage("res/Effects/Black-6.png");
	private boolean enter;
	private int f1;
	private int f2;
	private int f3;
	private int f4;
	private int f5;
	private int f6;
	
	public BlackScreen(boolean enter, int i) {
		super(0, 0, 256*r, 224*r, 0, 0, false);
		this.enter = enter;
		f1=i/6;
		f2=i/3;
		f3=i/2;
		f4=i*2/3;
		f5=i*5/6;
		f6=i;
	}
	public BufferedImage titleWave() {
		frames++;
		if(enter==true) {
			if(frames<=5) {
				return b1;
			}else if(frames<10) {
				return b2;
			}else if(frames<15) {
				return b3;
			}else if(frames<20) {
				return b4;
			}else if(frames<25) {
				return b5;
			}else if(frames<30) {
				return b6;
			}else {
				return b6;}
		}else {
			if(frames<=5) {
				return b6;
			}else if(frames<10) {
				return b5;
			}else if(frames<15) {
				return b4;
			}else if(frames<20) {
				return b3;
			}else if(frames<25) {
				return b2;
			}else if(frames<30) {
				return b1;
			}else {
				return b1;}
		}
	}
	public BufferedImage wave() {
		frames++;
		if(enter==true) {
			if(frames<=f1) {
				return b1;
			}else if(frames<f2) {
				return b2;
			}else if(frames<f3) {
				return b3;
			}else if(frames<f4) {
				return b4;
			}else if(frames<f5) {
				return b5;
			}else if(frames<f6) {
				return b6;
			}else {
				frames = 0;
				Game.effects.remove(this);
				return b6;}
		}else {
			if(frames<=f1) {
				return b6;
			}else if(frames<f2) {
				return b5;
			}else if(frames<f3) {
				return b4;
			}else if(frames<f4) {
				return b3;
			}else if(frames<f5) {
				return b2;
			}else if(frames<f6) {
				return b1;
			}else {
				frames = 0;
				Game.effects.remove(this);
				return b1;}
		}
	}
	public void restart() {
		this.frames=0;
	}
}
