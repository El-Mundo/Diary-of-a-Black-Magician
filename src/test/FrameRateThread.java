package test;

import display.Sprite;

public class FrameRateThread extends Thread {
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Sprite.framePerSecond = Sprite.frameNumber;
			Sprite.frameNumber = 0;
		}
	}
	
}

