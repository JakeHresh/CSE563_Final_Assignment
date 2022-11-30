package CSE563_Final_Project;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JFrame frame;
    private JPanel panel;

    public MainFrame() {
        initialize();
    }

    private void initialize() {

        frame = new JFrame();
        frame.setTitle("CSE563 Final Project");

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));

        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
