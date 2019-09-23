/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.ArrayList;

import lombok.Data;
/**
 *
 * @author L627B
 */
@Data
public class Difficulty {
    private String steptype;
    private String level;
    private ArrayList<HighScore> pScores;
    private String title;
    private int timesPlayed;
    
    public Difficulty(String tit, int tmPld, String lvl, String sttype, ArrayList<HighScore> a) {
        level = lvl;
        timesPlayed = tmPld;
        steptype = sttype;
        pScores = a;
        title = tit;
    }
    public ArrayList<String> simplify() {
        ArrayList<String> str = new ArrayList<>();
        getPScores().forEach((i) -> {
            str.add(i.toString() + "on the " + getSteptype() + " " + getLevel());
            //System.out.print(i.toString() + "on the " + getSteptype() + " " + getLevel());
        });
        return str;
    }


        
    
}
