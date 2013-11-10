import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class FunctionButton extends JButton implements MouseListener{
	
	private BufferedImage image_normal;
	private BufferedImage image_selected;
	private Point orignalLocation;
	private Point scaledLocation;
	final private float scaleSizeChange = -0.2f;
	
	private int buttonType;
	final static public int CLUE_BUTTON = 1;
	final static public int MAP_BUTTON = 2;
	final static public int ASSISTANT_BUTTON = 3;
	final static public int MENU_BUTTON = 4;
	
	final private int NORMAL = 1;
	final private int SELECTED = 2;
	final private int SCALED = 3;
	
	public FunctionButton(Dimension size,Point locationPoint,int type) {
		// TODO Auto-generated constructor stub
		setBorderPainted(false);
		setSize(size);
		setLocation(locationPoint);
		buttonType = type;
		assignImages();
		addMouseListener(this);
		setImageIconAndPosition(NORMAL);
	}
	
	
	
	private void assignImages() {
		switch (buttonType) {
		case CLUE_BUTTON:
			try {
				image_normal = ImageIO.read(getClass().getResource("Resource/Function_Button/clueButtonNormal.png"));
				image_selected = ImageIO.read(getClass().getResource("Resource/Function_Button/clueButtonSelected.png"));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
			
		case MAP_BUTTON:
			try {
				image_normal = ImageIO.read(getClass().getResource("Resource/Function_Button/mapButtonNormal.png"));
				image_selected = ImageIO.read(getClass().getResource("Resource/Function_Button/mapButtonSelected.png"));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;
			
		case ASSISTANT_BUTTON:
			try {
				image_normal = ImageIO.read(getClass().getResource("Resource/Function_Button/assistantButtonNormal.png"));
				image_selected = ImageIO.read(getClass().getResource("Resource/Function_Button/assistantButtonSelected.png"));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;

		case MENU_BUTTON:
			try {
				image_normal = ImageIO.read(getClass().getResource("Resource/Function_Button/menuButtonNormal.png"));
				image_selected = ImageIO.read(getClass().getResource("Resource/Function_Button/menuButtonSelected.png"));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			break;

		default:
			System.out.println("wrong button type");
			break;
		}
	}

	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(this + " mouseCliecked");
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(this + " mouseEntered");
		setImageIconAndPosition(SELECTED);
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(this + " mouseExited");
		setImageIconAndPosition(NORMAL);
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(this + " mousePressed");
		setImageIconAndPosition(SCALED);
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(this + " mouseReleased");
		setImageIconAndPosition(SELECTED);
	}
	
	
	public String toString() {
		switch (buttonType) {
		case MENU_BUTTON:
			return "MENU_BUTTON";
		case MAP_BUTTON:
			return "MAP_BUTTON";
		case ASSISTANT_BUTTON:
			return "ASSISTANT_BUTTON";
		case CLUE_BUTTON:
			return "CLUE_BUTTON";
		default:
			return "wrong button type";
		}
	}
	
	public void setImageIconAndPosition(int state) {
		ImageIcon icon;
		if (state == NORMAL) {
			icon = new ImageIcon(image_normal.getScaledInstance(getWidth(), getHeight(),Image.SCALE_SMOOTH));
			setIcon(icon);
		}
		else if (state == SELECTED) {
			icon = new ImageIcon(image_selected.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH));
			setIcon(icon);
		}
		else if (state == SCALED) {
			icon = new ImageIcon(image_selected.getScaledInstance((int)(getWidth() * (1 + scaleSizeChange)), (int)(getHeight() * (1 + scaleSizeChange)), Image.SCALE_SMOOTH));
			setIcon(icon);
		}
	}
	
	
}
