/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Model;
import View.SongTableModel;
import View.View;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lamar Cooley
 */
public class Controller {

    Model model;
    View view;

    public Controller(Model m, View v) {
        model = m;
        view = v;
        view.getMf().createTable(model.getStData().getDisplayedData());
        view.getMf().getjTable1().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected 
                int position = view.getMf().getjTable1().getSelectedRow();
                view.getMf().getTitleP().setText(model.getStData().getDisplayedData().get(position)[1]);
                view.getMf().getChaos().setText("Chaos: " + model.getStData().getSideData().get(position).getRadarv().getChaos());
                view.getMf().getTaphold().setText("TapHold: " + model.getStData().getSideData().get(position).getRadarv().getTapsAndHolds());
                view.getMf().getHitmine().setText("Hit Mine: " + model.getStData().getSideData().get(position).getNscores().getHitMine());
                view.getMf().getAir().setText("Air: " + model.getStData().getSideData().get(position).getRadarv().getAir());
                view.getMf().getStream().setText("Stream: " + model.getStData().getSideData().get(position).getRadarv().getStream());
                view.getMf().getVoltage().setText("Voltage: " + model.getStData().getSideData().get(position).getRadarv().getVoltage());
                view.getMf().getDifficulty().setText("Difficulty: " + model.getStData().getDisplayedData().get(position)[3]);
                view.getMf().getNotes().setText("Notes: " + model.getStData().getSideData().get(position).getRadarv().getNotes());
                view.getMf().getLifts().setText("Lifts: " + model.getStData().getSideData().get(position).getRadarv().getLifts());
                view.getMf().getJumps().setText("Jumps " + model.getStData().getSideData().get(position).getRadarv().getJumps());
                view.getMf().getHolds().setText("Holds: " + model.getStData().getSideData().get(position).getRadarv().getHolds());
                view.getMf().getFakes().setText("Fakes: " + model.getStData().getSideData().get(position).getRadarv().getFakes());
                view.getMf().getRolls().setText("Rolls: " + model.getStData().getSideData().get(position).getRadarv().getRolls());
                view.getMf().getFreeze().setText("Freeze: " + model.getStData().getSideData().get(position).getRadarv().getFreeze());
                view.getMf().getFantastic().setText("Fantastics: " + model.getStData().getSideData().get(position).getNscores().getW1());
                view.getMf().getExcellent().setText("Excellent: " + model.getStData().getSideData().get(position).getNscores().getW2());
                view.getMf().getGreat().setText("Great: " + model.getStData().getSideData().get(position).getNscores().getW3());
                view.getMf().getDecents().setText("Decent: " + model.getStData().getSideData().get(position).getNscores().getW4());
                view.getMf().getWayoff().setText("Way Offs: " + model.getStData().getSideData().get(position).getNscores().getW5());
                view.getMf().getMiss().setText("Miss: " + model.getStData().getSideData().get(position).getNscores().getMiss());
                view.getMf().getCpMiss().setText("CP Miss: " + model.getStData().getSideData().get(position).getNscores().getCheckpointMiss());
                view.getMf().getCpHit().setText("CP Hit: " + model.getStData().getSideData().get(position).getNscores().getCheckpointHit());
                view.getMf().getAvoidmine().setText("Avoid Miss: " + model.getStData().getSideData().get(position).getNscores().getAvoidMine());
                view.getMf().getHands().setText("Hands: " + model.getStData().getSideData().get(position).getRadarv().getHands());
            }
        });

    }
}
