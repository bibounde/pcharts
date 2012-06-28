package com.bibounde.pcharts.client.bar;

import java.util.logging.Logger;

import com.bibounde.pcharts.client.AbstractChartWidget;
import com.bibounde.pcharts.client.ProtovisUtil;
import com.bibounde.pcharts.client.tooltip.Tooltip;
import com.bibounde.pcharts.client.tooltip.TooltipComposite.ArrowStyle;

public class BarChartWidget extends AbstractChartWidget {

    /** Set the CSS class name to allow styling. */
    public static final String CLASSNAME = "gwt-pcharts-barchart";
    
    private Logger LOGGER = Logger.getLogger(BarChartWidget.class.getName());

    private Tooltip currentTooltip;
    
    public BarChartWidget() {
        super(CLASSNAME);
        this.setModel(new BarWidgetModel());
    }
    
    private BarWidgetModel getBarWidgetModel() {
        return (BarWidgetModel) this.model;
    }
    
    public native void render   () /*-{
    
    var vbarchart = this;

    var colors = eval(this.@com.bibounde.pcharts.client.bar.BarChartWidget::getColors()());
    var axisColor = $wnd.pv.color("#969696");
    var legendColor = $wnd.pv.color("#464646");
    var gridColor = $wnd.pv.color("#E4E4E4");

    var data = eval(this.@com.bibounde.pcharts.client.bar.BarChartWidget::getData()());
    var serieNames = eval(this.@com.bibounde.pcharts.client.bar.BarChartWidget::getSerieNames()());
    var groupCount = this.@com.bibounde.pcharts.client.bar.BarChartWidget::getGroupCount()();
    var groupNames = eval(this.@com.bibounde.pcharts.client.bar.BarChartWidget::getGroupNames()());
    
    var chartWidth = this.@com.bibounde.pcharts.client.bar.BarChartWidget::getChartWidth()();
    var chartHeight = this.@com.bibounde.pcharts.client.bar.BarChartWidget::getChartHeight()();
    
    var panelBottom = this.@com.bibounde.pcharts.client.bar.BarChartWidget::getPanelBottom()();
    var panelLeft = this.@com.bibounde.pcharts.client.bar.BarChartWidget::getPanelLeft()();
    
    var vis = new $wnd.pv.Panel().canvas(this.@com.bibounde.pcharts.client.bar.BarChartWidget::getDivId()());
    vis.width(chartWidth);
    vis.height(chartHeight);
    
    var marginLeft = this.@com.bibounde.pcharts.client.bar.BarChartWidget::getMarginLeft()();
    var marginRight = this.@com.bibounde.pcharts.client.bar.BarChartWidget::getMarginRight()();
    var marginBottom = this.@com.bibounde.pcharts.client.bar.BarChartWidget::getMarginBottom()();
    var marginTop = this.@com.bibounde.pcharts.client.bar.BarChartWidget::getMarginTop()();
    var paddingLeft = this.@com.bibounde.pcharts.client.bar.BarChartWidget::getPaddingLeft()();
    var paddingRight = this.@com.bibounde.pcharts.client.bar.BarChartWidget::getPaddingRight()();
    var paddingBottom = this.@com.bibounde.pcharts.client.bar.BarChartWidget::getPaddingBottom()();
    var paddingTop = this.@com.bibounde.pcharts.client.bar.BarChartWidget::getPaddingTop()();
    
    var legendAreaWidth = this.@com.bibounde.pcharts.client.bar.BarChartWidget::getLegendAreaWidth()();
    var legendInsetLeft = this.@com.bibounde.pcharts.client.bar.BarChartWidget::getLegendInsetLeft()();
    
    var maxYTick = chartHeight - marginTop;
    var minYTick = marginBottom;
    
    var yRange = eval(this.@com.bibounde.pcharts.client.bar.BarChartWidget::getVerticalAxisLabelRangeDValues()());
    var yRangeText = eval(this.@com.bibounde.pcharts.client.bar.BarChartWidget::getVerticalAxisLabelRangeSValues()());
    
    var groupWidth = this.@com.bibounde.pcharts.client.bar.BarChartWidget::getGroupWidth()();
    var groupInset = this.@com.bibounde.pcharts.client.bar.BarChartWidget::getGroupInset()();
    var barWidth = this.@com.bibounde.pcharts.client.bar.BarChartWidget::getBarWidth()();
    var barHeight = this.@com.bibounde.pcharts.client.bar.BarChartWidget::getBarHeight()();
    var barInset = this.@com.bibounde.pcharts.client.bar.BarChartWidget::getBarInset()();
    
    //Grid management
    if (this.@com.bibounde.pcharts.client.bar.BarChartWidget::isYAxisGridEnabled()()) {
        var grid = vis.add($wnd.pv.Rule).data(yRange);
        grid.visible(function(d) {
            var ret = (d * barHeight) + panelBottom;
            return ret < maxYTick && ret >= minYTick;
        });
        grid.bottom(function(d) {
            return (d * barHeight) + panelBottom;
        });
        grid.left(0 + marginLeft);
        grid.width(chartWidth - marginLeft - marginRight - legendAreaWidth - legendInsetLeft);
        grid.strokeStyle(gridColor);
    }
    
    //Panel and bar management
    var panel = vis.add($wnd.pv.Panel).def("active", false).def("activeIndex", -1).data(data);
    panel.width(groupWidth).bottom(panelBottom).left(function() {
        return paddingLeft + panelLeft + this.index * (groupWidth + groupInset);
    });
            
    var bar = panel.add($wnd.pv.Bar).data(function(d){ return d});
    bar.bottom(function(d) {
        if (d < 0) {
            return d * barHeight;
        } else {
            return 0;
        }
    });
    bar.width(barWidth).height(function(d) {return Math.abs(d * barHeight);});
    bar.left(function(){return this.index * (barWidth + barInset)});
    //Color management
    bar.fillStyle(colors.by($wnd.pv.index));

    //Horizontal axis management
    if (this.@com.bibounde.pcharts.client.bar.BarChartWidget::isXAxisEnabled()()) {
        var rule = vis.add($wnd.pv.Rule);
        
        rule.bottom(panelBottom).width(chartWidth - marginLeft - marginRight - legendAreaWidth - legendInsetLeft).left(0 + marginLeft);
        rule.strokeStyle(axisColor);
        
        if (this.@com.bibounde.pcharts.client.bar.BarChartWidget::isXAxisLabelEnabled()()) {
    
            var tick = vis.add($wnd.pv.Rule).data(groupNames);
            tick.left(function() {
                return paddingLeft + panelLeft + this.index * (groupWidth + groupInset) + (groupWidth / 2);
            });
            tick.bottom(panelBottom - 3);
            tick.height(3);
            tick.strokeStyle(axisColor);
            tick.anchor("bottom").add($wnd.pv.Label).text(function(d) {
                return d;
            }).textStyle(axisColor);
        }
    }
    
    //Vertical axis management
    if (this.@com.bibounde.pcharts.client.bar.BarChartWidget::isYAxisEnabled()()) {
        var rule = vis.add($wnd.pv.Rule);
        rule.bottom(0 + marginBottom).left(panelLeft).height(chartHeight - marginBottom - marginTop);
        rule.strokeStyle(axisColor);
        
        if (this.@com.bibounde.pcharts.client.bar.BarChartWidget::isYAxisLabelEnabled()()) {
    
            var tick = vis.add($wnd.pv.Rule).data(yRange);
            tick.visible(function(d) {
                var ret = (d * barHeight) + panelBottom;
                return ret <= maxYTick && ret >= minYTick;
            });
            tick.bottom(function(d) {
                return (d * barHeight) + panelBottom;
            });
            tick.left(panelLeft - 3);
            tick.width(3);
            tick.strokeStyle(axisColor);
            tick.anchor("left").add($wnd.pv.Label).text(function() {
                return yRangeText[this.index];
            }).textStyle(axisColor);
        }
    }
    
    //Event management
    if (this.@com.bibounde.pcharts.client.bar.BarChartWidget::isTooltipEnabled()()) {
        var tooltips = eval(this.@com.bibounde.pcharts.client.bar.BarChartWidget::getTooltips()());
        bar.event('mouseover', function() {
            var left = this.left() + this.parent.left();
            var top = this.top() + this.parent.top();
            var bottom = this.bottom() + this.parent.bottom();
            var barWidth = this.width();
            var barBbottom = this.bottom();
            var tooltip = tooltips[this.parent.index][this.index];
            vbarchart.@com.bibounde.pcharts.client.bar.BarChartWidget::showTooltip(DDDDDLjava/lang/String;)(left, top, bottom, barBbottom, barWidth, tooltip);
            
            return this;
        });
        bar.event('mouseout', function() {
            vbarchart.@com.bibounde.pcharts.client.bar.BarChartWidget::hideTooltip()();
            return this;
        });
    }
    
    //Legend management
    if (this.@com.bibounde.pcharts.client.bar.BarChartWidget::isLegendEnabled()()) {
        //Use bar instead of DOT because msie-shim does not support it
        var legend = vis.add($wnd.pv.Bar).data(serieNames);
        legend.top(function(){
            return marginTop + (this.index * 18);
        });
        legend.width(11).height(11).left(chartWidth - marginRight - legendAreaWidth + legendInsetLeft);
        legend.fillStyle(colors.by($wnd.pv.index));
        legend.anchor("left").add($wnd.pv.Label).textBaseline("middle").textMargin(16).textStyle(legendColor);
    }

    vis.render();
}-*/;
    
