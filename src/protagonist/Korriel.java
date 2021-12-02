package protagonist;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import display.GameFrame;
import display.Image;
import display.Sprite;
import effects.RainbowRoot;
import game.*;
import levels.InfiniteLevel;
import protagonist.*;

public class Korriel extends Player {
	public double x;
	public double y;
	private double hSpeed;
	private double vSpeed;
	private int frameTime;
	private int magicTime;
	final private static BufferedImage n1 = Image.readImage("res/Korriel-n1.png");
	final private static BufferedImage n2 = Image.readImage("res/Korriel-n2.png");
	final private static BufferedImage n3 = Image.readImage("res/Korriel-n3.png");
	final private static BufferedImage n4 = Image.readImage("res/Korriel-n4.png");
	final private static BufferedImage f1 = Image.readImage("res/Korriel-f1.png");
	final private static BufferedImage f2 = Image.readImage("res/Korriel-f2.png");
	final private static BufferedImage f3 = Image.readImage("res/Korriel-f3.png");
	final private static BufferedImage f4 = Image.readImage("res/Korriel-f4.png");
	final private static BufferedImage b1 = Image.readImage("res/Korriel-b1.png");
	final private static BufferedImage b2 = Image.readImage("res/Korriel-b2.png");
	final private static BufferedImage b3 = Image.readImage("res/Korriel-b3.png");
	final private static BufferedImage b4 = Image.readImage("res/Korriel-b4.png");
	final private static BufferedImage h1 = Image.readImage("res/Korriel-h1.png");
	final private static BufferedImage h2 = Image.readImage("res/Korriel-h2.png");
	final private static BufferedImage i1 = Image.readImage("res/Effects/KState.png");
	final private static BufferedImage i2 = Image.readImage("res/Effects/KState2.png");
	private int A;
	private int D;
	private int W;
	private int S;
	private boolean J;
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
	
