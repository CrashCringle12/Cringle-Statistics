/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author L627B
 */
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

    HighScore(String name, String grade, int score, double percent, NoteScores noteScores) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String simplify() {
        return(getName() + "received a(n) " + getGrade() + " with a " + getPercent() + "% and " + getScore() + "pts on " + getDate() + " ");
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the percent
     */
    public double getPercent() {
        return percent;
    }

    /**
     * @param percent the percent to set
     */
    public void setPercent(double percent) {
        this.percent = percent;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the radar
     */
    public RadarValues getRadar() {
        return radar;
    }

    /**
     * @param radar the radar to set
     */
    public void setRadar(RadarValues radar) {
        this.radar = radar;
    }

    /**
     * @return the nth
     */
    public NoteTypeHit getNth() {
        return nth;
    }

    /**
     * @param nth the nth to set
     */
    public void setNth(NoteTypeHit nth) {
        this.nth = nth;
    }

    /**
     * @return the Nscores
     */
    public NoteScores getNscores() {
        return Nscores;
    }

    /**
     * @param Nscores the Nscores to set
     */
    public void setNscores(NoteScores Nscores) {
        this.Nscores = Nscores;
    }
    
}
