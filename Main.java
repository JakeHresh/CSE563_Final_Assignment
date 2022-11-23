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

/** Represents an main menu for the application.
 * @author CSE563 Team
 * @version 1.0
*/

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

class Main{
    public static void main(String[] args) {
        JFrame menuMain = new JFrame();
        menuMain.setTitle("CSE563 Final Project");
        menuMain.setSize(1366, 786);
        menuMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuMain.setVisible(true);

        JMenuBar menuBarMain = new JMenuBar();
        menuMain.setJMenuBar(menuBarMain);

        JMenu optionFile = new JMenu("File");
        menuBarMain.add(optionFile);

        JMenu optionAbout = new JMenu("About");
        menuBarMain.add(optionAbout);

        JMenuItem menuItemLoadRoster = new JMenuItem("Load Roster");
        optionFile.add(menuItemLoadRoster);

        JMenuItem menuItemAddAttendance = new JMenuItem("Add Attendance");
        optionFile.add(menuItemAddAttendance);

        JMenuItem menuItemSave = new JMenuItem("Save");
        optionFile.add(menuItemSave);

        JMenuItem menuItemPlotData = new JMenuItem("Plot Data");
        optionFile.add(menuItemPlotData);
    }
}
