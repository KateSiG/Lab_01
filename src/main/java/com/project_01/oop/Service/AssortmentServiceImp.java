package com.project_01.oop.Service;

import com.project_01.oop.Assortment;
import com.project_01.oop.Entity.Mineral;

import java.util.List;
import java.util.stream.Collectors;

public class AssortmentServiceImp extends MineralService {
    private Assortment assortment = new Assortment();
    private List<Mineral> minerals = assortment.getMinerals();

    public List<Mineral> getAll(List<Mineral> minerals){
        return assortment.getMinerals();
    }

    public List<Mineral> getAll(){
        return assortment.getMinerals();
    }

    @Override
    double countAll() {
        return minerals.stream()
                .mapToDouble(i -> i.getPrice())
                .sum();
    }

    @Override
    public void sortByPrecious() {
        minerals.stream()
                .mapToDouble(i -> i.getPrice())
                .sorted();
    }

    @Override
    public List<Mineral> getMineralByTransparensy(Mineral.Transparency transparency) {
        return minerals.stream()
                .filter(i -> i.getTransparency() == transparency)
                .collect(Collectors.toList());
    }

    public List<Mineral> getMineralByTransparensy(Mineral.Transparency transparency, List<Mineral> list) {
        return list.stream()
                .filter(i -> i.getTransparency() == transparency)
                .collect(Collectors.toList());
    }

    public List<Mineral> getByCarats(double from, double to, List<Mineral> mineralsOrder){
        return mineralsOrder.stream()
                .filter(i ->
                    from <= i.getCarat() && to >= i.getCarat())
                .collect(Collectors.toList());
    }
}
