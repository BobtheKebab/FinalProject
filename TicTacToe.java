import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//Errors can be found starting in lines 33 and 57
public class TicTacToe {

    private static BoardGUI gui;
    private String[][] board;
                                
    /* This will be for the random grid. Will be implemented later
    public Board (int size) {
    data = new String[size][size];
    }
    */

    public TicTacToe () {
	gui = new BoardGUI();
	board = new String[3][3];
    }

    // This will allow us to make each button alternate between X and O whenever we click on them. 
    // String X will be the starting object for now
    private String player = "X";

    private void changePlayer (){
        if (player.equals ("X")){
            player = "O";
        }
        else {player = "X";}
    }
// Something is wrong with using frame even though it was researched online
    public void xWinner(){
	Container frame = gui.pane;
        JOptionPane.showMessageDialog(frame,
    "Player 1 Wins!",
    "Winner",
    JOptionPane.PLAIN_MESSAGE);
    }

    public void oWinner(){
	Container frame = gui.pane;
        JOptionPane.showMessageDialog(frame,
    "Player 2 Wins!",
    "Winner",
    JOptionPane.PLAIN_MESSAGE);
    }

    public void tiedGame(){
	Container frame = gui.pane;
        JOptionPane.showMessageDialog(frame,
            "Draw!",
            "Tied Game",
            JOptionPane.PLAIN_MESSAGE);
    }

    // Separate JButtons from each other and determine winning factors
    // Have only written down the layout for a horizontal winning pattern. Also need to include a return that will tell us the winner WHEN we have three of kind
    // Terminal says it cannot find symbol @ board. So is it a case of not creating a board fxn?
    // Every time a move is made, the data in board must be updated. This change is then pushed over to the GUI.
    private void determineWinner(){
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
    }

    public void tiedGame2(){
        for (int row = 0; row < 3; row++){
            for (int column = 0; column < 3; column++){
                if (board[row][column] != ""){
                    tiedGame();
                }
            }
        }
    }

  
   public void update(int num){
	int row = num / (board.length);
	int col = num - (board.length) * row; 
	board[row][col] = player;
	gui.board[row][col].setText(player);
	changePlayer();
	gui.pane.repaint();
}


    public static void main (String[]args) {
	TicTacToe game = new TicTacToe();
        game.gui.setVisible(true);
    
    }

    
}

//BoardGUI will have a fxn to already create the window to display the GUI
