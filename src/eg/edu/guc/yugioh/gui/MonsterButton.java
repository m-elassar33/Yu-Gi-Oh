package eg.edu.guc.yugioh.gui;

import java.awt.GridLayout;

import javax.swing.JLabel;

public class MonsterButton extends CardButton{
	
	private JLabel monsterName;
	private JLabel levelplusmode;
	private JLabel attplusdef;
	
	public MonsterButton() {
		super();
		setLayout(new GridLayout(3, 1));
		monsterName = new JLabel("");
		levelplusmode=new JLabel("");
		attplusdef=new JLabel("");
		add(monsterName);
		add(levelplusmode);
		add(attplusdef);
	}

	public JLabel getMonsterName() {
		return monsterName;
	}

	public JLabel getLevelplusmode() {
		return levelplusmode;
	}

	public JLabel getAttplusdef() {
		return attplusdef;
	}
}