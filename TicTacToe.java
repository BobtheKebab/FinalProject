import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TicTacToe {

    public static BoardGUI gui;
    private static String[][] board;
    private static boolean versusAI;
    private static int winsX, winsO;
    private static String player = "X";

    public TicTacToe (int size, String p1, String p2, boolean againstAI) {
	gui = new BoardGUI(size, p1, p2);
	board = new String[size][size];
	versusAI = againstAI;
    }

    private static void changePlayer (){
        if (player.equals ("X")){
            player = "O";
	    gui.whosTurn.setText("======>");
        }
        else {
	    player = "X";
	    gui.whosTurn.setText("<======");
	}
	
    }
    
    public static void xWinner(){
	Container frame = gui.pane;
        JOptionPane.showMessageDialog(frame, gui.player1.getText() + " Wins!", "Winner",
    JOptionPane.PLAIN_MESSAGE);
            resetGame();
    }

    public static void oWinner(){
	Container frame = gui.pane;
        JOptionPane.showMessageDialog(frame, gui.player2.getText() + " Wins!", "Winner",
    JOptionPane.PLAIN_MESSAGE);
            resetGame();
    }

    public static void tiedGame(){
	Container frame = gui.pane;
        JOptionPane.showMessageDialog(frame,
            "Draw!",
            "Tied Game",
            JOptionPane.PLAIN_MESSAGE);
            resetGame();
    }


    public static void resetGame(){
    	for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
		board[row][col] = "";
                gui.buttons[row][col].setText("");
	        gui.buttons[row][col].setEnabled(true);
            player = "X";
            gui.whosTurn.setText("<======");
	    }
    	}
	
    }
	
    private static void gameAI(){
	int random = 0;
	int random1 = 0;
	boolean moveDone = false;
	System.out.println(moveDone);
	    
	while (!moveDone) {
	    random = (int) (Math.random() * board.length);
	    random1 = (int) (Math.random() * board.length);
	    if ( board[random][random1].equals("") ) {
		moveDone = true;
		board[random][random1] = player;
		JButton tempButton = gui.buttons[random][random1];
		tempButton.setText(player);
		tempButton.setEnabled(false);
		tempButton.setFont(new Font("Arial", Font.BOLD, 450 / board.length));
	    }
	}
	changePlayer();
	    
    }

    private static void determineWinner() {

	String toWinX = new String(new char[board.length]).replace("\0", "X");
	if (anyWon(toWinX)) {
	    winsX++;
	    gui.wins1.setText("" + winsX);
	    xWinner();
	}

	String toWinO = new String(new char[board.length]).replace("\0", "O");
	if (anyWon(toWinO)) {
	    winsO++;
	    gui.wins2.setText("" + winsO);
	    oWinner();
	}
	
	if ( isTiedGame() ) tiedGame();

    }

    private static boolean anyWon (String winString) {
        
        for (String[] row : board) {
	    String horizString = "";
	    for (String col : row) {
	        horizString += col;
	    }
	    if ((horizString.indexOf(winString)) != -1) {
	        return true;
	    }
	}

	for (int col = 0; col < board[0].length; col++) {
	    String vertString = "";
	    for (int row = 0; row < board.length; row++) {
	        vertString += board[row][col];
	    }
	    if ((vertString.indexOf(winString)) != -1) {
	        return true;
	    }
	}
	
	String diagString = "";
	for (int row = 0; row < board.length; row++){
	    diagString += board[row][row];
	}
	if ((diagString.indexOf(winString)) != -1){
	    return true; 
	}
	    
	diagString = "";
	for (int row = 0, col = board.length - 1; row < board.length; row++, col--){
	    diagString += board[row][col];
	}
	if ((diagString.indexOf(winString)) != -1){
	    return true;
	}
	
	return false;
    
    }
	    
    public static boolean isTiedGame () {
	int filled = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (!board[row][col].equals("")){
                    filled++;
                }
            }
        }
	return (filled == (board.length * board.length));
    }

  
   public static void update(int num){
	
	int row = num / (board.length);
	int col = num - (board.length) * row; 
	board[row][col] = player;
	
	JButton tempButton = gui.buttons[row][col];
	tempButton.setText(player);
	tempButton.setEnabled(false);
	tempButton.setFont(new Font("Arial", Font.BOLD, 450 / board.length));
	
	changePlayer();
	determineWinner();
	
   }

    public static void main (String[] args) {
	
	int size = Integer.parseInt(args[0]);
	if (size < 3) {
	    throw new UnsupportedOperationException("Given size is too low");
	}
	TicTacToe game = new TicTacToe(size, args[1], args[2], false);
        game.gui.setVisible(true);
    
    }

    
}
