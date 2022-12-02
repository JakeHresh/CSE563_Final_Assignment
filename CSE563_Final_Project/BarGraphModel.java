package CSE563_Final_Project;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

// ** This class is for assigning the sized of each bar and the spacing between each bar.
//** It includes the setting of color, font, background color, setting location.
public class BarGraphModel {
    
    public static class BarItem {
        public int index;
        public int percentage;
        public int width;
        public String title;
        public Color background;
        
        public BarItem(String title){
            this.title = title;
        }
    }
    
    public static final int DEFAULT_ITEM_WIDTH = 40;
    
    protected List<BarItem> items = new ArrayList<BarItem>();
    protected Point location = new Point();
    protected Dimension size =  new Dimension();
    protected int horizontalGap = DEFAULT_ITEM_WIDTH * 2;
    
    public BarGraphModel() {

    }

    public void setHorizontalGap(int horizontalGap) {
        this.horizontalGap = horizontalGap;
    }
    
    public int getHorizontalCenterBarPosition(){
        return getX() + (getSize().width - (DEFAULT_ITEM_WIDTH+horizontalGap));
    }

    
    public int getHorizontalGap() {
        return horizontalGap;
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(int width, int height) {
        size.width = width;
        size.height = height;
    }

    public void setLocation(int x, int y) {
        this.location.x = x;
        this.location.y = y;
    }

    public Point getLocation() {
        return location;
    }
    
    public int getX(){
        return location.x;
    }
    
    public int getY(){
        return location.y;
    }
    
    public void addItem(BarItem item){
        item.width = item.width == 0 ? DEFAULT_ITEM_WIDTH: item.width;
        items.add(item);
    }
    
    public BarItem itemAt(int index){
        return items.get(index);
    }
    
    public BarItem removeItemAt(int index){
        return items.remove(index);
    }
}
