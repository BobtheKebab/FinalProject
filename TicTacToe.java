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

        if (one == "X" && two == "X" && three == "X"){

        }
        if (four == "X" && five == "X" && six == "X"){
            
        }
        if (seven == "X" && eight == "X" && nine == "X"){
            
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