	public Korriel() {
		A = 0;
		D = 0;
		W = 0;
		S = 0;
		J = false;
		this.x = -32*r;
		this.y = 100*r;
		this.hSpeed = 0;
		this.vSpeed = 0;
		this.frameTime = 0;
		this.freeze = 0;
		this.magicTime = 3;
		this.hp = 3;
		this.maxHP=3;
		this.stick = false;
		this.invinsible = 0;
		this.stickTime = 0; 
		this.rightBlock = false;
		this.leftBlock = false;
		this.upBlock = false;
		this.downBlock = false;
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
	public int getInvinsible() {
		return invinsible;
	}
	public int getMg() {
		return magicTime;
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
			if(Game.hissatsu!=null) {
					if(frameTime<=8) {return f3;}
					else if(frameTime<16) {return f4;}
					else {frameTime = 0;
					return f4;
					}
			}
			else if(vSpeed>=r) {
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
		S = GameThread.St;
		A = GameThread.At;
		W = GameThread.Wt;
		D = GameThread.Dt;
		J = GameFrame.J;
		if(stickTime>120) {hp=0;}
		if(hp<=0) {Game.over=true;}
		if(controllable==false) {
			x+=hSpeed;
			y+=vSpeed;
		}else {
			if((A>0)&&(D>0)) {
				if(A<D) {hSpeed-=acceleration;}
				else if(A>D){hSpeed+=acceleration;}}
			else if((A>0)&&(D==0)) {
				hSpeed-=acceleration;
			}
			else if((D>0)&&(A==0)) {
				hSpeed+=acceleration;
			}
			if((W>0)&&(S>0)) {
				if(W<S) {vSpeed-=acceleration;}
				else if(W>S){vSpeed+=acceleration;}}
			else if((W>0)&&(S==0)) {
				vSpeed-=acceleration;
			}
			else if((S>0)&&(W==0)) {
				vSpeed+=acceleration;
			}
			if(vSpeed<-vMaximum) {vSpeed=-vMaximum;}
			if(vSpeed>vMaximum) {vSpeed=vMaximum;}
			if(hSpeed<-hMaximum) {hSpeed=-hMaximum;}
			if(hSpeed>hMaximum) {hSpeed=hMaximum;}
			if((A==0)&&(D==0)) {
				hSpeed = shift(hSpeed);
			}
			if((W==0)&&(S==0)) {
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
			if(J==true) {if(invinsible<=0) {shoot();}}
		}
	}
	
	public void multiMove(Mariutza c2) {
		S = MultiGameThread.St;
		A = MultiGameThread.At;
		W = MultiGameThread.Wt;
		D = MultiGameThread.Dt;
		J = GameFrame.J;
		if(stickTime>120) {hp=0;}
		if(hp<=0) {InfiniteLevel.kover=true;}
		if(controllable==false) {
			x+=hSpeed;
			y+=vSpeed;
		}else {
			if((A>0)&&(D>0)) {
				if(A<D) {hSpeed-=acceleration;}
				else if(A>D){hSpeed+=acceleration;}}
			else if((A>0)&&(D==0)) {
				hSpeed-=acceleration;
			}
			else if((D>0)&&(A==0)) {
				hSpeed+=acceleration;
			}
			if((W>0)&&(S>0)) {
				if(W<S) {vSpeed-=acceleration;}
				else if(W>S){vSpeed+=acceleration;}}
			else if((W>0)&&(S==0)) {
				vSpeed-=acceleration;
			}
			else if((S>0)&&(W==0)) {
				vSpeed+=acceleration;
			}
			if(vSpeed<-vMaximum) {vSpeed=-vMaximum;}
			if(vSpeed>vMaximum) {vSpeed=vMaximum;}
			if(hSpeed<-hMaximum) {hSpeed=-hMaximum;}
			if(hSpeed>hMaximum) {hSpeed=hMaximum;}
			if((A==0)&&(D==0)) {
				hSpeed = shift(hSpeed);
			}
			if((W==0)&&(S==0)) {
				vSpeed = shift(vSpeed);
			}
			push(c2);
			x+=hSpeed;
			y+=vSpeed;
			pushBound(c2);
			if(x>screenBoundX) {x=screenBoundX;if(hSpeed>0) {hSpeed=0;}}
			else if(x<0) {x=0;if(hSpeed<0) {hSpeed=0;}}
			if(y<0) {y=0;if(vSpeed<0) {vSpeed=0;}}
			else if(y>screenBoundY) {y=screenBoundY;if(vSpeed>0) {vSpeed=0;}}
			if(freeze>0) {freeze--;}
			if(invinsible>0) {invinsible--;}
			if(stick==true) {stickTime++;}else {stickTime = 0;}
			if(J==true) {if(invinsible<=0) {shoot();}}
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
			Game.pbullets.add(new PBullet((int)(this.vSpeed)));
			freeze = 25;
			Main.sounds.play(Sound.spitSound);
		}
	}
	public void hissatsu() {
		if(controllable==true) {
			if(magicTime>0) {
				if(freeze==0) {
					if(invinsible<=0) {
						freeze = 320;
						magicTime--;
						Game.effects.add(new RainbowRoot());
						Game.hissatsu = new Hissatsu();
					}
				}
			}
		}
	}
	public BufferedImage icon() {
		if(invinsible>0) {return i2;}
		return i1;
	}
	public Rectangle toRect() {
		range = new Rectangle((int)(x+rx),(int)(y+ry),rw,rh);
		return range;
	}
	public void push(Mariutza c) {
		if(c.toRect().intersects(this.toRect())) {
			if(this.x<=c.x+c.getRW()) {if(c.getHSpeed()>0) {if(this.x>c.x+c.getRW()*3/4) {if(this.x>c.x+c.getRW()*3/4) {this.hSpeed+=c.getHSpeed();}}}
			if((this.x+this.rw)>=c.x) {if(c.getHSpeed()<0) {if((this.x+this.rw)<c.x+c.getRW()/4) {this.hSpeed+=c.getHSpeed();}}}
			if(this.y<=c.y+c.getRH()) {if(c.getVSpeed()>0) {if(this.y>c.y+c.getRH()*3/4) {this.vSpeed+=c.getVSpeed();}}}
			if((this.y+this.rh)>=c.y) {if(c.getVSpeed()<0) {if((this.y+this.rh)<c.y+c.getRH()/4) {this.vSpeed+=c.getVSpeed();}}}}
		}
	}
	public void pushBound(Mariutza c) {
		if(c.toRect().intersects(this.toRect())) {
			if((this.x<=0)||(this.leftBlock==true)) {c.x+=2*r;c.changeHSpeed(0);}
			if((this.x>=screenBoundX)||(this.rightBlock==true)) {c.x-=2*r;c.changeHSpeed(0);}
			if((this.y<=0)||(this.upBlock==true)) {c.y+=2*r;c.changeVSpeed(0);}
			if((this.y>=screenBoundY)||(this.downBlock==true)) {c.y-=2*r;c.changeVSpeed(0);}
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
	public void initializeCollision() {
		stick=false;
		rightBlock=false;
		leftBlock=false;
		upBlock=false;
		downBlock=false;
	}
	public void starting() {
		controllable = false;
		
	}
	public void initialize() {
		A = 0;
		D = 0;
		W = 0;
		S = 0;
		J = false;
		this.x = -32*r;
		this.y = 100*r;
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
		magicTime = 3;
		controllable = true;
		hp = 3;
		maxHP = 3;
	}
	public void exit() {
		if(exitTime==0) {
			hSpeed=0;
			vSpeed=0;
			if(this.x>66*r) {this.x-=1*r;}
			else if(this.x<64*r) {this.x+=1*r;}
			else {this.x=65*r;}
			if(this.y>81*r) {this.y-=1*r;}
			else if(this.y<79*r) {this.y+=1*r;}
			else {this.y=80*r;}
			if(((int)(this.x)==65*r)&&((int)(this.y)==80*r)) {exitTime++;}
		}else if((exitTime>0)&&(exitTime<=120)) {
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
	public void mgcRecover() {
		magicTime++;
	}
	
}
