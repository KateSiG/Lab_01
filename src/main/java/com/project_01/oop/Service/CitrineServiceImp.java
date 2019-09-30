package com.project_01.oop.Service;

import com.project_01.oop.Entity.Mineral;

import java.util.List;
import java.util.stream.Collectors;

public class CitrineServiceImp extends MineralService {
    private AssortmentServiceImp assortmentServiceImp = new AssortmentServiceImp();
    List<Mineral> citrines;

    public List<Mineral> getAll(List<Mineral> minerals) {
        citrines = minerals.stream().filter(i -> ((Object) i).getClass().toString().endsWith("Citrine")).collect(Collectors.toList());
        return citrines;
    }

    @Override
    double countAll() {
        return citrines.stream().mapToDouble(i -> i.getPrice()).sum();
    }

    @Override
    void sortByPrecious() {
        citrines.stream().mapToDouble(i -> i.getPrice()).sorted();
    }

    @Override
    List<Mineral> getMineralByTransparensy(Mineral.Transparency transparency) {
        return citrines.stream().filter(i -> i.getTransparency() == transparency).collect(Collectors.toList());
    }
}
