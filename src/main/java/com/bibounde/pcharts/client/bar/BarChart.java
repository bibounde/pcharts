package com.bibounde.pcharts.client.bar;

import com.bibounde.pcharts.client.AbstractChart;
import com.bibounde.pcharts.shared.bar.BarChartHelper;
import com.bibounde.pcharts.shared.bar.BarChartHelper.ProtovisConvertedData;
import com.bibounde.pcharts.shared.bar.BarChartModel;
import com.bibounde.pcharts.shared.bar.BarTooltipFormatter;
import com.bibounde.pcharts.shared.bar.DefaultBarTooltipFormatter;
import com.bibounde.pcharts.shared.bar.Serie;
import com.bibounde.pcharts.shared.common.AxisLabelFormatter;
import com.bibounde.pcharts.shared.common.DefaultAxisLabelFormatter;
import com.bibounde.pcharts.shared.common.Padding;
import com.bibounde.pcharts.shared.common.Range;

public class BarChart extends AbstractChart {
    
    private AxisLabelFormatter yAxisLabelFormatter = new DefaultAxisLabelFormatter();
    private BarTooltipFormatter tooltipFormatter = new DefaultBarTooltipFormatter();
    private BarChartHelper helper;
    
    public BarChart() {
        super(new BarChartWidget(), new BarChartModel());
        this.helper = new BarChartHelper(this.getBarChartModel());
    }
    
    private BarChartModel getBarChartModel() {
        return (BarChartModel) this.chartModel;
    }
    
    @Override
    protected void synchronize() {
        BarWidgetModel widgetModel = (BarWidgetModel) this.widget.getModel();
        
        int groupCount = 0;
        double minValue = 0d, maxValue = 0d;
        for (Serie serie : this.getBarChartModel().getSeries()) {
            for (int i = 0; i < serie.getValues().length; i++) {
                minValue = minValue < serie.getValues()[i] ? minValue : serie.getValues()[i];
                maxValue = maxValue < serie.getValues()[i] ? serie.getValues()[i] : maxValue;
            }
            groupCount = groupCount < serie.getValues().length ? serie.getValues().length : groupCount;
        }
        Padding padding = new Padding(10d, 10d, 10d, minValue < 0 ? 10d : 0d);
        String[] groupNames = this.helper.getGroupNames(groupCount);
        
        widgetModel.setGroupNames(groupNames);
        
        ProtovisConvertedData data = this.helper.getProtovisData(groupNames, tooltipFormatter);
        widgetModel.setSerieNames(data.serieNames);
        widgetModel.setGroupValues(data.groupValues);
        
        boolean tooltipEnabled = this.getBarChartModel().isTooltipEnabled();
        widgetModel.setTooltipEnabled(tooltipEnabled);
        if (tooltipEnabled) {
            widgetModel.setGroupTooltipValues(data.tooltipValues);
        }
        
        double bottom = this.helper.getAutoBottom(minValue);
        widgetModel.setPanelBottom(bottom);
        widgetModel.setPanelLeft(this.getBarChartModel().getMarginLeft());
        
        double groupWidth = this.helper.getAutoGroupWidth(groupCount, padding);
        widgetModel.setGroupWidth(groupWidth);
        widgetModel.setGroupInset(this.getBarChartModel().getGroupInset());
        widgetModel.setBarHeight(this.helper.getAutoBarHeight(minValue, maxValue, bottom, padding));
        widgetModel.setBarWidth(this.helper.getAutoBarWidth(groupWidth));
        widgetModel.setBarInset(this.getBarChartModel().getBarInset());

        widgetModel.setPaddingLeft(padding.getLeft());
        widgetModel.setPaddingBottom(padding.getBottom());
        widgetModel.setPaddingRight(padding.getRight());
        widgetModel.setPaddingTop(padding.getTop());
        
        widgetModel.setXAxisEnabled(this.getBarChartModel().isXAxisEnabled());
        widgetModel.setXAxisLabelEnabled(this.getBarChartModel().isXAxisLabelEnabled());

        widgetModel.setYAxisEnabled(this.getBarChartModel().isYAxisEnabled());
        widgetModel.setYAxisLabelEnabled(this.getBarChartModel().isYAxisLabelEnabled());

        // Add y axis values and their formatted text
        Range rangeY = Range.getAutoRange(minValue, maxValue, this.getBarChartModel().getYAxisLabelStep());
        double[] rangeYValues = rangeY.getRangeArray();
        String[] rangeYSValues = new String[rangeYValues.length];
        for (int i = 0; i < rangeYValues.length; i++) {
            rangeYSValues[i] = this.yAxisLabelFormatter.format(rangeYValues[i]);
        }
        widgetModel.setYAxisLabelRangeValues(rangeYValues);
        widgetModel.setYAxisLabelRangeTextValues(rangeYSValues);
        widgetModel.setYAxisGridEnabled(this.getBarChartModel().isYAxisGridEnabled());
    }

