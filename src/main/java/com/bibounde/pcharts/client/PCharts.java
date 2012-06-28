package com.bibounde.pcharts.client;

import com.bibounde.pcharts.client.bar.BarChart;
import com.bibounde.pcharts.shared.common.AxisLabelFormatter;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PCharts implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        BarChart bar = new BarChart();
        bar.addSerie("Sales", new double[] { -100, 1170, 660, 1030 });
        bar.addSerie("Expenses", new double[] { 1757.0, -1307.0, -1825.0, 252.0 });
        bar.addSerie("VAT", new double[] { 1593.0, -1659.0, -204.0, 680.0 });
        
        bar.setGroupNames(new String[] { "2008", "2009", "2010", "2011" });
        bar.setChartWidth(550);
        bar.setChartHeight(300);
        ///bar.setdi
        
        //bar.setBarInset(2);
        //bar.setGroupBarInset(25);
        
        //bar.setXAxisLabelVisible(true);
        
        bar.setMarginLeft(50);
        bar.setMarginBottom(20);
        bar.setYAxisVisible(true);
        bar.setYAxisLabelVisible(true);
        bar.setYAxisLabelStep(650);
        bar.setYAxisGridVisible(true);
        bar.setYAxisLabelFormatter(new AxisLabelFormatter() {
            public String format(double labelValue) {
                return String.valueOf(labelValue) + "\u20AC";
            }
        });
        
        bar.setLegendVisible(true);
        bar.setLegendAreaWidth(150);
        bar.setLegendInsetLeft(50);
        
        
        RootPanel.get().add(bar);
        bar.requestRepaint();
        //RootPanel.get().add(new Label("Putain de bordel"));
    }
}
