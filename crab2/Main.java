package crab2;

import java.awt.Color;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        // Create the main window
        JFrame window = new JFrame("Shaper Runner");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create an instance of the game board
        GameBoard gameBoard = new GameBoard(800, 600, Color.white);
        
        // Add the game board to the window
        window.getContentPane().add(gameBoard);
        
        // Set the window size and make it visible
        window.setSize(800, 600);
        window.setVisible(true);
    }

}
