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
public class NoteTypeHit {
    private int notes;
    private int tapsAndHolds;
    private int jumps;
    private int holds;
    private int mines;
    private int hands;
    private int rolls;
    private int lifts;
    private int fakes;
    
    public NoteTypeHit(int note, int taph, int jump, int hold, int mine, int hand, int roll, int lift, int fake) {
        notes = note;
        tapsAndHolds = taph;
        jumps = jump;
        holds = hold;
        mines = mine;
        hands = hand;
        rolls = roll;
        lifts = lift;
        fakes = fake;
    }

}

