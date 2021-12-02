package misc;

import java.awt.Rectangle;

import display.GameFrame;
import effects.Puff;
import effects.Puffie;
import enemy.Enemy;
import game.Game;
import game.Main;
import game.Sound;
import protagonist.*;

public class Block extends Rectangle {
	public int ax;
	public int ay;
	public double rs;
	public double ds;
	public double rx;
	public double ry;
	private static int r = Main.rate;
	
	public Block(int ax,int ay,int w,int h) {
		super();
		this.ax = ax*r;
		this.ay = ay*r;
		this.width = w*r;
		this.height = h*r;
		this.rx = this.ax - Game.screenX;
		this.ry = this.ay - Game.screenY;
		this.x = (int) this.rx;
		this.y = (int) this.ry;
		this.rs = x+width;
		this.ds = y+height;
	}
	
	public void move() {
		this.rx = this.ax - Game.screenX;
		this.ry = this.ay - Game.screenY;
		this.x = (int) this.rx;
		this.y = (int) this.ry;
		this.rs = x+width;
		this.ds = y+height;
	}
	
	public void stopMP(Korriel k, Mariutza m) {
		if(this.intersects(k.toRect())) {
			if((k.getRight()>=x)&&(k.getRight()<=x+4*r+Game.screenHSpeed)) {
				if((k.getBottom()>=y)&&(k.y+k.getRY()<=ds)){
					k.rightBlock = true;
					if(k.getHSpeed()>0) {
						k.x-=k.getHSpeed()+1.2*r;
						k.changeHSpeed(0);}
					if(Game.screenHSpeed>0) {
						k.x-=4*Game.screenHSpeed;
						}else if(Game.screenHSpeed<0) {
							k.x-=1.2*r;}
					}
				}
			if((k.x+k.getRX()<=rs)&&(k.x+k.getRX()>=rs-4*r+Game.screenHSpeed)) {
				if((k.getBottom()>=y)&&(k.y+k.getRY()<=ds)){
					k.leftBlock = true;
					if(k.getHSpeed()<0) {
						k.x-=k.getHSpeed()-1.2*r;
						k.changeHSpeed(0);}
					if(Game.screenHSpeed<0) {
						k.x-=4*Game.screenHSpeed;
						}else if(Game.screenHSpeed>0) {
							k.x+=1.2*r;}
					}
				}
			if((k.getBottom()>=y)&&(k.getBottom()<=y+5*r+Game.screenVSpeed)) {
				if((k.getRight()>=x)&&(k.x+k.getRX()<=rs)){
					k.downBlock = true;
					if(k.getVSpeed()>0) {
						k.y-=k.getVSpeed()+1.2*r;
						k.changeVSpeed(0);}
					if(Game.screenVSpeed>0) {
						k.y-=4*Game.screenVSpeed;
						}else if(Game.screenVSpeed<0) {
							k.y-=1.2*r;}
					}
				}
			if((k.y+k.getRY()<=ds)&&(k.y+k.getRY()>=ds-5*r+Game.screenVSpeed)) {
				if((k.getRight()>=x)&&(k.x+k.getRX()<=rs)){
					k.upBlock = true;
					if(k.getVSpeed()<0) {
						k.y-=k.getVSpeed()-1.2*r;
						k.changeVSpeed(0);}
					if(Game.screenVSpeed<0) {
						k.y-=4*Game.screenVSpeed;
						}else if(Game.screenVSpeed>0) {
							k.y+=1.2*r;}
					}
				}
			k.stick = true;
		}
		if(this.intersects(m.toRect())) {
			if((m.getRight()>=x)&&(m.getRight()<=x+4*r+Game.screenHSpeed)) {
				if((m.getBottom()>=y)&&(m.y+m.getRY()<=ds)){
					m.rightBlock = true;
					if(m.getHSpeed()>0) {
						m.x-=m.getHSpeed()+1.2*r;
						m.changeHSpeed(0);}
					if(Game.screenHSpeed>0) {
						m.x-=4*Game.screenHSpeed;
						}else if(Game.screenHSpeed<0) {
							m.x-=1.2*r;}
					}
				}
			if((m.x+m.getRX()<=rs)&&(m.x+m.getRX()>=rs-4*r-Game.screenHSpeed)) {
				if((m.getBottom()>=y)&&(m.y+m.getRY()<=ds)){
					m.leftBlock = true;
					if(m.getHSpeed()<0) {
						m.x-=m.getHSpeed()-1.2*r;
						m.changeHSpeed(0);}
					if(Game.screenHSpeed<0) {
						m.x-=4*Game.screenHSpeed;
						}else if(Game.screenHSpeed>0) {
							m.x+=1.2*r;}
					}
				}
			if((m.getBottom()>=y)&&(m.getBottom()<=y+5*r+Game.screenVSpeed)) {
				if((m.getRight()>=x)&&(m.x+m.getRX()<=rs)){
					m.downBlock = true;
					if(m.getVSpeed()>0) {
						m.y-=m.getVSpeed()+1.2*r;
						m.changeVSpeed(0);}
					if(Game.screenVSpeed>0) {
						m.y-=4*Game.screenVSpeed;
						}else if(Game.screenVSpeed<0) {
							m.y-=1.2*r;}
					}
				}
			if((m.y+m.getRY()<=ds)&&(m.y+m.getRY()>=ds-5*r-Game.screenVSpeed)) {
				if((m.getRight()>=x)&&(m.x+m.getRX()<=rs)){
					m.upBlock = true;
					if(m.getVSpeed()<0) {
						m.y-=m.getVSpeed()-1.2*r;
						m.changeVSpeed(0);}
					if(Game.screenVSpeed<0) {
						m.y-=4*Game.screenVSpeed;
						}else if(Game.screenVSpeed>0) {
							m.y+=1.2*r;}
					}
				}
			m.stick = true;
		}
	}
	public void stop1P(Korriel k) {
		if(this.intersects(k.toRect())) {
			if((k.getRight()>=x)&&(k.getRight()<=x+4*r+Game.screenHSpeed)) {
				if((k.getBottom()>=y)&&(k.y+k.getRY()<=ds)){
					k.rightBlock = true;
					if(k.getHSpeed()>0) {
						k.x-=k.getHSpeed()+1.2*r;
						k.changeHSpeed(0);}
					if(Game.screenHSpeed>0) {
						k.x-=4*Game.screenHSpeed;
						}else if(Game.screenHSpeed<0) {
							k.x-=1.2*r;}
					}
				}
			if((k.x+k.getRX()<=rs)&&(k.x+k.getRX()>=rs-4*r+Game.screenHSpeed)) {
				if((k.getBottom()>=y)&&(k.y+k.getRY()<=ds)){
					k.leftBlock = true;
					if(k.getHSpeed()<0) {
						k.x-=k.getHSpeed()-1.2*r;
						k.changeHSpeed(0);}
					if(Game.screenHSpeed<0) {
						k.x-=4*Game.screenHSpeed;
						}else if(Game.screenHSpeed>0) {
							k.x+=1.2*r;}
					}
				}
			if((k.getBottom()>=y)&&(k.getBottom()<=y+5*r+Game.screenVSpeed)) {
				if((k.getRight()>=x)&&(k.x+k.getRX()<=rs)){
					k.downBlock = true;
					if(k.getVSpeed()>0) {
						k.y-=k.getVSpeed()+1.2*r;
						k.changeVSpeed(0);}
					if(Game.screenVSpeed>0) {
						k.y-=4*Game.screenVSpeed;
						}else if(Game.screenVSpeed<0) {
							k.y-=1.2*r;}
					}
				}
			if((k.y+k.getRY()<=ds)&&(k.y+k.getRY()>=ds-5*r+Game.screenVSpeed)) {
				if((k.getRight()>=x)&&(k.x+k.getRX()<=rs)){
					k.upBlock = true;
					if(k.getVSpeed()<0) {
						k.y-=k.getVSpeed()-1.2*r;
						k.changeVSpeed(0);}
					if(Game.screenVSpeed<0) {
						k.y-=4*Game.screenVSpeed;
						}else if(Game.screenVSpeed>0) {
							k.y+=1.2*r;}
					}
				}
			k.stick = true;
		}
	}
	public void stop2P(Mariutza m) {
		if(this.intersects(m.toRect())) {
			if((m.getRight()>=x)&&(m.getRight()<=x+4*r+Game.screenHSpeed)) {
				if((m.getBottom()>=y)&&(m.y+m.getRY()<=ds)){
					m.rightBlock = true;
					if(m.getHSpeed()>0) {
						m.x-=m.getHSpeed()+1.2*r;
						m.changeHSpeed(0);}
					if(Game.screenHSpeed>0) {
						m.x-=4*Game.screenHSpeed;
						}else if(Game.screenHSpeed<0) {
							m.x-=1.2*r;}
					}
				}
			if((m.x+m.getRX()<=rs)&&(m.x+m.getRX()>=rs-4*r-Game.screenHSpeed)) {
				if((m.getBottom()>=y)&&(m.y+m.getRY()<=ds)){
					m.leftBlock = true;
					if(m.getHSpeed()<0) {
						m.x-=m.getHSpeed()-1.2*r;
						m.changeHSpeed(0);}
					if(Game.screenHSpeed<0) {
						m.x-=4*Game.screenHSpeed;
						}else if(Game.screenHSpeed>0) {
							m.x+=1.2*r;}
					}
				}
			if((m.getBottom()>=y)&&(m.getBottom()<=y+5*r+Game.screenVSpeed)) {
				if((m.getRight()>=x)&&(m.x+m.getRX()<=rs)){
					m.downBlock = true;
					if(m.getVSpeed()>0) {
						m.y-=m.getVSpeed()+1.2*r;
						m.changeVSpeed(0);}
					if(Game.screenVSpeed>0) {
						m.y-=4*Game.screenVSpeed;
						}else if(Game.screenVSpeed<0) {
							m.y-=1.2*r;}
					}
				}
			if((m.y+m.getRY()<=ds)&&(m.y+m.getRY()>=ds-5*r-Game.screenVSpeed)) {
				if((m.getRight()>=x)&&(m.x+m.getRX()<=rs)){
					m.upBlock = true;
					if(m.getVSpeed()<0) {
						m.y-=m.getVSpeed()-1.2*r;
						m.changeVSpeed(0);}
					if(Game.screenVSpeed<0) {
						m.y-=4*Game.screenVSpeed;
						}else if(Game.screenVSpeed>0) {
							m.y+=1.2*r;}
					}
				}
			m.stick = true;
		}
	}
	public void stopBullet(PBullet p) {
		if(this.intersects(p.toRect())) {Game.effects.add(new Puff(p.x,p.y));p.x=260*r;Main.sounds.play(Sound.pomSound);}
	}
	public void stopBullet2(P2Bullet p) {
		if(this.intersects(p.toRect())) {Game.effects.add(new Puffie(p.x,p.y));p.x=260*r;Main.sounds.play(Sound.pomSound);}
	}
	public void stopBomb(P2Bomb p) {
		if(this.intersects(p.toRect())) {Game.effects.add(new Puffie(p.x,p.y));p.x=y=265*r;Main.sounds.play(Sound.pomSound);}
	}

}
