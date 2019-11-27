/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 *
 * @author Lamar Cooley
 */
@XmlRootElement(name="RadarValues")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class RadarValues {

    private double Stream;
    private double Voltage;
    private double Air;
    private double Freeze;
    private double Chaos;
    private int LetGo;
    private int Held;
    private int MissedHold;
    private double Notes;
    private int TapsAndHolds;
    private int Jumps;
    private int Holds;
    private int Mines;
    private int Hands;
    private int Rolls;
    private int Lifts;
    private int Fakes;

    public RadarValues() {
    }

    public RadarValues(double stre, double volt, double ai, double fre, double cha,
            double note, int taph, int jump, int hold, int mine, int hand, int roll, int lift, int fake) {
        Stream = stre;
        Voltage = volt;
        Air = ai;
        Freeze = fre;
        Chaos = cha;
        Notes = note;
        TapsAndHolds = taph;
        Jumps = jump;
        Holds = hold;
        Mines = mine;
        Hands = hand;
        Rolls = roll;
        Lifts = lift;
        Fakes = fake;
    }
    public void makeScoresSimple() {
        Stream = Math.round(Stream*100)/100.0;
        Voltage = Math.round(Voltage*100)/100.0;
        Chaos = Math.round(Chaos*100)/100.0;
        Freeze = Math.round(Freeze*100)/100.0;
        Air = Math.round(Air*100)/100.0;
    
    }
}
