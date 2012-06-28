package com.bibounde.pcharts.client.tooltip;

import com.bibounde.pcharts.client.tooltip.TooltipComposite.ArrowStyle;

public class TooltipOptions {

    public int left, top;
    public ArrowStyle arrowStyle;
    
    @Override
    public String toString() {
        return "TooltipOptions [left=" + left + ", top=" + top + ", arrowStyle=" + arrowStyle + "]";
    }
    
    
}
