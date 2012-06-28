package com.bibounde.pcharts.shared.bar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bibounde.pcharts.shared.common.Padding;

public class BarChartHelper {
    
    private BarChartModel model;

    public BarChartHelper(BarChartModel model) {
        this.model = model;
    }

    public String[] getGroupNames(int groupCount) {

        String[] ret = new String[groupCount];

        if (this.model.getGroupNames() == null) {
            for (int i = 0; i < groupCount; i++) {
                ret[i] = "";
            }
        } else {
            int namesCount = this.model.getGroupNames().length;
            for (int i = 0; i < groupCount; i++) {
                if (i < namesCount) {
                    ret[i] = this.model.getGroupNames()[i];
                } else {
                    ret[i] = "";
                }
            }
        }

        return ret;
    }

    public double getAutoBottom(double minValue) {
        if (minValue < 0) {
            // Axis is in the center of chart
            return (this.model.getHeight() - this.model.getMarginBottom() - this.model.getMarginTop()) / 2 + this.model.getMarginBottom();
        } else {
            return 0d + this.model.getMarginBottom();
        }
    }

    public double getAutoGroupWidth(int groupCount, Padding padding) {
        double availableWidth = this.model.getWidth() - this.model.getMarginLeft() - this.model.getMarginRight() - padding.getRight() - padding.getLeft()
                - this.model.getLegendAreaWidth() - this.model.getLegendInsetLeft();

        return (availableWidth - ((groupCount - 1) * this.model.getGroupInset())) / groupCount;
    }

    public double getAutoBarHeight(double minValue, double maxValue, double bottom, Padding padding) {
        double availableHeight = this.model.getHeight() - bottom - this.model.getMarginTop() - padding.getTop() - padding.getBottom();

        double minAbs = Math.abs(minValue);
        double max = minAbs > maxValue ? minAbs : maxValue;

        return availableHeight / max;
    }

    public double getAutoBarWidth(double groupWidth) {
        return (groupWidth - ((this.model.getSeries().size() - 1) * this.model.getBarInset())) / this.model.getSeries().size();
    }
    
    public ProtovisConvertedData getProtovisData(String[] groupNames, BarTooltipFormatter tooltipFormatter) {
     // Convert data in protovis mode
        Map<Integer, List<Double>> dataMap = new HashMap<Integer, List<Double>>();
        Map<Integer, List<String>> tooltipMap = new HashMap<Integer, List<String>>();

        String[] serieNames = new String[this.model.getSeries().size()];

        int serieIndex = 0;
        for (Serie serie : this.model.getSeries()) {
            for (int i = 0; i < serie.getValues().length; i++) {
                // Data
                List<Double> values = null;
                if (!dataMap.containsKey(i)) {
                    values = new ArrayList<Double>();
                    dataMap.put(i, values);
                } else {
                    values = dataMap.get(i);
                }
                values.add(serie.getValues()[i]);
                // Tooltips
                if (this.model.isTooltipEnabled()) {
                    List<String> tooltips = null;
                    if (!tooltipMap.containsKey(i)) {
                        tooltips = new ArrayList<String>();
                        tooltipMap.put(i, tooltips);
                    } else {
                        tooltips = tooltipMap.get(i);
                    }
                    tooltips.add(tooltipFormatter.getTooltipHTML(serie.getName(), serie.getValues()[i], groupNames[i]));
                }
            }
            serieNames[serieIndex] = serie.getName();
            serieIndex++;
        }

        ProtovisConvertedData ret = new ProtovisConvertedData();
        
        // Serie names
        ret.serieNames = serieNames;

        // Data
        ret.groupValues = new double[dataMap.size()][];
        int index = 0;
        for (List<Double> values : dataMap.values()) {
            ret.groupValues[index] = new double[values.size()];
            for (int i = 0; i < values.size(); i++) {
                ret.groupValues[index][i] = values.get(i);
            }
            index++;
        }

        // Tooltips
        if (this.model.isTooltipEnabled()) {
            ret.tooltipValues = new String[tooltipMap.size()][];
            index = 0;
            for (List<String> values : tooltipMap.values()) {
                ret.tooltipValues[index] = values.toArray(new String[values.size()]);
                index++;
            }
        }
        
        return ret;
    }
    
    public class ProtovisConvertedData {
        public String[] serieNames;
        public String[][] tooltipValues;
        public double[][] groupValues;
    }
}
