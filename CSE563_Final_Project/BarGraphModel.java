/** This file makes the BarGraphModel class 
 * @author CSE563 Team
 * @version 1.0
*/
package CSE563_Final_Project;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is for assigning the sized of each bar and the spacing between each bar.
 * It includes the setting of color, font, background color, setting location.
 */
public class BarGraphModel {
    
    /**
     * this is the static method of this class making an item of the BAR model
     */
    public static class BarItem {
        // index of the item
        public int index;
        // percentage
        public int percentage;
        // width of the graph
        public int width;
        // title of the graph
        public String title;
        // background color of this graph
        public Color background;
        
        public BarItem(String title){
            this.title = title;
        }
    }

    // default width
    public static final int DEFAULT_ITEM_WIDTH = 40;
    // some variables to be used
    protected List<BarItem> items = new ArrayList<BarItem>();
    // location of the bar graph
    protected Point location = new Point();
    // size of the bar graph
    protected Dimension size =  new Dimension();
    // horizontal gap
    protected int horizontalGap = DEFAULT_ITEM_WIDTH * 2;
    
    /**
     * constructor of the class which is empthy
     */
    public BarGraphModel() {

    }

    /**
     * function to set the horizontal gap
     * @param horizontalGap - the setter parameter for this gap
     */
    public void setHorizontalGap(int horizontalGap) {
        this.horizontalGap = horizontalGap;
    }
    
    /**
     * method to get the horizontal center bar position
     * @return int
     */
    public int getHorizontalCenterBarPosition(){
        return getX() + (getSize().width - (DEFAULT_ITEM_WIDTH+horizontalGap));
    }

    /**
     * method to get the horizontal gap of this bar graph
     * @return int
     */
    public int getHorizontalGap() {
        return horizontalGap;
    }

    /**
     * method to get the size of the bar graph
     * @return Dimension
     */
    public Dimension getSize() {
        return size;
    }

    /**
     * method to set the size of the bar graph
     * @param width - width of teh graph
     * @param height - height of the graph
     */
    public void setSize(int width, int height) {
        size.width = width;
        size.height = height;
    }

    /**
     * method to set the location of the graph
     * @param x - x coordinate
     * @param y - y coordinate
     */
    public void setLocation(int x, int y) {
        this.location.x = x;
        this.location.y = y;
    }

    /**
     * method to get the location in (x,y) point
     * @return Point
     */
    public Point getLocation() {
        return location;
    }
    
    /**
     * get x coordinate of location
     * @return int
     */
    public int getX(){
        return location.x;
    }
    
    /**
     * get y coordinate of location 
     * @return int
     */
    public int getY(){
        return location.y;
    }
    
    /**
     * add the bar item to the graph
     * @param item - BarItem
     */
    public void addItem(BarItem item){
        item.width = item.width == 0 ? DEFAULT_ITEM_WIDTH: item.width;
        items.add(item);
    }
    
    /**
     * get the item at a point in the bar
     * @param index - index of the item
     * @return BarItem
     */
    public BarItem itemAt(int index){
        return items.get(index);
    }
    
    /**
     * remove the item from one index and return it
     * @param index - index of the item to be removed
     * @return BarItem
     */
    public BarItem removeItemAt(int index){
        return items.remove(index);
    }
}
