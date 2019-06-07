
package View;

import java.io.File;
import javax.swing.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
/**
 *
 * @author L627B
 */
public class DialogBox {
    
    public DialogBox() {
        
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
}
