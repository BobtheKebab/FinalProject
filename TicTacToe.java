import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TicTacToe {

	private char[][] data;

	public Board () {
		data = new char[3][3];
	}


	/* This will be for the random grid. Will be implemented later
    public Board (int size) {
	data = new char[size][size];
    }
	*/

    public BoardGUI Start () {
	BoardGUI board = new BoardGUI();
	return board;
    }

    public void Run () {
	board = Start();
	
    }

    public static void main (String[]args) {

	Window g = new Window();
	g.setVisible(true);
	
    }

    
}

//BoardGUI will have a fxn to already create the window to display the GUI
