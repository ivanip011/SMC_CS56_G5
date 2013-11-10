import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author Jiahao Chen
 * CS 56 Group project
 * 
 * CluePanel class
 * ð Put a clue into the bag
 * ð Show the clues in 4x3
 * ð Take a clue out of the bag
 * ð Show the description of a clue
 */

public class CluePanel extends JPanel implements ActionListener{
	
	private ArrayList<Clue> clueList; //TODO: Allowance of duplicates? Assume no.
	private ClueBag clueBag;
	private ClueDetail clueDetail;
	private JScrollPane scroller;
	private Dimension d = new Dimension(556, 478); //TODO: Set ratio.	16:9	15 border, 20 between.
	//private ControllerFrame container;
	
	public CluePanel(/*ControllerFrame c*/) {
		//this.container = c;
		clueList = new ArrayList<Clue>();
		clueBag = new ClueBag();
		scroller = new JScrollPane(clueBag);
		scroller.setPreferredSize(d);
		this.setSize(d);
		this.add(scroller);
		this.setVisible(true);
	}
	
	public void addClue(Clue c) {
		clueList.add(c);
		JButton cb = new JButton(c.getName());
		cb.setPreferredSize(new Dimension(120, 136)); //TODO: Set ratio.
		clueBag.add(cb);
		
		//-----Adjust the width of the cluepanel. The width of a scrollbar on mac is 15.
		if(clueBag.getComponentCount() == 13) {
			this.setSize(this.getWidth() + 15, this.getHeight());
			scroller.setPreferredSize(new Dimension(scroller.getWidth() + 15, scroller.getHeight()));
		}
	}
	
	public void removeClue(Clue c) {
		int i = clueList.indexOf(c);
		if(i >= 0) {
			clueBag.remove(i); //TODO: Make sure that index in JPanel same as in ArrayList.
		}
		clueList.remove(c);
		this.revalidate();
		
		//-----Adjust the width of the cluepanel. The width of a scrollbar on mac is 15.
		if(clueBag.getComponentCount() == 12) {
			this.setSize(this.getWidth() - 15, this.getHeight());
			scroller.setPreferredSize(new Dimension(scroller.getWidth() - 15, scroller.getHeight()));
		}
	}
	
	/*
	 * Show the detail of a clue by using a clueDetail panel.
	 */
	public void showClue(Clue c) {	//Assume only called in bag view.
		//-----If already exist, no need to create a new one.
		if((clueDetail == null) || (!c.getName().equals(clueDetail.getName()))) {
			clueDetail = new ClueDetail(c);	
		}
		this.remove(scroller);
		this.revalidate();
		this.add(clueDetail);
	}
	
	public void backToPanel() {		//Assume only called in detail view.
		this.remove(clueDetail);
		this.revalidate();
		this.add(scroller);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
}

class ClueBag extends JPanel{
	
	public ClueBag() {
		this.setSize(500,1); 
		this.setBackground(Color.GREEN);   //For testing.
		this.setLayout(new WrapLayout(WrapLayout.LEFT, 14, 14));
	}
}

class ClueDetail extends JPanel{
	//TODO: Fill this out.
	private String name;
	public ClueDetail(Clue c) {
		this.name = c.getName();
	}
	
	public String getName() {
		return name;
	}
}
