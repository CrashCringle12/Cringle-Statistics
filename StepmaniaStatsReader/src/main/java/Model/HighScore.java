/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import lombok.Data;

/**
 *
 * @author L627B
 */
@Data
public class HighScore {
    private String name;
    private String grade;
    private int score;
    private double percent;
    private String date;
    private RadarValues radar;
    private NoteTypeHit nth;
    private NoteScores Nscores;
    public HighScore (String nm, String grd, int sc, double perc, String dt, RadarValues a, NoteTypeHit b, NoteScores c) {
        name = nm;
        grade = grd;
        score = sc;
        percent = perc;
        date = dt;
        radar = a;
        nth = b;
        Nscores = c;
    }

    
    @Override
    public String toString() {
        return(getName() + " received a(n) " + getGrade() + " with a " + getPercent() + "% and " + getScore() + "pts on " + getDate() + " ");
    }
    
}
