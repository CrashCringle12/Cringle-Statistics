package Controller;

import Model.Model;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author L627B
 */
public class Controller {
    Model model;
    
    public Controller(Model m) {
        model = m;
        System.out.println(model.getStData().toString());
    }
}
