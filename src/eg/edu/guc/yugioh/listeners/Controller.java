package eg.edu.guc.yugioh.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Mode;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.ChangeOfHeart;
import eg.edu.guc.yugioh.cards.spells.MagePower;
import eg.edu.guc.yugioh.cards.spells.SpellCard;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;
import eg.edu.guc.yugioh.gui.CardButton;
import eg.edu.guc.yugioh.gui.GUI;

public class Controller implements ActionListener {
	private GUI gui;
	private Board board;

	public Controller(GUI gui, Board board) throws UnexpectedFormatException,
			IOException {
		this.gui = gui;
		this.board = board;
		addActionListenersToButtons();
	}

	public void updateGUI() {
		switch (board.getActivePlayer().getField().getPhase()) {
		case MAIN1:
			gui.getAdditionalLabelsPanel().getPhase().setText("Phase:MAIN1");
			break;
		case BATTLE:
			gui.getAdditionalLabelsPanel().getPhase().setText("Phase:BATTLE");
			break;
		case MAIN2:
			gui.getAdditionalLabelsPanel().getPhase().setText("Phase:MAIN2");
			break;
		}
		gui.getAdditionalLabelsPanel().getTurn()
				.setText("Turn:" + board.getActivePlayer().getName());
		gui.getLabelsPanel().getActiveName()
				.setText("Act:" + board.getActivePlayer().getName());
		gui.getLabelsPanel().getActiveLF()
				.setText("LF:" + board.getActivePlayer().getLifePoints());
		gui.getLabelsPanel()
				.getActiveDeckCount()
				.setText(
						"Deck:"
								+ board.getActivePlayer().getField().getDeck()
										.getDeck().size());
		gui.getLabelsPanel().getOpponentName()
				.setText("Opp:" + board.getOpponentPlayer().getName());
		gui.getLabelsPanel().getOpponentLF()
				.setText("LF:" + board.getOpponentPlayer().getLifePoints());
		gui.getLabelsPanel()
				.getOpponentDeckCount()
				.setText(
						"Deck:"
								+ board.getOpponentPlayer().getField()
										.getDeck().getDeck().size());
		int i = 0;
		for (; i < board.getActivePlayer().getField().getSpellArea().size(); i++) {
			if (board.getActivePlayer().getField().getSpellArea().get(i)
					.isHidden()) {
				gui.getFieldPanel()
				.getActiveSpellButtons()
				.get(i)
				.setToolTipText("Name:"+board.getActivePlayer().getField()
						.getSpellArea().get(i).getName()+" Description:"+
						board.getActivePlayer().getField()
								.getSpellArea().get(i).getDescription());
				gui.getFieldPanel().getActiveSpellButtons().get(i)
						.setEnabled(true);
				gui.getFieldPanel().getActiveSpellButtons().get(i)
						.setText("Hidden Spell");
			} else {
				gui.getFieldPanel().getActiveSpellButtons().get(i)
						.setEnabled(true);
				gui.getFieldPanel()
						.getActiveSpellButtons()
						.get(i)
						.setText(
								board.getActivePlayer().getField()
										.getSpellArea().get(i).getName());
				gui.getFieldPanel()
						.getActiveSpellButtons()
						.get(i)
						.setToolTipText(
								board.getActivePlayer().getField()
										.getSpellArea().get(i).getDescription());
			}
		}
		for (; i < 5; i++) {
			gui.getFieldPanel().getActiveSpellButtons().get(i)
					.setToolTipText("");
			gui.getFieldPanel().getActiveSpellButtons().get(i)
					.setEnabled(false);
			gui.getFieldPanel().getActiveSpellButtons().get(i)
					.setText("No Spell Here");
		}
		int a = 0;
		for (; a < board.getActivePlayer().getField().getMonstersArea().size(); a++) {
			if (board.getActivePlayer().getField().getMonstersArea().get(a)
					.isHidden()) {
				gui.getFieldPanel().getActiveMonsterButtons().get(a)
						.setToolTipText("<html>Name:"+board.getActivePlayer().getField()
								.getMonstersArea().get(a).getName()+"<br/>"+" Description:"+board.getActivePlayer().getField()
								.getMonstersArea().get(a)
								.getDescription()+"<br/>"+" Level:"+board.getActivePlayer().getField()
								.getMonstersArea().get(a).getLevel()+" AttP:"+board.getActivePlayer().getField()
								.getMonstersArea().get(a).getAttackPoints()+" Def:"+board.getActivePlayer().getField()
								.getMonstersArea().get(a).getDefensePoints()+"</html>");
				gui.getFieldPanel().getActiveMonsterButtons().get(a)
						.setEnabled(true);
				gui.getFieldPanel().getActiveMonsterButtons().get(a)
						.setText("");
				gui.getFieldPanel().getActiveMonsterButtons().get(a)
						.getMonsterName().setText("Hidden Monster");
				if (board.getActivePlayer().getField().getMonstersArea().get(a)
						.getMode() == Mode.ATTACK) {
					gui.getFieldPanel().getActiveMonsterButtons().get(a)
							.getLevelplusmode().setText(" M:Attack");
				} else {
					gui.getFieldPanel().getActiveMonsterButtons().get(a)
							.getLevelplusmode().setText(" M:Defense");
				}
				gui.getFieldPanel().getActiveMonsterButtons().get(a)
						.getAttplusdef().setText("");
			} else {
				gui.getFieldPanel()
						.getActiveMonsterButtons()
						.get(a)
						.setToolTipText(
								board.getActivePlayer().getField()
										.getMonstersArea().get(a)
										.getDescription());
				gui.getFieldPanel().getActiveMonsterButtons().get(a)
						.setEnabled(true);
				gui.getFieldPanel().getActiveMonsterButtons().get(a)
						.setText("");
				gui.getFieldPanel()
						.getActiveMonsterButtons()
						.get(a)
						.getMonsterName()
						.setText(
								board.getActivePlayer().getField()
										.getMonstersArea().get(a).getName());
				if (board.getActivePlayer().getField().getMonstersArea().get(a)
						.getMode() == Mode.ATTACK) {
					gui.getFieldPanel()
							.getActiveMonsterButtons()
							.get(a)
							.getLevelplusmode()
							.setText(
									"L:"
											+ board.getActivePlayer()
													.getField()
													.getMonstersArea().get(a)
													.getLevel() + " M:Attack");
				} else {
					gui.getFieldPanel()
							.getActiveMonsterButtons()
							.get(a)
							.getLevelplusmode()
							.setText(
									"L:"
											+ board.getActivePlayer()
													.getField()
													.getMonstersArea().get(a)
													.getLevel() + " M:Defense");
				}

				gui.getFieldPanel()
						.getActiveMonsterButtons()
						.get(a)
						.getAttplusdef()
						.setText(
								"A:"
										+ board.getActivePlayer().getField()
												.getMonstersArea().get(a)
												.getAttackPoints()
										+ " D:"
										+ board.getActivePlayer().getField()
												.getMonstersArea().get(a)
												.getDefensePoints());
			}
		}
		for (; a < 5; a++) {
			gui.getFieldPanel().getActiveMonsterButtons().get(a)
					.setToolTipText("");
			gui.getFieldPanel().getActiveMonsterButtons().get(a)
					.setEnabled(false);
			gui.getFieldPanel().getActiveMonsterButtons().get(a)
					.setText("No Monster Here");
			gui.getFieldPanel().getActiveMonsterButtons().get(a)
					.getMonsterName().setText("");
			gui.getFieldPanel().getActiveMonsterButtons().get(a)
					.getLevelplusmode().setText("");
			gui.getFieldPanel().getActiveMonsterButtons().get(a)
					.getAttplusdef().setText("");
		}
		int j = 0;
		for (; j < board.getOpponentPlayer().getField().getSpellArea().size(); j++) {
			if (board.getOpponentPlayer().getField().getSpellArea().get(j)
					.isHidden()) {
				gui.getFieldPanel().getOpponentSpellButtons().get(j)
						.setText("Hidden Spell");
				gui.getFieldPanel().getOpponentSpellButtons().get(j)
						.setToolTipText("");
			} else {
				gui.getFieldPanel()
						.getOpponentSpellButtons()
						.get(j)
						.setToolTipText(
								board.getOpponentPlayer().getField()
										.getSpellArea().get(j).getDescription());
				gui.getFieldPanel()
						.getOpponentSpellButtons()
						.get(j)
						.setText(
								board.getOpponentPlayer().getField()
										.getSpellArea().get(j).getName());
			}
		}
		for (; j < 5; j++) {
			gui.getFieldPanel().getOpponentSpellButtons().get(j)
					.setToolTipText("");
			gui.getFieldPanel().getOpponentSpellButtons().get(j)
					.setText("No Spell Here");
		}
		int b = 0;
		for (; b < board.getOpponentPlayer().getField().getMonstersArea()
				.size(); b++) {
			if (board.getOpponentPlayer().getField().getMonstersArea().get(b)
					.isHidden()) {
				gui.getFieldPanel().getOpponentMonsterButtons().get(b)
						.setText("");
				gui.getFieldPanel().getOpponentMonsterButtons().get(b)
						.setToolTipText("");
				gui.getFieldPanel().getOpponentMonsterButtons().get(b)
						.getMonsterName().setText("Hidden Monster");
				if (board.getOpponentPlayer().getField().getMonstersArea()
						.get(b).getMode() == Mode.ATTACK) {
					gui.getFieldPanel().getOpponentMonsterButtons().get(b)
							.getLevelplusmode().setText(" M:Attack");
				} else {
					gui.getFieldPanel().getOpponentMonsterButtons().get(b)
							.getLevelplusmode().setText(" M:Defense");
				}
				gui.getFieldPanel().getOpponentMonsterButtons().get(b)
						.getAttplusdef().setText("");
			} else {
				gui.getFieldPanel().getOpponentMonsterButtons().get(b)
						.setText("");
				gui.getFieldPanel()
						.getOpponentMonsterButtons()
						.get(b)
						.getMonsterName()
						.setText(
								board.getOpponentPlayer().getField()
										.getMonstersArea().get(b).getName());
				gui.getFieldPanel()
						.getOpponentMonsterButtons()
						.get(b)
						.setToolTipText(
								board.getOpponentPlayer().getField()
										.getMonstersArea().get(b)
										.getDescription());
				if (board.getOpponentPlayer().getField().getMonstersArea()
						.get(b).getMode() == Mode.ATTACK) {
					gui.getFieldPanel()
							.getOpponentMonsterButtons()
							.get(b)
							.getLevelplusmode()
							.setText(
									"L:"
											+ board.getOpponentPlayer()
													.getField()
													.getMonstersArea().get(b)
													.getLevel() + " M:Attack");
				} else {
					gui.getFieldPanel()
							.getOpponentMonsterButtons()
							.get(b)
							.getLevelplusmode()
							.setText(
									"L:"
											+ board.getOpponentPlayer()
													.getField()
													.getMonstersArea().get(b)
													.getLevel() + " M:Defense");
				}

				gui.getFieldPanel()
						.getOpponentMonsterButtons()
						.get(b)
						.getAttplusdef()
						.setText(
								"A:"
										+ board.getOpponentPlayer().getField()
												.getMonstersArea().get(b)
												.getAttackPoints()
										+ " D:"
										+ board.getOpponentPlayer().getField()
												.getMonstersArea().get(b)
												.getDefensePoints());
			}
		}
		for (; b < 5; b++) {
			gui.getFieldPanel().getOpponentMonsterButtons().get(b)
					.setToolTipText("");
			gui.getFieldPanel().getOpponentMonsterButtons().get(b)
					.setText("No Monster Here");
			gui.getFieldPanel().getOpponentMonsterButtons().get(b)
					.getMonsterName().setText("");
			gui.getFieldPanel().getOpponentMonsterButtons().get(b)
					.getLevelplusmode().setText("");
			gui.getFieldPanel().getOpponentMonsterButtons().get(b)
					.getAttplusdef().setText("");
		}
		if (board.getActivePlayer().getField().getGraveyard().size() > 0){
			gui.getFieldPanel()
					.getActiveGraveyardButton()
					.setText(
							board.getActivePlayer()
									.getField()
									.getGraveyard()
									.get(board.getActivePlayer().getField()
											.getGraveyard().size() - 1)
									.getName());
			if(board.getActivePlayer()
									.getField()
									.getGraveyard()
									.get(board.getActivePlayer().getField()
											.getGraveyard().size() - 1)instanceof MonsterCard){
				MonsterCard tuv=(MonsterCard) board.getActivePlayer()
						.getField()
						.getGraveyard()
						.get(board.getActivePlayer().getField()
								.getGraveyard().size() - 1);
				gui.getFieldPanel().getActiveGraveyardButton()
				.setToolTipText("Description:" + tuv.getDescription()
						+ " Level:" + tuv.getLevel() + " AttP:"
						+ tuv.getAttackPoints() + " DefP:"
						+ tuv.getDefensePoints());
			}
			else{
				gui.getFieldPanel().getActiveGraveyardButton()
				.setToolTipText(board.getActivePlayer()
						.getField()
						.getGraveyard()
						.get(board.getActivePlayer().getField()
								.getGraveyard().size() - 1).getDescription());
			}
		}
		else{
			gui.getFieldPanel().getActiveGraveyardButton()
			.setToolTipText("");
			gui.getFieldPanel().getActiveGraveyardButton()
					.setText("Empty Graveyard");
		}
		if (board.getOpponentPlayer().getField().getGraveyard().size() > 0) {
			gui.getFieldPanel()
					.getOpponentGraveyardButton()
					.setText(
							board.getOpponentPlayer()
									.getField()
									.getGraveyard()
									.get(board.getOpponentPlayer().getField()
											.getGraveyard().size() - 1)
									.getName());
			if (board
					.getOpponentPlayer()
					.getField()
					.getGraveyard()
					.get(board.getOpponentPlayer().getField().getGraveyard()
							.size() - 1) instanceof MonsterCard) {
				MonsterCard lmn = (MonsterCard) board
						.getOpponentPlayer()
						.getField()
						.getGraveyard()
						.get(board.getOpponentPlayer().getField()
								.getGraveyard().size() - 1);
				gui.getFieldPanel()
						.getOpponentGraveyardButton()
						.setToolTipText(
								"Description:" + lmn.getDescription()
										+ " Level:" + lmn.getLevel() + " AttP:"
										+ lmn.getAttackPoints() + " DefP:"
										+ lmn.getDefensePoints());
			} else {
				gui.getFieldPanel()
						.getOpponentGraveyardButton()
						.setToolTipText(
								board.getOpponentPlayer()
										.getField()
										.getGraveyard()
										.get(board.getOpponentPlayer()
												.getField().getGraveyard()
												.size() - 1).getDescription());
			}
		} else {
			gui.getFieldPanel().getOpponentGraveyardButton().setToolTipText("");
			gui.getFieldPanel().getOpponentGraveyardButton()
					.setText("Empty Graveyard");
		}

		gui.getOpponentPlayerHand().removeAll();
		gui.getOpponentPlayerHand().getHandButtons().clear();
		for (int k = 0; k < board.getOpponentPlayer().getField().getHand()
				.size(); k++) {
			CardButton cardButton = new CardButton("Hidden Card");
			cardButton.setEnabled(false);
			gui.getOpponentPlayerHand().getHandButtons().add(cardButton);
			gui.getOpponentPlayerHand().add(cardButton);
		}
		gui.getActivePlayerHand().removeAll();
		gui.getActivePlayerHand().getHandButtons().clear();
		for (int k = 0; k < board.getActivePlayer().getField().getHand().size(); k++) {
			CardButton cardButton = new CardButton(board.getActivePlayer()
					.getField().getHand().get(k).getName());
			if(board.getActivePlayer()
					.getField().getHand().get(k)instanceof MonsterCard){
				MonsterCard qrs=(MonsterCard) board.getActivePlayer()
						.getField().getHand().get(k);
				
				cardButton.setToolTipText("<html>Name:"+ qrs.getName()+"<br/>"+" Description:" + qrs.getDescription()+"<br/>"
						+ " Level:" + qrs.getLevel() + " AttP:"
						+ qrs.getAttackPoints() + " DefP:"
						+ qrs.getDefensePoints()+"</html>");
			}else{
				cardButton.setToolTipText(board.getActivePlayer()
					.getField().getHand().get(k).getDescription());
			}
			cardButton.addActionListener(this);
			cardButton.setActionCommand("handAction");
			gui.getActivePlayerHand().getHandButtons().add(cardButton);
			gui.getActivePlayerHand().add(cardButton);
		}
		if (board.isGameOver()) {
			int n = JOptionPane.showConfirmDialog(null,
					"Do you want to play again?", board.getWinner().getName()
							+ " has Won!", JOptionPane.YES_NO_OPTION);
			switch (n) {
			case 0:
				gui.setVisible(false);
				StartGame restart = new StartGame();
				break;
			case 1:
				gui.dispatchEvent(new WindowEvent(gui,
						WindowEvent.WINDOW_CLOSING));
				break;
			}
		}
		gui.validate();
		gui.repaint();
	}

