import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class StartupGUI extends JFrame {

    private Container pane;
    private JPanel top, mid, bot;
    private JLabel title, playerNames, gameMode, size;
    private JButton start;
    private JTextField playerX, playerO;
    private JComboBox selectGameMode, selectSize;

    public StartupGUI () {

	this.setTitle("Ultimate Tic-Tac-Toe");
	this.setSize(400, 400);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	title = new JLabel("Ultimate Tic-Tac-Toe", JLabel.CENTER);
	title.setFont(new Font("Arial", Font.BOLD, 60));
	playerNames = new JLabel("Player Names", JLabel.CENTER);
	gameMode = new JLabel("Game Mode", JLabel.CENTER);
	size = new JLabel("Size", JLabel.CENTER);

	JTextField playerX = new JTextField("Player 1");
	JTextField playerO = new JTextField("Player 2");

	String[] gameModeAry = { "Standard" };
	selectGameMode = new JComboBox(gameModeAry);
	String[] sizeAry = { "3 X 3" };
	selectSize = new JComboBox(sizeAry);
	

	top = new JPanel(new GridLayout(1, 3));
	mid = new JPanel(new GridLayout(1, 2));
	bot = new JPanel(new GridLayout(1, 2));

	top.add(playerNames);
	top.add(playerX);
	top.add(playerO);

	mid.add(gameMode);
	mid.add(selectGameMode);

	bot.add(size);
	bot.add(selectSize);

	pane.add(title);
	pane.add(top);
	pane.add(mid);
	pane.add(bot);
	pane.add(start);

    }

    public static void main (String[] args) {

	StartupGUI dank = new StartupGUI();
	dank.setVisible(true);

    }

}
