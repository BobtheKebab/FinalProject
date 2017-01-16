import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//Errors can be found starting in lines 33 and 57
public class TicTacToe {

    private static BoardGUI gui;
    private static String[][] board;
                                
    /* This will be for the random grid. Will be implemented later
    public Board (int size) {
    board = new String[size][size];
    moves = 0;
    }
    */

    public TicTacToe (int size, String p1, String p2) {
	gui = new BoardGUI(size, p1, p2);
	board = new String[size][size];
    }


    // This will allow us to make each button alternate between X and O whenever we click on them. 
    // String X will be the starting object for now
    private static String player = "X";

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
// Something is wrong with using frame even though it was researched online
    public static void xWinner(){
	Container frame = gui.pane;
        JOptionPane.showMessageDialog(frame,
    "Player 1 Wins!",
    "Winner",
    JOptionPane.PLAIN_MESSAGE);
            resetGame();
    }

    public static void oWinner(){
	Container frame = gui.pane;
        JOptionPane.showMessageDialog(frame,
    "Player 2 Wins!",
    "Winner",
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
	    }
    	}
	
    }
   
	public static void toResize(){;}
	
	private static void gameAI(){;}

    // Separate JButtons from each other and determine winning factors
    // Have only written down the layout for a horizontal winning pattern. Also need to include a return that will tell us the winner WHEN we have three of kind
    // Terminal says it cannot find symbol @ board. So is it a case of not creating a board fxn?
    // Every time a move is made, the data in board must be updated. This change is then pushed over to the GUI.
    private static void determineWinner(){

	/*
        String one = board[0][0];
        String two = board[0][1];
        String three = board[0][2];
        String four = board[1][0];
        String five = board[1][1];
        String six = board[1][2];
        String seven = board[2][0];
        String eight = board[2][1];
        String nine = board[2][2];

        // Checks each row for X
        if (one == "X" && two == "X" && three == "X"){
            xWinner();
        }
        if (four == "X" && five == "X" && six == "X"){
            xWinner();
        }
        if (seven == "X" && eight == "X" && nine == "X"){
            xWinner(); 
        }

        // Checks each column for X
        if (one == "X" && four == "X" && seven == "X"){
            xWinner();
        }
        if (two == "X" && five == "X" && eight == "X"){
            xWinner();
        }
        if (three == "X" && six == "X" && nine == "X"){
            xWinner();
        }

        // Checks each diagonal for X
        if (seven == "X" && five == "X" && three == "X"){
            xWinner();
        }
        if (nine == "X" && five == "X" && one == "X"){
            xWinner();
        }

        // Checks each row for O
        if (one == "O" && two == "O" && three == "O"){
            oWinner();
        }
        if (four == "O" && five == "O" && six == "O"){
            oWinner();
        }
        if (seven == "O" && eight == "O" && nine == "O"){
            oWinner(); 
        }

        // Checks each column for O
        if (one == "O" && four == "O" && seven == "O"){
            oWinner();
        }
        if (two == "O" && five == "O" && eight == "O"){
            oWinner();
        }
        if (three == "O" && six == "O" && nine == "O"){
            oWinner();
        }

        // Checks each diagonal for O
        if (seven == "O" && five == "O" && three == "O"){
            oWinner();
        }
        if (nine == "O" && five == "O" && one == "O"){
            oWinner(); 
	}
	*/

	
	if (anyWon("XXX")) xWinner();
	if (anyWon("OOO")) oWinner();
	if (isTiedGame()) tiedGame();

    }

    // This method is based off of WordSearch;
    /*
    private static boolean winString? (String word, int row, int col, int deltaRow, int deltaCol) {

	if (board[row][col].equals("")) {
	    return false;
	}

	// Checks if word can fit
	int lastCol = col + ( deltaCol * 2 );
	if ( (lastCol > board[row].length - 1) || (lastCol < 0) ) return false;
	
	int lastRow = row + ( deltaRow * 2 );
	if ( (lastRow > board.length - 1) || (lastRow < 0) ) return false;

	
	// Checks if theres conflicting letters
	for (int index = 0, num = row, count = col; index < word.length(); index ++, num += deltaRow, count += deltaCol) {
	    if ( !board[num][count].equals("" + word.charAt(index) ) ) {
		return false;
	    }
	}
	
	return true;
    }
    */

    private static boolean anyWon (String winString) {
        
        for (String[] row : board) {
	    String horizString = "";
	    for (String col : row) {
	        horizString += col;
	    }
	    if ( (horizString.indexOf(winString)) != -1 ) {
	        return true;
	    }
	}

	for (int col = 0; col < board[0].length; col++) {
	    String vertString = "";
	    for (int row = 0; row < board.length; row++) {
	        vertString += board[row][col];
	    }
	    if ( (vertString.indexOf(winString)) != -1) {
	        return true;
	    }
	}
/*
    for (int row = 0; row < (board.length); row++) {
        String diagString = "";
        for (int col = 0; col <= row; col++){
            int temp = row - col;
             diagString += board[temp][col]; 
            }
        if ( (diagString.indexOf(winString)) != -1) {
            return true;
        }

}
    for (int row = (board.length) - 2; row >= 0; row --){
        String diagString1 = "";
        for (int col = 0; col <= row; col++){
            int temp = row - col;
            diagString1 += board[(board.length) - col - 1][(board.length) - temp - 1];
        }
        if ((diagString1.indexOf(winString)) != -1){
            return true;
        }
    }
    */
    
    String diagString = "";
    for (int row = 0; row < board.length; row++){
        diagString += board[row][row];
    }
    if ((diagString.indexOf(winString)) != -1){
            return true; 
    }

    String diagString1 = "";
    for (int row = 0, col = board.length - 1; row < board.length; row++, col--){
            diagString1 += board[row][col];
        }
        if ((diagString1.indexOf(winString)) != -1){
            return true;
        }

/*
    for(int y = 0; y < board.length; y++){
        String diagString = "";
        for (int x = 0; x < board.length; x++){

            }
        }
    }

    for (int k = 0; k <= (board.length - 1); k++){
        String diagString2 = "";
        int yMin = Math.max(0, k - board.length + 1);
        int yMax = Math.max(board.length - 1, k);
        for (int y = yMin; y <= yMax; y++){
            int x = k - y;
            diagString2 += board[y][x];
        }
        if ((diagString2.indexOf(winString)) != -1){
            return true;
        }
    }
*/
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
	return (filled == 9);
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

    public static void aiupdate(){;}


    public static void main (String[]args) {
	TicTacToe game = new TicTacToe(10, "DANK", "MEMES");
        game.gui.setVisible(true);
    
    }

    
}

//BoardGUI will have a fxn to already create the window to display the GUI
