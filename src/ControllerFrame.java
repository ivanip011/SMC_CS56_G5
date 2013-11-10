import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ControllerFrame extends JFrame {

	private Rectangle originRectangle;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ControllerFrame frame = new ControllerFrame();
		frame.setSize(960,560);
		frame.getContentPane().setLayout(null);
		frame.setBackground(Color.WHITE);
		
		int x = 680;
		int y = 470;
		
		frame.getContentPane().add(new FunctionButton(new Dimension(60, 60),new Point(x, y), FunctionButton.CLUE_BUTTON));
		frame.getContentPane().add(new FunctionButton(new Dimension(60, 60),new Point(x + 70, y), FunctionButton.MAP_BUTTON));
		frame.getContentPane().add(new FunctionButton(new Dimension(60, 60),new Point(x + 140, y), FunctionButton.ASSISTANT_BUTTON));
		frame.getContentPane().add(new FunctionButton(new Dimension(60, 60),new Point(x + 210, y), FunctionButton.MENU_BUTTON));
		
		WHQPanel panel = new WHQPanel();

		try {
			panel = new WHQPanel(ImageIO.read(frame.getClass().getResource("Resource/testgraphic/test1.png")), WHQPanel.SIZE_FIT_IMAGE);
			panel.setLocation(new Point(0, 0));
			panel.setVisible(true);
			panel.setLayout(null);
			JLabel label = new JLabel("testString");
			label.setBounds(20, 20, 200, 200);
			panel.add(label);
			frame.add(panel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		
		frame.setVisible(true);
		
	}
	
	
	
	public void fullScreen() {
		originRectangle = getBounds();
		dispose();
		setUndecorated(true);
		//Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(new Dimension(1280, 720));
		setLocation(0, 40);
		setVisible(true);
		this.getGraphicsConfiguration().getDevice().setFullScreenWindow(this);
		System.out.println(this.getBounds());
	}
	
	public void exitFullScreen() {
		dispose();
		setUndecorated(false);
		setBounds(originRectangle);
		setVisible(true);
		System.out.println(this.getBounds());
	}
	
	
	
	
	
}
