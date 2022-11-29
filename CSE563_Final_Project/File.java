package CSE563_Final_Project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import java.util.Arrays;
import java.util.Comparator;
import java.io.FilenameFilter;

public class File extends JMenu {

    private static String fileName;
    // label is used to display error messgaes
    private static JLabel label;
    // used redundant table for now, it will be used when the Table class is updated
    private Table table;

	private MainFrame window;

    /**
	 * Constructor that adds buttons to the File JMenu
	 */
	public File(MainFrame window){
		super("File");
		this.window = window;

		// Adding save and loadRoster buttons to the File Menu, other butthons and their functions can be added here
		add(getLoadRoster());
		add(getSaveButton());
		add(getAddAttendance());
	}

	/**
	 * Create menu Item for Load Roster button and the listener called when the button is selected
	 */
	private JMenuItem getLoadRoster() {
		JMenuItem loadRoster = new JMenuItem("Load Roster");
		
		loadRoster.addActionListener(new ActionListener() {

			/**
			 * Listens for the "Load Roaster" button preseed and takes the following actions:
			 * 1- Asks file name/directory from the user using the JFileChooser (Task 8)
			 * 2- Saves the data of the choosen csv file to a data-structure (JTable is used here) (Task 9)
			 * 3- The data is saved to global variable "table" (Task 9)
			 * 4- displays the data in the Frame (Task 11)
			 * 
			 * @param arg0 The action event of button
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {

				// when the button is pressed, first thing is to let user choose a file 
				JFileChooser file_chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

				// show the dialogue to the user to choose the file
				int ret_val = file_chooser.showOpenDialog(null);

				// if the user chooses a file and selects "OK" then perform the following task
				if (ret_val == JFileChooser.APPROVE_OPTION)
				{
					// Update the fileName by the file selected by the user and make an array list to store the data 
					fileName = file_chooser.getSelectedFile().getAbsolutePath();

					// make an instance of the loadRoster class
					loadRoster roster = new loadRoster();

					// Save the data of the file to a JTable global instance table 
					table = new Table(roster.loadData(fileName), window);
				}

				// If the user cancelled the operation
				else
				label.setText("Operation Cancelled");
			}
		});
		return loadRoster;
	}

    /**
	 * Creates menu item "Save" and assigns an action to the item.
	 */
	private JMenuItem getSaveButton() {
		JMenuItem save = new JMenuItem("Save");
		
		save.addActionListener(new ActionListener() {

			/**
			 * This function is called when the Menu Item "Save" is selected from the File Menu, it chooses the filename using Filechooser
			 * 
			 * @param arg0 
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {

				//  file_chooser is an object of the JFileChooser class
				JFileChooser file_chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

				// Showing the dialogbox 
				int dialogbox = file_chooser.showSaveDialog(null);

				// If the user selects a file
				if (dialogbox == JFileChooser.APPROVE_OPTION)
				{
					// save the filename in the variable and call the save class with this
					fileName = file_chooser.getSelectedFile().getAbsolutePath();
					save csv_file = new save(fileName, table);
				}

				// If the user cancelled the operation
				else
                label.setText("Operation Cancelled");

			}
		});
		
		return save;
	}


	/*
	 * Creates menu item "AddAttendance" and assigns an action to the item
	 */
	private JMenuItem getAddAttendance() {
		JMenuItem addAttendance = new JMenuItem("Add Attendance");
		
		addAttendance.addActionListener(new ActionListener() {

			/**
			 * Listens for the "Add Attendance" button pressed event and takes the following actions:
			 * 1- Asks file directory from the user using the JFileChooser
			 * 2- Grabs the files in the directory filtered according to ^[0-9]{8} attendance.csv$
			 * 3- Sorts the attendance files by Date before parsing the attendance files
			 * 
			 * @param arg0 The action event of button
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				// do nothing if no roster is loaded yet
				if(table == null) {
					return;
				}

				// Have user pick directory via JFileChooser
				JFileChooser file_chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				file_chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int dialogbox = file_chooser.showDialog(null, "Select Attendance Directory");
				if (dialogbox == JFileChooser.APPROVE_OPTION)
				{
					//Filter the files in the directory according to our attendance file format
					FilenameFilter filter = (directory,name) -> name.matches("^[0-9]{8} attendance.csv$");
					java.io.File[] attendanceFiles = file_chooser.getSelectedFile().listFiles(filter);

					//Sort attendance files by date
					Arrays.sort(attendanceFiles, new Comparator<java.io.File>(){
						@Override
						public int compare(java.io.File f1, java.io.File f2){
							int date1 = Integer.parseInt(f1.getName().substring(0,8));
							int date2 = Integer.parseInt(f2.getName().substring(0,8));
							return date1-date2;
						}
					});

					

					//Add a column for each file
					for(java.io.File attendanceFile : attendanceFiles){
						String fileName = attendanceFile.getName();
						int date = Integer.parseInt(fileName.substring(0,8));
						int column = table.model.getColumnCount();
						table.model.addColumn(date);
						//Init column values to 0
						for(int i = 0; i<table.model.getRowCount(); i++){
							table.model.setValueAt(0, i, column);
						}
						loadAttendance.parseAttendanceFile(attendanceFile.getAbsolutePath(), table.model, column);
					}
				}
			}
		});
		
		return addAttendance;
	}
    
}
