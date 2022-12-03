/** This file makes the BarGraphApp class 
 * @author CSE563 Team
 * @version 1.0
*/
package CSE563_Final_Project;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


/** 
 * This function makes the JPanel child class for BarGraphApp
*/
public class BarGraphApp extends JPanel {

    // variables to be used here
    private BarGraph graph;
    private BarGraphModel model;
    
    /**
     * Constructor of the class
     * @param table - Table class object is being passsed, it combines the BarGraph and its model
     */
    public BarGraphApp(Table table) {
        setBackground(new Color(27, 29, 77));
        this.graph = new BarGraph(table);
        this.model = graph.getModel();

    }

    /**
     * overrides the paintComponent of the JPanel class
     * @param g - Graphics
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        graph.draw(g);
    }
}
