import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BoardGUI extends JFrame {
    
    private JPanel top, bottom, mainPanel;
    private JLabel player1, player2, wins1, wins2;
    private JButton[][] board;

    public BoardGUI () {

	mainPanel = new JPanel(new BoxLayout());
	mainPanel.setSize(300, 300);
	mainPanel.setDefaultCloseOperation(EXIT_ON_CLOSE);

	player1 = new JLabel("Player 1", JLabel.CENTER);
	player2 = new JLabel("Player 2", JLabel.CENTER);
	wins1 = new JLabel("0 Wins", JLabel.CENTER);
	wins2 = new JLabel("0 Wins", JLabel.CENTER);

	top = new JPanel(new FlowLayout());
	top.setPreferredSize(new Dimension(100,100));
	bottom = new JPanel(new FlowLayout());

	//top.add(player1);

	mainPanel.add(top);
    }

	

	
    public static void main (String[] args) {

	BoardGUI dank = new BoardGUI();
	dank.setVisible(true);

    }

}
