package View;

import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class WestPanel extends JPanel
{
    private JRadioButton a;
    private JRadioButton b;
    private JRadioButton c;
    int units = 0;
    public WestPanel() {
//        JButton top = new JButton("Choose a SORT Type");
//        a = new JRadioButton("(1) Selection");
//        b = new JRadioButton("(2)Merge/ArrayList()");
//        c = new JRadioButton("(3)Quick/Arrays[]");
//        add(top);
//        add(a);
//        add(b);
//        add(c);
//        ButtonGroup group = new ButtonGroup();
//        group.add(a);
//        group.add(b);
//        group.add(c);
    } 

    /**
     * @return the a
     */
    public JRadioButton getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(JRadioButton a) {
        this.a = a;
    }

    /**
     * @return the b
     */
    public JRadioButton getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(JRadioButton b) {
        this.b = b;
    }

    /**
     * @return the c
     */
    public JRadioButton getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(JRadioButton c) {
        this.c = c;
    }


    }

