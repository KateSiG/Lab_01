package com.project_01.oop.Entity;

abstract class Gemstone implements Mineral {

    double setPrice() {
        double carat = this.getCarat();
        double price = this.isPrecious() ? (carat * 1000) : (carat * 100);
        price = (this.getTransparency() == Mineral.Transparency.TRANSPARENT) ? price * 6 :
                (this.getTransparency() == Mineral.Transparency.TRANSLUCENT) ? price * 2 : price * 0.9;
        return price;
    }

}
