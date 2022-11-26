package CSE563_Final_Project;

/** Represents About Menu for the class
 * @author CSE563 Team
 * @version 1.0
*/

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * About class displays the menu displaying the team members information
 */
public class About extends JMenu {
	private Component parent;
	private JMenu menu;

	public About(Component parent) {
		super("About");

		this.parent = parent;
		this.menu = this;

		/**
		 * When the About Button is clicked then this function will be called
		 */
		addMenuListener(new MenuListener() {
			/**
			 * Action performed when the menu is selected
			 * @param arg0 - Action used to interact with menu class
			 */
			@Override
			public void menuSelected(MenuEvent arg0) {
				// Display pop up
				JOptionPane.showMessageDialog(
						parent,
						"Team Members:\n" +
								"Simran Bhalla - ssbhalla@asu.edu\n" +
								"Member 2 - member2@asu.edu\n" +
								"Member 3 - member3@asu.edu\n" +
								"Member 4 - member4@asu.edu\n" +
								"Member 5 - member5@asu.edu\n" +
								"Member 6 - member6@asu.edu",
						"About",
						JOptionPane.PLAIN_MESSAGE);

				new Timer(50, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						menu.setSelected(false);
					}
				}).start();
			}

			/**
			 * Unused 
			 * @param arg0
			 */
			@Override
			public void menuCanceled(MenuEvent arg0) {
				return;
			}

			/**
			 * Unused
			 * @param arg0
			 */
			@Override
			public void menuDeselected(MenuEvent arg0) {
				return;
			}
		});
	}

}