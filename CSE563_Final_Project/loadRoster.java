package CSE563_Final_Project;

import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * loadRoster loads the data and creates array list of studnets from a given csv file (task 9)
 */
public class loadRoster {
    // comma delimiter is used to parse csv file
    public static final String delimiter = ",";

    /**
     * this method reads the data from CSV file and stores it in ArrayList
     * @param csvFile : name of the file
     * @return : LinkedList contains all the students and their data
     */
    public static LinkedList<Student> loadData(String csvFile) {
        
        LinkedList<Student> link_list = new LinkedList<Student>();
        String line = "";

        // temporary array
        String[] temp_array;

        try {
            // reading the file 
            File fileFd = new File(csvFile);
            FileReader fileReader = new FileReader(fileFd);
            BufferedReader buffer = new BufferedReader(fileReader);

            // read line by line
            while ((line = buffer.readLine()) != null) {

                temp_array = line.split(delimiter);

                // store the information of each student
                Student new_student = new Student();
                new_student.set_studentID(Integer.parseInt(temp_array[0]));
                new_student.set_fName(temp_array[1]);
                new_student.set_lName(temp_array[2]);
                new_student.set_asuriteID(temp_array[3]);

                // add the student to the linked list if not already added
                if (!link_list.stream().anyMatch(x -> x.get_studentID() == new_student.get_studentID() || x.get_asuriteID().equals(new_student.get_asuriteID()))) {
                    link_list.add(new_student);
                }
            }

            buffer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // return linked list of data
        return link_list;
    }
}
