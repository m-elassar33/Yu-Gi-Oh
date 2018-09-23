package eg.edu.guc.yugioh.gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabelsPanel extends JPanel {

	private JLabel activeName;
	private JLabel activeLF;
	private JLabel activeDeckCount;
	private JLabel opponentName;
	private JLabel opponentLF;
	private JLabel opponentDeckCount;
	
	public LabelsPanel(){
		super();
		this.setSize(new Dimension(100, 400));
		this.setLayout(new GridLayout(6, 1));
		activeName = new JLabel("ActP");
		activeLF = new JLabel("ActLF");
		activeDeckCount= new JLabel("deckA");
		opponentName = new JLabel("OppoP");
		opponentLF = new JLabel("OppLF");
		opponentDeckCount = new JLabel("deckO");
		add(opponentName);
		add(opponentLF);
		add(opponentDeckCount);
		add(activeName);
		add(activeLF);
		add(activeDeckCount);
	}

	public JLabel getActiveName() {
		return activeName;
	}

	public void setActiveName(JLabel activeName) {
		this.activeName = activeName;
	}

	public JLabel getActiveLF() {
		return activeLF;
	}

	public void setActiveLF(JLabel activeLF) {
		this.activeLF = activeLF;
	}

	public JLabel getActiveDeckCount() {
		return activeDeckCount;
	}

	public void setActiveDeckCount(JLabel activeDeckCount) {
		this.activeDeckCount = activeDeckCount;
	}

	public JLabel getOpponentName() {
		return opponentName;
	}

	public void setOpponentName(JLabel opponentName) {
		this.opponentName = opponentName;
	}

	public JLabel getOpponentLF() {
		return opponentLF;
	}

	public void setOpponentLF(JLabel opponentLF) {
		this.opponentLF = opponentLF;
	}

	public JLabel getOpponentDeckCount() {
		return opponentDeckCount;
	}

	public void setOpponentDeckCount(JLabel opponentDeckCount) {
		this.opponentDeckCount = opponentDeckCount;
	}
	
	
	
}
