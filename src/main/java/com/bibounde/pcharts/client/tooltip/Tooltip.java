package com.bibounde.pcharts.client.tooltip;

import com.bibounde.pcharts.client.AbstractChartWidget;
import com.bibounde.pcharts.client.tooltip.TooltipComposite.ArrowStyle;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class Tooltip extends PopupPanel {
    
    private static final String ATTR_ZINDEX = "zIndex";
	
    private TooltipComposite composite;
    private AbstractChartWidget parent;
    
	public Tooltip(AbstractChartWidget parent) {
	    super(true);
	    this.parent = parent;
        this.init();
        
    }
	
	private void init() {
	    this.removeStyleName("gwt-PopupPanel");
	    this.removeStyleName("gwt-PopupPanel");
	    this.removeStyleName("popupContent");
	    this.removeStyleName("gwt-PopupPanelGlass");
	    this.composite = new TooltipComposite(this.parent.getTooltipCSSNames());
        this.add(composite);
	}
	
	public void setText(String html) {
		this.composite.setText(html);
	}
	
	public void setArrowStyle(ArrowStyle style) {
		this.composite.setArrowStyle(style);
	}

    @Override
    public void show() {
        Widget p = this.parent;
        while(p != null) {
            int zIndex = DOM.getIntStyleAttribute(p.getElement(), ATTR_ZINDEX);
            if (zIndex > 0) {
                DOM.setIntStyleAttribute(this.getElement(), ATTR_ZINDEX, zIndex);
                break;
            } else {
                p = p.getParent();
            }
        }
        super.show();
    }
	
}
