/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsbochum.fbg.kswe.tdd;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arne
 */
public class TimeSeries {

    private String name;
    private final List<Observation> observations;

    public TimeSeries(String name) {
        this.name = name;
        this.observations = new ArrayList<>();
    }

    public TimeSeries(String name, List<Observation> observations) {
        this.name = name;
        this.observations = observations;
    }

    public void addObservation(Observation o) {
        this.observations.add(o);
    }

    public void removeObservation(Observation o) {
        this.observations.remove(o);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double calculateMean() {
        double valueMeter;
        double sum = 0.0;
        int size = this.observations.size();

        for (Observation o : this.observations) {
            valueMeter = o.getValue(Unit.M);
            sum += valueMeter;
        }

        double avg = (sum / size);

        return avg;
    }

    public double calculateMean(Unit unit) {
        double valueMeter;
        double sum = 0.0;
        int size = this.observations.size();

        for (Observation o : this.observations) {
            valueMeter = o.getValue(unit);
            sum += valueMeter;
        }

        double avg = (sum / size);

        return avg;
    }

}
