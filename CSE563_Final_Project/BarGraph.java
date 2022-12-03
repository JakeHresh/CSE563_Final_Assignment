/** This function makes the BarGraph class which is responsible to display data grapph
 * @author CSE563 Team
 * @version 1.0
*/

package CSE563_Final_Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.lang.String;

/**
 * BarGraph class is used to display the data in form of the graph
 */
public class BarGraph {

    // model instance of the bar graph
    protected BarGraphModel model;
    
    protected static final Font BAR_TITLE_FONT = new Font("Calibri", Font.PLAIN, 12);
    
    /**
    * BarGraph class is used to display the data in form of the graph
    * @param table - takes the input from the Table class that has all the stored data in it
    */
    public BarGraph(Table table) {
    	
        this.model = new BarGraphModel();

        model.setLocation(50, 50);				// Setting location of the border line of bar plot
        model.setSize(1000, 300);				// Setting Size of the border line of bar plot
                
        int x = table.getColumnCount();
 
        for(int column = 4;column < x; column++)	// for loop to assign weights to the bars in bar plot
        {
        	String date = table.getColumnName(column);
    		int attendance[] = table.getAttendance(column);

    		int count=0;
    		for(int i = 0; i < attendance.length; i++) {  		// this for loop is to ignore the non attendees.
    			
    			if(attendance[i]!=0)
    			{
    				count = count+1;
    			}
    			
    		}
    					
			BarGraphModel.BarItem
        	item = new BarGraphModel.BarItem(date);
        	item.percentage = count;
        	model.addItem(item);        	
        }
    
    }
    
    /**
     * returns the model of the BarGraph
     * @return BarGraphModel
     */
    public BarGraphModel getModel() {
        return model;
    }

    /**
     * updates the bar graph model
     * @param model - set the model of this bar graph
     */
    public void setModel(BarGraphModel model) {
        this.model = model;
    }
    
    /**
     * draw garphics 
     * @param g - Graphics needed to be drawn
     */
    public void draw(Graphics g){
        drawItems(g);
        drawBoarder(g);
    }
    
    /**
     * method to show the bar graph on the screen
     * @param g - Graphics to show
     */
    private void drawItems(Graphics g){				// this method is to display the bar graph 
        int i = 1;
        g.setFont(BAR_TITLE_FONT);
        FontMetrics fm = g.getFontMetrics(BAR_TITLE_FONT);
        
        
      // To calculate the height of the bar plot based on the percentage of the model size.
        for (BarGraphModel.BarItem item : model.items){
            
            int percentHeight = ((int)((double)item.percentage/100 * model.getSize().height));
            
            int x = i * model.getHorizontalGap();
            int y = model.getY() + model.getSize().height - percentHeight;
            int w = item.width;
            int h = percentHeight;
            g.setColor(item.background==null ? new Color(136, 193, 251) : item.background);
            g.fillRect(x, y, w, h);
            i++;
            
      //Draw the title
            int sw = fm.stringWidth(item.title);
            if (sw < item.width){
                x = x + ((item.width - sw)/2);
            } else {
                x = x - ((sw - item.width)/2);
            }
            
            y = model.getY() + model.getSize().height + BAR_TITLE_FONT.getSize();
            g.drawString(item.title, x, y);
        }
        
     //Draw Y axis points
        String str[] = {"100","90","80","70","60","50","40","30","20","10"};
    	
    	int ydiff =  (model.getSize().height)/10;
    	
    	int yx = model.getY()+ydiff;
    	
    	g.drawString(str[0],25, model.getY());
        for(int e=1; e<10; e++) {
        	
        	g.drawString(str[e],25, yx);
        	yx = yx+ydiff;
    }
    }
    
    /**
     * this method is used to draw the border of the bar graph
     * @param g - Graphics
     */
    private void drawBoarder(Graphics g){
        g.setColor(Color.cyan);
        g.drawRoundRect(model.getX(), model.getY(), model.getSize().width, model.getSize().height, 5, 5);
    }
}


