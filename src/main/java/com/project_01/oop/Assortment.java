package com.project_01.oop;

import com.project_01.oop.Entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.log4j.Logger;

public class Assortment {
    private static final Logger LOG = Logger.getLogger(String.valueOf(Assortment.class));

    private static List<Mineral> minerals = createMinerals();

    public List<Mineral> getMinerals() {
        return minerals;
    }

    private static List<Mineral> createMinerals() {
        LOG.info("creating new Assortment...");

        minerals = new ArrayList<>();
        Random random = new Random();
        Mineral.Transparency transparensyAll[] = Mineral.Transparency.values();
        Mineral.Transparency transparensyFirstTwoEnum[] = {Mineral.Transparency.TRANSLUCENT, Mineral.Transparency.TRANSPARENT};
        for (int i = 1; i < 10; i++) {
            minerals.add(new Diamond(i * 0.3));
            minerals.add(new Citrine(i * 1.1));
            minerals.add(new Malachite(i * 1.5));
            minerals.add(new Beryl(i * 0.5, transparensyAll[random.nextInt(transparensyAll.length)]));
            minerals.add(new Ruby(i * 0.4, transparensyFirstTwoEnum[random.nextInt(transparensyFirstTwoEnum.length)]));
        }
        return minerals;
    }
}