    public void showTooltip(double left, double top, double bottom, double barBottom, double barWidth, String tooltipText) {
        int arrowOffset = 10;
        String elt = this.getElement().getId();
        int absTop = this.getElement().getAbsoluteTop();
        
        int tooltipLeft = this.getElement().getAbsoluteLeft() + Double.valueOf(left).intValue();
        int tooltipTop = this.getElement().getAbsoluteTop() + Double.valueOf(top).intValue();
        int tooltipBottom = this.getElement().getAbsoluteBottom() - Double.valueOf(bottom).intValue();
        
        if (this.currentTooltip == null) {
            this.currentTooltip = new Tooltip(this);
        }
        this.currentTooltip.setText(tooltipText);
        
        //Tooltip location calculation
        this.currentTooltip.show();
        if (barBottom < 0) {
            //Bar with negative value
            if (bottom < this.currentTooltip.getOffsetHeight()) {
                //Display at the right
                this.currentTooltip.setArrowStyle(ArrowStyle.MIDDLE_TOP_LEFT);
                this.currentTooltip.setPopupPosition(tooltipLeft + Double.valueOf(barWidth).intValue() + 2, tooltipBottom - this.currentTooltip.getOffsetHeight());
            } else {
                this.currentTooltip.setArrowStyle(ArrowStyle.TOP_LEFT);
                this.currentTooltip.setPopupPosition(tooltipLeft - arrowOffset+ (Double.valueOf(barWidth).intValue() / 2), tooltipBottom);
            }
        } else {
            if (top < this.currentTooltip.getOffsetHeight()) {
                //Display at the right
                this.currentTooltip.setArrowStyle(ArrowStyle.MIDDLE_TOP_LEFT);
                this.currentTooltip.setPopupPosition(tooltipLeft + Double.valueOf(barWidth).intValue() + 2, tooltipTop);
            } else {
                this.currentTooltip.setArrowStyle(ArrowStyle.BOTTOM_LEFT);
                this.currentTooltip.setPopupPosition(tooltipLeft - arrowOffset+ (Double.valueOf(barWidth).intValue() / 2), tooltipTop - this.currentTooltip.getOffsetHeight());
            }
        }
    }
    
