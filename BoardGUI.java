import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BoardGUI extends JFrame {
    
    private Container pane;
    private JPanel top, bottom;
    private JLabel player1, player2, wins1, wins2;
    private JButton[][] board;

    public BoardGUI () {

        this.setTitle("Tic-Tac-Toe");
	this.setSize(300, 300);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	player1 = new JLabel("Player 1", JLabel.CENTER);
	player2 = new JLabel("Player 2", JLabel.CENTER);
	wins1 = new JLabel("0 Wins", JLabel.CENTER);
	wins2 = new JLabel("0 Wins", JLabel.CENTER);

	top = new JPanel(new GridLayout());
	bottom = new JPanel(new GridLayout(2, 2));

	bottom.add(player1);
	bottom.add(wins1);
	bottom.add(player2);
	bottom.add(wins2);

	pane.add(top);
	pane.add(bottom);
    }

	

	
    public static void main (String[] args) {

	BoardGUI dank = new BoardGUI();
	dank.setVisible(true);

    }

}
