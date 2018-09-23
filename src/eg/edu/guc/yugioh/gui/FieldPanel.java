package eg.edu.guc.yugioh.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FieldPanel extends JPanel {
	private ArrayList<MonsterButton> activeMonsterButtons;
	private ArrayList<SpellButton> activeSpellButtons;
	private ArrayList<MonsterButton> opponentMonsterButtons;
	private ArrayList<SpellButton> opponentSpellButtons;
	private CardButton activeGraveyardButton;
	private CardButton opponentGraveyardButton;
	private CardButton activeDeckButton;
	private CardButton opponentDeckButton;

	public FieldPanel() {
		super();
		this.setSize(new Dimension(600, 600));
		this.setLayout(new GridLayout(4, 6));

		activeMonsterButtons = new ArrayList<MonsterButton>();
		activeSpellButtons = new ArrayList<SpellButton>();
		opponentMonsterButtons = new ArrayList<MonsterButton>();
		opponentSpellButtons = new ArrayList<SpellButton>();
		activeGraveyardButton = new CardButton("GraveyardA");
		opponentGraveyardButton=new CardButton("GraveyardO");
		activeDeckButton= new CardButton("DeckA");
		opponentDeckButton= new CardButton("DeckO");
				
		
		for (int i = 0; i < 5; i++) {
			MonsterButton monsterButton = new MonsterButton();
			opponentMonsterButtons.add(monsterButton);
			monsterButton.setEnabled(false);
			this.add(monsterButton);
		}
		opponentGraveyardButton.setEnabled(false);
		this.add(opponentGraveyardButton);
		
		for (int i = 0; i < 5; i++) {
			SpellButton spellButton = new SpellButton("oppS");
			spellButton.setEnabled(false);
			opponentSpellButtons.add(spellButton);
			this.add(spellButton);
		}
		opponentDeckButton.setEnabled(false);
		this.add(opponentDeckButton);
		
		for (int i = 0; i < 5; i++) {
			MonsterButton monsterButton = new MonsterButton();
			activeMonsterButtons.add(monsterButton);
			this.add(monsterButton);
		}
		activeGraveyardButton.setEnabled(false);
		this.add(activeGraveyardButton);
		for (int i = 0; i < 5; i++) {
			SpellButton spellButton = new SpellButton("actS");
			activeSpellButtons.add(spellButton);
			this.add(spellButton);
		}
		activeDeckButton.setEnabled(false);
		this.add(activeDeckButton);
	}

	public ArrayList<MonsterButton> getaMonsterButtons() {
		return activeMonsterButtons;
	}

	public ArrayList<SpellButton> getaSpellButtons() {
		return activeSpellButtons;
	}

	public ArrayList<MonsterButton> getoMonsterButtons() {
		return opponentMonsterButtons;
	}

	public ArrayList<SpellButton> getoSpellButtons() {
		return opponentSpellButtons;
	}

	public ArrayList<MonsterButton> getActiveMonsterButtons() {
		return activeMonsterButtons;
	}

	public ArrayList<SpellButton> getActiveSpellButtons() {
		return activeSpellButtons;
	}

	public ArrayList<MonsterButton> getOpponentMonsterButtons() {
		return opponentMonsterButtons;
	}

	public ArrayList<SpellButton> getOpponentSpellButtons() {
		return opponentSpellButtons;
	}

	public CardButton getActiveGraveyardButton() {
		return activeGraveyardButton;
	}

	public CardButton getOpponentGraveyardButton() {
		return opponentGraveyardButton;
	}

	public CardButton getActiveDeckButton() {
		return activeDeckButton;
	}

	public CardButton getOpponentDeckButton() {
		return opponentDeckButton;
	}
	
	
	
}
