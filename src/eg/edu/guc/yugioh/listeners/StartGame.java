package eg.edu.guc.yugioh.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;
import eg.edu.guc.yugioh.gui.GUI;

public class StartGame extends JFrame 
implements ActionListener 
{
	
	JLabel p1;
	JLabel p2;
	JTextField player1;
	JTextField player2;
	JButton start;

	public StartGame() {
		super("YugiohStartGame");
		getContentPane().setLayout(null);
		setBounds(200, 0, 800, 800);
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p1=new JLabel("Player1 Name:");
		p2=new JLabel("Player2 Name:");
		player1=new JTextField();
		player2=new JTextField();
		start=new JButton("Start");
		p1.setBounds(300, 130, 100, 40);
		p2.setBounds(300, 300, 100, 40);
		player1.setBounds(300, 200, 200, 40);
		player2.setBounds(300, 370, 200, 40);
		start.setBounds(300, 500, 200, 40);
		start.addActionListener(this);
		start.setActionCommand("StartGame");
		getContentPane().add(p1);
		getContentPane().add(p2);
		getContentPane().
		add(player1);
		getContentPane().
		add(player2);
		getContentPane().
		add(start);
		this.validate();
		this.repaint();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("StartGame")){
			GUI gui=new GUI();
			Board board = new Board();
			try {
				setVisible(false);
				Player first=new Player(player1.getText());
				Player second=new Player(player2.getText());
				board.startGame(first, second);
				Controller controller=new Controller(gui, board);
				controller.updateGUI();				
			} catch (IOException | UnexpectedFormatException e1) {
			}
		}
	}

}
