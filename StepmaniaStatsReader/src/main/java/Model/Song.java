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
        difficulties.forEach((i) -> {
            i.simplify().forEach((w) -> {
                str.add(pack + "-" + title + ": " +  w);
            });
        });
        return str;
    }

    
}
