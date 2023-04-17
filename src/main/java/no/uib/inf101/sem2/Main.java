package no.uib.inf101.sem2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame{

  // TitleScreen title = new TitleScreen();
  Game game = new Game();
  GameBoard board = new GameBoard();
  JButton NGbutton = new JButton("Check solution");


  public Main(){

    
    Container c = getContentPane();
    c.add(board, BorderLayout.CENTER);
    //add button to restart game via board.newGame()

    c.add(NGbutton, BorderLayout.SOUTH);
    NGbutton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            game.isSolved();


        }
    });

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

