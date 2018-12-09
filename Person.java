package myfamily;

/**
 *
 * @author Andy Jagello
 */

import java.awt.Point;

public class Person {
    private int id;
    private String name;
    private java.util.List<Point> track;
    
    public Person(){
        track = new java.util.ArrayList<Point>();
    }

    public void setId(int id){
        this.id=id;
    }
    
    public int getId(){
        return id;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public String getName(){
        return name;
    }
    
    public void clearTrack(){
        track.clear();
    }
    
    public void addPointToTrack(Point point){
        track.add(point);
    }
    
    public Point getCurrentPoint(){
        Point result = null;
        if (track.size()>0) result = track.get(track.size()-1);
        return result;
        
    }
    
}
