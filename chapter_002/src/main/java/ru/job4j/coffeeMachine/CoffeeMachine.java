package ru.job4j.coffeeMachine;

import java.util.ArrayList;

public class CoffeeMachine {
    public ArrayList<Integer> changes(int value, int price) {
        int[] coins = {10, 5, 2, 1};
        int change = value - price;
        ArrayList<Integer> changes = new ArrayList<>();
        for (int coin : coins ) {
            while(change >= coin) {
                change = change - coin;
                changes.add(coin);
            }
        }
        return changes;
    }

}
