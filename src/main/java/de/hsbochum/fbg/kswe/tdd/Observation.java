/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsbochum.fbg.kswe.tdd;

import org.joda.time.DateTime;

/**
 *
 * @author Arne
 */
public class Observation {

    private double value;
    private DateTime time;
    private Unit unit;

    public Observation() {
    }

    public Observation(double value, DateTime time) {
        this.time = time;
        this.unit = Unit.M;
        this.value = valueToMeter(value, this.unit);
    }

    public Observation(double value, DateTime time, Unit unit) {
        this.time = time;
        this.unit = unit;
        this.value = valueToMeter(value, this.unit);
    }

    public DateTime getTime() {
        return time;
    }

    public void setTime(DateTime time) {
        this.time = time;
    }

    public double getValue() {
        return valueMeterToUnit(this.unit);
    }

    public double getValue(Unit unit) {
        return valueMeterToUnit(unit);
    }

    public void setValue(double value) {
        this.value = valueToMeter(value, this.unit);
    }
    
    public void setValue(double value, Unit unit) {
        this.value = valueToMeter(value, unit);
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    private double valueToMeter(double value, Unit unit) {
        double valueMeter;

        switch (unit) {
            case MM:
                valueMeter = value / 1000;
                break;
            case CM:
                valueMeter = value / 100;
                break;
            case DM:
                valueMeter = value / 10;
                break;
            default:
                valueMeter = value;
                break;
        }
        return valueMeter;
    }
    
    private double valueMeterToUnit(Unit unit){
        double valueUnit;

        switch (unit) {
            case MM:
                valueUnit = this.value * 1000;
                break;
            case CM:
                valueUnit = this.value * 100;
                break;
            case DM:
                valueUnit = this.value * 10;
                break;
            default:
                valueUnit = this.value;
                break;
        }
        return valueUnit;
    }

}
