package display;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import effects.BlackScreen;
import game.Game;
import game.Main;
import game.Sound;
import misc.Save;

public class Intro extends JPanel {
	private final static BufferedImage introMenu1 = Image.readImage("res/Background/StarryNight-1.png");
	private final static BufferedImage introMenu2 = Image.readImage("res/Background/StarryNight-2.png");
	private final static BufferedImage introMenu3 = Image.readImage("res/Background/StarryNight-3.png");
	private final static BufferedImage introMenu4 = Image.readImage("res/Background/StarryNight-4.png");
	private final static BufferedImage WoodFrame = Image.readImage("res/Background/Layer2/WoodenFrame.png");
	private final static BufferedImage Ahoutsukai1 = Image.readImage("res/Background/Layer2/Ahoutsukai.png");
	private final static BufferedImage Ahoutsukai2 = Image.readImage("res/Background/Layer2/Ahoutsukai-1.png");
	private final static BufferedImage Ahoutsukai3 = Image.readImage("res/Background/Layer2/Ahoutsukai-2.png");
	private final static BufferedImage Ahoutsukai4 = Image.readImage("res/Background/Layer2/Ahoutsukai-3.png");
	private final static BufferedImage Ahoutsukai5 = Image.readImage("res/Background/Layer2/Ahoutsukai-4.png");
	private final static BufferedImage Ahoutsukai6 = Image.readImage("res/Background/Layer2/Ahoutsukai-5.png");
	private final static BufferedImage Ahoutsukai7 = Image.readImage("res/Background/Layer2/Ahoutsukai-6.png");
	private final static BufferedImage Ahoutsukai8 = Image.readImage("res/Background/Layer2/Ahoutsukai-7.png");
	private final static BufferedImage Ahoutsukai9 = Image.readImage("res/Background/Layer2/Ahoutsukai-8.png");
	private final static BufferedImage Ahoutsukai10 = Image.readImage("res/Background/Layer2/Ahoutsukai-9.png");
	private final static BufferedImage Nikki1 = Image.readImage("res/Background/Layer2/Nikki.png");
	private final static BufferedImage Nikki2 = Image.readImage("res/Background/Layer2/Nikki-1.png");
	private final static BufferedImage Nikki3 = Image.readImage("res/Background/Layer2/Nikki-2.png");
	private final static BufferedImage Nikki4 = Image.readImage("res/Background/Layer2/Nikki-3.png");
	private final static BufferedImage Nikki5 = Image.readImage("res/Background/Layer2/Nikki-4.png");
	private final static BufferedImage Nikki6 = Image.readImage("res/Background/Layer2/Nikki-5.png");
	private final static BufferedImage Nikki7 = Image.readImage("res/Background/Layer2/Nikki-6.png");
	private final static BufferedImage p1con = Image.readImage("res/Background/ControlPad.png");
	private final static BufferedImage p2con = Image.readImage("res/Background/ControlPad2.png");
	private final static BufferedImage START = Image.readImage("res/Effects/START.png");
	private final static BufferedImage SETTING = Image.readImage("res/Effects/SETTING.png");
	private final static BufferedImage CONTROLS = Image.readImage("res/Effects/CONTROLS.png");
	private final static BufferedImage Triangle = Image.readImage("res/Effects/triangle.png");
	private final static BufferedImage DisplaySize = Image.readImage("res/Effects/DISPLAY_SIZE.png");
	private static BufferedImage OneX = Image.readImage("res/Effects/1x.png");
	private static BufferedImage TwoX = Image.readImage("res/Effects/2x.png");
	private static BufferedImage FourX = Image.readImage("res/Effects/4x.png");
	private static BufferedImage LEVEL = Image.readImage("res/Effects/LEVEL.png");
	private static BufferedImage INFINITE = Image.readImage("res/Effects/INFINITE.png");
	private static BlackScreen bse = new BlackScreen(false,30);
	private static BlackScreen bso = new BlackScreen(true,30);
	private static int r = Main.rate;
	private static int framie = 0;
	private static int state = 0;
	private static boolean bgms = false;
	private static int maxLevel;
	private static int previous;
	private static int x = 0;
	private static int frames = 0;
	private static int bgFrame = 0;
	
