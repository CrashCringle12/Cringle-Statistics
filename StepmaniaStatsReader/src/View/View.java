
package View;

/**
 *
 * @author L627B
 */
public class View {
    private DialogBox dg;
    private MainFrame mf;
    public View() {
        dg = new DialogBox();
        setMf(new MainFrame());
    }

    /**
     * @return the dg
     */
    public DialogBox getDg() {
        return dg;
    }

    /**
     * @param dg the dg to set
     */
    public void setDg(DialogBox dg) {
        this.dg = dg;
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
