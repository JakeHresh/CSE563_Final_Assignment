package CSE563_Final_Project;

import java.io.*;
import java.io.File;
import java.io.FileReader;
import javax.swing.table.TableModel;

/**
 * loadAttendance parses an attendance file and updates the table accordingly
 */

public class loadAttendance {
    // comma delimiter is used to parse csv file
    public static final String delimiter = ",";

    /**
     * this method parses an attendance csv file and updates the table accordingly
     * @param csvFile : name of the file
     * @param model : table's data model
     * @param column : table's data model
     */
    public static void parseAttendanceFile(String csvFile, TableModel model, int columnIndex) {
        
        String line = "";
        int idColumn = 5;

        try {
            // reading the file 
            File fileFd = new File(csvFile);
            FileReader fileReader = new FileReader(fileFd);
            BufferedReader buffer = new BufferedReader(fileReader);

            // read line by line
            while ((line = buffer.readLine()) != null) {
                //split line into id and time
                String[] idTimeArray = line.split(delimiter);
                String id = idTimeArray[0];
                int time = Integer.parseInt(idTimeArray[1]);

                //check model for this line's id; if it exists in the roster, update the time attended
                boolean foundID = false;
                for(int i = 0; i < model.getRowCount(); i++){
                    if(model.getValueAt(i, idColumn).equals(id)) {
                        foundID = true;
                        time += (int)model.getValueAt(i, columnIndex);
                        model.setValueAt(time, i, columnIndex);
                    }
                }
                //if the id is not found in roster, inform user (NYI)
                if(!foundID){
                    System.out.println("User " + id + " who attended for " + time + " minutes is not a part of the roster!");
                }
            }

            buffer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
