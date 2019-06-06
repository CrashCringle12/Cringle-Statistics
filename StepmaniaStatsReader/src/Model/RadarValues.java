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
public class RadarValues {
    double stream;
    double voltage;
    double air;
    double freeze;
    double chaos;
    public RadarValues(double a, double b, double c, double d, double e) {
        stream = a;
        voltage = b;
        air = c;
        freeze = d;
        chaos = e;
    }
}
