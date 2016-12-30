import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BoardGUI extends JFrame {
    
    private Container pane;
    private JPanel top, bottom, bottomLeft, bottomRight;
    private JLabel player1, player2, wins1, wins2, whosTurn;
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
	whosTurn = new JLabel("<<<<<<<", JLabel.CENTER);

	top = new JPanel(new GridLayout(3, 3));
	bottom = new JPanel(new GridLayout(1, 3, 50, 0));
	bottomLeft = new JPanel(new GridLayout(2, 1, 0, 5));
	bottomRight = new JPanel(new GridLayout(2, 1, 0, 5));

	bottomLeft.add(player1);
	bottomLeft.add(wins1);
	bottomRight.add(player2);
	bottomRight.add(wins2);

	bottom.add(bottomLeft);
	bottom.add(whosTurn);
	bottom.add(bottomRight);
	
	board = new JButton[3][3];
	for (int row = 0; row < board.length; row++) {
	    for (int col = 0; col < board[0].length; col++) {
		JButton button = board[row][col];
	        button = new JButton("");
		button.setVisible(true);
		//button.addActionListener(this);
		top.add(button);
	    }
	}

	pane.add(top);
	pane.add(bottom);
    }

	

	
    public static void main (String[] args) {

	BoardGUI dank = new BoardGUI();
	dank.setVisible(true);

    }

}
