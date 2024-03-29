package com.bibounde.pcharts.shared.bar;

import java.io.Serializable;

/**
 * Identifies components that can be used to format tooltip content
 * @author bibounde
 *
 */
public interface BarTooltipFormatter extends Serializable {
    /**
     * Returns tooltip content as HTML
     * @param serieName serie name which is selected
     * @param value selected value
     * @param groupName selected group
     * @return tooltip content as HTML
     */
    String getTooltipHTML(String serieName, double value, String groupName);
}
