package eg.edu.guc.yugioh.gui;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class HandPanel extends JPanel {
	
	private ArrayList<CardButton> handButtons;

	public HandPanel(String name) {
		super();
		this.setLayout(new FlowLayout());
		handButtons = new ArrayList<CardButton>();	
	}

	public ArrayList<CardButton> getHandButtons() {
		return handButtons;
	}
	
	
	
}
