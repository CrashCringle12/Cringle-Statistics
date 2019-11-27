/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lamar Cooley
 */
public class SongTableModel extends AbstractTableModel{
    private final String[] columnNames = {"Pack", "Song", "StepType", "Level", "Name", "Grade", "Percent", "Score", "Date"};
    private ArrayList<String[]> myList;
    public SongTableModel(List<String[]> songList) {
        myList = (ArrayList<String[]>) songList;
    }
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    @Override
    public int getRowCount() {
        int size = 0;
        if (myList == null) {
            size = 0;
        } else {
            size = myList.size();
            }
        return size;
    }
    @Override
    public Object getValueAt(int row, int col) {
        Object temp = null;
        if (col == 7) {
            temp = Integer.parseInt(myList.get(row)[col]);
        } else {
            temp = myList.get(row)[col];
        }
        
        return temp;
        
    }
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    @Override
    public Class getColumnClass(int col) {
        switch (col) {
            case 8:
                return Integer.class;
            default:
                return String.class;
        }
    }
}
