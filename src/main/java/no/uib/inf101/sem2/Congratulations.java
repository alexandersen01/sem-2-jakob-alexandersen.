package no.uib.inf101.sem2;

import javax.swing.JLabel;

/**
 * This screen is responsible for drawing the congratulations screen.
 */

public class Congratulations extends javax.swing.JPanel {
    private JLabel jLabel1;

    // draw congratulations screen
    public Congratulations() {
        initComponents();
    }

    // add neccecary components to the congratulations screen
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setText("Congratulations! You solved the puzzle!");

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
