import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TicTacToe {

    private char[][] data;

    /* This will be for the random grid. Will be implemented later
    public Board (int size) {
    data = new char[size][size];
    }
    */

    public BoardGUI Start () {
    data = new char[3][3];
    BoardGUI board = new BoardGUI();
    return board;
    }

    // This will allow us to make each button alternate between X and O whenever we click on them. 
    // String X will be the starting object for now
    private char player = "X";

    private void changePlayer (){
        if (player.equals ("X")){
            player == "O";
        }
        else (player == "X";)
    }

    public void xWinner(){
        JOptionPane.showMessageDialog(frame,
    "Player 1 Wins!",
    "Winner",
    JOptionPane.PLAIN_MESSAGE);
    }

    public void oWinner(){
        JOptionPane.showMessageDialog(frame,
    "Player 2 Wins!",
    "Winner",
    JOptionPane.PLAIN_MESSAGE);
    }

    // Separate JButtons from each other and determine winning factors
    // Have only written down the layout for a horizontal winning pattern. Also need to include a return that will tell us the winner WHEN we have three of kind
    private void determineWinner(){
        Char one = board[0][0].getText();
        Char two = board[0][1].getText();
        Char three = board[0][2].getText();
        Char four = board[1][0].getText();
        Char five = board[1][1].getText();
        Char six = board[1][2].getText();
        Char seven = board[2][0].getText();
        Char eight = board[2][1].getText();
        Char nine = board[2][2].getText();

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




    public void Run () {
    board = Start();
    board.setVisisble(true);
    
    }

    public static void main (String[]args) {

        Run();
    
    }

    
}

//BoardGUI will have a fxn to already create the window to display the GUI
