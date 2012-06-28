package com.bibounde.pcharts.shared.common;

import com.google.gwt.i18n.client.NumberFormat;

/**
 * Default implementation
 * @author bibounde
 *
 */
public class DefaultAxisLabelFormatter implements AxisLabelFormatter {

    private static final NumberFormat decimalFormat = NumberFormat.getFormat("0.#"); 
    /**
     * 
     * @return String.valueOf(labelValue)
     */
    public String format(double labelValue) {
        return decimalFormat.format(labelValue);
    }

}
