package com.bibounde.pcharts.shared.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Range implements Serializable {

    private double start, stop, step;

    public Range(double start, double stop, double step) {
        super();
        this.start = start;
        this.stop = stop;
        this.step = step;
    }
    
    public String[] getRangeArrayAsString() {
        List<String> ret = new ArrayList<String>();
        for (double i = start; i < stop; i += step) {
            ret.add(String.valueOf(i));
        }
        return ret.toArray(new String[ret.size()]);
    }
    
    public double[] getRangeArray() {
        List<Double> retList = new ArrayList<Double>();
        for (double i = start; i < stop; i += step) {
            retList.add(i);
        }
        double[] ret = new double[retList.size()];
        for (int i = 0; i < retList.size(); i++) {
            ret[i] = retList.get(i);
        }
        return ret;
    }

    /**
     * @return the start
     */
    public double getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(double start) {
        this.start = start;
    }

    /**
     * @return the stop
     */
    public double getStop() {
        return stop;
    }

    /**
     * @param stop the stop to set
     */
    public void setStop(double stop) {
        this.stop = stop;
    }

    /**
     * @return the step
     */
    public double getStep() {
        return step;
    }

    /**
     * @param step the step to set
     */
    public void setStep(double step) {
        this.step = step;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Range [start=" + start + ", stop=" + stop + ", step=" + step + "]";
    }
    
    public static  Range getAutoRange(double minValue, double maxValue, double step) {
        double start = 0d;
        double stop = maxValue + step;
        double autoStep = step == 0 ? Math.abs((maxValue - minValue)/4) : step; 
        if (minValue < 0) {
            //0 must be displayed
            double initialStart = 1 - Math.max(Math.abs(minValue), maxValue) - autoStep;
            while(start > initialStart) {
                start -= autoStep;
            }
            stop = 1 - start; 
        }
        
        return new Range(start, stop, autoStep);
    }
}
