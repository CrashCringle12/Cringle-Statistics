/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


/**
 *
 * @author lbc5186
 */
public class NorthPanel extends JPanel {
    private JTextField tf1;
    public NorthPanel() {
        tf1 = new JTextField(30);
        tf1.setOpaque(true);
        tf1.setBackground(Color.white);
        add(tf1);
        
    }

    /**
     * @return the tf1
     */
    public JTextField getTf1() {
        return tf1;
    }

    /**
     * @param tf1 the tf1 to set
     */
    public void setTf1(JTextField tf1) {
        this.tf1 = tf1;
    }
}
