package com.project_01.oop.Service;

import com.project_01.oop.Entity.Mineral;

import java.util.List;
import java.util.stream.Collectors;

abstract class MineralService {
    abstract double countAll();
    abstract void sortByPrecious();
    abstract List<Mineral> getMineralByTransparensy(Mineral.Transparency transparency);
}
