package no.uib.inf101.sem2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TitleScreen extends JPanel{
    // create title screen
    // create new game button
    GameStatus state = GameStatus.START;

    // create restart button


    Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    int dims = ((int) screenSize.getWidth()) / 3;

    public TitleScreen(){
        super.setLayout(new GridLayout(2, 1));

        // Create the buttons
        JButton NGbutton = new JButton("New Game");
        JButton RButton = new JButton("Restart");

        // Add the buttons to the panel
        super.add(NGbutton);
        super.add(RButton);

        // Set the size of the panel
        super.setPreferredSize(new Dimension(dims, dims));

        // if new game button is pressed, start a new game and set gamestate to active 
        NGbutton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                state = GameStatus.ACTIVE;
            }
        });



    }


}
