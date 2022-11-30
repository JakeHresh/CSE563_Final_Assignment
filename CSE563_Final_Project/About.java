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
	// parent menu is the parent menu option for the About class
	private Component parent_menu;
	private JMenu menu;

	public About(Component parent_menu) {
		super("About");

		this.parent_menu = parent_menu;
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
					parent_menu,
						"Team Members:\n" +
								"Simran Bhalla - ssbhalla@asu.edu\n" +
								"Omkar Pisal - opisal@asu.edu\n" +
								"Haritej Lakshami Narayan - hlakshm2@asu.edu\n" +
								"Jacob Hreshchyshyn  - jhreshch@asu.edu\n" +
								"London Fischer - Lcfisch2@asu.edu\n" +
								"Preetham Akunuri - pakunur1@asu.edu",
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