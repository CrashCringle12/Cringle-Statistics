/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.ArrayList;
/**
 *
 * @author L627B
 */
public class Difficulty {
    private String steptype;
    private String level;
    private ArrayList<HighScore> pScores;
    private String title;
    public Difficulty(String tit, String lvl, String sttype, ArrayList<HighScore> a) {
        level = lvl;
        steptype = sttype;
        pScores = a;
        title = tit;
    }
    public ArrayList<String> simplify() {
        ArrayList<String> str = new ArrayList<>();
        for (HighScore i : pScores) {
            str.add(i.toString() + "on the " + getSteptype() + " " + getLevel());
            //System.out.print(i.toString() + "on the " + getSteptype() + " " + getLevel());
        }
        return str;
    }

    /**
     * @return the steptype
     */
    public String getSteptype() {
        return steptype;
    }

    /**
     * @param steptype the steptype to set
     */
    public void setSteptype(String steptype) {
        this.steptype = steptype;
    }

    /**
     * @return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * @return the pScores
     */
    public ArrayList<HighScore> getPScore() {
        return pScores;
    }

    /**
     * @param pScores the pScores to set
     */
    public void setPScore(ArrayList<HighScore> pScores) {
        this.pScores = pScores;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    

        
    
}
