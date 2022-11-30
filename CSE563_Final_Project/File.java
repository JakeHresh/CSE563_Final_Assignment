package CSE563_Final_Project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;


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
    
}
