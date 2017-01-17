import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class StartupGUI extends JFrame implements ActionListener {

    private Container pane;
    private JPanel top, topRight, mid, bot;
    private JLabel title, playerNames, gameMode, size;
    private JButton start;
    private JTextField playerX, playerO;
    private JComboBox selectGameMode, selectSize;

    public StartupGUI () {

	this.setTitle("Ultimate Tic-Tac-Toe");
	this.setSize(600, 600);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new GridLayout(5, 1));

	title = new JLabel("Ultimate Tic-Tac-Toe", JLabel.CENTER);
	title.setFont(new Font("Arial", Font.BOLD, 40));
	playerNames = new JLabel("Player Names", JLabel.CENTER);
	gameMode = new JLabel("Game Mode", JLabel.CENTER);
	size = new JLabel("Size", JLabel.CENTER);

	JTextField playerX = new JTextField("Player 1");
	playerX.setPreferredSize(new Dimension (100, 50));
	JTextField playerO = new JTextField("Player 2");
	playerO.setPreferredSize(new Dimension (100, 50));

	String[] gameModeAry = { "Standard" };
	selectGameMode = new JComboBox(gameModeAry);
	selectGameMode.setPreferredSize(new Dimension (150, 50));
	String[] sizeAry = { "3 X 3", "4 X 4", "5 X 5", "6 X 6", "7 X 7", "8 X 8", "9 X 9", "10 X 10" };
	selectSize = new JComboBox(sizeAry);
        selectSize.setPreferredSize(new Dimension (150, 50));


	start = new JButton("Start");
	start.setPreferredSize(new Dimension(100, 50));
	start.addActionListener(this);
	start.setActionCommand("start");

	top = new JPanel(new GridLayout(1, 2));
	topRight = new JPanel(new GridLayout(1, 2));
	mid = new JPanel(new GridLayout(1, 2));
	bot = new JPanel(new GridLayout(1, 2));
	// This is a really ugly way to initialize, but using a loop didnt work :(
	JPanel startPanel = new JPanel(), panel0 = new JPanel(), panel1 = new JPanel(), panel2 = new JPanel(), panel3 = new JPanel();
        

	panel0.add(playerX);
	panel1.add(playerO);
	topRight.add(panel0);
	topRight.add(panel1);
	top.add(playerNames);
	top.add(topRight);

	mid.add(gameMode);
	panel2.add(selectGameMode);
	mid.add(panel2);

	bot.add(size);
	panel3.add(selectSize);
	bot.add(panel3);

	startPanel.add(start);

	pane.add(title);
	pane.add(top);
	pane.add(mid);
	pane.add(bot);
	pane.add(startPanel);

    }

    public void actionPerformed (ActionEvent e) {
	int size = Integer.parseInt( "" +  ((String) selectSize.getSelectedItem()).charAt(0) );
	System.out.println( "" + size + (String) playerX.getText());
	//TicTacToe game = new TicTacToe( size, playerX.getText(), playerO.getText() );
	//game.gui.setVisible(true);
    }

    public static void main (String[] args) {

	StartupGUI start  = new StartupGUI();
	start.setVisible(true);

    }

}
