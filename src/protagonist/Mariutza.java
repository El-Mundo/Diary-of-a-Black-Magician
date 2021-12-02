package protagonist;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import display.GameFrame;
import display.Image;
import display.Sprite;
import game.*;
import protagonist.*;

public class Mariutza extends Player {
	public double x;
	public double y;
	private double hSpeed;
	private double vSpeed;
	private int frameTime;
	final private static BufferedImage n1 = Image.readImage("res/Mariutza-n1.png");
	final private static BufferedImage n2 = Image.readImage("res/Mariutza-n2.png");
	final private static BufferedImage n3 = Image.readImage("res/Mariutza-n3.png");
	final private static BufferedImage n4 = Image.readImage("res/Mariutza-n4.png");
	final private static BufferedImage f1 = Image.readImage("res/Mariutza-f1.png");
	final private static BufferedImage f2 = Image.readImage("res/Mariutza-f2.png");
	final private static BufferedImage f3 = Image.readImage("res/Mariutza-f3.png");
	final private static BufferedImage f4 = Image.readImage("res/Mariutza-f4.png");
	final private static BufferedImage b1 = Image.readImage("res/Mariutza-b1.png");
	final private static BufferedImage b2 = Image.readImage("res/Mariutza-b2.png");
	final private static BufferedImage b3 = Image.readImage("res/Mariutza-b3.png");
	final private static BufferedImage b4 = Image.readImage("res/Mariutza-b4.png");
	final private static BufferedImage h1 = Image.readImage("res/Mariutza-h1.png");
	final private static BufferedImage h2 = Image.readImage("res/Mariutza-h2.png");
	final private static BufferedImage i1 = Image.readImage("res/Effects/MState.png");
	final private static BufferedImage i2 = Image.readImage("res/Effects/MState2.png");
	private int up;
	private int left;
	private int down;
	private int right;
	private boolean zero;
	private static int r = Main.rate;
	public int w = 32*r;
	public int h = 32*r;
	private double acceleration= 0.12*r;
	private double hMaximum = 1.6*r;
	private double vMaximum = 2*r;
	private static int screenBoundX = 224*r;
	private static int screenBoundY = 192*r;
	private static double shiftSpeed = 0.06*r;
	private int freeze;
	public boolean controllable = true;
	private Rectangle range;
	private int rx = 13*r;
	private int ry = 0;
	private int rw = 14*r;
	private int rh = 29*r;
	private int invinsible;
	public static int stickTime;
	public int hp;
	public int maxHP = 3;
	public boolean stick;
	public boolean rightBlock;
	public boolean leftBlock;
	public boolean upBlock;
	public boolean downBlock;
	private int exitTime = 0;
	
	public Mariutza() {
		up = 0;
		down = 0;
		right = 0;
		left = 0;
		this.x = -32*r;
		this.y = 160*r;
		this.hSpeed = 0;
		this.vSpeed = 0;
		this.frameTime = 0;
		this.freeze = 0;
		this.hp = 3;
		this.maxHP=3;
		this.invinsible = 0;
		this.stickTime = 0;
	}
	public double getHSpeed() {
		return hSpeed;
	}
	public double getVSpeed() {
		return vSpeed;
	}
	public void changeHSpeed(double d) {
		hSpeed = d;
	}
	public void changeVSpeed(double d) {
		vSpeed = d;
	}
	public double getRH() {
		return rh;
	}
	public double getRW() {
		return rw;
	}
	public double getRX() {
		return rx;
	}
	public double getRY() {
		return ry;
	}
	public double getBottom() {
		return y+ry+rh;
	}
	public double getRight() {
		return x+rx+rw;
	}
	
	public BufferedImage wave() {
		frameTime++;
		if(invinsible>0) {
			if(frameTime<=8) {return h1;}
			else if(frameTime<16) {return null;}
			else if(frameTime<25) {return h2;}
			else if(frameTime<32) {return null;}
			else {frameTime = 0;
			return h2;
			}
		}else {
		if(vSpeed>=r) {
			if((freeze>0)) {
				if(frameTime<=8) {return f3;}
				else if(frameTime<16) {return f4;}
				else {frameTime = 0;
				return f4;
				}
			}else {
				if(frameTime<=8) {return f1;}
				else if(frameTime<16) {return f2;}
				else {frameTime = 0;
				return f2;
				}
			}
		}else if(vSpeed<=-r){
			if((freeze>0)) {
				if(frameTime<=8) {return b3;}
				else if(frameTime<16) {return b4;}
				else {frameTime = 0;
				return b4;
				}
			}else {
				if(frameTime<=8) {return b1;}
				else if(frameTime<16) {return b2;}
				else {frameTime = 0;
				return b2;
				}
			}
		}else {
			if((freeze>0)) {
				if(frameTime<=8) {return n3;}
				else if(frameTime<16) {return n4;}
				else {frameTime = 0;
				return n4;
				}
			}else {
				if(frameTime<=8) {return n1;}
				else if(frameTime<16) {return n2;}
				else {frameTime = 0;
				return n2;
				}
			}
		}
		}
	}
	
