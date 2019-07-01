package View;

import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class WestPanel extends JPanel
{
    private JLabel a;
    String text;
    public WestPanel() {
        text = "Times Played:";
        a = new JLabel(text);

        add(a);

    } 

    /**
     * @return the a
     */
    public JLabel getA() {
        return a;
    }

    public void setA(String txt) {
        this.a.setText(text + " " + txt);
    }
    }

