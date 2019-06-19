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
            	String pack = model.getStData().getAllSongs().get(i).getPack();
            	String song = model.getStData().getAllSongs().get(i).getTitle();
            	String steptype = model.getStData().getAllSongs().get(i).getDifficulties().get(o).getSteptype();
            	String level = model.getStData().getAllSongs().get(i).getDifficulties().get(o).getLevel();
            	for (int w = 0; w < model.getStData().getAllSongs().get(i).getDifficulties().get(o).getPScore().size(); w++) {
            		String name = model.getStData().getAllSongs().get(i).getDifficulties().get(o).getPScore().get(w).getName();
            		String grade = model.getStData().getAllSongs().get(i).getDifficulties().get(o).getPScore().get(w).getGrade();
            		double percent = model.getStData().getAllSongs().get(i).getDifficulties().get(o).getPScore().get(w).getPercent();
            		double points = model.getStData().getAllSongs().get(i).getDifficulties().get(o).getPScore().get(w).getScore();
            		String date = model.getStData().getAllSongs().get(i).getDifficulties().get(o).getPScore().get(w).getDate();
            		Object[] obj = {pack, song, steptype, level, name, grade, percent, points, date};
            		view.getMf().getTableModel().addRow(obj);
            	}
            }
        }
       

    }
}
