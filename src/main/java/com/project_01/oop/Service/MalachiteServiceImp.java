package com.project_01.oop.Service;

import com.project_01.oop.Entity.Mineral;
//import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//@Service
public class MalachiteServiceImp extends MineralService {
    private AssortmentServiceImp assortmentServiceImp = new AssortmentServiceImp();
    List<Mineral> malachites;

    public List<Mineral> getAll(List<Mineral> minerals) {
        malachites = minerals.stream().filter(i -> ((Object) i).getClass().toString().endsWith("Malachite")).collect(Collectors.toList());
        return malachites;
    }

    @Override
    double countAll() {
        return malachites.stream().mapToDouble(i -> i.getPrice()).sum();
    }

    @Override
    void sortByPrecious() {
        malachites.stream().mapToDouble(i -> i.getPrice()).sorted();
    }

    @Override
    List<Mineral> getMineralByTransparensy(Mineral.Transparency transparency) {
        return malachites.stream().filter(i -> i.getTransparency() == transparency).collect(Collectors.toList());
    }
}
