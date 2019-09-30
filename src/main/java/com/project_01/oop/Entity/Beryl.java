package com.project_01.oop.Entity;

import java.text.DecimalFormat;

public class Beryl extends Gemstone {
    private double carat;
    private double price;
    private boolean isPrecious = false;
    Transparency transparency;

    public Beryl(double carat, Transparency transparency) {
        this.carat = carat;
        this.transparency = transparency;
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
        return "\nBeryl      " + " carat  = " + decimalFormat.format(carat)
                + ", price = " + decimalFormat.format(price)
                + ", isPrecious  = " + isPrecious
                + ", transparency  = " + transparency;
    }
}
