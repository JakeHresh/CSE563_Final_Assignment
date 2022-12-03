/** This file is responsible to handel Main window shown
 * @author CSE563 Team
 * @version 1.0
*/
package CSE563_Final_Project;

import javax.swing.*;
import java.awt.*;

/**
 * Main frame extends the JFrame class 
 */
public class MainFrame extends JFrame {
    // frmae and panel used
    private JFrame frame;
    private JPanel panel;

    /**
     * constructor
     */
    public MainFrame() {
        initialize();
    }

    /**
     * initialization takes place here
     */
    private void initialize() {

        frame = new JFrame();
        frame.setTitle("CSE563 Final Project");

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));

        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);

        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);

        JMenuBar menuBarMain = new JMenuBar();
        frame.setJMenuBar(menuBarMain);

        menuBarMain.add(new File(this));

        JMenu optionAbout = new JMenu();
        menuBarMain.add(new About(optionAbout));


    }
}
