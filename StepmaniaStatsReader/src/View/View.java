
package View;

import java.util.ArrayList;

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
        public void setupShop(int totLines, ArrayList<String> headerText) {
            getMf().getIp().cp.setupLayout(totLines+1, headerText.size());
            getMf().getIp().cp.setupButtons(headerText,headerText.size()*totLines );
        }
        public void displayData(int fRow, int lRow, int totLines, ArrayList<String> headerText, ArrayList<String[]> songs){
            getMf().getIp().cp.addButtons(fRow, totLines, songs);
            mf.validate();
            mf.repaint();
        }
}
