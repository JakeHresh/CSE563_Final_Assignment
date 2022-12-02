package CSE563_Final_Project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;

/**
 * Table class creates a JTable with attendance array returned from AttendanceAdder class and adds attendance.
 * When adding attendance, procts a date picker to allow the user to select a date. 
 */
public class Table extends JTable{
    DefaultTableModel model = new DefaultTableModel();
    MainFrame main_frame;
    
    /**
     * Constructor for table. Creates a table with the inputted array list and displays on the given GUI window. 
     * @param roster - ArrayList<student> containing student information to be inputted into the table. 
     * @param main_frame - GUI instance where the table is to be displayed. 
     */
    Table(LinkedList<Student> roster, MainFrame main_frame){
        
        this.main_frame = main_frame;
        // header for the table 
        String columns[] = {"ID", "First Name", "Last Name", "ASURITE"};  

        // add column headers
        for (int i = 0; i < 4; i ++){
            model.addColumn(columns[i]);
        }

        // make object to store the rows
        Object rows[] = new Object[4];
        for (int i = 0; i < roster.size(); i++){
            rows[0] = roster.get(i).get_studentID();
            rows[1] = roster.get(i).get_fName();
            rows[2] = roster.get(i).get_lName();
            rows[3] = roster.get(i).get_asuriteID();
            model.addRow(rows);
        }

        setModel(model);
        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        setBounds(30,40,200,300);  

        // add scroll panel
        JScrollPane scroll_panel = new JScrollPane(this);
        scroll_panel.setPreferredSize(new Dimension(400,600));  // dimentions of the table 
        main_frame.add(scroll_panel, BorderLayout.CENTER);
        main_frame.setSize(640,600); 
        main_frame.setVisible(true);
    }
    
    // this method gets the total number of attendees in the class on particular date(column))
    public int[] getAttendance(int column){
        int[] attendees = new int[model.getRowCount()];
        for(int i = 0; i < model.getRowCount(); i++){
            attendees[i] = (int)model.getValueAt(i, column);
        }
        return attendees;
    }
}

