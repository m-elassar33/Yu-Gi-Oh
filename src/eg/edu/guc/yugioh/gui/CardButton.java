package eg.edu.guc.yugioh.gui;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CardButton extends JButton{
	public CardButton(String name) {
		super(name);
		setPreferredSize(new Dimension(185, 85));
	}
	public CardButton() {
		super();
		setPreferredSize(new Dimension(100, 100));
	}
}