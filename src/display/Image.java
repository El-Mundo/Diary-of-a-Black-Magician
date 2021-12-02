package display;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Main;

public class Image extends JLabel{
    private static BufferedImage image;
    private BufferedImage imageLabel;
    public final static BufferedImage clouds = readImage("res/Background/Layer2/Clouds.png");
    public final static BufferedImage cloudie = readImage("res/Tiles/cloudBlock.png");
    public final static BufferedImage skyBlue = readImage("res/Background/skyBlue.png");
    public final static BufferedImage zhujue = readImage("res/Effects/»À∂˘.png");
    public final static BufferedImage zhujueer = readImage("res/Effects/»À»À.png");
    
	public static BufferedImage readImage(String path) {
	        try{
	        	image = ImageIO.read(new File(path));}
	        catch(IOException e){e.printStackTrace();}
	        return image;
	}
	
	public Image(JPanel jp, String path) {
		this.imageLabel = readImage(path);
		jp.add(this);
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(imageLabel, 0, 0, 256*Main.rate, 224*Main.rate, this);
	}

}
