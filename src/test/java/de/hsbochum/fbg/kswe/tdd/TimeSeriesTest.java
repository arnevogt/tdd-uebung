package de.hsbochum.fbg.kswe.tdd;

import org.hamcrest.CoreMatchers;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author <a href="mailto:m.rieke@52north.org">Matthes Rieke</a>
 */
public class TimeSeriesTest {

    @Test
    public void testStatistics() {
        TimeSeries ts = new TimeSeries("waterGauge");
        ts.addObservation(new Observation(12.2, new DateTime("2017-06-06T12:00:00+01:00")));
        ts.addObservation(new Observation(12.4, new DateTime("2017-06-06T12:30:00+01:00")));
        ts.addObservation(new Observation(14.4, new DateTime("2017-06-06T13:00:00+01:00")));

        Assert.assertThat(ts.calculateMean(), CoreMatchers.is(13.0));
    }

    @Test
    public void testStatisticsUnit() {
        TimeSeries ts = new TimeSeries("waterGauge");
        ts.addObservation(new Observation(1, new DateTime("2017-06-06T12:00:00+01:00"), Unit.M));
        ts.addObservation(new Observation(10, new DateTime("2017-06-06T12:30:00+01:00"), Unit.DM));
        ts.addObservation(new Observation(100, new DateTime("2017-06-06T13:00:00+01:00"), Unit.CM));

        Assert.assertThat(ts.calculateMean(Unit.DM), CoreMatchers.is(10.0));
    }

}
