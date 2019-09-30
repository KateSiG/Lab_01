package com.project_01.oop.Entity;

import java.text.DecimalFormat;

public class Ruby extends Gemstone {
    private double carat;
    private double price;
    private boolean isPrecious = true;
    Transparency transparency;

    public Ruby(double carat, Transparency transparency) {
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

    public Transparency setTransparency() {
        return transparency;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return "\nRuby       " + " carat  = " + decimalFormat.format(carat)
                + ", price = " + decimalFormat.format(price)
                + ", isPrecious  = " + isPrecious
                + ", transparency  = " + transparency ;
    }
}
