package no.uib.inf101.sem2;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame{

  GameBoard board = new GameBoard();
  TitleScreen title = new TitleScreen();
  JButton NGbutton = new JButton("New Game");
  JButton RButton = new JButton("Restart");

  public Main(){

    
    Container c = getContentPane();
    c.add(board, BorderLayout.CENTER);
    board.newGame();
    pack();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setTitle("SUDOKU!");

  }

  public static void main(String[] args) {
    new Main();
  }

}

