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

    /**
     * @return the notes
     */
    public int getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(int notes) {
        this.notes = notes;
    }

    /**
     * @return the tapsAndHolds
     */
    public int getTapsAndHolds() {
        return tapsAndHolds;
    }

    /**
     * @param tapsAndHolds the tapsAndHolds to set
     */
    public void setTapsAndHolds(int tapsAndHolds) {
        this.tapsAndHolds = tapsAndHolds;
    }

    /**
     * @return the jumps
     */
    public int getJumps() {
        return jumps;
    }

    /**
     * @param jumps the jumps to set
     */
    public void setJumps(int jumps) {
        this.jumps = jumps;
    }

    /**
     * @return the holds
     */
    public int getHolds() {
        return holds;
    }

    /**
     * @param holds the holds to set
     */
    public void setHolds(int holds) {
        this.holds = holds;
    }

    /**
     * @return the mines
     */
    public int getMines() {
        return mines;
    }

    /**
     * @param mines the mines to set
     */
    public void setMines(int mines) {
        this.mines = mines;
    }

    /**
     * @return the hands
     */
    public int getHands() {
        return hands;
    }

    /**
     * @param hands the hands to set
     */
    public void setHands(int hands) {
        this.hands = hands;
    }

    /**
     * @return the rolls
     */
    public int getRolls() {
        return rolls;
    }

    /**
     * @param rolls the rolls to set
     */
    public void setRolls(int rolls) {
        this.rolls = rolls;
    }

    /**
     * @return the lifts
     */
    public int getLifts() {
        return lifts;
    }

    /**
     * @param lifts the lifts to set
     */
    public void setLifts(int lifts) {
        this.lifts = lifts;
    }

    /**
     * @return the fakes
     */
    public int getFakes() {
        return fakes;
    }

    /**
     * @param fakes the fakes to set
     */
    public void setFakes(int fakes) {
        this.fakes = fakes;
    }
}

