package com.project_01.oop.Service;

import com.project_01.oop.Entity.Mineral;

import java.util.List;
import java.util.stream.Collectors;

public class DiamondServiceImp extends MineralService {
    private AssortmentServiceImp assortmentServiceImp = new AssortmentServiceImp();
    private List<Mineral> diamonds;


    public List<Mineral> getAll(List<Mineral> minerals) {
         this.diamonds = minerals.stream()
                .filter( i -> ((Object) i).getClass().toString().endsWith("Diamond"))
                .collect(Collectors.toList());
        return diamonds;
    }

    @Override
    double countAll() {
        return  diamonds.stream()
                .mapToDouble(i -> i.getPrice())
                .sum();
    }

    @Override
    void sortByPrecious() {
        diamonds.stream()
                .mapToDouble(i -> i.getPrice())
                .sorted();
    }

    @Override
    List<Mineral> getMineralByTransparensy(Mineral.Transparency transparency) {
        return diamonds.stream()
                .filter(i -> i.getTransparency() == transparency)
                .collect(Collectors.toList());
    }
}
