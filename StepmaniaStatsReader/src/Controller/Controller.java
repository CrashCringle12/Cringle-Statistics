package Controller;

import Model.Model;
import View.View;

/**
 *
 * @author L627B
 */
public class Controller {
    Model model;
    View view;
    public Controller(Model m, View v) {
        model = m;
        view = v;
       for (int i = 0; i < model.getStData().getAllSongs().size(); i++) {            
            System.out.println(model.getStData().getAllSongs().get(i).getTitle()+ ": ");
            for (int o = 0; o < model.getStData().getAllSongs().get(i).getDifficulties().size(); o++) {
                System.out.println(model.getStData().getAllSongs().get(i).getDifficulties().get(o).simplify());
            }
        }

    }
}
