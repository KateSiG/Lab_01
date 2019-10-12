package com.project_01.oop.Service;

import com.project_01.oop.Entity.Mineral;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

public class RubyServiceImp extends MineralService {
    private static final Logger LOG = Logger.getLogger(RubyServiceImp.class);

    private AssortmentServiceImp assortmentServiceImp = new AssortmentServiceImp();
    private List<Mineral> rubies;

    public List<Mineral> getAll(List<Mineral> minerals) {
        LOG.info("Show all Rubies");

        rubies = minerals.stream().filter(i -> ((Object) i).getClass().toString().endsWith("Ruby")).collect(Collectors.toList());
        return rubies;
    }

    @Override
    double countAll() {
        return rubies.stream().mapToDouble(i -> i.getPrice()).sum();
    }

    @Override
    void sortByPrecious() {
        rubies.stream().mapToDouble(i -> i.getPrice()).sorted();
    }

    @Override
    List<Mineral> getMineralByTransparensy(Mineral.Transparency transparency) {
        return rubies.stream().filter(i -> i.getTransparency() == transparency).collect(Collectors.toList());
    }
}
