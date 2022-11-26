package CSE563_Final_Project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;


public class File extends JMenu {

    private static String fileName;
    // label is used to display error messgaes
    private static JLabel label;
    // used redundant table for now, it will be used when the Table class is updated
    private Table table;


    /**
	 * Constructor that creates adds buttons to the JMenu
	 */
	public File(){
		super("File");

		// Adding save button to the File Menu, other butthons and their functions can be added here

		add(getSaveButton());
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
                label.setText("the user cancelled the operation");

			}
		});
		
		return save;
	}
    
}
