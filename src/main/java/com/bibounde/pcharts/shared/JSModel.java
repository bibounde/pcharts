package com.bibounde.pcharts.shared;

import java.io.Serializable;

public interface JSModel extends Serializable {
    /**
     * @return the id
     */
    public String getId();
    /**
     * @param id the id to set
     */
    public void setId(String id);
    /**
     * @return the width
     */
    public double getWidth();
    /**
     * @param width the width to set
     */
    public void setWidth(double width);
    /**
     * @return the height
     */
    public double getHeight();
    /**
     * @param height the height to set
     */
    public void setHeight(double height);
    /**
     * @return the marginLeft
     */
    public double getMarginLeft();
    /**
     * @param marginLeft the marginLeft to set
     */
    public void setMarginLeft(double marginLeft);
    /**
     * @return the marginRight
     */
    public double getMarginRight();
    /**
     * @param marginRight the marginRight to set
     */
    public void setMarginRight(double marginRight);
    /**
     * @return the marginTop
     */
    public double getMarginTop();
    /**
     * @param marginTop the marginTop to set
     */
    public void setMarginTop(double marginTop);
    /**
     * @return the marginBottom
     */
    public double getMarginBottom();
    /**
     * @param marginBottom the marginBottom to set
     */
    public void setMarginBottom(double marginBottom);
    /**
     * @return the colors
     */
    public String[] getColors();
    /**
     * @param colors the colors to set
     */
    public void setColors(String[] colors);
    /**
     * @return the legendEnabled
     */
    public boolean isLegendEnabled();
    /**
     * @param legendEnabled the legendEnabled to set
     */
    public void setLegendEnabled(boolean legendEnabled);
    /**
     * @return the legendAreaWidth
     */
    public double getLegendAreaWidth();
    /**
     * @param legendAreaWidth the legendAreaWidth to set
     */
    public void setLegendAreaWidth(double legendAreaWidth);
    /**
     * @return the legendInsetLeft
     */
    public double getLegendInsetLeft();
    /**
     * @param legendInsetLeft the legendInsetLeft to set
     */
    public void setLegendInsetLeft(double legendInsetLeft);
    /**
     * @return the tooltipEnabled
     */
    public boolean isTooltipEnabled();
    /**
     * @param tooltipEnabled the tooltipEnabled to set
     */
    public void setTooltipEnabled(boolean tooltipEnabled);
}
