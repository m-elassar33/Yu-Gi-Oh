package eg.edu.guc.yugioh.gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdditionalLabelsPanel extends JPanel {

	private JLabel phase;
	private JLabel turn;
	
	
	public AdditionalLabelsPanel(){
		super();
		this.setSize(new Dimension(100, 400));
		this.setLayout(new GridLayout(2, 1));
		phase = new JLabel("phase");
		turn = new JLabel("turn");
		add(phase);
		add(turn);
	}


	public JLabel getPhase() {
		return phase;
	}


	public void setPhase(JLabel phase) {
		this.phase = phase;
	}


	public JLabel getTurn() {
		return turn;
	}


	public void setTurn(JLabel turn) {
		this.turn = turn;
	}
	
	
	
}
