package com.bibounde.pcharts.shared.bar;

/**
 * Default implementation.
 * 
 * @author bibounde
 *
 */
public class DefaultBarTooltipFormatter implements BarTooltipFormatter {

    public String getTooltipHTML(String serieName, double value, String groupName) {
        StringBuilder ret = new StringBuilder();
        if (!"".equals(groupName)) {
            ret.append("<b>").append(groupName).append("</b><br/>");
        }
        ret.append(serieName).append(": ").append(value);
        
        return ret.toString();
    }

}
