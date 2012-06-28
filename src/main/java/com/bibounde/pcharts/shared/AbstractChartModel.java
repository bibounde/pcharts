package com.bibounde.pcharts.shared;

import com.bibounde.pcharts.shared.util.ColorUtil;

public abstract class AbstractChartModel {

    private String id;
    private double width = 150, height = 150;
    private double marginLeft = 10d, marginRight = 10d, marginTop = 10d, marginBottom = 10d;
    private String[] colors = ColorUtil.getDefaultColors();
    private boolean legendEnabled = false;
    private double legendAreaWidth = 0d;
    private boolean tooltipEnabled = true;
    private double legendLeftInset = 20d;
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getMarginLeft() {
        return marginLeft;
    }
    public void setMarginLeft(double marginLeft) {
        this.marginLeft = marginLeft;
    }
    public double getMarginRight() {
        return marginRight;
    }
    public void setMarginRight(double marginRight) {
        this.marginRight = marginRight;
    }
    public double getMarginTop() {
        return marginTop;
    }
    public void setMarginTop(double marginTop) {
        this.marginTop = marginTop;
    }
    public double getMarginBottom() {
        return marginBottom;
    }
    public void setMarginBottom(double marginBottom) {
        this.marginBottom = marginBottom;
    }
    public String[] getColors() {
        return colors;
    }
    public void setColors(String[] colors) {
        this.colors = colors;
    }
    public boolean isLegendEnabled() {
        return legendEnabled;
    }
    public void setLegendEnabled(boolean legendEnabled) {
        this.legendEnabled = legendEnabled;
    }
    public double getLegendAreaWidth() {
        return legendAreaWidth;
    }
    public void setLegendAreaWidth(double legendAreaWidth) {
        this.legendAreaWidth = legendAreaWidth;
    }
    public boolean isTooltipEnabled() {
        return tooltipEnabled;
    }
    public void setTooltipEnabled(boolean tooltipEnabled) {
        this.tooltipEnabled = tooltipEnabled;
    }
    public double getLegendInsetLeft() {
        return this.legendLeftInset;
    }
    public void setLegendInsetLeft(double inset) {
        this.legendLeftInset = inset;
    }
}
