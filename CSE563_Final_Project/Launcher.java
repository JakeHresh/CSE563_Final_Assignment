/** This file is responsible to handel the main frame
 * @author CSE563 Team
 * @version 1.0
*/
package CSE563_Final_Project;

import javax.swing.*;
import java.awt.*;

/**
 * Launcher class to run the main function
 */
public class Launcher {
    public static void main(String[] args) {
        // Run this program on the Event Dispatch Thread (EDT)
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        try {
                            UIManager.setLookAndFeel(info.getClassName());
                        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                                 | UnsupportedLookAndFeelException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }

                new MainFrame();
            }
        });
    }
}
