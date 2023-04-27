package no.uib.inf101.sem2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame {

  // initialize components
  Ouch ouch = new Ouch(); // losing screen
  Congratulations congrats = new Congratulations(); // winning screen
  Game game = new Game(); // game
  GameModel model = new GameModel(); // game model
  GameView board = new GameView(model); // gameboard
  JButton NGbutton = new JButton("Check solution"); // button for checking solution

  public Main() {

    Container c = getContentPane();

    c.add(board, BorderLayout.CENTER);

    // button for checking solution
    c.add(NGbutton, BorderLayout.SOUTH);
    NGbutton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        game.isSolved(); // check if game is solved
        if (game.isSolved()) {
          c.removeAll();
          c.add(congrats, BorderLayout.CENTER);
          pack();
        } else {
          c.removeAll();
          c.add(ouch, BorderLayout.CENTER);
          pack();
        }
      }
    });
    model.newGame();
    board.updateView();

    pack();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setTitle("SUDOKU!");

  }

  public static void main(String[] args) {
    new Main();
  }

}
