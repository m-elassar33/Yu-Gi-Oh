package eg.edu.guc.yugioh.gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonsPanel extends JPanel {

	private JButton phaseButton;
	private JButton turnButton;
	
	public ButtonsPanel() {
		super();
		this.setSize(new Dimension(100, 400));
		this.setLayout(new GridLayout(2, 1));
		
		phaseButton=new JButton("endPhase");
		turnButton = new JButton("endTurn");
		
		add(phaseButton);
		add(turnButton);
	}

	public JButton getPhaseButton() {
		return phaseButton;
	}

	public JButton getTurnButton() {
		return turnButton;
	}

	
	
}
