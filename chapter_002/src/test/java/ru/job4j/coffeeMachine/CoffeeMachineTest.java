package ru.job4j.coffeeMachine;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class CoffeeMachineTest {
    @Test
    public void when50Change15() {
        CoffeeMachine changesTest = new CoffeeMachine();
        int[] result = changesTest.changes(50, 35);
        int[] expect = {10, 5};
        assertThat(result, Matchers.is(expect));
    }
}
