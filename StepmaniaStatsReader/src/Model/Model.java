/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author L627B
 */
public class Model {
    private StatsData stData;
    
    public Model() {
        stData = new StatsData(getFile());
    }
    public File getFile() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = jfc.getSelectedFile();
                return selectedFile;
        }
        else {
            return null;
        }
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

