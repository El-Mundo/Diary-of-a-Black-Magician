package enemy;

import game.Game;

public class InfiniteFire extends Enemy {
	public InfiniteFire(int y) {
		super(256, y, 0, 0, 20, 20, 20, 20, 4);
	}
	
	public void move() {
		if(immune>0) {immune--;}
		frames++;
		x-=Game.screenHSpeed;
		if((x>266*r)||(x<-10*r-this.w)||(y>236*r)||(y<-10*r-this.h)) {Game.enemies.remove(this);}
	}

}