    public void hideTooltip() {
        if (this.currentTooltip != null) {
            this.currentTooltip.hide();
        }
    }
    
    public String getData() {
        StringBuilder ret = new StringBuilder("[");
        
        int serieCount = this.getBarWidgetModel().getGroupValues().length;
        
        for (int i = 0; i < serieCount; i++) {
            if (i > 0) {
                ret.append(", ");
            }
            ret.append("[");
            
            double[] values = this.getBarWidgetModel().getGroupValues()[i];
            for (int j = 0; j < values.length; j++) {
                if (j > 0) {
                    ret.append(", ");
                }
                ret.append(values[j]);
            }
            ret.append("]");
        }
        ret.append("]");
        return ret.toString();
    };
    
    
    
    public double getPanelBottom() {
        return this.getBarWidgetModel().getPanelBottom();
    }
    
    public double getPanelLeft() {
        return this.getBarWidgetModel().getPanelLeft();
    }
    
    public double getGroupWidth() {
        return this.getBarWidgetModel().getGroupWidth();
    }
    
    public int getGroupCount() {
        return this.getBarWidgetModel().getGroupValues().length;
    }
    
    public double getGroupInset() {
        return this.getBarWidgetModel().getGroupInset();
    }
    
    public double getBarWidth() {
        return this.getBarWidgetModel().getBarWidth();
    }
    