	public void move() {
		up = MariutzaThread.Wt;
		down = MariutzaThread.St;
		right = MariutzaThread.Dt;
		left = MariutzaThread.At;
		zero = GameFrame.J;
		if(stickTime>120) {hp=0;}
		if(hp<=0) {Game.over=true;}
		if(controllable==false) {
			x+=hSpeed;
			y+=vSpeed;
		}else {
			if((left>0)&&(right>0)) {
				if(left<right) {hSpeed-=acceleration;}
				else if(left>right){hSpeed+=acceleration;}}
			else if((left>0)&&(right==0)) {
				hSpeed-=acceleration;
			}
			else if((right>0)&&(left==0)) {
				hSpeed+=acceleration;
			}
			if((up>0)&&(down>0)) {
				if(up<down) {vSpeed-=acceleration;}
				else if(up>down){vSpeed+=acceleration;}}
			else if((up>0)&&(down==0)) {
				vSpeed-=acceleration;
			}
			else if((down>0)&&(up==0)) {
				vSpeed+=acceleration;
			}
			if(vSpeed<-vMaximum) {vSpeed=-vMaximum;}
			if(vSpeed>vMaximum) {vSpeed=vMaximum;}
			if(hSpeed<-hMaximum) {hSpeed=-hMaximum;}
			if(hSpeed>hMaximum) {hSpeed=hMaximum;}
			if((left==0)&&(right==0)) {
				hSpeed = shift(hSpeed);
			}
			if((up==0)&&(down==0)) {
				vSpeed = shift(vSpeed);
			}
			x+=hSpeed;
			y+=vSpeed;
			if(x>screenBoundX) {x=screenBoundX;if(hSpeed>0) {hSpeed=0;}}
			else if(x<0) {x=0;if(hSpeed<0) {hSpeed=0;}}
			if(y<0) {y=0;if(vSpeed<0) {vSpeed=0;}}
			else if(y>screenBoundY) {y=screenBoundY;if(vSpeed>0) {vSpeed=0;}}
			if(freeze>0) {freeze--;}
			if(invinsible>0) {invinsible--;}
			if(stick==true) {stickTime++;}else {stickTime = 0;}
			if(zero==true) {if(invinsible<=0) {shoot();}}
		}
	}
	public void multiMove(Korriel c1) {
		up = MultiGameThread.upT;
		down = MultiGameThread.downT;
		right = MultiGameThread.rightT;
		left = MultiGameThread.leftT;
		zero = GameFrame.zero;
		if(stickTime>120) {hp=0;}
		if(controllable==false) {
			x+=hSpeed;
			y+=vSpeed;
		}else {
			if((left>0)&&(right>0)) {
				if(left<right) {hSpeed-=acceleration;}
				else if(left>right){hSpeed+=acceleration;}}
			else if((left>0)&&(right==0)) {
				hSpeed-=acceleration;
			}
			else if((right>0)&&(left==0)) {
				hSpeed+=acceleration;
			}
			if((up>0)&&(down>0)) {
				if(up<down) {vSpeed-=acceleration;}
				else if(up>down){vSpeed+=acceleration;}}
			else if((up>0)&&(down==0)) {
				vSpeed-=acceleration;
			}
			else if((down>0)&&(up==0)) {
				vSpeed+=acceleration;
			}
			if(vSpeed<-vMaximum) {vSpeed=-vMaximum;}
			if(vSpeed>vMaximum) {vSpeed=vMaximum;}
			if(hSpeed<-hMaximum) {hSpeed=-hMaximum;}
			if(hSpeed>hMaximum) {hSpeed=hMaximum;}
			if((left==0)&&(right==0)) {
				hSpeed = shift(hSpeed);
			}
			if((up==0)&&(down==0)) {
				vSpeed = shift(vSpeed);
			}
			push(c1);
			x+=hSpeed;
			y+=vSpeed;
			pushBound(c1);
			if(x>screenBoundX) {x=screenBoundX;if(hSpeed>0) {hSpeed=0;}}
			else if(x<0) {x=0;if(hSpeed<0) {hSpeed=0;}}
			if(y<0) {y=0;if(vSpeed<0) {vSpeed=0;}}
			else if(y>screenBoundY) {y=screenBoundY;if(vSpeed>0) {vSpeed=0;}}
			if(freeze>0) {freeze--;}
			if(invinsible>0) {invinsible--;}
			if(stick==true) {stickTime++;}else {stickTime = 0;}
			if(zero==true) {if(invinsible<=0) {shoot();}}
		}
	}
	
