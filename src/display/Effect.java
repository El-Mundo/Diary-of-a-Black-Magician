package display;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.Game;
import game.Main;

public abstract class Effect {
	public double x;
	public double y;
	public int w;
	public int h;
	public double hSpeed;
	public double vSpeed;
	public int frames;
	public boolean moveWithScreen;
	private final static BufferedImage num1 = Image.readImage("res/Effects/1.png");
	private final static BufferedImage num2 = Image.readImage("res/Effects/2.png");
	private final static BufferedImage num3 = Image.readImage("res/Effects/3.png");
	private final static BufferedImage num4 = Image.readImage("res/Effects/4.png");
	private final static BufferedImage num5 = Image.readImage("res/Effects/5.png");
	private final static BufferedImage num6 = Image.readImage("res/Effects/6.png");
	private final static BufferedImage num7 = Image.readImage("res/Effects/7.png");
	private final static BufferedImage num8 = Image.readImage("res/Effects/8.png");
	private final static BufferedImage num9 = Image.readImage("res/Effects/9.png");
	private final static BufferedImage num0 = Image.readImage("res/Effects/0.png");
	private final static BufferedImage xx = Image.readImage("res/Effects/x.png");
	public final static BufferedImage heart1 = Image.readImage("res/Effects/Heart-1.png");
	public final static BufferedImage heart2 = Image.readImage("res/Effects/Heart-2.png");
	public final static BufferedImage mgcBall = Image.readImage("res/Effects/blueBall.png");
	public final static BufferedImage PAUSE = Image.readImage("res/Effects/PAUSE.png");
	public final static BufferedImage SCORE = Image.readImage("res/Effects/SCORE.png");
	public static int r = Main.rate;
	public static BufferedImage[] nums = {num0,num1,num2,num3,num4,num5,num6,num7,num8,num9};
	
	public Effect(double x, double y, int w, int h, double hSpeed, double vSpeed, boolean screen) {
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.frames=0;
		this.moveWithScreen=screen;
		if(screen==true) {this.hSpeed=hSpeed-Game.screenHSpeed;this.vSpeed=vSpeed-Game.screenVSpeed;}
		else {this.hSpeed=hSpeed;this.vSpeed=vSpeed;}
	}
	public void move() {
		this.x+=this.hSpeed;
		this.y+=this.vSpeed;
		frames++;
	}
	public BufferedImage wave() {
		return mgcBall;
	}
	
	public static void paintHissatsu(int i, Graphics g, int x, int y) {
		if(i>99) {i=99;}
		if(i<0) {i=0;}
		g.drawImage(xx, x, y+r, 7*r, 7*r, null);
		g.drawImage(nums[i/10], x+7*r, y, 8*r, 8*r, null);
		g.drawImage(nums[i%10], x+15*r, y, 8*r, 8*r, null);
	}
	public static void paintScore(int i, Graphics g, int x, int y) {
		if(i>999999) {i=999999;}
		if(i<0) {i=0;}
		g.drawImage(nums[(i%1000000)/100000], x, y, 8*r, 8*r, null);
		g.drawImage(nums[(i%100000)/10000], x+8*r, y, 8*r, 8*r, null);
		g.drawImage(nums[(i%10000)/1000], x+16*r, y, 8*r, 8*r, null);
		g.drawImage(nums[(i%1000)/100], x+24*r, y, 8*r, 8*r, null);
		g.drawImage(nums[(i%100)/10], x+32*r, y, 8*r, 8*r, null);
		g.drawImage(nums[i%10], x+40*r, y, 8*r, 8*r, null);

	}
	public static char[] toDoubleChar(int i) {
		char[] out = new char[2];
		if(i>99) {out[0] = '9'; out[1] = '9';return out;}
		else if((i<10)&&(i>=0)) {out[0] = '0'; out[1] = Integer.toString(i).charAt(0); return out;}
		else if(i>=10) {String s = Integer.toString(i);out[0]=s.charAt(0);out[1]=s.charAt(1);return out;}
		out[0] = '0'; out[1] = '0';
		return out;
	}

}
