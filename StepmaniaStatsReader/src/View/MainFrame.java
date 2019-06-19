package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
 
public class MainFrame {
        private JFrame frame;
        private DefaultTableModel tableModel;
        private JTable table;
        private JScrollPane scrollPane;
        private JLabel lblHeading;
        
    public MainFrame() {
        frame = new JFrame("Cringle Statistics Alpha");
        String col[] = {"Pack", "Song", "StepType", "Difficulty", "Name", "Grade", "Percent", "Points", "Date"};
        tableModel = new DefaultTableModel(col, 0);
        table = new JTable(getTableModel());
        scrollPane = new JScrollPane(getTable());
        table.setFillsViewportHeight(true);
        
        JLabel lblHeading = new JLabel("Stepmania Statistics");
        lblHeading.setFont(new Font("Arial",Font.TRUETYPE_FONT,24));
 
        frame.getContentPane().setLayout(new BorderLayout());
 
        frame.getContentPane().add(lblHeading,BorderLayout.PAGE_START);
        frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 200);
        frame.setVisible(true);

    }

    /**
     * @return the frame
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * @param frame the frame to set
     */
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    /**
     * @return the tableModel
     */
    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    /**
     * @param tableModel the tableModel to set
     */
    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    /**
     * @return the table
     */
    public JTable getTable() {
        return table;
    }

    /**
     * @param table the table to set
     */
    public void setTable(JTable table) {
        this.table = table;
    }

    /**
     * @return the scrollPane
     */
    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    /**
     * @param scrollPane the scrollPane to set
     */
    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    /**
     * @return the lblHeading
     */
    public JLabel getLblHeading() {
        return lblHeading;
    }

    /**
     * @param lblHeading the lblHeading to set
     */
    public void setLblHeading(JLabel lblHeading) {
        this.lblHeading = lblHeading;
    }
}