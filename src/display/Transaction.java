package display;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import game.Game;
import game.Main;
import misc.Save;

public class Transaction extends JPanel {
	private boolean over;
	private int i;
	public Transaction() {
		this.setBackground(Color.black);
		i=0;
	}
	public void paint(Graphics g) {
		super.paint(g);
		try {
			Thread.sleep(17);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i==1) {
			if(Game.levelNumber-1>Main.save[1]) {
				Main.save[1] = Game.levelNumber-1;
				Save.writeSav(Main.save);
			}
		}
		i++;
		if(i==80) {
			GameFrame.game = new Game();
			Main.frame.gameDisplay();
			this.setVisible(false);
			Main.frame.remove(this);
		}

		this.repaint();
	}
}
