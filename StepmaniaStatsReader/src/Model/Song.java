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
public class Song {
    private String pack;
    private String title;
    private ArrayList<Difficulty> difficulties;
    private int timesPlayed;
    public Song(String pck, String sng, ArrayList<Difficulty> difs, int totTimes) {
        pack = pck;
        title = sng;
        difficulties = difs;
        timesPlayed = totTimes;
    }

    
    public ArrayList<String> simplify() {
        ArrayList<String> str = new ArrayList<>();
        for (Difficulty i : difficulties) {
            for (String w : i.simplify()) {
                str.add(pack + "-" + title + ": " +  w);
            }
            
        }
        return str;
    }

    /**
     * @return the pack
     */
    public String getPack() {
        return pack;
    }

    /**
     * @param pack the pack to set
     */
    public void setPack(String pack) {
        this.pack = pack;
    }

    /**
     * @return the song
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param song the song to set
     */
    public void setSong(String title) {
        this.title = title;
    }

    /**
     * @return the difficulty
     */
    public ArrayList<Difficulty> getDifficulties() {
        return difficulties;
    }

    /**
     * @param difficulty the difficulty to set
     */
    public void setDifficulties(ArrayList<Difficulty> difficulties) {
        this.difficulties = difficulties;
    }

    /**
     * @return the timesPlayed
     */
    public int getTimesPlayed() {
        return timesPlayed;
    }

    /**
     * @param timesPlayed the timesPlayed to set
     */
    public void setTimesPlayed(int timesPlayed) {
        this.timesPlayed = timesPlayed;
    }

    
}
