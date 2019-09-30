package com.project_01.oop.Entity;

import java.text.DecimalFormat;

public class Diamond extends Gemstone {
    private double carat;
    private double price;
    private boolean isPrecious = true;
    Transparency transparency = Transparency.TRANSPARENT;

    public Diamond(double carat) {
        this.carat = carat;
        this.price = super.setPrice();
    }

    public double getCarat() {
        return carat;
    }

    public double getPrice() {
        return price;
    }

    public boolean isPrecious() {
        return isPrecious;
    }

    public Transparency getTransparency() {
        return transparency;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return "\nDiamond    " + " carat  = " + decimalFormat.format(carat)
                + ", price = " + decimalFormat.format(price)
                + ", isPrecious  = " + isPrecious
                + ", transparency  = " + transparency ;
    }
}
