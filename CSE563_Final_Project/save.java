package CSE563_Final_Project;

import javax.swing.*;
import java.io.*;

/**
 * This class extends the JFrama, gets the filename and/or directory from the user using FileWriter and stores the Table data into the that location in csv format
 */
public class save extends JFrame{

    /**
     *  takes the data Table and saves 
     * 
     * @param fileName Takes in the filename chosen from the GUI
     * @param table Data table from Table class to read and save from
     */
    save(String fileName, Table table) {
        FileWriter writer = null;

        try {
            // create the writer with the filename mentioned
            writer = new FileWriter(fileName);

            // store the column headers int he csv file (getting columns count and columns name from the Table class)
            for ( int i = 0; i < table.getColumnCount(); i++){
                writer.write(table.getColumnName(i) + ",");
            }
            writer.write("\n");

            // goes through each entry (columns and rows count taken from Table class) and stored the data in the file one by one
            for(int i = 0; i < table.getColumnCount(); i++){
                for(int j = 0; j < table.getColumnCount(); j++){
                    writer.write(table.getValueAt(i, j).toString() + ",");
                }
                writer.write("\n");
            }
            //  close the file after writing all the data
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}