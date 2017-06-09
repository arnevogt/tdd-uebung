
package de.hsbochum.fbg.kswe.tdd;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author <a href="mailto:m.rieke@52north.org">Matthes Rieke</a>
 */
public class Station {
    
    private Point location;
    private String name;
    private final List<TimeSeries> timeSeries;

    public Station(Point location, String name) {
        this.location = location;
        this.name = name;
        this.timeSeries = new ArrayList<>();
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addTimeSeries(TimeSeries ts){
        this.timeSeries.add(ts);
    }

    public List<TimeSeries> getTimeSeries() {
        return timeSeries;
    }
    
    public double calculateDistance(Station otherStation){
        Coordinate thisCoord = this.getLocation().getCoordinate();
        Coordinate otherCoord = otherStation.getLocation().getCoordinate();
        
        return thisCoord.distance(otherCoord);
    }
    
}
