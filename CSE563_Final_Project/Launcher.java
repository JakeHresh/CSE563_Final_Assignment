package CSE563_Final_Project;

import javax.swing.*;
import java.awt.*;

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
                            // TODO Auto-generated catch block
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
