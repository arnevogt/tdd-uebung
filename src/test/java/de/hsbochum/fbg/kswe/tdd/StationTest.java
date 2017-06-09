/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsbochum.fbg.kswe.tdd;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import org.hamcrest.CoreMatchers;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Arne
 */
public class StationTest {

    @Test
    public void testDistance() {
        GeometryFactory gf = new GeometryFactory();
        Point a = gf.createPoint(new Coordinate(0.0, 0.0));
        Point b = gf.createPoint(new Coordinate(10.0, 0.0));

        Station s1 = new Station(a, "Station1");
        Station s2 = new Station(b, "Station2");

        Assert.assertThat(s1.calculateDistance(s2), CoreMatchers.is(10.0));
    }

    @Test
    public void testTimeSeries() {
        TimeSeries ts = new TimeSeries("waterGauge");
        ts.addObservation(new Observation(12.2, new DateTime("2017-06-06T12:00:00+01:00")));
        
        GeometryFactory gf = new GeometryFactory();
        Point a = gf.createPoint(new Coordinate(0.0, 0.0));

        Station s = new Station(a, "Station1");
        
        s.addTimeSeries(ts);
        TimeSeries tsGet = s.getTimeSeries().get(0); 

        Assert.assertThat(ts, CoreMatchers.equalTo(tsGet));
    }

}
