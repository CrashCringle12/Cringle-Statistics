package View;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class CenterPanel extends JPanel
{
   private ArrayList<JButton> headers = new ArrayList<>();
   private ArrayList<JButton> bs = new ArrayList<>();
   int rows;
   int cols;
    public CenterPanel()
    {    
        super();


    }
    public void setupButtons(ArrayList<String> headerText, int num) {
        
        for (int i = 0; i < headerText.size(); i++) {
            JButton header = new JButton(headerText.get(i));
            getHeaders().add(header);
            getHeaders().get(i).setBackground(Color.lightGray);
            add(header);       
        }
        for (int i = 0; i < num; i++) {
            JButton b = new JButton();
            getBs().add(b);
        }
    }
    public void addButtons(int fRow,int totLines, ArrayList<String[]> songs) {
        int cl = 0;
        System.out.println(songs.size());
        System.out.println("totRows: " + totLines);
        System.out.println("fRow: " + fRow);
        for (int i = fRow; i < fRow+totLines ; i++) { 
            for (int o = 0; o < songs.get(i).length; o++) {
                getBs().get(cl).setText(songs.get(i)[o]);
                System.out.print(songs.get(i)[o] + ", ");   
                add(getBs().get(cl));
                cl++;
            }
            System.out.println();
        }
    }
    public void setupLayout(int rows, int cols) {
        setLayout(new GridLayout(rows, cols));
        System.out.println(rows+ " "+ cols);
    }
    /**
     * @return the headers
     */
    public ArrayList<JButton> getHeaders() {
        return headers;
    }

    /**
     * @param headers the headers to set
     */
    public void setHeaders(ArrayList<JButton> headers) {
        this.headers = headers;
    }

    /**
     * @return the bs
     */
    public ArrayList<JButton> getBs() {
        return bs;
    }

    /**
     * @param bs the bs to set
     */
    public void setBs(ArrayList<JButton> bs) {
        this.bs = bs;
    }


}
               
        
    