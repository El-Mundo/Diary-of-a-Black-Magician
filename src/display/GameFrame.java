   package display;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import effects.HighestScore;
import game.*;
import levels.Level;
import misc.Save;

public class GameFrame extends JFrame{
	public static Game game;
	public static boolean W = false;
	public static boolean S = false;
	public static boolean A = false;
	public static boolean D = false;
	public static boolean J = false;
	public static boolean K = false;
	public static boolean Enter = false;
	public static boolean up = false;
	public static boolean down = false;
	public static boolean left = false;
	public static boolean right = false;
	public static boolean zero = false;
	public static boolean three = false;
	public static Intro intro;
	public static Sprite sprite;
	public static MariutzaSprite mariutzaSprite;
	public static Sprite2P sprite2P;
	private static Transaction tr;
	private static KeyAdapter k1 = new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
				if(keyCode==KeyEvent.VK_W) {
					W = true;
				}
				if(keyCode==KeyEvent.VK_S) {
					S = true;
				}
				if(keyCode==KeyEvent.VK_A) {
					A= true;
				}
				if(keyCode==KeyEvent.VK_D) {
					D = true;
				}
				if(keyCode==KeyEvent.VK_J) {
					J = true;
				}
				if(keyCode==KeyEvent.VK_K) {
					K = true;
				}
				if(keyCode==KeyEvent.VK_ENTER) {
					Enter = true;
						if(Game.pause == false) {
							if((Game.start==true)&&(Game.end==false)&&(Game.over==false)){
								Game.pause = true;
								Main.sounds.play(Sound.testSound);
								}
						}else {
							Game.pause = false;
							Main.sounds.play(Sound.testSound);
					}
				}
			}
		public void keyReleased(KeyEvent e) {
			int keyCode = e.getKeyCode();
				if(keyCode==KeyEvent.VK_W) {
					W = false;
				}
				if(keyCode==KeyEvent.VK_S) {
					S = false;
				}
				if(keyCode==KeyEvent.VK_A) {
					A = false;
				}
				if(keyCode==KeyEvent.VK_D) {
					D = false;
				}
				if(keyCode==KeyEvent.VK_J) {
					J = false;
				}
				if(keyCode==KeyEvent.VK_K) {
					K = false;
				}
				if(keyCode==KeyEvent.VK_ENTER) {
					Enter = false;
				}
			}
	};

private static KeyAdapter k2 = new KeyAdapter() {
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
			if(keyCode==KeyEvent.VK_UP) {
				up = true;
			}
			if(keyCode==KeyEvent.VK_DOWN) {
				down = true;
			}
			if(keyCode==KeyEvent.VK_LEFT) {
				left = true;
			}
			if(keyCode==KeyEvent.VK_RIGHT) {
				right = true;
			}
			if(keyCode==KeyEvent.VK_NUMPAD0) {
				zero = true;
			}
			if(keyCode==KeyEvent.VK_NUMPAD3) {
				three = true;
			}
		}
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
			if(keyCode==KeyEvent.VK_UP) {
				up = false;
			}
			if(keyCode==KeyEvent.VK_DOWN) {
				down = false;
			}
			if(keyCode==KeyEvent.VK_LEFT) {
				left = false;
			}
			if(keyCode==KeyEvent.VK_RIGHT) {
				right = false;
			}
			if(keyCode==KeyEvent.VK_NUMPAD0) {
				zero = false;
			}
			if(keyCode==KeyEvent.VK_NUMPAD3) {
				three = false;
			}
		}
};
	
	
	public GameFrame() {
		super();
		intro = new Intro();
		//this.setUndecorated(true);
		FocusedMonitor focused = new FocusedMonitor(this);
		this.setSize(256*Main.rate+6, 224*Main.rate+35);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("�黨СħŮSFC");//SFC == SNES
		this.setFocusable(true);
		this.add(intro);
		this.addKeyListener(k1);
		this.addKeyListener(k2);
		this.setVisible(true);
		focused.start();
		tr = new Transaction();
	}
	public void gameDisplay() {
		if(Game.twoPlayer==false) {
			if(Game.mari==false) {sprite=new Sprite();this.add(sprite);}
			else {mariutzaSprite=new MariutzaSprite();this.add(mariutzaSprite);}
		}else {sprite2P=new Sprite2P();this.add(sprite2P);}
		
	}
	@SuppressWarnings("deprecation")
	public static void exitGame() {
		Main.sounds.stopBGM();
		Main.sounds.changeBGM(0);
		if(Game.twoPlayer==false) {
			if(Game.mari==false){sprite.setVisible(false);}
			else {mariutzaSprite.setVisible(false);}
		}else {sprite2P.setVisible(false);}
		Game.level.levelEnd();
		Level.nextLevel();
		Main.frame.add(tr);
		tr.setVisible(true);
		if(Game.twoPlayer==false) {
			if(Game.mari==false){
				Sprite.gt.stop();
				Sprite.spThread.stop();
			}else {MariutzaSprite.mThread.stop();
			MariutzaSprite.mSP.stop();}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void lostGame() {
		Main.sounds.changeBGM(3);
		if(Game.twoPlayer==false) {
			if(Game.mari==false){sprite.setVisible(false);}
			else {mariutzaSprite.setVisible(false);}
		}else {sprite2P.setVisible(false);}
		Main.frame.add(GameFrame.intro);
		GameFrame.intro.setVisible(true);
		Game.level.levelEnd();
		Game.korriel.clear();
		Game.mariutza.clear();
		if(Game.twoPlayer==false) {
			if(Game.mari==false){
				Sprite.gt.stop();
				Sprite.spThread.stop();
			}else {MariutzaSprite.mThread.stop();
			MariutzaSprite.mSP.stop();}
		}else {
			Sprite2P.mgt.stop();
			Sprite2P.sp2Thread.stop();
		}
	}
	public static void scoreMenu() {
		Main.sounds.stopBGM();
		Main.sounds.changeBGM(0);
		Main.frame.add(new HighestScore());
		if(Game.twoPlayer==false) {
			if(Game.mari==false){sprite.setVisible(false);}
			else {mariutzaSprite.setVisible(false);}
		}else {sprite2P.setVisible(false);}
	}

}

class FocusedMonitor extends Thread {
	private JFrame jf;
	private static boolean play = true;
	private static boolean stop = false;
	public FocusedMonitor(JFrame jf) {
		this.jf = jf;
	}
	public void run() {
		while(true){try {
			Thread.sleep(17);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(jf.isFocused()==false) {
			stop=true;
			if(Game.pause==false) {
				Game.pause = true;
				if(play==true) {
					if((Game.start==true)&&(Game.end==false)&&(Game.over==false)) {Main.sounds.play(Sound.testSound);}
			}}
			if(play==true) {
				Main.sounds.stopBGM();
				play=false;}
			GameFrame.A = false;
			GameFrame.W = false;
			GameFrame.S = false;
			GameFrame.D = false;
			GameFrame.J = false;
			GameFrame.K = false;
			GameFrame.zero = false;
			GameFrame.up = false;
			GameFrame.down = false;
			GameFrame.right = false;
			GameFrame.left = false;
			GameFrame.three = false;
	}else {play = true;
	if((Game.start==true)&&(Game.end==false)&&(Game.over==false)) {
		}else {Game.pause=false;}
	if(stop==true) {stop=false;Main.sounds.loopBGM();}
	}
		}
	}
}