	public static double shift(double i) {
		if(i!=0) {
			if((i>=-shiftSpeed)&&(i<=shiftSpeed)) {i=0;}else {
				if(i>0) {i-=shiftSpeed;}
				if(i<0) {i+=shiftSpeed;}}
	}
		return i;}
	
	public void shoot() {
		if(freeze==0) {
			Game.p2bullets.add(new P2Bullet(this));
			freeze = 10;
			Main.sounds.play(Sound.fireballSound2);
		}
	}
	public Rectangle toRect() {
		range = new Rectangle((int)(x+rx),(int)(y+ry),rw,rh);
		return range;
	}
	public void push(Korriel c) {
		if(c.toRect().intersects(this.toRect())) {
			if(this.x<=c.x+c.getRW()) {if(c.getHSpeed()>0) {if(this.x>c.x+c.getRW()*3/4) {if(this.x>c.x+c.getRW()*3/4) {this.hSpeed+=c.getHSpeed();}}}
			if((this.x+this.rw)>=c.x) {if(c.getHSpeed()<0) {if((this.x+this.rw)<c.x+c.getRW()/4) {this.hSpeed+=c.getHSpeed();}}}
			if(this.y<=c.y+c.getRH()) {if(c.getVSpeed()>0) {if(this.y>c.y+c.getRH()*3/4) {this.vSpeed+=c.getVSpeed();}}}
			if((this.y+this.rh)>=c.y) {if(c.getVSpeed()<0) {if((this.y+this.rh)<c.y+c.getRH()/4) {this.vSpeed+=c.getVSpeed();}}}}
		}
	}
	public void pushBound(Korriel c) {
		if(c.toRect().intersects(this.toRect())) {
			if((this.x<=0)||(this.leftBlock==true)) {c.x+=r;c.changeHSpeed(0);}
			if((this.x>=screenBoundX)||(this.rightBlock==true)) {c.x-=r;c.changeHSpeed(0);}
			if((this.y<=0)||(this.upBlock==true)) {c.y+=r;c.changeVSpeed(0);}
			if((this.y>=screenBoundY)||(this.downBlock==true)) {c.y-=r;c.changeVSpeed(0);}
		}
	}
	public void damage() {
		if(invinsible<=0) {
			hp--;
			invinsible = 120;
			Main.sounds.play(Sound.booomSound);
		}
	}
	public void heal() {
		if((hp>0)&&(hp<maxHP)){hp++;}
	}
	public void hissatsu() {
		if(Game.bomb==null) {
			if(freeze==0) {
				if(invinsible<=0) {
					freeze = 40;
					Game.bomb = new P2Bomb();
					Main.sounds.play(Sound.fireballSound);
				}
			}
		}
	}
	public BufferedImage icon() {
		if(invinsible>0) {return i2;}
		return i1;
	}
	public void initializeCollision() {
		stick=false;
		rightBlock=false;
		leftBlock=false;
		upBlock=false;
		downBlock=false;
	}
	public void initialize() {
		up = 0;
		right = 0;
		up = 0;
		down = 0;
		zero = false;
		this.x = -32*r;
		this.y = 160*r;
		this.hSpeed = 0;
		this.vSpeed = 0;
		frameTime = 0;
		freeze = 0;
		invinsible = 0;
		stickTime = 0;
		stick=false;
		rightBlock=false;
		leftBlock=false;
		upBlock=false;
		downBlock=false;
		exitTime=0;
	}
	public void clear() {
		this.initialize();
		controllable = true;
		hp = 3;
		maxHP = 3;
	}
	public void exit() {
		if(exitTime==0) {
			hSpeed=0;
			vSpeed=0;
			if(this.x>51*r) {this.x-=1*r;}
			else if(this.x<49*r) {this.x+=1*r;}
			else {this.x=50*r;}
			if(this.y>101*r) {this.y-=1*r;}
			else if(this.y<99*r) {this.y+=1*r;}
			else {this.y=100*r;}
			if(((int)(this.x)==50*r)&&((int)(this.y)==100*r)) {exitTime++;}
		}else if((exitTime>0)&&(exitTime<=128)) {
			exitTime++;
		}else {
			if(this.x<260*r) {this.x+=3*r;}
		}
	}
	public void lose() {
		invinsible=999;
		changeHSpeed(0);
		changeVSpeed(2*r);
		controllable=false;
	}


}
