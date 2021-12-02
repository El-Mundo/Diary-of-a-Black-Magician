package game;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JApplet;

public class Sound extends Thread {
	private static AudioClip sound;
	private AudioClip BGM;
	public final static AudioClip testBGM = readWav("res/Music/Coo's Theme.wav");
	public final static AudioClip testSound = readWav("res/Sound/Lick.wav");
	public final static AudioClip testSound2 = readWav("res/Sound/³õÒô°¡°¡°¡.wav");
	public final static AudioClip yoshiSound = readWav("res/Sound/Lick2.wav");
	public final static AudioClip fooSound = readWav("res/Sound/podoboo.wav");
	public final static AudioClip fireballSound = readWav("res/Sound/fireball.wav");
	public final static AudioClip fireballSound2 = readWav("res/Sound/fireball2.wav");
	public final static AudioClip puruSound = readWav("res/Sound/kick.wav");
	public final static AudioClip pomSound = readWav("res/Sound/bump.wav");
	public final static AudioClip poomSound = readWav("res/Sound/super-stomp.wav");
	public final static AudioClip ringringSound = readWav("res/Sound/EBlick.wav");
	public final static AudioClip ringringSound2 = readWav("res/Sound/FBlick.wav");
	public final static AudioClip ringringSound3 = readWav("res/Sound/GBlick.wav");
	public final static AudioClip byuuSound = readWav("res/Sound/Catch.wav");
	public final static AudioClip booomSound = readWav("res/Sound/Boom.wav");
	public final static AudioClip spitSound = readWav("res/Sound/spit.wav");
	public final static AudioClip flyspitSound = readWav("res/Sound/fly-spit.wav");
	public final static AudioClip selectSound = readWav("res/Sound/health.wav");
	public final static AudioClip noSound = readWav("res/Sound/Wrong.wav");
	public final static AudioClip SMWitemSound = readWav("res/Sound/item-get.wav");
	public final static AudioClip SMWmessageSound = readWav("res/Sound/message.wav");
	public final static AudioClip YiBloob = readWav("res/Sound/Bloob.wav");
	public final static AudioClip YiRoar = readWav("res/Sound/Roar.wav");
	public final static AudioClip SMWBurb = readWav("res/Sound/Burb.wav");
	public final static AudioClip SMWPower = readWav("res/Sound/powerup.wav");
	public final static AudioClip SMWItem = readWav("res/Sound/sprout-item.wav");
	public final static AudioClip BGM1 = readWav("res/Music/09. ¤ª²è¤ÇÒ»·þ(Tea Time).wav");
	public final static AudioClip BGM2 = readWav("res/Music/02. Vampire Killer (Courtyard).wav");
	public final static AudioClip BGM3 = readWav("res/Music/12. ¥¨¥ó¥¸¥§¥ë¥Á¥ã©`¥Á(Stage 3).wav");
	public final static AudioClip BGM4 = readWav("res/Music/35 Player Select.wav");
	public final static AudioClip BGM5 = readWav("res/Music/02_Story Music Box.wav");
	public final static AudioClip BGM6 = readWav("res/Music/15 Still, the Road is Full of Dangers.wav");
	public final static AudioClip BGM7 = readWav("res/Music/19 Fight Against an Armed Boss.wav");
	
	public Sound() {
		super();
		this.BGM = testBGM;
	}
	public AudioClip getBGM() {
		return BGM;
	}
	
	public static AudioClip readWav(String path) {
		try {
			JApplet JA = new JApplet();
			File FILE = new File(path);
			URL url = FILE.toURL();
			sound = Applet.newAudioClip(url);
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
		return sound;
	}
	
	public void play(AudioClip sound) {
		sound.play();
	}

	public void loop(AudioClip sound) {
		sound.loop();
	}
	public void changeBGM(int i) {
		if(i==1) {
			this.BGM = BGM1;
		}else if(i==2) {
			this.BGM = BGM2;
		}else if(i==3) {
			this.BGM = BGM3;
		}else if(i==4) {
			this.BGM = BGM4;
		}else if(i==5) {
			this.BGM = BGM5;
		}else if(i==6) {
			this.BGM = BGM6;
		}else if(i==7) {
			this.BGM = BGM7;
		}else {this.BGM = testBGM;}
	}
	public void loopBGM() {
		this.BGM.loop();
	}
	public void stopBGM() {
		this.BGM.stop();
	}
}
