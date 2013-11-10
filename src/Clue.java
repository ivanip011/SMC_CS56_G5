import javax.swing.JButton;

/**
 * @author Jiahao Chen
 * CS 56 Group project
 */

public class Clue {
	private String description, respond, name;
	private int clueIndex;
	private boolean isValid;
	
	public Clue(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String desc) {
		description = desc;
	}
	
	public String getRespond() {
		return respond;
	}
	
	public void setRespond(String resp) {
		respond = resp;
	}
	
	public int getClueIndex() {
		return clueIndex;
	}
	
	public void setClueIndex(int i) {
		clueIndex = i;
	}
	
	public boolean isValid() {
		return isValid;
	}
	
	public void setValid(boolean b) {
		this.isValid = b;
	}
}
