package View;

import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class InitialPanel extends JPanel
{
    int units = 0;
    public CenterPanel cp;
    public WestPanel wp;
    public NorthPanel np;
    public InitialPanel()
    {
        wp = new WestPanel();
        cp = new CenterPanel();
        setLayout(new BorderLayout());
        np = new NorthPanel();
        add(wp, "West");
        add(cp, "Center");
        add(np, "North");

        wp.setLayout(new GridLayout(4, 1, 1 ,1));

    }
          
    
}
