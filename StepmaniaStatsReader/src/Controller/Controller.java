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
        model.getStData().setStats(view.getDg().getFile());
        System.out.println("Pack size" + model.getStData().getPack().size());
        System.out.println(model.getStData().getPack().get(4).getTitle() + " " + model.getStData().getPack().get(4).getDifficulties().get(0).getPScore().size());
        for (int i = 0; i < model.getStData().getPack().size(); i++) {
            
            //System.out.println(model.getStData().getPack().get(i).getPack() + " :\n\n");
            for (int t = 0; t <  model.getStData().getPack().get(i).getDifficulties().size(); t++) {
               // System.out.println("Difficulties per song " + model.getStData().getPack().get(i).getTitle()+ " " + model.getStData().getPack().get(i).getDifficulties().size());
                //System.out.println(model.getStData().getPack().get(i).getTitle() + " :\n\n");
                for (int z = 0; z < model.getStData().getPack().get(i).getDifficulties().get(t).getPScore().size(); z++ ) {
                   // System.out.println(model.getStData().getPack().get(i).getDifficulties().get(t).getPScore().get(z));
                }
                
            }
        }

    }
}
