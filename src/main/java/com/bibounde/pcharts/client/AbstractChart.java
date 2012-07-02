package com.bibounde.pcharts.client;

import com.bibounde.pcharts.shared.AbstractChartModel;
import com.bibounde.pcharts.shared.util.ColorUtil;
import com.google.gwt.user.client.ui.Composite;

public abstract class AbstractChart extends Composite {

    protected AbstractChartWidget widget;
    protected AbstractChartModel chartModel;
    
    public AbstractChart(AbstractChartWidget widget, AbstractChartModel chartModel) {
        this.widget = widget;
        this.chartModel = chartModel;
        //Init html id
        this.chartModel.setId("gwt-pchart-" + this.hashCode());
        this.initWidget(this.widget);
    }
    
    public void requestRepaint() {
      
        this.widget.getElement().setId(this.chartModel.getId());
        
        this.updateJSModel();
        this.widget.render();
    }
    
    protected abstract void updateJSModel();
    
    /**
     * Sets html element id
     * @param id html element id
     */
    public void setId(String id) {
        chartModel.setId(id);
    }
    
    /**
     * Sets chart width (unit : pixels)
     * @param width new chart width (unit : pixels)
     */
    public void setChartWidth(double width) {
        chartModel.setWidth(width);
    }

    /**
     * Sets chart height (unit : pixels)
     * @param height new chart height (unit : pixels)
     */
    public void setChartHeight(double height) {
        chartModel.setHeight(height);
    }
    
    /**
     * Sets left margin (unit : pixels)
     * @param marginLeft left margin (unit : pixels)
     */
    public void setMarginLeft(double marginLeft) {
        chartModel.setMarginLeft(marginLeft);
    }

    /**
     * Sets right margin (unit : pixels)
     * @param marginRight right margin (unit : pixels)
     */
    public void setMarginRight(double marginRight) {
        chartModel.setMarginRight(marginRight);
    }

    /**
     * Set top margin (unit : pixels)
     * @param marginTop top margin (unit : pixels)
     */
    public void setMarginTop(double marginTop) {
        chartModel.setMarginTop(marginTop);
    }

    /**
     * Sets bottom margin (unit : pixels)
     * @param marginBottom bottom margin (unit : pixels)
     */
    public void setMarginBottom(double marginBottom) {
        chartModel.setMarginBottom(marginBottom);
    }

    /**
     * Sets bar colors
     * @param colors new bar colors
     */
    public void setColors(String[] colors) {
        if (colors == null) {
            chartModel.setColors(ColorUtil.getDefaultColors());
        } else {
            chartModel.setColors(colors);
        }
    }

    /**
     * Sets legend visibility
     * @param visible legend visibility
     */
    public void setLegendVisible(boolean visible) {
        chartModel.setLegendEnabled(visible);
        chartModel.setLegendAreaWidth(visible ? 150d : 0d);
    }

    /**
     * Sets legend area width (unit : pixels)
     * @param legendAreaWidth legend area width
     */
    public void setLegendAreaWidth(double legendAreaWidth) {
        chartModel.setLegendAreaWidth(legendAreaWidth);
    }
    
    /**
     * Enables (or disables) the tooltip
     * @param enabled  true to enable the tooltip, otherwise false
     */
    public void setTooltipEnabled(boolean enabled) {
        this.chartModel.setTooltipEnabled(enabled);
    }
    /**
     * Sets legend's left inset value
     * @param inset legend's left inset value
     */
    public void setLegendInsetLeft(double inset) {
        this.chartModel.setLegendInsetLeft(inset);
    }
}
