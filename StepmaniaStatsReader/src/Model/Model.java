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
public class Model {
    private StatsData stData;
    
    public Model() {
        stData = new StatsData();
    }
    
    public StatsData getStData() {
        return stData;
    }

    /**
     * @param stData the stData to set
     */
    public void setStData(StatsData stData) {
        this.stData = stData;
    }
}
