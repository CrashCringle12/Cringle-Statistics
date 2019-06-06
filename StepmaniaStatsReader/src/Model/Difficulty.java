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
    private HighScore p1Score;
    private String title;
    public Difficulty(String tit, String lvl, String sttype, HighScore a) {
        level = lvl;
        steptype = sttype;
        p1Score = a;
        title = tit;
    }
    public String simplify() {
        return "";
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
     * @return the p1Score
     */
    public HighScore getP1Score() {
        return p1Score;
    }

    /**
     * @param p1Score the p1Score to set
     */
    public void setP1Score(HighScore p1Score) {
        this.p1Score = p1Score;
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
