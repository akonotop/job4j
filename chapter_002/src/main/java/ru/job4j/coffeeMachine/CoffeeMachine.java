package ru.job4j.coffeeMachine;

import java.util.ArrayList;

public class CoffeeMachine {
    public ArrayList<Integer> changes(int value, int price) {
        int[] nominal = {1, 2, 5, 10};
        int change = value - price;
        ArrayList<Integer> changes = new ArrayList<>();
        while (change !=0) {
            if (change > 9) {
                change = change - nominal[3];
                changes.add(nominal[3]);
            }
            if (change > 4 && change < 10) {
                change = change - nominal[2];
                changes.add(nominal[2]);
            }
            if (change == 3) {
                change = change - nominal[1];
                changes.add(nominal[1]);
            }
            if (change == 1) {
                change = change - nominal[0];
                changes.add(nominal[0]);
            }
        }
        return changes;
    }

}
