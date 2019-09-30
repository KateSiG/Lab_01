package com.project_01.oop.Service;

import com.project_01.oop.Entity.Mineral;

import java.util.List;
import java.util.stream.Collectors;

public class BerylServiceImp extends MineralService {
    private AssortmentServiceImp assortmentServiceImp = new AssortmentServiceImp();
    private List<Mineral> beryls;

    public List<Mineral> getAll(List<Mineral> minerals) {
        beryls = minerals.stream()
                .filter( i -> ((Object) i).getClass().toString().endsWith("Beryl"))
                .collect(Collectors.toList());
        return beryls;
    }

    @Override
    double countAll() {
        return beryls.stream().mapToDouble(i -> i.getPrice()).sum();
    }

    @Override
    void sortByPrecious() {
        beryls.stream().mapToDouble(i -> i.getPrice()).sorted();
    }

    @Override
    List<Mineral> getMineralByTransparensy(Mineral.Transparency transparency) {
        return beryls.stream().filter(i -> i.getTransparency() == transparency).collect(Collectors.toList());
    }
}
