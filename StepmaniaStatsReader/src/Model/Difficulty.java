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
    String steptype;
    String level;
    HighScore p1Score;
    String song;
    public Difficulty(String lvl, String sttype, HighScore a) {
        level = lvl;
        steptype = sttype;
        p1Score = a;
    }
    public String simplify() {
        return "";
    }
    

        
    
}
