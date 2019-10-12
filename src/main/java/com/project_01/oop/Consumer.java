package com.project_01.oop;

import com.project_01.oop.Entity.Mineral;
import com.project_01.oop.Service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Consumer {

    private static BerylServiceImp berylServiceImp = new BerylServiceImp();
    private static CitrineServiceImp citrineServiceImp = new CitrineServiceImp();
    private static DiamondServiceImp diamondServiceImp = new DiamondServiceImp();
    private static MalachiteServiceImp malachiteServiceImp = new MalachiteServiceImp();
    private static RubyServiceImp rubyServiceImp = new RubyServiceImp();
    private static AssortmentServiceImp assortmentServiceImp = new AssortmentServiceImp();

    public static void main(String[] args) {
        Assortment assortment = new Assortment();
        List<Mineral> minerals = assortmentServiceImp.getAll();
        System.out.println("This is our assortments " + minerals + "\n Pleas choose a stone for a necklace:" + "\n D - Diamonds, B - Beryl, C - Cetrin, M - Malachite, R - Ruby, A - All stones");

        Scanner sc = new Scanner(System.in);
        String stones = sc.nextLine();
        List<Mineral> mineralsOrder = addStones(stones, minerals);

        System.out.println("Carat from (use a comma for fractions): ");
        double caratFrom = sc.nextDouble();
        System.out.println("Carat to (use a comma for fractions): ");
        double caratTo = sc.nextDouble();
        mineralsOrder = assortmentServiceImp.getByCarats(caratFrom, caratTo, mineralsOrder);
        isCorrect(mineralsOrder);

        System.out.println("Which transparency do you prefer? (1 - TRANSPARENT, 2 - TRANSLUCENT, 3 - OPAQUE)");
        sc.nextLine();
        String transparency = sc.nextLine();
        mineralsOrder = getByTransparency(transparency, mineralsOrder);
        sc.close();
        isCorrect(mineralsOrder);

        mineralsOrder.stream().forEach(i -> System.out.print(i));

        System.out.println("\nSum carats: " + mineralsOrder.stream().mapToDouble(i -> i.getCarat()).sum());

        System.out.println("Total coast: " + mineralsOrder.stream().mapToDouble(i -> i.getPrice()).sum());
    }

    private static boolean isCorrect(List<Mineral> mineralsOrder) {
        if (mineralsOrder.size() == 0) {
            throw new IllegalArgumentException("Sorry, we have no stones matching your order");
        }
        return true;
    }

    private static List<Mineral> getByTransparency(String transparency, List<Mineral> minerals) {
        List<Mineral> mineralList = new ArrayList<>();
        if (transparency.contains("1")) {
            mineralList.addAll(assortmentServiceImp.getMineralByTransparensy(Mineral.Transparency.TRANSPARENT, minerals));
        }
        if (transparency.contains("2")) {
            mineralList.addAll(assortmentServiceImp.getMineralByTransparensy(Mineral.Transparency.TRANSLUCENT, minerals));
        }
        if (transparency.contains("3")) {
            mineralList.addAll(assortmentServiceImp.getMineralByTransparensy(Mineral.Transparency.OPAQUE, minerals));
        }
        if (transparency.contains("\\D")) {
            throw new IllegalArgumentException("Transparency input is not correct");
        }
        return mineralList;
    }

    private static List<Mineral> addStones(String stones, List<Mineral> minerals) {
        String arr[] = stones.replaceAll("(.)\\1{1,}", "$1").split("");
        List<Mineral> mineralsOrder = new ArrayList<>();

        if (stones.toUpperCase().contains("A")) {
            mineralsOrder.addAll(assortmentServiceImp.getAll(minerals));
        } else {
            if (stones.toUpperCase().contains("B")) {
                mineralsOrder.addAll(berylServiceImp.getAll(minerals));
            }
            if (stones.toUpperCase().contains("C")) {
                mineralsOrder.addAll(citrineServiceImp.getAll(minerals));
            }
            if (stones.toUpperCase().contains("D")) {
                mineralsOrder.addAll(diamondServiceImp.getAll(minerals));
            }
            if (stones.toUpperCase().contains("M")) {
                mineralsOrder.addAll(malachiteServiceImp.getAll(minerals));
            }
            if (stones.toUpperCase().contains("R")) {
                mineralsOrder.addAll(rubyServiceImp.getAll(minerals));
            }
        }
        return mineralsOrder;
    }
}

