package com.bibounde.pcharts.client;

import com.bibounde.pcharts.client.tooltip.DefaultTooltipCSSNames;
import com.bibounde.pcharts.client.tooltip.TooltipCSSNames;
import com.bibounde.pcharts.shared.JSModel;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.ui.Widget;

public abstract class AbstractChartWidget extends Widget {

    protected JSModel model;
    private int mouseX = -1;
    private int mouseY = -1;
    private TooltipCSSNames tooltipCSSNames = new DefaultTooltipCSSNames();
    
    public AbstractChartWidget(String className) {
        setElement(this.createRootElement());
        setStyleName(className);
        this.getElement().setId("");
        Event.addNativePreviewHandler(new NativePreviewHandler(){
            public void onPreviewNativeEvent(NativePreviewEvent event) {
                if (event.getNativeEvent().getType().equals("mousemove"))
                {
                    mouseX = event.getNativeEvent().getClientX();
                    mouseY = event.getNativeEvent().getClientY();
                }
            }
        });
    }
    
    protected Element createRootElement() {
        DivElement canvas = Document.get().createDivElement();
        return canvas;
    }
    
    public native void render()/*-{
    }-*/;
    
    public void setModel(JSModel model) {
        this.model = model;
    }
    
    /**
     * @return the model
     */
    public JSModel getModel() {
        return model;
    }

    public String getDivId() {
        return this.model.getId();
    }
    
    public double getChartWidth() {
        return this.model.getWidth();
    }
    
    public double getChartHeight() {
        return this.model.getHeight();
    }
    
    public double getMarginLeft() {
        return this.model.getMarginLeft();
    }
    
    public double getMarginRight() {
        return this.model.getMarginRight();
    }

    public double getMarginTop() {
        return this.model.getMarginTop();
    }
    
    public double getMarginBottom() {
        return this.model.getMarginBottom();
    }
    
    public boolean isLegendEnabled() {
        return this.model.isLegendEnabled();
    }
    
    public double getLegendAreaWidth() {
        return this.model.getLegendAreaWidth();
    }
    
    public String getColors() {
        String[] colors = this.model.getColors();
        
        StringBuilder ret = new StringBuilder("$wnd.pv.colors(");

        for (int i = 0; i < colors.length; i++) {
            if (i > 0) {
                ret.append(", ");
            }
            ret.append("'").append(colors[i]).append("'");
        }
        ret.append(")");
        return ret.toString();
    }
    
    public boolean isTooltipEnabled() {
        return this.model.isTooltipEnabled();
    }
    
    public double getLegendInsetLeft() {
        return this.model.getLegendInsetLeft();
    }

    /**
     * @return the tooltipCSSNames
     */
    public TooltipCSSNames getTooltipCSSNames() {
        return tooltipCSSNames;
    }

    /**
     * @param tooltipCSSNames the tooltipCSSNames to set
     */
    public void setTooltipCSSNames(TooltipCSSNames tooltipCSSNames) {
        this.tooltipCSSNames = tooltipCSSNames;
    }
    
}
