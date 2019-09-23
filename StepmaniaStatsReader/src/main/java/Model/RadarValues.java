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
public class RadarValues {
    private double stream;
    private double voltage;
    private double air;
    private double freeze;
    private double chaos;
    public RadarValues(double stre, double volt, double ai, double fre, double cha) {
        stream = stre;
        voltage = volt;
        air = ai;
        freeze = fre;
        chaos = cha;
    }
}
