/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import lombok.Data;

/**
 *
 * @author L627B
*/
@XmlRootElement
public class HighScore {
    @XmlElement
    String Name;
    @XmlElement
    String Grade;
    @XmlElement
    int Score;
    @XmlElement
    double PercentDP;
    @XmlElement
    String DateTime;  
    
    @XmlElement(name="RadarValues")
    RadarValues radarv;

    @XmlElement(name="TapNoteScores")
    TapNoteScores Nscores;
    public HighScore(){}

    public HighScore (String name, String grade, int score, double percent, String datetime, RadarValues radarvalues, TapNoteScores tapnotescores) {
        Name = name;
        Grade = grade;
        convertGrade();
        Score = score;
        PercentDP = percent;
        DateTime = datetime;
        makeDateNice();
        radarv = radarvalues;
        Nscores = tapnotescores;
    }
        public void convertGrade() {
    	String dynamite = Grade;
    	switch(Grade) {
        case "Tier17":
            dynamite = "D";
            break;	
        case "Tier16":
            dynamite = "C-";
            break;
        case "Tier15":
            dynamite = "C";
            break;
        case "Tier14":
            dynamite = "C+";
            break;
        case "Tier13":
            dynamite = "B-";
            break;
        case "Tier12":
            dynamite = "B";
            break;
        case "Tier11":
            dynamite = "B+";
            break;
        case "Tier10":
            dynamite = "A-";
            break;
        case "Tier09":
            dynamite = "A";
            break;
        case "Tier08":
            dynamite = "A+ ";
            break;
        case "Tier07":
            dynamite = "S-";
            break;
        case "Tier06":
            dynamite = "S";
            break;
        case "Tier05":
            dynamite = "S+";
            break;
        case "Tier04":
            dynamite = "\u2606";
            break;
        case "Tier03":
            dynamite = "\u2606\u2606";
            break;
        case "Tier02":
            dynamite = "\u2606\u2606\u2606";
            break;
        case "Tier01":
            dynamite = "\u2606\u2606\u2606\u2606";
            break;
        case "Failed":
            dynamite = "Failure";
            break;	
    	}
        Grade = dynamite;
    }
    public void makeDateNice() {
        SimpleDateFormat formatter6=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formate = new SimpleDateFormat("EEE. MMM d, yyyy hh:mmaaa");           			
        Date date1 = new Date();
        try {
            date1 = formatter6.parse(DateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateTime = formate.format(date1);

    }
    
    public RadarValues getRadarv() {
        return radarv;
    }
    public TapNoteScores getNscores() {
        return Nscores;
    }
    @Override
    public String toString() {
        return(Name + " received a(n) " + Grade + " with a " + PercentDP + "% and " + Score + "pts on " + DateTime + " ");
    }
    
} 
   