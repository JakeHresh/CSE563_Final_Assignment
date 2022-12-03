package CSE563_Final_Project;

// Copyright 2022 CSE563 Team
// 
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// 
//     http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/** Student data structure to store information of the students
 * @author CSE563 Team
 * @version 1.0
*/


/**
 * Student class is responsible to store student's information including: studnet_id, first and last name, program, academic level, and asurite id (task 37)
 */
public class Student{

  	private int studentID;
    private String fName;
    private String lName;
    private String asuriteID;

    /**
     * initialization of the Student data to null
     */
    public Student() {
        studentID = 0;
        fName = null;
        lName = null;
        asuriteID = null;
    }

    /**
     * initialization of the Student data to specific values
	 * @param ID - integer ID for the student
	 * @param firstName - first name of the student in string
	 * @param lastName - last name of the student in string
	 * @param asuID - asurite id of the student in string
     */
    public Student(int ID, String firstName, String lastName, String asuID) {
        studentID = ID;
        fName = firstName;
        lName = lastName;
        asuriteID = asuID;
    }

    /**
     * setter for studentID
     * 
     * @param id - set student id
     */
    public void set_studentID(int id) {
        this.studentID = id;
    }

    /**
     * setter for fName
     * 
     * @param firstName - first name update
     */
    public void set_fName(String firstName) {
        this.fName = firstName;
    }

    /**
     *setter for lName
     * 
     * @param lastName - last name update
     */
    public void set_lName(String lastName) {
        this.lName = lastName;
    }

    /**
     * setter for Asurite ID
     * 
     * @param asuID - asurite ID update
     */
    public void set_asuriteID(String asuID) {
        this.asuriteID = asuID;
    }

    /**
     * getter for studentID
	 * @return int
     */
    public int get_studentID() {
        return studentID;
    }

    /**
     * getter for first name
	 * @return String
     */
    public String get_fName() {
        return fName;
    }

    /**
     * getter for last name
	 * @return String
     */
    public String get_lName() {
        return lName;
    }

    /**
     * getter for Asurite ID
	 * @return String
     */
    public String get_asuriteID() {
        return asuriteID;
    }

}
