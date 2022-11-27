package CSE563_Final_Project;

import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.ArrayList;

/**
 * loadRoster loads the data and creates array list of studnets from a given csv file (task 9)
 */
public class loadRoster {
    // comma delimiter is used to parse csv file
    public static final String delimiter = ",";

    /**
     * this method reads the data from CSV file and stores it in ArrayList
     * @param csvFile : name of the file
     * @return : ArrayList contains all the students and their data
     */
    public static ArrayList loadData(String csvFile) {
        
        String line = "";
        // create ArrayList of Student data type
        ArrayList<Student> arraylist = new ArrayList<Student>();
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
                new_student.set_program(temp_array[3]);
                new_student.set_academicLevel(temp_array[4]);
                new_student.set_asuriteID(temp_array[5]);

                // add the student to the array list if not already added
                if (!arraylist.stream().anyMatch(x -> x.get_studentID() == new_student.get_studentID() || x.get_asuriteID().equals(new_student.get_asuriteID()))) {
                    arraylist.add(new_student);
                }
            }

            buffer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // return arraylist of data
        return arraylist;
    }
}
