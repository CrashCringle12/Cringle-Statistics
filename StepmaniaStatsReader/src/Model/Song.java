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
    public Song(String pck, String sng, ArrayList<Difficulty> difs) {
        pack = pck;
        title = sng;
        difficulties = difs;
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

    
}
