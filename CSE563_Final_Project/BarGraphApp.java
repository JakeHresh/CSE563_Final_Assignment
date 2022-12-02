package CSE563_Final_Project;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;



public class BarGraphApp extends JPanel {


    private BarGraph graph;
    private BarGraphModel model;
    
    public BarGraphApp(Table table) {
        setBackground(new Color(27, 29, 77));
        this.graph = new BarGraph(table);
        this.model = graph.getModel();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        graph.draw(g);
    }
}
