package com.bibounde.pcharts.shared.bar;

import com.bibounde.pcharts.shared.JSModel;

public interface BarJSModel extends JSModel{

    /**
     * @return the serieNames
     */
    public String[] getSerieNames();
    /**
     * @param serieNames the serieNames to set
     */
    public void setSerieNames(String[] serieNames);
    /**
     * @return the groupNames
     */
    public String[] getGroupNames();
    /**
     * @param groupNames the groupNames to set
     */
    public void setGroupNames(String[] groupNames);
    /**
     * @return the groupValues
     */
    public double[][] getGroupValues();
    /**
     * @param groupValues the groupValues to set
     */
    public void setGroupValues(double[][] groupValues);
    /**
     * @return the groupTooltipValues
     */
    public String[][] getGroupTooltipValues();
    /**
     * @param groupTooltipValues the groupTooltipValues to set
     */
    public void setGroupTooltipValues(String[][] groupTooltipValues);
    /**
     * @return the panelBottom
     */
    public double getPanelBottom();
    /**
     * @param panelBottom the panelBottom to set
     */
    public void setPanelBottom(double panelBottom);
    /**
     * @return the panelLeft
     */
    public double getPanelLeft();
    /**
     * @param panelLeft the panelLeft to set
     */
    public void setPanelLeft(double panelLeft);
    /**
     * @return the groupWidth
     */
    public double getGroupWidth();
    /**
     * @param groupWidth the groupWidth to set
     */
    public void setGroupWidth(double groupWidth);
    /**
     * @return the groupInset
     */
    public double getGroupInset();
    /**
     * @param groupInset the groupInset to set
     */
    public void setGroupInset(double groupInset);
    /**
     * @return the barHeight
     */
    public double getBarHeight();
    /**
     * @param barHeight the barHeight to set
     */
    public void setBarHeight(double barHeight);
    /**
     * @return the barWidth
     */
    public double getBarWidth();
    /**
     * @param barWidth the barWidth to set
     */
    public void setBarWidth(double barWidth);
    /**
     * @return the barInset
     */
    public double getBarInset();
    /**
     * @param barInset the barInset to set
     */
    public void setBarInset(double barInset);
    /**
     * @return the paddingLeft
     */
    public double getPaddingLeft();
    /**
     * @param paddingLeft the paddingLeft to set
     */
    public void setPaddingLeft(double paddingLeft);
    /**
     * @return the paddingRight
     */
    public double getPaddingRight();
    /**
     * @param paddingRight the paddingRight to set
     */
    public void setPaddingRight(double paddingRight);
    /**
     * @return the paddingTop
     */
    public double getPaddingTop();
    /**
     * @param paddingTop the paddingTop to set
     */
    public void setPaddingTop(double paddingTop);
    /**
     * @return the paddingBottom
     */
    public double getPaddingBottom();
    /**
     * @param paddingBottom the paddingBottom to set
     */
    public void setPaddingBottom(double paddingBottom);
    /**
     * @return the isXAxisEnabled
     */
    public boolean isXAxisEnabled();
    /**
     * @param isXAxisEnabled the isXAxisEnabled to set
     */
    public void setXAxisEnabled(boolean isXAxisEnabled);
    /**
     * @return the isXAxisLabelEnabled
     */
    public boolean isXAxisLabelEnabled();
    /**
     * @param isXAxisLabelEnabled the isXAxisLabelEnabled to set
     */
    public void setXAxisLabelEnabled(boolean isXAxisLabelEnabled);
    /**
     * @return the isYAxisEnabled
     */
    public boolean isYAxisEnabled();
    /**
     * @param isYAxisEnabled the isYAxisEnabled to set
     */
    public void setYAxisEnabled(boolean isYAxisEnabled);
    /**
     * @return the isYAxisLabelEnabled
     */
    public boolean isYAxisLabelEnabled();
    /**
     * @param isYAxisLabelEnabled the isYAxisLabelEnabled to set
     */
    public void setYAxisLabelEnabled(boolean isYAxisLabelEnabled);
    /**
     * @return the yAxisLabelRangeValues
     */
    public double[] getYAxisLabelRangeValues();
    /**
     * @param yAxisLabelRangeValues the yAxisLabelRangeValues to set
     */
    public void setYAxisLabelRangeValues(double[] yAxisLabelRangeValues);
    /**
     * @return the yAxisLabelRangeTextValues
     */
    public String[] getYAxisLabelRangeTextValues();
    /**
     * @param yAxisLabelRangeTextValues the yAxisLabelRangeTextValues to set
     */
    public void setYAxisLabelRangeTextValues(String[] yAxisLabelRangeTextValues);
    /**
     * @return the isYAxisGridEnabled
     */
    public boolean isYAxisGridEnabled();
    /**
     * @param isYAxisGridEnabled the isYAxisGridEnabled to set
     */
    public void setYAxisGridEnabled(boolean isYAxisGridEnabled);
}
