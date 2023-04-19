package no.uib.inf101.sem2;

import javax.swing.JLabel;

/**
 * This screen is responsible for drawing the loser screen.
 */
public class Ouch extends javax.swing.JPanel {
    private JLabel jLabel1;

    // draw congratulations screen
    public Ouch() {
        initComponents();
    }

    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setText("Yikes! You made a mistake!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabel1)
                                .addContainerGap(100, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabel1)
                                .addContainerGap(100, Short.MAX_VALUE)));
    }
}
