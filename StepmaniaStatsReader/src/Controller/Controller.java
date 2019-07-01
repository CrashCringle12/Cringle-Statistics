package Controller;

import Model.Model; 
import View.View;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author L627B
 */
public class Controller {
    Model model;
    View view;
    public Controller(Model m, View v) {
        view = v;
        model = m;
        view.setupShop(model.getStData().getLinesBeingDisplayed() , model.getStData().getHeaders());
        displayData();
        addClicking();
        addSearching();
        addScrolling();

    }
    
    public void addScrolling() {
        view.getMf().getIp().cp.addMouseWheelListener(
                new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                model.getStData().setFirstLineToDisplay(e.getUnitsToScroll() + model.getStData().getFirstLineToDisplay());
                displayData();

            }
        });
    }
    public void addSearching() {
        view.getMf().getIp().np.getTf1().addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent p) {
                String searchTerm = view.getMf().getIp().np.getTf1().getText();
                if (model.getStData().search(searchTerm)) {
                    view.getMf().getIp().np.getTf1().setBackground(Color.green);
                    model.getStData().setLineToHighlight(model.getStData().getFoundIndex() - 1);
                    model.getStData().setFirstLineToDisplay(model.getStData().getFoundIndex() - 1);
                    
                    for (int i = 0; i < 9; i++) {
                        System.out.print("Highlight: " + model.getStData().getLineToHighlight());
                        System.out.println(view.getMf().getIp().cp.getBs().get(i).getText());
                        view.getMf().getIp().cp.getBs().get(i).setBackground(Color.pink);
                    }
                    displayData();
                }
                else {
                    view.getMf().getIp().np.getTf1().setBackground(Color.red);
                    }
            }
        });
        

    }
    
    
    public void displayData() {      
        view.displayData(model.getStData().getFirstLineToDisplay(), model.getStData().getLastLineToDisplay(), 
                model.getStData().getLinesBeingDisplayed(), model.getStData().getHeaders(), model.getStData().getDisplayedData());
        
    }
    public void addClicking() {
            for (int i = 1; i < view.getMf().getIp().cp.getBs().size(); i += 9) {
                view.getMf().getIp().cp.getBs().get(i).addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        
                        JButton v = (JButton) event.getSource();
                        int o = view.getMf().getIp().cp.getBs().indexOf(v);
                        for (int f = 0; f < view.getMf().getIp().cp.getBs().size(); f++) {
                            if (f != o) {
                                view.getMf().getIp().cp.getBs().get(f).setBackground(null);
                            } else {
                                view.getMf().getIp().cp.getBs().get(f).setBackground(Color.pink);
                                String songName = view.getMf().getIp().cp.getBs().get(f).getText();
                                view.getMf().getIp().wp.setA(model.getStData().getAdditionalInfo(songName) + "");
                                
                            }
                        }
                    }
                });
            }
            for (JButton i : view.getMf().getIp().cp.getHeaders()) {

            i.addActionListener(
                    new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {

                    JButton v = (JButton) event.getSource();
                    int o = view.getMf().getIp().cp.getHeaders().indexOf(v);
                    {
                        for (int f = 0; f < view.getMf().getIp().cp.getHeaders().size(); f++) {
                            if (f != o) {
                                view.getMf().getIp().cp.getHeaders().get(f).setBackground(Color.lightGray);
                            } else {
                                view.getMf().getIp().cp.getHeaders().get(f).setBackground(Color.pink);
                                model.getStData().setSortType(o);
                            }
                        }
                    }
                    model.getStData().setSortField(o);
                    model.getStData().setSearchByField(o);
                    
                    model.getStData().sort(model.getStData().getSortField(), model.getStData().getSortType());
                    displayData();
 
                }
            }
            );
        }
    }
}
