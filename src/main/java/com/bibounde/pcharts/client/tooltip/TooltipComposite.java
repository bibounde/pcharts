package com.bibounde.pcharts.client.tooltip;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class TooltipComposite extends Composite {

    private HTML leftArrow, bottomArrow, rightArrrow, topArrow, message;
    private FlexTable grid;
    private TooltipCSSNames tooltipCSSNames;
   
    public TooltipComposite(TooltipCSSNames tooltipCSSNames) {
        this.tooltipCSSNames = tooltipCSSNames;
        
        grid = new FlexTable();
        grid.setCellPadding(0);
        grid.setCellSpacing(0);
        
        topArrow = new HTML();
        topArrow.setVisible(false);
        grid.setWidget(0, 1, topArrow);
        
        leftArrow = new HTML();
        leftArrow.setVisible(false);
        grid.setWidget(1, 0, leftArrow);
        grid.getFlexCellFormatter().setVerticalAlignment(1, 0, HasVerticalAlignment.ALIGN_TOP);
        
        rightArrrow = new HTML();
        rightArrrow.setVisible(false);
        grid.setWidget(1, 2, rightArrrow);
        grid.getFlexCellFormatter().setVerticalAlignment(1, 2, HasVerticalAlignment.ALIGN_TOP);
        
        bottomArrow = new HTML();
        bottomArrow.setVisible(false);
        grid.setWidget(2, 1, bottomArrow);
        grid.getFlexCellFormatter().setHorizontalAlignment(2, 1, HasHorizontalAlignment.ALIGN_LEFT);
        
        this.message = new HTML();
        this.message.setStyleName(this.tooltipCSSNames.getContent());
        grid.setWidget(1, 1, this.message);
        
        this.initWidget(grid);
    }
    
    public void setText(String html) {
        this.message.setHTML(html);
    }
    
    public void setArrowStyle(ArrowStyle style) {
        switch (style) {
        case BOTTOM_LEFT:
            this.setBottomLeft();
            break;
        case BOTTOM_RIGHT:
            this.setBottomRight();
            break;
        case MIDDLE_BOTTOM_LEFT:
            this.setMiddleBottomLeft();
            break;
        case MIDDLE_BOTTOM_RIGHT:
            this.setMiddleBottomRight();
            break;
        case MIDDLE_TOP_LEFT:
            this.setMiddleTopLeft();
            break;
        case MIDDLE_TOP_RIGHT:
            this.setMiddleTopRight();
            break;
        case TOP_LEFT:
            this.setTopLeft();
            break;
        case TOP_RIGHT:
            this.setTopRight();
            break;
        default:
            this.topArrow.setVisible(false);
            this.leftArrow.setVisible(false);
            this.rightArrrow.setVisible(false);
            this.bottomArrow.setVisible(true);
            break;
        }
    }
    
    private void setBottomLeft() {
        this.bottomArrow.setStyleName(this.tooltipCSSNames.getArrowBottomLeft());
        this.topArrow.setVisible(false);
        this.leftArrow.setVisible(false);
        this.rightArrrow.setVisible(false);
        this.bottomArrow.setVisible(true);
        grid.getFlexCellFormatter().setHorizontalAlignment(2, 1, HasHorizontalAlignment.ALIGN_LEFT);
    }
    
    private void setBottomRight() {
        this.bottomArrow.setStyleName(this.tooltipCSSNames.getArrowBottomRight());
        this.topArrow.setVisible(false);
        this.leftArrow.setVisible(false);
        this.rightArrrow.setVisible(false);
        this.bottomArrow.setVisible(true);
        grid.getFlexCellFormatter().setHorizontalAlignment(2, 1, HasHorizontalAlignment.ALIGN_RIGHT);
    }
    
    private void setMiddleBottomLeft() {
        this.leftArrow.setStyleName(this.tooltipCSSNames.getArrowMiddleBottomLeft());
        this.topArrow.setVisible(false);
        this.leftArrow.setVisible(true);
        this.rightArrrow.setVisible(false);
        this.bottomArrow.setVisible(false);
        grid.getFlexCellFormatter().setVerticalAlignment(1, 0, HasVerticalAlignment.ALIGN_BOTTOM);
    }
    
    private void setMiddleTopLeft() {
        this.leftArrow.setStyleName(this.tooltipCSSNames.getArrowMiddleTopLeft());
        this.topArrow.setVisible(false);
        this.leftArrow.setVisible(true);
        this.rightArrrow.setVisible(false);
        this.bottomArrow.setVisible(false);
        grid.getFlexCellFormatter().setVerticalAlignment(1, 0, HasVerticalAlignment.ALIGN_TOP);
    }
    
    private void setMiddleBottomRight() {
        this.rightArrrow.setStyleName(this.tooltipCSSNames.getArrowMiddleBottomRight());
        this.topArrow.setVisible(false);
        this.leftArrow.setVisible(false);
        this.rightArrrow.setVisible(true);
        this.bottomArrow.setVisible(false);
        grid.getFlexCellFormatter().setVerticalAlignment(1, 2, HasVerticalAlignment.ALIGN_BOTTOM);
    }
    
    private void setMiddleTopRight() {
        this.rightArrrow.setStyleName(this.tooltipCSSNames.getArrowMiddleTopRight());
        this.topArrow.setVisible(false);
        this.leftArrow.setVisible(false);
        this.rightArrrow.setVisible(true);
        this.bottomArrow.setVisible(false);
        grid.getFlexCellFormatter().setVerticalAlignment(1, 2, HasVerticalAlignment.ALIGN_TOP);
    }
    
    private void setTopLeft() {
        this.topArrow.setStyleName(this.tooltipCSSNames.getArrowTopLeft());
        this.topArrow.setVisible(true);
        this.leftArrow.setVisible(false);
        this.rightArrrow.setVisible(false);
        this.bottomArrow.setVisible(false);
        grid.getFlexCellFormatter().setHorizontalAlignment(0, 1, HasHorizontalAlignment.ALIGN_LEFT);
    }
    
    private void setTopRight() {
        this.topArrow.setStyleName(this.tooltipCSSNames.getArrowTopRight());
        this.topArrow.setVisible(true);
        this.leftArrow.setVisible(false);
        this.rightArrrow.setVisible(false);
        this.bottomArrow.setVisible(false);
        grid.getFlexCellFormatter().setHorizontalAlignment(0, 1, HasHorizontalAlignment.ALIGN_RIGHT);
    }
    
    
    
    public enum ArrowStyle {
        TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT, MIDDLE_TOP_LEFT, MIDDLE_BOTTOM_LEFT, MIDDLE_TOP_RIGHT, MIDDLE_BOTTOM_RIGHT;
    }
}
