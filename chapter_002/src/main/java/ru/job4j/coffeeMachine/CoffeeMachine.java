package ru.job4j.coffeeMachine;

public class CoffeeMachine {
    public static int[] changes(int value, int price) {
        int amount = 0;
        int change = value - price;
        if(change > 10 && change%2 == 1 ) {
            amount = change / 10;
        }
        int i;
        int[] changes = new int[amount + 1];
        for(i = 0; i < amount; i++) {
            changes[i] = 10;
        }
        changes[i] = 5;
        return changes;
    }
}
