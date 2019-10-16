package com.project_01.oop.Service;

import com.project_01.oop.Entity.Mineral;
//import org.springframework.stereotype.Service;

import java.util.List;

//@Service
abstract class MineralService {
    abstract double countAll();

    abstract void sortByPrecious();

    abstract List<Mineral> getMineralByTransparensy(Mineral.Transparency transparency);
}
