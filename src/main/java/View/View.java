
package View;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author L627B
 */
public class View {
    private MainFrame mf;
    public View() {
        setMf(new MainFrame());
    }

	/**
	 * @return the mf
	 */
	public MainFrame getMf() {
		return mf;
	}

	/**
	 * @param mf the mf to set
	 */
	public void setMf(MainFrame mf) {
		this.mf = mf;
	}
}
