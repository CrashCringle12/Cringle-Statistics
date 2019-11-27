/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 *
 * @author L627B
 */
@Data
@XmlRootElement
public class Song {
    
    @XmlAttribute(name="Dir")
    private String Dir;
    
    private String pack;
    private String title;
    @XmlElement(name="Steps")
    private List<Step> Steps;
    
     public Song(){}
    public Song(String dir, ArrayList<Step> difs) {
        Dir = dir;
        songPack();
        Steps = difs;
    }
    
    public void songPack() {  
        //This gets the attribute information of each song which is just the file path, and makes it look pretty
        String[] songString = Dir.split("/");
        try {
                  if (songString[0].contains("@mem") ) {
                      setPack("USB Songs");
                      setTitle(songString[1]);
                  }
                  else {
                  setPack(songString[1]);
                  setTitle(songString[2]);
                  }

        }
        catch (Exception y) {
            System.out.println("There seems to be a problem");
        }
    }
    

    
    public ArrayList<String> simplify() {
        ArrayList<String> str = new ArrayList<>();
        Steps.forEach((i) -> {
            i.simplify().forEach((w) -> {
                str.add(pack + "-" + title + ": " +  w);
            });
        });
        return str;
    }
}
@Data
@XmlRootElement(name="Steps")
class Step {
    @XmlAttribute(name="StepsType")
    private String StepsType;
    @XmlAttribute(name="Difficulty")
    private String Difficulty;
    
    @XmlElementWrapper(name="HighScoreList")
    @XmlElement(name="HighScore")
    private ArrayList<HighScore> pScores;
  
    @XmlElement(name="NumTimesPlayed")
    private int NumTimesPlayed;
    public Step(){}
    public Step(int tmPld, String lvl, String sttype, ArrayList<HighScore> a) {
        Difficulty = lvl;
        NumTimesPlayed = tmPld;
        StepsType = sttype;
        pScores = a;
    }
    public void shortenType() {
        StepsType = StepsType.replace("dance-", "").toUpperCase();
    }
    public ArrayList<String> simplify() {
        ArrayList<String> str = new ArrayList<>();
        getPScores().forEach((i) -> {
            str.add(i.toString() + "on the " + getStepsType() + " " + getDifficulty());
            //System.out.print(i.toString() + "on the " + getSteptype() + " " + getLevel());
        });
        return str;
    }
}
