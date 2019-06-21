package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
 
public class MainFrame extends JFrame {
        private DefaultTableModel tableModel;
        private JTable table;
        private JScrollPane scrollPane;
        private JLabel lblHeading;
        private InitialPanel ip;
    public MainFrame() {
        super("Cringle Statistics Alpha");
        setupLayoutForMacs();
        ip = new InitialPanel();
        add(ip, "Center");
        //------------------------------------------------------
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 800);
        setVisible(true);
//        String col[] = {"Pack", "Song", "StepType", "Difficulty", "Name", "Grade", "Percent", "Points", "Date"};
//        tableModel = new DefaultTableModel(col, 0);
//        table = new JTable(getTableModel());
//        scrollPane = new JScrollPane(getTable());
//        table.setFillsViewportHeight(true);
//        
//        JLabel lblHeading = new JLabel("Stepmania Statistics");
//        lblHeading.setFont(new Font("Arial",Font.TRUETYPE_FONT,24));
// 
//        frame.getContentPane().setLayout(new BorderLayout());
// 
//        frame.getContentPane().add(lblHeading,BorderLayout.PAGE_START);
//        frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
//         


    }
    private void setupLayoutForMacs()
    {
        // On some MACs it might be necessary to have the statement below 
        //for the background color of the button to appear    
        try
        {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        //------------------------------------------------------
    }
    /**
     * @return the ip
     */
    public InitialPanel getIp()
    {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(InitialPanel ip)
    {
        this.ip = ip;
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