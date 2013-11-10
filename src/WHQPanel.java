import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;


//a basic image panel;

public class WHQPanel extends JPanel{

	private static final long serialVersionUID = -2967321735758471119L;

	private BufferedImage image;

	final static public int IMAGE_FIT_SIZE = 1;
	final static public int SIZE_FIT_IMAGE = 2;
	
	private int fitType = 1; // default fit type image fit size;
	public WHQPanel() {};
	
	public WHQPanel(BufferedImage img) {
		image = img;
		setSize(new Dimension(10, 10));
	}
	
	public WHQPanel(BufferedImage img,int type) {
		image = img;
		fitType = type;
		setSize(new Dimension(10, 10));
	}
	 
	public void setBackgroundImage(BufferedImage img) {
		image = img;
	}
	 
	public BufferedImage getBackgroundImage() {
		return image;
	}
	 
	public void setFitType(int type) {
		fitType = type;
	}
	 
	public int getFitType() {
		return fitType;
	}
	
	
	public void paintComponent(Graphics g) {
		if (fitType == IMAGE_FIT_SIZE) {
			g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		}
		if (fitType == SIZE_FIT_IMAGE) {
			setSize(image.getWidth(), image.getHeight());
			g.drawImage(image, 0, 0, null);
		}
		
		
	}
}
