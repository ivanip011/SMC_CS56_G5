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
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class ControllerFrame extends JFrame {

	private static final long serialVersionUID = -5125579779103493695L;

	private Rectangle originRectangle;
	private JPanel basePanel;
	
	//test for github
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ControllerFrame frame = new ControllerFrame();
		frame.setSize(960,560);
		frame.getContentPane().setLayout(null);
		frame.setBackground(Color.WHITE);
		
		int x = 680;
		int y = 470;
		
		frame.getContentPane().add(new FunctionButton(new Dimension(60, 60),new Point(x, y), FunctionButton.CLUE_BUTTON,frame));
		frame.getContentPane().add(new FunctionButton(new Dimension(60, 60),new Point(x + 70, y), FunctionButton.MAP_BUTTON,frame));
		frame.getContentPane().add(new FunctionButton(new Dimension(60, 60),new Point(x + 140, y), FunctionButton.ASSISTANT_BUTTON,frame));
		frame.getContentPane().add(new FunctionButton(new Dimension(60, 60),new Point(x + 210, y), FunctionButton.MENU_BUTTON,frame));
		
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
	
	public ControllerFrame() {
		
	}
	
	
	public void addAllComponents() {
		JLayeredPane container = getLayeredPane();
		container.setLayout(null);
		basePanel = new JPanel();
		basePanel.setBounds(0, 0, getWidth(), getHeight() - 20);
		
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
	
	
	public void functionButtonClicked(int type) {
		System.out.println("In functionButtonClicked");
		switch (type) {
		case FunctionButton.ASSISTANT_BUTTON:
			//deal with assistant panel
			System.out.println("assistant clicked");
			break;
		case FunctionButton.CLUE_BUTTON:
			//deal with clue panel
			System.out.println("clue clicked");
			break;
		case FunctionButton.MAP_BUTTON:
			//deal with mapPanel
			System.out.println("map clicked");
			break;
		case FunctionButton.MENU_BUTTON:
			//deal with menuPanel
			System.out.println("menu clicked");
			break;
		default:
			System.out.println("wrong fucntion button type");
			break;
		}
	}
	
	
	
}
