package com.project_01.oop.Service;

import com.project_01.oop.Assortment;
import com.project_01.oop.Entity.Mineral;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssortmentServiceImp extends MineralService {
    private static final Logger LOG = Logger.getLogger(AssortmentServiceImp.class);

    private Assortment assortment = new Assortment();
    private List<Mineral> minerals = assortment.getMinerals();

    public List<Mineral> getAll(List<Mineral> minerals) {
        return assortment.getMinerals();
    }

    public List<Mineral> getAll() {
        LOG.info("Show all Minerals");

        return assortment.getMinerals();
    }

    @Override
    double countAll() {
        LOG.info("Count amount");
        return minerals.stream().mapToDouble(i -> i.getPrice()).sum();
    }

    @Override
    public void sortByPrecious() {
        LOG.info("Sorting by precious");
        minerals.stream().mapToDouble(i -> i.getPrice()).sorted();
    }

    @Override
    public List<Mineral> getMineralByTransparensy(Mineral.Transparency transparency) {
        LOG.info("Show minerals by transparensy");
        return minerals.stream().filter(i -> i.getTransparency() == transparency).collect(Collectors.toList());
    }

    public List<Mineral> getMineralByTransparensy(Mineral.Transparency transparency, List<Mineral> list) {
        LOG.info("Show minerals by transparensy");
        return list.stream().filter(i -> i.getTransparency() == transparency).collect(Collectors.toList());
    }

    public List<Mineral> getByCarats(double from, double to, List<Mineral> mineralsOrder) {
        LOG.info("Show minerals by carats " + this.getClass());
        return mineralsOrder.stream().filter(i -> from <= i.getCarat() && to >= i.getCarat()).collect(Collectors.toList());
    }
}
