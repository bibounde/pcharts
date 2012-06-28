package com.bibounde.pcharts.client.bar;

import com.bibounde.pcharts.client.AbstractWidgetModel;

public class BarWidgetModel extends AbstractWidgetModel {

    private String[] serieNames;
    private String[] groupNames;
    private String[][] groupTooltipValues;
    private double[][] groupValues; 
    
    private double  panelBottom, panelLeft;
    private double groupWidth, groupInset;
    private double barHeight, barWidth, barInset;
    private double paddingLeft, paddingRight, paddingTop, paddingBottom;
    private boolean isXAxisEnabled, isXAxisLabelEnabled;
    private boolean isYAxisEnabled, isYAxisLabelEnabled;
    private double[] yAxisLabelRangeValues;
    private String[] yAxisLabelRangeTextValues;
    private boolean isYAxisGridEnabled;
    
    /**
     * @return the serieNames
     */
    public String[] getSerieNames() {
        return serieNames;
    }
    /**
     * @param serieNames the serieNames to set
     */
    public void setSerieNames(String[] serieNames) {
        this.serieNames = serieNames;
    }
    /**
     * @return the groupNames
     */
    public String[] getGroupNames() {
        return groupNames;
    }
    /**
     * @param groupNames the groupNames to set
     */
    public void setGroupNames(String[] groupNames) {
        this.groupNames = groupNames;
    }
    /**
     * @return the groupValues
     */
    public double[][] getGroupValues() {
        return groupValues;
    }
    /**
     * @param groupValues the groupValues to set
     */
    public void setGroupValues(double[][] groupValues) {
        this.groupValues = groupValues;
    }
    /**
     * @return the groupTooltipValues
     */
    public String[][] getGroupTooltipValues() {
        return groupTooltipValues;
    }
    /**
     * @param groupTooltipValues the groupTooltipValues to set
     */
    public void setGroupTooltipValues(String[][] groupTooltipValues) {
        this.groupTooltipValues = groupTooltipValues;
    }
    /**
     * @return the panelBottom
     */
    public double getPanelBottom() {
        return panelBottom;
    }
    /**
     * @param panelBottom the panelBottom to set
     */
    public void setPanelBottom(double panelBottom) {
        this.panelBottom = panelBottom;
    }
    /**
     * @return the panelLeft
     */
    public double getPanelLeft() {
        return panelLeft;
    }
    /**
     * @param panelLeft the panelLeft to set
     */
    public void setPanelLeft(double panelLeft) {
        this.panelLeft = panelLeft;
    }
    /**
     * @return the groupWidth
     */
    public double getGroupWidth() {
        return groupWidth;
    }
    /**
     * @param groupWidth the groupWidth to set
     */
    public void setGroupWidth(double groupWidth) {
        this.groupWidth = groupWidth;
    }
    /**
     * @return the groupInset
     */
    public double getGroupInset() {
        return groupInset;
    }
    /**
     * @param groupInset the groupInset to set
     */
    public void setGroupInset(double groupInset) {
        this.groupInset = groupInset;
    }
    /**
     * @return the barHeight
     */
    public double getBarHeight() {
        return barHeight;
    }
    /**
     * @param barHeight the barHeight to set
     */
    public void setBarHeight(double barHeight) {
        this.barHeight = barHeight;
    }
    /**
     * @return the barWidth
     */
    public double getBarWidth() {
        return barWidth;
    }
    /**
     * @param barWidth the barWidth to set
     */
    public void setBarWidth(double barWidth) {
        this.barWidth = barWidth;
    }
    /**
     * @return the barInset
     */
    public double getBarInset() {
        return barInset;
    }
    /**
     * @param barInset the barInset to set
     */
    public void setBarInset(double barInset) {
        this.barInset = barInset;
    }
    /**
     * @return the paddingLeft
     */
    public double getPaddingLeft() {
        return paddingLeft;
    }
    /**
     * @param paddingLeft the paddingLeft to set
     */
    public void setPaddingLeft(double paddingLeft) {
        this.paddingLeft = paddingLeft;
    }
    /**
     * @return the paddingRight
     */
    public double getPaddingRight() {
        return paddingRight;
    }
    /**
     * @param paddingRight the paddingRight to set
     */
    public void setPaddingRight(double paddingRight) {
        this.paddingRight = paddingRight;
    }
    /**
     * @return the paddingTop
     */
    public double getPaddingTop() {
        return paddingTop;
    }
    /**
     * @param paddingTop the paddingTop to set
     */
    public void setPaddingTop(double paddingTop) {
        this.paddingTop = paddingTop;
    }
    /**
     * @return the paddingBottom
     */
    public double getPaddingBottom() {
        return paddingBottom;
    }
    /**
     * @param paddingBottom the paddingBottom to set
     */
    public void setPaddingBottom(double paddingBottom) {
        this.paddingBottom = paddingBottom;
    }
    /**
     * @return the isXAxisEnabled
     */
    public boolean isXAxisEnabled() {
        return isXAxisEnabled;
    }
    /**
     * @param isXAxisEnabled the isXAxisEnabled to set
     */
    public void setXAxisEnabled(boolean isXAxisEnabled) {
        this.isXAxisEnabled = isXAxisEnabled;
    }
    /**
     * @return the isXAxisLabelEnabled
     */
    public boolean isXAxisLabelEnabled() {
        return isXAxisLabelEnabled;
    }
    /**
     * @param isXAxisLabelEnabled the isXAxisLabelEnabled to set
     */
    public void setXAxisLabelEnabled(boolean isXAxisLabelEnabled) {
        this.isXAxisLabelEnabled = isXAxisLabelEnabled;
    }
    /**
     * @return the isYAxisEnabled
     */
    public boolean isYAxisEnabled() {
        return isYAxisEnabled;
    }
    /**
     * @param isYAxisEnabled the isYAxisEnabled to set
     */
    public void setYAxisEnabled(boolean isYAxisEnabled) {
        this.isYAxisEnabled = isYAxisEnabled;
    }
    /**
     * @return the isYAxisLabelEnabled
     */
    public boolean isYAxisLabelEnabled() {
        return isYAxisLabelEnabled;
    }
    /**
     * @param isYAxisLabelEnabled the isYAxisLabelEnabled to set
     */
    public void setYAxisLabelEnabled(boolean isYAxisLabelEnabled) {
        this.isYAxisLabelEnabled = isYAxisLabelEnabled;
    }
    /**
     * @return the yAxisLabelRangeValues
     */
    public double[] getYAxisLabelRangeValues() {
        return yAxisLabelRangeValues;
    }
    /**
     * @param yAxisLabelRangeValues the yAxisLabelRangeValues to set
     */
    public void setYAxisLabelRangeValues(double[] yAxisLabelRangeValues) {
        this.yAxisLabelRangeValues = yAxisLabelRangeValues;
    }
    /**
     * @return the yAxisLabelRangeTextValues
     */
    public String[] getYAxisLabelRangeTextValues() {
        return yAxisLabelRangeTextValues;
    }
    /**
     * @param yAxisLabelRangeTextValues the yAxisLabelRangeTextValues to set
     */
    public void setYAxisLabelRangeTextValues(String[] yAxisLabelRangeTextValues) {
        this.yAxisLabelRangeTextValues = yAxisLabelRangeTextValues;
    }
    /**
     * @return the isYAxisGridEnabled
     */
    public boolean isYAxisGridEnabled() {
        return isYAxisGridEnabled;
    }
    /**
     * @param isYAxisGridEnabled the isYAxisGridEnabled to set
     */
    public void setYAxisGridEnabled(boolean isYAxisGridEnabled) {
        this.isYAxisGridEnabled = isYAxisGridEnabled;
    }
    
}
