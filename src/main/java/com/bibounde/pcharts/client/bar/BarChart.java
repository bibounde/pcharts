package com.bibounde.pcharts.client.bar;

import com.bibounde.pcharts.client.AbstractChart;
import com.bibounde.pcharts.shared.bar.BarChartHelper;
import com.bibounde.pcharts.shared.bar.BarChartModel;
import com.bibounde.pcharts.shared.bar.BarJSModel;
import com.bibounde.pcharts.shared.bar.BarTooltipFormatter;
import com.bibounde.pcharts.shared.bar.DefaultBarTooltipFormatter;
import com.bibounde.pcharts.shared.common.AxisLabelFormatter;
import com.bibounde.pcharts.shared.common.DefaultAxisLabelFormatter;

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
    protected void updateJSModel() {
        BarJSModel jsModel = (BarJSModel) this.widget.getModel();
        this.helper.updateJSModel(jsModel, tooltipFormatter, yAxisLabelFormatter);
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
