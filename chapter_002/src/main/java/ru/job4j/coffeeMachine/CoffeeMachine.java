package ru.job4j.coffeeMachine;

import java.util.ArrayList;

public class CoffeeMachine {
    public ArrayList<Integer> changes(int value, int price) {
        int change = value - price;
        ArrayList<Integer> changes = new ArrayList<>();
        while (change !=0) {
            if (change > 9) {
                change = change - 10;
                changes.add(10);
            }
            if (change > 4 && change < 10) {
                change = change - 5;
                changes.add(5);
            }
            if (change == 3) {
                change = change - 2;
                changes.add(2);
            }
            if (change == 1) {
                change = change - 1;
                changes.add(1);
            }
        }
        return changes;
    }

}
