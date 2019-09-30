package com.project_01.oop.Entity;

import java.text.DecimalFormat;

public class Malachite extends Gemstone {
    private double carat;
    private double price;
    private boolean isPrecious = false;
    Transparency transparency;

    public Malachite(double carat) {
        this.carat = carat;
        this.transparency = Transparency.OPAQUE;
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
        return "\nMalachite  " + " carat  = " + decimalFormat.format(carat)
                + ", price = " + decimalFormat.format(price)
                + ", isPrecious  = " + isPrecious
                + ", transparency  = " + transparency ;
    }
}
