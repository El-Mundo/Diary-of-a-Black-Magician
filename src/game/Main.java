package game;

import display.GameFrame;
import misc.Save;

/* 1. Level changing (Story mode)
   2. Double layers background
   3. Multiple threads *
   4. Multiple controllable characters *
   5. Multiple players *
   6. HP display 
   7. Move when coming across *
   */

public class Main {
	public static int rate = 2;
	public static GameFrame frame;
	public static Sound sounds = new Sound();
	public static int[] save;
	public static void main(String args[]) {
		save = Save.readSav();
		rate = save[0];
		frame = new GameFrame();
		sounds.start();
	}

}
