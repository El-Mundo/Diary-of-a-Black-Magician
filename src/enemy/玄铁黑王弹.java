package enemy;

import game.Game;
import game.Main;
import game.Sound;

public class ÐþÌúºÚÍõµ¯ extends Enemy {
	
	public ÐþÌúºÚÍõµ¯(int x, int y,double h) {
		super(x,y,0,0,10,10,10,10,999999);
		if(h>0) {hSpeed=3*r;}else {hSpeed=-3*r;}
	}
	public void move() {
		if(immune>0) {immune--;}
		frames++;
		x+=hSpeed;
		if((x>266*r)||(x<-10*r-this.w)||(y>236*r)||(y<-10*r-this.h)) {Game.enemies.remove(this);}
	}
	public void damage() {
		hp+=10;
	}

}
