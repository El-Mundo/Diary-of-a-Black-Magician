package effects;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import display.Image;
import game.Game;
import game.Main;

public abstract class Foreground {
	
	public static class bigFlower extends Foreground {
		private final static BufferedImage flower1 = Image.readImage("res/Background/Layer3/Foreground-Flower1.png");

		public bigFlower(double x, double y, double r) {
			super(x, y, 128*Main.rate, 144*Main.rate, r);
		}
		public BufferedImage wave() {
			return flower1;
		}
	}
	public static class smallFlower extends Foreground {
		private final static BufferedImage flower1 = Image.readImage("res/Background/Layer3/Foreground-Flower2.png");

		public smallFlower(double x, double y, double r) {
			super(x, y, 128*Main.rate, 48*Main.rate, r);
		}
		public BufferedImage wave() {
			return flower1;
		}
	}
	public static class smallForeCloud extends Foreground {
		private final static BufferedImage cloud1 = Image.readImage("res/Background/Layer3/Foreground-Cloud2.png");

		public smallForeCloud(double x, double y, double r) {
			super(x, y, 32*Main.rate, 16*Main.rate, r);
		}
		public BufferedImage wave() {
			return cloud1;
		}
	}
	public static class bigForeCloud extends Foreground {
		private final static BufferedImage cloud1 = Image.readImage("res/Background/Layer3/Foreground-Cloud1.png");

		public bigForeCloud(double x, double y, double r) {
			super(x, y, 192*Main.rate, 56*Main.rate, r);
		}
		public BufferedImage wave() {
			return cloud1;
		}
	}
	public static class smallYellowFlower extends Foreground {
		private final static BufferedImage flower1 = Image.readImage("res/Background/Layer2/yellowFlower.png");

		public smallYellowFlower(double x, double y, double r) {
			super(x, y, 31*Main.rate, 26*Main.rate, r);
		}
		public BufferedImage wave() {
			return flower1;
		}
	}
	
	public double x;
	public double y;
	public int w;
	public int h;
	private int dis;
	private int dis2;
	private double r;
	private int fr;
	
	public Foreground(double x, double y, int w, int h, double r) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.r = r;
		this.fr = 0;
		this.dis = -w;
		this.dis2 = 224*Main.rate;
	}
	public void move(ArrayList<Foreground> l) {
		this.x-=Game.screenHSpeed*r;
		this.y-=Game.screenVSpeed*r;
		if((this.x<dis)||(this.y>dis2)){
			l.remove(this);
		}
	}
	public BufferedImage wave() {
		fr++;
		return null;
	}
}


