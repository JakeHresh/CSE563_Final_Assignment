package CSE563_Final_Project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * Table class creates a JTable with attendance array returned from AttendanceAdder class and adds attendance.
 * When adding attendance, procts a date picker to allow the user to select a date. 
 */
public class Table extends JTable{
    DefaultTableModel model = new DefaultTableModel();
    MainFrame window;
    
    /**
     * Constructor for table. Creates a table with the inputted array list and displays on the given GUI window. 
     * @param roster - ArrayList<student> containing student information to be inputted into the table. 
     * @param window - GUI instance where the table is to be displayed. 
     */
    Table(ArrayList<Student> roster, MainFrame window){
        
        this.window = window;
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
        window.add(scroll_panel, BorderLayout.CENTER);
        window.setSize(640,600); 
        window.setVisible(true);
    }
}

