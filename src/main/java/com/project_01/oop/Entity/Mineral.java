package com.project_01.oop.Entity;

public interface Mineral {
    enum Transparency {
        TRANSPARENT, TRANSLUCENT, OPAQUE;

    }
    double getCarat();
    double getPrice();
    boolean isPrecious();
    Transparency getTransparency();
}