    /**
     * Appends serie values
     * @param name name of the serie
     * @param values values
     * @return serie index
     */
    public int addSerie(String name, double[] values) {
        return this.getBarChartModel().addSerie(name, values);
    }

    /**
     * Clears all serie values
     */
    public void clearSeries() {
        this.getBarChartModel().getSeries().clear();
    }

    /**
     * Sets the names of group
     * @param groupNames new names of group
     */
    public void setGroupNames(String[] groupNames) {
        this.getBarChartModel().setGroupNames(groupNames);
    }

    /**
     * Sets space (unit : pixels) between groups
     * @param groupInset space (unit : pixels) between groups
     */
    public void setGroupInset(double groupInset) {
        this.getBarChartModel().setGroupInset(groupInset);
    }

    /**
     * Sets space (unit : pixels) between bar in each group
     * @param barInset space (unit : pixels) between bar in each group
     */
    public void setBarInset(double barInset) {
        this.getBarChartModel().setBarInset(barInset);
    }

    /**
     * Sets visibility of x axis
     * @param visible x axis visibility
     */
    public void setXAxisVisible(boolean visible) {
        this.getBarChartModel().setXAxisEnabled(visible);
        this.getBarChartModel().setXAxisLabelEnabled(false);
    }

    /**
     * Sets visibility of x axis labels
     * @param visible x axis label visibility
     */
    public void setXAxisLabelVisible(boolean visible) {
        this.getBarChartModel().setXAxisEnabled(this.getBarChartModel().isXAxisEnabled() || visible);
        this.getBarChartModel().setXAxisLabelEnabled(visible);
    }

    /**
     * Sets visibility of y axis
     * @param visible y axis visibility
     */
    public void setYAxisVisible(boolean visible) {
        this.getBarChartModel().setYAxisEnabled(visible);
        this.getBarChartModel().setYAxisLabelEnabled(false);
    }

    /**
     * Sets visibility of y axis labels
     * @param visible y axis label visibility
     */
    public void setYAxisLabelVisible(boolean visible) {
        this.getBarChartModel().setYAxisEnabled(this.getBarChartModel().isYAxisEnabled() || visible);
        this.getBarChartModel().setYAxisLabelEnabled(visible);
    }

    /**
     * Sets y axis label step (used to display ticks on y axis)
     * @param step y axis label step
     */
    public void setYAxisLabelStep(double step) {
        this.getBarChartModel().setYAxisLabelStep(step);
    }

    /**
     * Sets visibility of horizontal lines
     * @param visible horizontal line visibility
     */
    public void setYAxisGridVisible(boolean visible) {
        this.getBarChartModel().setYAxisEnabled(this.getBarChartModel().isYAxisEnabled() || visible);
        this.getBarChartModel().setYAxisGridEnabled(visible);
    }

    /**
     * Sets y axis label formatter
     * @param yAxisLabelFormatter y axis label formatter
     */
    public void setYAxisLabelFormatter(AxisLabelFormatter yAxisLabelFormatter) {
        if (yAxisLabelFormatter == null) {
            this.yAxisLabelFormatter = new DefaultAxisLabelFormatter();
        } else {
            this.yAxisLabelFormatter = yAxisLabelFormatter;
        }
    }

    /**
     * Sets tooltip formatter
     * @param tooltipFormatter tooltip formatter
     */
    public void setTooltipFormatter(BarTooltipFormatter tooltipFormatter) {
        this.tooltipFormatter = tooltipFormatter;
        this.getBarChartModel().setTooltipEnabled(tooltipFormatter != null);
    }
}
