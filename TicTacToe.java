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
    private String player = "X";

    private void changePlayer (){
    	if (player.equals ("X")){
    		player == "O";
    	}
    	else (player == "X";)
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
