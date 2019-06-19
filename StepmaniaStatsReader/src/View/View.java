
package View;

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
	void setMf(MainFrame mf) {
		this.mf = mf;
	}
}