	public Intro() {
		if(Main.rate==1) {
			OneX = Image.readImage("res/Effects/1xr.png");
		}else if(Main.rate==2) {
			TwoX = Image.readImage("res/Effects/2xr.png");
		}else if(Main.rate==4) {
			FourX = Image.readImage("res/Effects/4xr.png");
		}
		maxLevel = Main.save[1];
		
	}
	public void paint(Graphics g) {
		super.paint(g);
		if(state==0) {
			g.drawImage(p1con,0,0,256*r,224*r,this);
			g.drawImage(bso.titleWave(), 0, 0, 256*r, 224*r, this);
			if((framie==24)||(GameFrame.J==true)||(GameFrame.Enter==true)) {state++;framie=0;bso.restart();}
		}else if(state==1) {
			g.drawImage(p1con,0,0,256*r,224*r,this);
			if((framie==240)||(GameFrame.J==true)||(GameFrame.Enter==true)) {state++;framie=0;}
		}else if(state==2) {
			g.drawImage(p1con,0,0,256*r,224*r,this);
			g.drawImage(bse.titleWave(), 0, 0, 256*r, 224*r, this);
			if(framie==24) {state++;framie=0;bse.restart();frames = 0;bgFrame = 0;}
		}else if(state==3) {
			g.drawImage(background(),0,0,256*r,224*r,this);
			g.drawImage(titleWave(),36*r,30*r,160*r,16*r,this);
			g.drawImage(titleNikkiWave(),154*r,55*r,72*r,16*r,this);
			g.drawImage(WoodFrame,0,0,256*r,224*r,this);
			g.drawImage(bso.titleWave(), 0, 0, 256*r, 224*r, this);
			if(framie==24) {state++;framie=0;bso.restart();}
		}else if(state==4) {
			g.drawImage(background(),0,0,256*r,224*r,this);
			g.drawImage(titleWave(),36*r,30*r,160*r,16*r,this);
			g.drawImage(titleNikkiWave(),154*r,55*r,72*r,16*r,this);
			g.drawImage(WoodFrame,0,0,256*r,224*r,this);
			if(bgms==false) {bgms=true;Main.sounds.changeBGM(5);Main.sounds.loopBGM();}
			if(framie==50) {state++;framie=0;}
		}else if(state==5) {
			g.drawImage(background(), 0, 0, 256*r, 224*r, this);
			g.drawImage(titleWave(),36*r,30*r,160*r,16*r,this);
			g.drawImage(titleNikkiWave(),154*r,55*r,72*r,16*r,this);
			g.drawImage(WoodFrame,0,0,256*r,224*r,this);
			if((framie%40>=0)&&(framie%40<=20)) {g.drawImage(START, 97*r, 150*r, 64*r,8 *r,this);}
			g.drawImage(Triangle, 80*r, 150*r, 8*r,8 *r,this);
			g.drawImage(CONTROLS, 93*r, 170*r, 71*r,8 *r,this);
			g.drawImage(SETTING, 98*r, 190*r, 62*r,8 *r,this);
			if((GameFrame.J==true)||(GameFrame.Enter==true)) {
				GameFrame.J=false;
				GameFrame.Enter=false;
				framie=0;
				state=15;Main.sounds.play(Sound.SMWmessageSound);}
			if(GameFrame.S==true) {
				GameFrame.S=false;
				state=6;
				Main.sounds.play(Sound.selectSound);}
		}else if(state==6) {
			g.drawImage(background(), 0, 0, 256*r, 224*r, this);
			g.drawImage(titleWave(),36*r,30*r,160*r,16*r,this);
			g.drawImage(titleNikkiWave(),154*r,55*r,72*r,16*r,this);
			g.drawImage(WoodFrame,0,0,256*r,224*r,this);
			g.drawImage(START, 97*r, 150*r, 64*r,8 *r,this);
			if((framie%40>=0)&&(framie%40<=20)) {g.drawImage(CONTROLS, 93*r, 170*r, 71*r,8 *r,this);}
			g.drawImage(Triangle, 80*r, 170*r, 8*r,8 *r,this);
			g.drawImage(SETTING, 98*r, 190*r, 62*r,8 *r,this);
			if((GameFrame.J==true)||(GameFrame.Enter==true)) {
				GameFrame.J=false;
				GameFrame.Enter=false;
				framie=0;
				state=9;Main.sounds.play(Sound.SMWmessageSound);}
			if(GameFrame.S==true) {
				GameFrame.S=false;
				framie=0;
				state=7;
				Main.sounds.play(Sound.selectSound);}
			if(GameFrame.W==true) {
				GameFrame.W=false;
				framie=0;
				state=5;
				Main.sounds.play(Sound.selectSound);}
		}else if(state==7) {
			g.drawImage(background(), 0, 0, 256*r, 224*r, this);
			g.drawImage(titleWave(),36*r,30*r,160*r,16*r,this);
			g.drawImage(titleNikkiWave(),154*r,55*r,72*r,16*r,this);
			g.drawImage(WoodFrame,0,0,256*r,224*r,this);
			g.drawImage(START, 97*r, 150*r, 64*r,8 *r,this);
			g.drawImage(CONTROLS, 93*r, 170*r, 71*r,8 *r,this);
			if((framie%40>=0)&&(framie%40<=20)) {g.drawImage(SETTING, 98*r, 190*r, 62*r,8 *r,this);}
			g.drawImage(Triangle, 80*r, 190*r, 8*r,8 *r,this);
			if(GameFrame.W==true) {
				GameFrame.W=false;
				framie=0;
				state=6;
				Main.sounds.play(Sound.selectSound);}
			if((GameFrame.J==true)||(GameFrame.Enter==true)) {
				GameFrame.J=false;
				GameFrame.Enter=false;
				state=11;
				Main.sounds.play(Sound.SMWmessageSound);
			}
		}else if(state==8) {
			g.drawImage(bse.titleWave(), 0, 0, 256*r, 224*r, this);
			if(framie==24) {
				GameFrame.game = new Game();
				this.setVisible(false);
				Main.frame.gameDisplay();
				framie=0;
				bse.restart();
				state=3;
			}
		}else if(state==9) {
			g.drawImage(p1con,0, 0, 256*r, 224*r, this);
			if((GameFrame.J==true)||(GameFrame.Enter==true)) {GameFrame.J=false;GameFrame.Enter=false;state++;Main.sounds.play(Sound.SMWmessageSound);}
			if(GameFrame.K==true) {GameFrame.K=false;state=6;framie=0;Main.sounds.play(Sound.yoshiSound);}
		}else if(state==10) {
			g.drawImage(p2con,0, 0, 256*r, 224*r, this);
			if((GameFrame.J==true)||(GameFrame.Enter==true)||(GameFrame.K==true)) {GameFrame.J=false;GameFrame.Enter=false;state=6;framie=0;Main.sounds.play(Sound.yoshiSound);}
		}else if(state==11) {
			g.drawImage(background(), 0, 0, 256*r, 224*r, this);
			g.drawImage(titleWave(),36*r,30*r,160*r,16*r,this);
			g.drawImage(titleNikkiWave(),154*r,55*r,72*r,16*r,this);
			g.drawImage(WoodFrame,0,0,256*r,224*r,this);
			g.drawImage(DisplaySize, 72*r, 147*r, 116*r, 22*r,this);
			if((framie%40>=0)&&(framie%40<=20)) {g.drawImage(OneX, 87*r, 193*r, 16*r, 7*r,this);}
			g.drawImage(Triangle, 76*r, 193*r, 8*r,8 *r,this);
			g.drawImage(TwoX, 122*r, 193*r, 16*r, 7*r,this);
			g.drawImage(FourX, 157*r, 193*r, 16*r, 7*r,this);
			if(GameFrame.K==true) {GameFrame.K=false;state=7;framie=0;Main.sounds.play(Sound.flyspitSound);}
			if((GameFrame.J==true)||(GameFrame.Enter==true)) {
				GameFrame.J=false;GameFrame.Enter=false;
				Main.save[0]=1;Save.writeSav(Main.save);
				state=7;framie=0;Main.sounds.play(Sound.SMWitemSound);}
			if(GameFrame.D==true) {
				GameFrame.D=false;
				framie=0;
				state=12;
				Main.sounds.play(Sound.selectSound);}
		}else if(state==12) {
			g.drawImage(background(), 0, 0, 256*r, 224*r, this);
			g.drawImage(titleWave(),36*r,30*r,160*r,16*r,this);
			g.drawImage(titleNikkiWave(),154*r,55*r,72*r,16*r,this);
			g.drawImage(WoodFrame,0,0,256*r,224*r,this);
			g.drawImage(DisplaySize, 72*r, 147*r, 116*r, 22*r,this);
			g.drawImage(OneX, 87*r, 193*r, 16*r, 7*r,this);
			if((framie%40>=0)&&(framie%40<=20)) {g.drawImage(TwoX, 122*r, 193*r, 16*r, 7*r,this);}
			g.drawImage(Triangle, 111*r, 193*r, 8*r,8 *r,this);
			g.drawImage(FourX, 157*r, 193*r, 16*r, 7*r,this);
			if(GameFrame.K==true) {GameFrame.K=false;state=7;framie=0;Main.sounds.play(Sound.flyspitSound);}
			if((GameFrame.J==true)||(GameFrame.Enter==true)) {
				GameFrame.J=false;GameFrame.Enter=false;
				Main.save[0]=2;Save.writeSav(Main.save);
				state=7;framie=0;Main.sounds.play(Sound.SMWitemSound);}
			if(GameFrame.D==true) {
				GameFrame.D=false;
				framie=0;
				state=14;
				Main.sounds.play(Sound.selectSound);}
			if(GameFrame.A==true) {
				GameFrame.A=false;
				framie=0;
				state=11;
				Main.sounds.play(Sound.selectSound);}
		}else if(state==14) {
			g.drawImage(background(), 0, 0, 256*r, 224*r, this);
			g.drawImage(titleWave(),36*r,30*r,160*r,16*r,this);
			g.drawImage(titleNikkiWave(),154*r,55*r,72*r,16*r,this);
			g.drawImage(WoodFrame,0,0,256*r,224*r,this);
			g.drawImage(DisplaySize, 72*r, 147*r, 116*r, 22*r,this);
			g.drawImage(OneX, 87*r, 193*r, 16*r, 7*r,this);
			g.drawImage(TwoX, 122*r, 193*r, 16*r, 7*r,this);
			if((framie%40>=0)&&(framie%40<=20)) {g.drawImage(FourX, 157*r, 193*r, 16*r, 7*r,this);}
			g.drawImage(Triangle, 146*r, 193*r, 8*r,8 *r,this);
			if(GameFrame.K==true) {GameFrame.K=false;state=7;framie=0;Main.sounds.play(Sound.flyspitSound);}
			if((GameFrame.J==true)||(GameFrame.Enter==true)) {
				GameFrame.J=false;GameFrame.Enter=false;
				Main.save[0]=4;Save.writeSav(Main.save);
				state=7;framie=0;Main.sounds.play(Sound.SMWitemSound);}
			if(GameFrame.A==true) {
				GameFrame.A=false;
				framie=0;
				state=12;
				Main.sounds.play(Sound.selectSound);}
		}else if(state==15) {
			g.drawImage(background(), 0, 0, 256*r, 224*r, this);
			g.drawImage(titleWave(),36*r,30*r,160*r,16*r,this);
			g.drawImage(titleNikkiWave(),154*r,55*r,72*r,16*r,this);
			g.drawImage(WoodFrame,0,0,256*r,224*r,this);
			g.drawImage(Triangle, 60*r, 157*r, 8*r,8 *r,this);
			g.drawImage(LEVEL, 84*r, 157*r, 48*r, 8*r,this);
			if((framie%40>=0)&&(framie%40<=20)) {g.drawImage(Effect.nums[1], 156*r, 157*r,8*r,8*r,this);}
			g.drawImage(INFINITE, 95*r, 187*r, 65*r, 8*r,this);
			if(GameFrame.K==true) {GameFrame.K=false;state=5;framie=0;Main.sounds.play(Sound.flyspitSound);}
			if(GameFrame.S==true) {
				GameFrame.S=false;
				framie=0;
				previous=state;
				state=20;
				Main.sounds.play(Sound.selectSound);
			}
			if(GameFrame.D==true) {
				GameFrame.D=false;
				if(maxLevel>=1) {
					framie=0;
					state=16;
					Main.sounds.play(Sound.selectSound);}
				else {Main.sounds.play(Sound.noSound);}
				}
			if((GameFrame.J==true)||(GameFrame.Enter==true)) {
				GameFrame.J=false;GameFrame.Enter=false;stopMusic();
				Game.levelNumber=1;
				state=21;
				Main.sounds.play(Sound.SMWmessageSound);
				changeBGM();
			}
		}
		else if(state==16) {
			g.drawImage(background(), 0, 0, 256*r, 224*r, this);
			g.drawImage(titleWave(),36*r,30*r,160*r,16*r,this);
			g.drawImage(titleNikkiWave(),154*r,55*r,72*r,16*r,this);
			g.drawImage(WoodFrame,0,0,256*r,224*r,this);
			g.drawImage(Triangle, 60*r, 157*r, 8*r,8 *r,this);
			g.drawImage(LEVEL, 84*r, 157*r, 48*r, 8*r,this);
			if((framie%40>=0)&&(framie%40<=20)) {g.drawImage(Effect.nums[2], 156*r, 157*r,8*r,8*r,this);}
			g.drawImage(INFINITE, 95*r, 187*r, 65*r, 8*r,this);
			if(GameFrame.K==true) {GameFrame.K=false;state=5;framie=0;Main.sounds.play(Sound.flyspitSound);}
			if(GameFrame.D==true) {
				GameFrame.D=false;
				if(maxLevel>=2) {
					framie=0;
					state=17;
					Main.sounds.play(Sound.selectSound);}
				else {Main.sounds.play(Sound.noSound);}
				}
			if(GameFrame.A==true) {
				GameFrame.A=false;
				framie=0;
				state=15;
				Main.sounds.play(Sound.selectSound);}
			if(GameFrame.S==true) {
				GameFrame.S=false;
				framie=0;
				previous=state;
				state=20;
				Main.sounds.play(Sound.selectSound);
			}
			if((GameFrame.J==true)||(GameFrame.Enter==true)) {
				GameFrame.J=false;GameFrame.Enter=false;stopMusic();
				Game.levelNumber=2;
				state=21;
				Main.sounds.play(Sound.SMWmessageSound);
				changeBGM();
			}
		}
		else if(state==17) {
			g.drawImage(background(), 0, 0, 256*r, 224*r, this);
			g.drawImage(titleWave(),36*r,30*r,160*r,16*r,this);
			g.drawImage(titleNikkiWave(),154*r,55*r,72*r,16*r,this);
			g.drawImage(WoodFrame,0,0,256*r,224*r,this);
			g.drawImage(Triangle, 60*r, 157*r, 8*r,8 *r,this);
			g.drawImage(LEVEL, 84*r, 157*r, 48*r, 8*r,this);
			if((framie%40>=0)&&(framie%40<=20)) {g.drawImage(Effect.nums[3], 156*r, 157*r,8*r,8*r,this);}
			g.drawImage(INFINITE, 95*r, 187*r, 65*r, 8*r,this);
			if(GameFrame.K==true) {GameFrame.K=false;state=5;framie=0;Main.sounds.play(Sound.flyspitSound);}
			if(GameFrame.D==true) {
				GameFrame.D=false;
				if(maxLevel>=3) {
					framie=0;
					state=18;
					Main.sounds.play(Sound.selectSound);}
				else {Main.sounds.play(Sound.noSound);}
			}
			if(GameFrame.A==true) {
				GameFrame.A=false;
				framie=0;
				state=16;
				Main.sounds.play(Sound.selectSound);}
			if(GameFrame.S==true) {
				GameFrame.S=false;
				framie=0;
				previous=state;
				state=20;
				Main.sounds.play(Sound.selectSound);
			}
			if((GameFrame.J==true)||(GameFrame.Enter==true)) {
				GameFrame.J=false;GameFrame.Enter=false;stopMusic();
				Game.levelNumber=3;
				state=21;
				Main.sounds.play(Sound.SMWmessageSound);
				changeBGM();
			}
		}
		else if(state==18) {
			g.drawImage(background(), 0, 0, 256*r, 224*r, this);
			g.drawImage(titleWave(),36*r,30*r,160*r,16*r,this);
			g.drawImage(titleNikkiWave(),154*r,55*r,72*r,16*r,this);
			g.drawImage(WoodFrame,0,0,256*r,224*r,this);
			g.drawImage(Triangle, 60*r, 157*r, 8*r,8 *r,this);
			g.drawImage(LEVEL, 84*r, 157*r, 48*r, 8*r,this);
			if((framie%40>=0)&&(framie%40<=20)) {g.drawImage(Effect.nums[4], 156*r, 157*r,8*r,8*r,this);}
			g.drawImage(INFINITE, 95*r, 187*r, 65*r, 8*r,this);
			if(GameFrame.K==true) {GameFrame.K=false;state=5;framie=0;Main.sounds.play(Sound.flyspitSound);}
			if(GameFrame.D==true) {
				GameFrame.D=false;
				if(maxLevel>=4) {
				framie=0;
				state=19;
				Main.sounds.play(Sound.selectSound);}
				else {Main.sounds.play(Sound.noSound);}
			}
			if(GameFrame.A==true) {
				GameFrame.A=false;
				framie=0;
				state=17;
				Main.sounds.play(Sound.selectSound);}
			if(GameFrame.S==true) {
				GameFrame.S=false;
				framie=0;
				previous=state;
				state=20;
				Main.sounds.play(Sound.selectSound);
			}
			if((GameFrame.J==true)||(GameFrame.Enter==true)) {
				GameFrame.J=false;GameFrame.Enter=false;stopMusic();
				Game.levelNumber=4;
				state=21;
				Main.sounds.play(Sound.SMWmessageSound);
				changeBGM();
			}
		}
		else if(state==19) {
			g.drawImage(background(), 0, 0, 256*r, 224*r, this);
			g.drawImage(titleWave(),36*r,30*r,160*r,16*r,this);
			g.drawImage(titleNikkiWave(),154*r,55*r,72*r,16*r,this);
			g.drawImage(WoodFrame,0,0,256*r,224*r,this);
			g.drawImage(Triangle, 60*r, 157*r, 8*r,8 *r,this);
			g.drawImage(LEVEL, 84*r, 157*r, 48*r, 8*r,this);
			if((framie%40>=0)&&(framie%40<=20)) {g.drawImage(Effect.nums[5], 156*r, 157*r,8*r,8*r,this);}
			g.drawImage(INFINITE, 95*r, 187*r, 65*r, 8*r,this);
			if(GameFrame.K==true) {GameFrame.K=false;state=5;framie=0;Main.sounds.play(Sound.flyspitSound);}
			if(GameFrame.A==true) {
				GameFrame.A=false;
				framie=0;
				state=18;
				Main.sounds.play(Sound.selectSound);}
			if(GameFrame.S==true) {
				GameFrame.S=false;
				framie=0;
				previous=state;
				state=20;
				Main.sounds.play(Sound.selectSound);
			}
			if((GameFrame.J==true)||(GameFrame.Enter==true)) {
				GameFrame.J=false;GameFrame.Enter=false;stopMusic();
				Game.levelNumber=5;
				state=21;
				Main.sounds.play(Sound.SMWmessageSound);
				changeBGM();
			}
		}
		else if(state==20) {
			g.drawImage(background(), 0, 0, 256*r, 224*r, this);
			g.drawImage(titleWave(),36*r,30*r,160*r,16*r,this);
			g.drawImage(titleNikkiWave(),154*r,55*r,72*r,16*r,this);
			g.drawImage(WoodFrame,0,0,256*r,224*r,this);
			g.drawImage(Triangle, 71*r, 187*r, 8*r,8 *r,this);
			g.drawImage(LEVEL, 84*r, 157*r, 48*r, 8*r,this);
			g.drawImage(Effect.nums[previous-14], 156*r, 157*r,8*r,8*r,this);
			if((framie%40>=0)&&(framie%40<=20)) {g.drawImage(INFINITE, 95*r, 187*r, 65*r, 8*r,this);}
			if(GameFrame.K==true) {GameFrame.K=false;state=5;framie=0;Main.sounds.play(Sound.flyspitSound);}
			if(GameFrame.W==true) {
				GameFrame.W=false;
				framie=0;
				state=previous;
				Main.sounds.play(Sound.selectSound);}
			if((GameFrame.J==true)||(GameFrame.Enter==true)) {
				GameFrame.J=false;GameFrame.Enter=false;stopMusic();
				Game.levelNumber=0;
				state=21;
				Main.sounds.play(Sound.SMWmessageSound);
				changeBGM();
			}
		}
		else if(state==21) {
			g.drawImage(Image.zhujue, 0,0,256*r, 224*r, this);
			if((GameFrame.J==true)||(GameFrame.Enter==true)) {
				GameFrame.J=false;GameFrame.Enter=false;
				stopMusic();
				Game.twoPlayer=false;
				Game.mari=false;
				GameFrame.game = new Game();
				this.setVisible(false);
				Main.frame.gameDisplay();
				framie=0;
				bse.restart();
				state=3;
			}
			if(GameFrame.D==true) {
				GameFrame.D=false;
				framie=0;
				state=22;}
			if(GameFrame.S==true) {
				GameFrame.S=false;
				framie=0;
				previous=state;
				state=23;}
		}
		else if(state==22) {
			g.drawImage(Image.zhujueer, 0,0,256*r, 224*r, this);
			if((GameFrame.J==true)||(GameFrame.Enter==true)) {
				GameFrame.J=false;GameFrame.Enter=false;
				stopMusic();
				Game.twoPlayer=false;
				Game.mari=true;
				GameFrame.game = new Game();
				this.setVisible(false);
				Main.frame.gameDisplay();
				framie=0;
				bse.restart();
				state=3;
			}
			if(GameFrame.A==true) {
				GameFrame.A=false;
				framie=0;
				state=21;}
			if(GameFrame.S==true) {
				GameFrame.S=false;
				framie=0;
				previous=state;
				state=23;}
		}
		else if(state==23) {
			g.drawImage(Image.zhujueer, -60*r,0,256*r, 224*r, this);
			g.drawImage(Image.zhujue, 40*r,0,256*r, 224*r, this);
			if((GameFrame.J==true)||(GameFrame.Enter==true)) {
				GameFrame.J=false;GameFrame.Enter=false;
				if(Game.levelNumber==0) {
					stopMusic();
					Game.twoPlayer=true;
					Game.mari=true;
					GameFrame.game = new Game();
					this.setVisible(false);
					Main.frame.gameDisplay();
					framie=0;
					bse.restart();
					state=3;
				}else {
					Main.sounds.play(Sound.noSound);
					//No MultiPlayer in Adventure Mode!
				}
			}
			if(GameFrame.W==true) {
				GameFrame.W=false;
				framie=0;
				state=previous;}
		}
		try {
			Thread.sleep(17);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		framie++;
		this.repaint();
	}
	public static void stopMusic() {
		Main.sounds.stopBGM();
		Main.sounds.changeBGM(0);
		bgms=false;
	}
	public static void changeBGM() {
		Main.sounds.changeBGM(4);
		Main.sounds.loopBGM();
	}
	public BufferedImage titleWave() {
		frames++;
		if(frames<60) {
			return Ahoutsukai1;
		}else if(frames<=65) {
			return Ahoutsukai2;
		}else if(frames<=70) {
			return Ahoutsukai3;
		}else if(frames<=75) {
			return Ahoutsukai4;
		}else if(frames<=80) {
			return Ahoutsukai5;
		}else if(frames<=85) {
			return Ahoutsukai6;
		}else if(frames<=90) {
			return Ahoutsukai7;
		}else if(frames<=95) {
			return Ahoutsukai8;
		}else if(frames<=100) {
			return Ahoutsukai9;
		}else if(frames<=105) {
			return Ahoutsukai10;
		}else {
			return Ahoutsukai1;
		}
	}
	public BufferedImage titleNikkiWave() {
		if(frames<85) {
			return Nikki1;
		}else if(frames<=90) {
			return Nikki2;
		}else if(frames<=95) {
			return Nikki3;
		}else if(frames<=100) {
			return Nikki4;
		}else if(frames<=105) {
			return Nikki5;
		}else if(frames<=110) {
			return Nikki6;
		}else if(frames<=115) {
			return Nikki7;
		}else {
			frames=0;
			return Nikki1;
		}
	}
	public BufferedImage background() {
		bgFrame++;
		if(bgFrame<10) {
			return introMenu1;
		}else if(bgFrame<=20) {
			return introMenu2;
		}else if(bgFrame<=30) {
			return introMenu3;
		}else if(bgFrame<=40) {
			return introMenu4;
		}else {
			bgFrame=0;
			return introMenu4;
		}
	}

}