	public void addActionListenersToButtons() {
		gui.getButtonsPanel().getTurnButton().addActionListener(this);
		gui.getButtonsPanel().getTurnButton().setActionCommand("endTurn");
		gui.getButtonsPanel().getPhaseButton().addActionListener(this);
		gui.getButtonsPanel().getPhaseButton().setActionCommand("endPhase");

		for (int i = 0; i < gui.getFieldPanel().getActiveMonsterButtons()
				.size(); i++) {
			gui.getFieldPanel().getActiveMonsterButtons().get(i)
					.addActionListener(this);
			gui.getFieldPanel().getActiveMonsterButtons().get(i)
					.setActionCommand("monsterAction");
		}
		for (int i = 0; i < gui.getFieldPanel().getActiveSpellButtons().size(); i++) {
			gui.getFieldPanel().getActiveSpellButtons().get(i)
					.addActionListener(this);
			gui.getFieldPanel().getActiveSpellButtons().get(i)
					.setActionCommand("spellAction");
		}
		for (int i = 0; i < gui.getActivePlayerHand().getHandButtons().size(); i++) {
			gui.getActivePlayerHand().getHandButtons().get(i)
					.addActionListener(this);
			gui.getActivePlayerHand().getHandButtons().get(i)
					.setActionCommand("handAction");
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("handAction")) {
			try {
				int x = gui.getActivePlayerHand().getHandButtons()
						.indexOf(e.getSource());
				if (board.getActivePlayer().getField().getHand().get(x) instanceof SpellCard) {
					String[] buttons = { "SetSpell", "ActivateSpell" };
					int n = JOptionPane.showOptionDialog(null,
							"Choose Spell Addition Type!", "",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, buttons,
							null);
					switch (n) {
					case 0:
						board.getActivePlayer().setSpell(
								(SpellCard) board.getActivePlayer().getField()
										.getHand().get(x));
						updateGUI();
						break;
					case 1:
						switch (board.getActivePlayer().getField().getHand()
								.get(x).getName()) {
						case "Change Of Heart":
							int i = -1;
							i = chooseOppMonster();
							if (i == 9) {
								JOptionPane.showMessageDialog(null, "No Monsters");
							} else {
								board.getActivePlayer().activateSpell(
										(SpellCard) board.getActivePlayer()
												.getField().getHand().get(x),
										board.getOpponentPlayer().getField()
												.getMonstersArea().get(i));
							}
							updateGUI();
							break;
						case "Mage Power":
							int j = -1;
							j = chooseActMonster();
							if (j == 9) {
								JOptionPane.showMessageDialog(null, "No Monsters");
							} else {
								board.getActivePlayer().activateSpell(
										(SpellCard) board.getActivePlayer()
												.getField().getHand().get(x),
										board.getActivePlayer().getField()
												.getMonstersArea().get(j));
							}
							updateGUI();
							break;
						case "Monster Reborn":
							boolean flag=true;
						for(int t =0;t<board.getActivePlayer().getField().getGraveyard().size();t++){
							if(board.getActivePlayer().getField().getGraveyard().get(t)instanceof MonsterCard)
								flag=false;
						}
						for(int v =0;v<board.getOpponentPlayer().getField().getGraveyard().size();v++){
							if(board.getOpponentPlayer().getField().getGraveyard().get(v)instanceof MonsterCard)
								flag=false;
						}
						
						if(flag)
							JOptionPane.showMessageDialog(null, "No Monsters");
						else
							board.getActivePlayer().activateSpell(
									(SpellCard) board.getActivePlayer()
											.getField().getHand().get(x), null);
							updateGUI();
							break;
						default:
							board.getActivePlayer().activateSpell(
									(SpellCard) board.getActivePlayer()
											.getField().getHand().get(x), null);
							updateGUI();
							break;
						}
					}
				} else {
					if (board.getActivePlayer().getField().getHand().get(x) instanceof MonsterCard) {
						String[] buttons = { "Summon Monster", "SetMonster" };
						int n = JOptionPane.showOptionDialog(null,
								"Choose monster addition type!", "",
								JOptionPane.DEFAULT_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null, buttons,
								null);
						MonsterCard temp = (MonsterCard) board
								.getActivePlayer().getField().getHand().get(x);
						switch (n) {
						case 0:
							if (temp.getLevel() <= 4) {
								board.getActivePlayer().summonMonster(
										(MonsterCard) board.getActivePlayer()
												.getField().getHand().get(x));
								updateGUI();
							} else {
								String[] buttons1 = { "One", "TWO" };
								int n1 = JOptionPane.showOptionDialog(null,
										"Choose number of sacrifices!", "",
										JOptionPane.DEFAULT_OPTION,
										JOptionPane.INFORMATION_MESSAGE, null,
										buttons1, null);
								switch (n1) {
								case 0:
									MonsterCard abc = (MonsterCard) board
											.getActivePlayer().getField()
											.getHand().get(x);
									if (!(abc.getLevel() == 5 || abc.getLevel() == 6)) {
										JOptionPane.showMessageDialog(null,
												"Wrong Number Of Sacrifices!");
									} else {
										if (board.getActivePlayer().getField()
												.getMonstersArea().size() == 0)
											JOptionPane
													.showMessageDialog(null,
															"Your Monsters Aren't Enough");
										else {
											int i = -1;
											i = chooseActMonster();
											ArrayList<MonsterCard> sacrifices = new ArrayList<MonsterCard>();
											sacrifices.add(board
													.getActivePlayer()
													.getField()
													.getMonstersArea().get(i));
											board.getActivePlayer()
													.summonMonster(
															(MonsterCard) board
																	.getActivePlayer()
																	.getField()
																	.getHand()
																	.get(x),
															sacrifices);

											updateGUI();
										}
									}
									break;
								case 1:
									MonsterCard xyz = (MonsterCard) board
											.getActivePlayer().getField()
											.getHand().get(x);
									if (!(xyz.getLevel() == 8 || xyz.getLevel() == 7)) {
										JOptionPane.showMessageDialog(null,
												"Wrong Number Of Sacrifices!");
									} else {
										if (board.getActivePlayer().getField()
												.getMonstersArea().size() < 2)
											JOptionPane
													.showMessageDialog(null,
															"Your Monsters Aren't Enough!");
										else {
											int j = -1;
											j = chooseActMonster();
											ArrayList<MonsterCard> sacrifices2 = new ArrayList<MonsterCard>();
											sacrifices2.add(board
													.getActivePlayer()
													.getField()
													.getMonstersArea().get(j));
											int k = -1;
											k = chooseActMonster();
											sacrifices2.add(board
													.getActivePlayer()
													.getField()
													.getMonstersArea().get(k));
											if (sacrifices2.get(0) == sacrifices2
													.get(1))
												JOptionPane
														.showMessageDialog(
																null,
																"You Cannot Sacrifice A Monster Twice!");
											else {
												board.getActivePlayer()
														.summonMonster(
																(MonsterCard) board
																		.getActivePlayer()
																		.getField()
																		.getHand()
																		.get(x),
																sacrifices2);
												updateGUI();
											}
										}
									}
									break;
								}

							}
							break;
						case 1:
							if (temp.getLevel() <= 4) {
								board.getActivePlayer().setMonster(
										(MonsterCard) board.getActivePlayer()
												.getField().getHand().get(x));
								updateGUI();
							} else {
								String[] buttons1 = { "One", "TWO" };
								int n1 = JOptionPane.showOptionDialog(null,
										"Choose number of sacrifices!", "",
										JOptionPane.DEFAULT_OPTION,
										JOptionPane.INFORMATION_MESSAGE, null,
										buttons1, null);
								switch (n1) {
								case 0:
									MonsterCard abc = (MonsterCard) board
											.getActivePlayer().getField()
											.getHand().get(x);
									if (!(abc.getLevel() == 5 || abc.getLevel() == 6)) {
										JOptionPane.showMessageDialog(null,
												"Wrong Number Of Sacrifices!");
									} else {
										if (board.getActivePlayer().getField()
												.getMonstersArea().size() == 0)
											JOptionPane
													.showMessageDialog(null,
															"Your Monsters Aren't Enough");
										else {
											int i = -1;
											i = chooseActMonster();
											ArrayList<MonsterCard> sacrifices = new ArrayList<MonsterCard>();
											sacrifices.add(board
													.getActivePlayer()
													.getField()
													.getMonstersArea().get(i));
											board.getActivePlayer().setMonster(
													(MonsterCard) board
															.getActivePlayer()
															.getField()
															.getHand().get(x),
													sacrifices);

											updateGUI();
										}
									}
									break;
								case 1:
									MonsterCard xyz = (MonsterCard) board
											.getActivePlayer().getField()
											.getHand().get(x);
									if (!(xyz.getLevel() == 8 || xyz.getLevel() == 7)) {
										JOptionPane.showMessageDialog(null,
												"Wrong Number Of Sacrifices!");
									} else {
										if (board.getActivePlayer().getField()
												.getMonstersArea().size() < 2)
											JOptionPane
													.showMessageDialog(null,
															"Your Monsters Aren't Enough!");
										else {
											int j = -1;
											j = chooseActMonster();
											ArrayList<MonsterCard> sacrifices2 = new ArrayList<MonsterCard>();
											sacrifices2.add(board
													.getActivePlayer()
													.getField()
													.getMonstersArea().get(j));
											int k = -1;
											k = chooseActMonster();
											sacrifices2.add(board
													.getActivePlayer()
													.getField()
													.getMonstersArea().get(k));
											if (sacrifices2.get(0) == sacrifices2
													.get(1))
												JOptionPane
														.showMessageDialog(
																null,
																"You Cannot Sacrifice A Monster Twice!");
											else {
												board.getActivePlayer()
														.setMonster(
																(MonsterCard) board
																		.getActivePlayer()
																		.getField()
																		.getHand()
																		.get(x),
																sacrifices2);
												updateGUI();
											}
										}
									}
									break;
								}
							}
							break;
						}
					}
				}
			} catch (RuntimeException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}

		if (e.getActionCommand().equals("spellAction")) {
			try {
				int x = gui.getFieldPanel().getActiveSpellButtons()
						.indexOf(e.getSource());
				switch (board.getActivePlayer().getField().getSpellArea()
						.get(x).getName()) {
				case "Change Of Heart":
					int i = -1;
					i = chooseOppMonster();
					if (i == 9) {
					JOptionPane.showMessageDialog(null, "No Monsters");
					} else {
						board.getActivePlayer().activateSpell(
								board.getActivePlayer().getField()
										.getSpellArea().get(x),
								board.getOpponentPlayer().getField()
										.getMonstersArea().get(i));
					}
					updateGUI();
					break;
				case "Mage Power":
					int j = -1;
					j = chooseActMonster();
					if (j == 9) {
						JOptionPane.showMessageDialog(null, "No Monsters");
					} else {
						board.getActivePlayer().activateSpell(
								board.getActivePlayer().getField()
										.getSpellArea().get(x),
								board.getActivePlayer().getField()
										.getMonstersArea().get(j));
					}
					updateGUI();
					break;
				case "Monster Reborn":
					boolean flag=true;
				for(int t =0;t<board.getActivePlayer().getField().getGraveyard().size();t++){
					if(board.getActivePlayer().getField().getGraveyard().get(t)instanceof MonsterCard)
						flag=false;
				}
				for(int v =0;v<board.getOpponentPlayer().getField().getGraveyard().size();v++){
					if(board.getOpponentPlayer().getField().getGraveyard().get(v)instanceof MonsterCard)
						flag=false;
				}
				
				if(flag)
					JOptionPane.showMessageDialog(null, "No Monsters");
				else
					board.getActivePlayer().activateSpell(
							board.getActivePlayer().getField().getSpellArea()
									.get(x), null);
					updateGUI();
					break;
				default:
					board.getActivePlayer().activateSpell(
							board.getActivePlayer().getField().getSpellArea()
									.get(x), null);
					updateGUI();
					break;
				}
			} catch (RuntimeException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
		if (e.getActionCommand().equals("endTurn")) {
			try {
				board.getActivePlayer().endTurn();
				updateGUI();
			} catch (RuntimeException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
		if (e.getActionCommand().equals("endPhase")) {
			try {
				board.getActivePlayer().endPhase();
				updateGUI();
			} catch (RuntimeException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
		if (e.getActionCommand().equals("monsterAction")) {
			try {
				int x = gui.getFieldPanel().getActiveMonsterButtons()
						.indexOf(e.getSource());
				String[] buttons = { "Switch Mode", "Attack" };
				int n = JOptionPane.showOptionDialog(null,
						"Choose monster action!", "",
						JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null, buttons, null);
				switch (n) {
				case 0:
					board.getActivePlayer().switchMonsterMode(
							board.getActivePlayer().getField()
									.getMonstersArea().get(x));
					updateGUI();
					break;
				case 1:
					if (board.getOpponentPlayer().getField().getMonstersArea()
							.size() == 0) {
						board.getActivePlayer().declareAttack(
								board.getActivePlayer().getField()
										.getMonstersArea().get(x));
						updateGUI();
					} else {
						int i = -1;
						i = chooseOppMonster();
						board.getActivePlayer().declareAttack(
								board.getActivePlayer().getField()
										.getMonstersArea().get(x),
								board.getOpponentPlayer().getField()
										.getMonstersArea().get(i));
						updateGUI();
					}
					break;
				}
			} catch (RuntimeException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
	}

	public int chooseOppMonster() {
		String i = "9";
		switch (board.getOpponentPlayer().getField().getMonstersArea().size()) {
		case 1:
			String[] names1 = new String[1];
			for (int x = 0; x < board.getOpponentPlayer().getField()
					.getMonstersArea().size(); x++) {
				if (board.getOpponentPlayer().getField().getMonstersArea()
						.get(x).isHidden())
					names1[x] = x + "Hidden Monster";
				else
					names1[x] = x
							+ board.getOpponentPlayer().getField()
									.getMonstersArea().get(x).getName();
			}
			i = (String) JOptionPane.showInputDialog(null, "Choose a monster",
					"", JOptionPane.INFORMATION_MESSAGE, null, names1, null);
			break;
		case 2:
			String[] names2 = new String[2];
			for (int x = 0; x < board.getOpponentPlayer().getField()
					.getMonstersArea().size(); x++) {
				if (board.getOpponentPlayer().getField().getMonstersArea()
						.get(x).isHidden())
					names2[x] = x + "Hidden Monster";
				else
					names2[x] = x
							+ board.getOpponentPlayer().getField()
									.getMonstersArea().get(x).getName();
			}
			i = (String) JOptionPane.showInputDialog(null, "Choose a monster",
					"", JOptionPane.INFORMATION_MESSAGE, null, names2, null);
			break;
		case 3:
			String[] names3 = new String[3];
			for (int x = 0; x < board.getOpponentPlayer().getField()
					.getMonstersArea().size(); x++) {
				if (board.getOpponentPlayer().getField().getMonstersArea()
						.get(x).isHidden())
					names3[x] = x + "Hidden Monster";
				else
					names3[x] = x
							+ board.getOpponentPlayer().getField()
									.getMonstersArea().get(x).getName();
			}
			i = (String) JOptionPane.showInputDialog(null, "Choose a monster",
					"", JOptionPane.INFORMATION_MESSAGE, null, names3, null);
			break;
		case 4:
			String[] names4 = new String[4];
			for (int x = 0; x < board.getOpponentPlayer().getField()
					.getMonstersArea().size(); x++) {
				if (board.getOpponentPlayer().getField().getMonstersArea()
						.get(x).isHidden())
					names4[x] = x + "Hidden Monster";
				else
					names4[x] = x
							+ board.getOpponentPlayer().getField()
									.getMonstersArea().get(x).getName();
			}
			i = (String) JOptionPane.showInputDialog(null, "Choose a monster",
					"", JOptionPane.INFORMATION_MESSAGE, null, names4, null);
			break;
		case 5:
			String[] names5 = new String[5];
			for (int x = 0; x < board.getOpponentPlayer().getField()
					.getMonstersArea().size(); x++) {
				if (board.getOpponentPlayer().getField().getMonstersArea()
						.get(x).isHidden())
					names5[x] = x + "Hidden Monster";
				else
					names5[x] = x
							+ board.getOpponentPlayer().getField()
									.getMonstersArea().get(x).getName();
			}
			i = (String) JOptionPane.showInputDialog(null, "Choose a monster",
					"", JOptionPane.INFORMATION_MESSAGE, null, names5, null);
			break;
		}
		return Integer.parseInt(i.charAt(0) + "");
	}

	public int chooseActMonster() {
		String i = "9";
		switch (board.getActivePlayer().getField().getMonstersArea().size()) {
		case 1:
			String[] names1 = { "0"
					+ board.getActivePlayer().getField().getMonstersArea()
							.get(0).getName() };
			i = (String) JOptionPane.showInputDialog(null, "Choose a monster",
					"", JOptionPane.INFORMATION_MESSAGE, null, names1, null);
			break;
		case 2:
			String[] names2 = {
					"0"
							+ board.getActivePlayer().getField()
									.getMonstersArea().get(0).getName(),
					"1"
							+ board.getActivePlayer().getField()
									.getMonstersArea().get(1).getName() };
			i = (String) JOptionPane.showInputDialog(null, "Choose a monster",
					"", JOptionPane.INFORMATION_MESSAGE, null, names2, null);
			break;
		case 3:
			String[] names3 = {
					"0"
							+ board.getActivePlayer().getField()
									.getMonstersArea().get(0).getName(),
					"1"
							+ board.getActivePlayer().getField()
									.getMonstersArea().get(1).getName(),
					"2"
							+ board.getActivePlayer().getField()
									.getMonstersArea().get(2).getName() };
			i = (String) JOptionPane.showInputDialog(null, "Choose a monster",
					"", JOptionPane.INFORMATION_MESSAGE, null, names3, null);
			break;
		case 4:
			String[] names4 = {
					"0"
							+ board.getActivePlayer().getField()
									.getMonstersArea().get(0).getName(),
					"1"
							+ board.getActivePlayer().getField()
									.getMonstersArea().get(1).getName(),
					"2"
							+ board.getActivePlayer().getField()
									.getMonstersArea().get(2).getName(),
					"3"
							+ board.getActivePlayer().getField()
									.getMonstersArea().get(3).getName() };
			i = (String) JOptionPane.showInputDialog(null, "Choose a monster",
					"", JOptionPane.INFORMATION_MESSAGE, null, names4, null);
			break;
		case 5:
			String[] names5 = {
					"0"
							+ board.getActivePlayer().getField()
									.getMonstersArea().get(0).getName(),
					"1"
							+ board.getActivePlayer().getField()
									.getMonstersArea().get(1).getName(),
					"2"
							+ board.getActivePlayer().getField()
									.getMonstersArea().get(2).getName(),
					"3"
							+ board.getActivePlayer().getField()
									.getMonstersArea().get(3).getName(),
					"4"
							+ board.getActivePlayer().getField()
									.getMonstersArea().get(4).getName() };
			i = (String) JOptionPane.showInputDialog(null, "Choose a monster",
					"", JOptionPane.INFORMATION_MESSAGE, null, names5, null);
			break;
		}
		return Integer.parseInt(i.charAt(0) + "");
	}
}
