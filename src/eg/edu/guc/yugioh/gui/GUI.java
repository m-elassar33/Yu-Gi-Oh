package eg.edu.guc.yugioh.gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class GUI extends JFrame{
	
	private FieldPanel fieldPanel;
	private HandPanel activePlayerHand;
	private HandPanel opponentPlayerHand;
	private LabelsPanel labelsPanel;
	private ButtonsPanel buttonsPanel;
	private AdditionalLabelsPanel additionalLabelsPanel;
	private JScrollPane x;
	private JScrollPane y;
	
	public GUI(){
		super("Yugioh");
		setSize(1280, 800);
		getContentPane().setLayout(null);
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		fieldPanel = new FieldPanel();
		activePlayerHand = new HandPanel("ActivePH");
		opponentPlayerHand = new HandPanel("OPPPH");
		labelsPanel = new LabelsPanel();
		additionalLabelsPanel=new AdditionalLabelsPanel();
		buttonsPanel = new ButtonsPanel();
		fieldPanel.setBounds(130, 155, 1000, 400);
		labelsPanel.setBounds(10, 155, 110, 400);
		buttonsPanel.setBounds(1150, 155, 100, 200);
		additionalLabelsPanel.setBounds(1150, 365, 100, 200);
		
		x=new JScrollPane(activePlayerHand);
		x.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		x.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		x.setBounds(80, 580, 1120, 110);
		getContentPane().add(x);
		
		y=new JScrollPane(opponentPlayerHand);
		y.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		y.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		y.setBounds(80, 20, 1120, 110);
		getContentPane().add(y);
		
		getContentPane().add(fieldPanel);
		getContentPane().add(labelsPanel);
		getContentPane().add(buttonsPanel);
		getContentPane().add(additionalLabelsPanel);
		this.validate();
		this.repaint();
	}
	
	public AdditionalLabelsPanel getAdditionalLabelsPanel() {
		return additionalLabelsPanel;
	}

	public void setAdditionalLabelsPanel(AdditionalLabelsPanel additionalLabelsPanel) {
		this.additionalLabelsPanel = additionalLabelsPanel;
	}
	
	public void setFieldPanel(FieldPanel fieldPanel) {
		this.fieldPanel = fieldPanel;
	}

	public void setActivePlayerHand(HandPanel activePlayerHand) {
		this.activePlayerHand = activePlayerHand;
	}

	public void setOpponentPlayerHand(HandPanel opponentPlayerHand) {
		this.opponentPlayerHand = opponentPlayerHand;
	}

	public void setLabelsPanel(LabelsPanel labelsPanel) {
		this.labelsPanel = labelsPanel;
	}

	public void setButtonsPanel(ButtonsPanel buttonsPanel) {
		this.buttonsPanel = buttonsPanel;
	}

	public FieldPanel getFieldPanel() {
		return fieldPanel;
	}

	public HandPanel getActivePlayerHand() {
		return activePlayerHand;
	}

	public HandPanel getOpponentPlayerHand() {
		return opponentPlayerHand;
	}

	public LabelsPanel getLabelsPanel() {
		return labelsPanel;
	}

	public ButtonsPanel getButtonsPanel() {
		return buttonsPanel;
	}
	
}
