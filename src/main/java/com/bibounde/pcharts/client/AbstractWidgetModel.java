package com.bibounde.pcharts.client;

import java.io.Serializable;

public abstract class AbstractWidgetModel implements Serializable {

    private String id;
    private double width;
    private double height;
    private double marginLeft;
    private double marginRight;
    private double marginTop;
    private double marginBottom;
    private String[] colors;
    private boolean legendEnabled;
    private double legendAreaWidth;
    private double legendInsetLeft;
    private boolean tooltipEnabled;
    
    
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
    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }
    /**
     * @param width the width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }
    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }
    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }
    /**
     * @return the marginLeft
     */
    public double getMarginLeft() {
        return marginLeft;
    }
    /**
     * @param marginLeft the marginLeft to set
     */
    public void setMarginLeft(double marginLeft) {
        this.marginLeft = marginLeft;
    }
    /**
     * @return the marginRight
     */
    public double getMarginRight() {
        return marginRight;
    }
    /**
     * @param marginRight the marginRight to set
     */
    public void setMarginRight(double marginRight) {
        this.marginRight = marginRight;
    }
    /**
     * @return the marginTop
     */
    public double getMarginTop() {
        return marginTop;
    }
    /**
     * @param marginTop the marginTop to set
     */
    public void setMarginTop(double marginTop) {
        this.marginTop = marginTop;
    }
    /**
     * @return the marginBottom
     */
    public double getMarginBottom() {
        return marginBottom;
    }
    /**
     * @param marginBottom the marginBottom to set
     */
    public void setMarginBottom(double marginBottom) {
        this.marginBottom = marginBottom;
    }
    /**
     * @return the colors
     */
    public String[] getColors() {
        return colors;
    }
    /**
     * @param colors the colors to set
     */
    public void setColors(String[] colors) {
        this.colors = colors;
    }
    /**
     * @return the legendEnabled
     */
    public boolean isLegendEnabled() {
        return legendEnabled;
    }
    /**
     * @param legendEnabled the legendEnabled to set
     */
    public void setLegendEnabled(boolean legendEnabled) {
        this.legendEnabled = legendEnabled;
    }
    /**
     * @return the legendAreaWidth
     */
    public double getLegendAreaWidth() {
        return legendAreaWidth;
    }
    /**
     * @param legendAreaWidth the legendAreaWidth to set
     */
    public void setLegendAreaWidth(double legendAreaWidth) {
        this.legendAreaWidth = legendAreaWidth;
    }
    /**
     * @return the legendInsetLeft
     */
    public double getLegendInsetLeft() {
        return legendInsetLeft;
    }
    /**
     * @param legendInsetLeft the legendInsetLeft to set
     */
    public void setLegendInsetLeft(double legendInsetLeft) {
        this.legendInsetLeft = legendInsetLeft;
    }
    /**
     * @return the tooltipEnabled
     */
    public boolean isTooltipEnabled() {
        return tooltipEnabled;
    }
    /**
     * @param tooltipEnabled the tooltipEnabled to set
     */
    public void setTooltipEnabled(boolean tooltipEnabled) {
        this.tooltipEnabled = tooltipEnabled;
    }
   
    
}
