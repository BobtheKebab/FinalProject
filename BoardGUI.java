import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BoardGUI extends JFrame implements ActionListener {
    
    public static Container pane;
    private JPanel top, bottom, bottomLeft, bottomRight;
    private JLabel player1, player2, wins1, wins2;
    public static JLabel whosTurn;
    public static JButton[][] buttons;

    public BoardGUI (int size, String p1, String p2) {

        this.setTitle("Tic-Tac-Toe");
	this.setSize(800, 825);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	player1 = new JLabel(p1 + " (X)", JLabel.CENTER);
	player2 = new JLabel(p2 + " (O)", JLabel.CENTER);
	wins1 = new JLabel("0 Wins", JLabel.CENTER);
	wins2 = new JLabel("0 Wins", JLabel.CENTER);
	whosTurn = new JLabel("<======", JLabel.CENTER);
	whosTurn.setFont(new Font("Arial", Font.BOLD, 40));

	top = new JPanel(new GridLayout(size, size));
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
	
	buttons = new JButton[size][size];
	int num = 0;
	for (int row = 0; row < buttons.length; row++) {
	    for (int col = 0; col < buttons[0].length; col++) {
	        JButton button = new JButton("");
		buttons[row][col] = button;
		button.setPreferredSize(new Dimension(700 / size, 700 / size));
		button.setVisible(true);
		button.addActionListener(this);
		button.setActionCommand("" + num);
		num++;
		top.add(button);
	    }
	}

	pane.add(top);
	pane.add(bottom);
    }

    /*
    public BoardGUI (int size, String p1, String p2) {
	BoardGUI();
	buttons = new JButton[size][size];
	for (JButton[] dank : buttons) {
	    for (JButton button : dank) {
		button.setPreferredSize(new Dimension(600 / size, 600 / size));
	    }
	}
	player1.setText(p1);
	player2.setText(p2);
    }
    */

    public void actionPerformed (ActionEvent e) {
        String event = e.getActionCommand();
	TicTacToe.update(Integer.parseInt(event));
    }
    

    public static void main (String[] args) {

	BoardGUI dank = new BoardGUI(9, "DANK", "MEMES");
	dank.setVisible(true);

    }

}