    public double getBarHeight() {
        return this.getBarWidgetModel().getBarHeight();
    }
    
    public double getBarInset() {
        return this.getBarWidgetModel().getBarInset();
    }
    
    public double getPaddingLeft() {
        return this.getBarWidgetModel().getPaddingLeft();
    }
    public double getPaddingRight() {
        return this.getBarWidgetModel().getPaddingRight();
    }
    public double getPaddingTop() {
        return this.getBarWidgetModel().getPaddingTop();
    }
    public double getPaddingBottom() {
        return this.getBarWidgetModel().getPaddingBottom();
    }
    public boolean isXAxisEnabled() {
        return this.getBarWidgetModel().isXAxisEnabled();
    }
    public boolean isXAxisLabelEnabled() {
        return this.getBarWidgetModel().isXAxisLabelEnabled();
    }
    
    public String getGroupNames() {
        return ProtovisUtil.getJSArray(this.getBarWidgetModel().getGroupNames(), true);
    }
    
    public boolean isYAxisEnabled() {
        return this.getBarWidgetModel().isYAxisEnabled();
    }
    
    public boolean isYAxisLabelEnabled() {
        return this.getBarWidgetModel().isYAxisLabelEnabled();
    }
    
    public boolean isYAxisGridEnabled() {
        return this.getBarWidgetModel().isYAxisGridEnabled();
    }
    
    public String getVerticalAxisLabelRangeDValues() {
        return ProtovisUtil.getJSArray(this.getBarWidgetModel().getYAxisLabelRangeValues());
    }
    
    public String getVerticalAxisLabelRangeSValues() {
        return ProtovisUtil.getJSArray(this.getBarWidgetModel().getYAxisLabelRangeTextValues(), true);
    }
    
    public String getSerieNames() {
        return ProtovisUtil.getJSArray(this.getBarWidgetModel().getSerieNames(), true);
    }
    
    public String getTooltips() {
        StringBuilder ret = new StringBuilder("[");
        
        int serieCount = this.getBarWidgetModel().getGroupValues().length;
        for (int i = 0; i < serieCount; i++) {
            if (i > 0) {
                ret.append(", ");
            }
            String[] values = this.getBarWidgetModel().getGroupTooltipValues()[i];
            
            ret.append("[");
            for (int j = 0; j < values.length; j++) {
                if (j > 0) {
                    ret.append(", ");
                }
                ret.append("'").append(values[j]).append("'");
            }
            ret.append("]");
        }
        ret.append("]");
        return ret.toString();
    }
}
