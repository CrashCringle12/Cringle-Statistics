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

    /**
     * @return the stream
     */
    public double getStream() {
        return stream;
    }

    /**
     * @param stream the stream to set
     */
    public void setStream(double stream) {
        this.stream = stream;
    }

    /**
     * @return the voltage
     */
    public double getVoltage() {
        return voltage;
    }

    /**
     * @param voltage the voltage to set
     */
    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    /**
     * @return the air
     */
    public double getAir() {
        return air;
    }

    /**
     * @param air the air to set
     */
    public void setAir(double air) {
        this.air = air;
    }

    /**
     * @return the freeze
     */
    public double getFreeze() {
        return freeze;
    }

    /**
     * @param freeze the freeze to set
     */
    public void setFreeze(double freeze) {
        this.freeze = freeze;
    }

    /**
     * @return the chaos
     */
    public double getChaos() {
        return chaos;
    }

    /**
     * @param chaos the chaos to set
     */
    public void setChaos(double chaos) {
        this.chaos = chaos;
    }
}
