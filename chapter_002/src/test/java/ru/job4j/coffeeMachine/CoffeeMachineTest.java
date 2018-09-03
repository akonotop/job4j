package ru.job4j.coffeeMachine;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class CoffeeMachineTest {
    @Test
    public void when50Change15() {
        CoffeeMachine changesTest = new CoffeeMachine();
        ArrayList<Integer> result = changesTest.changes(50, 35);
        List<Integer> expect = Arrays.asList(10, 5);
        assertThat(result, Matchers.is(expect));
    }
    @Test
    public void when73Change38() {
        CoffeeMachine changesTest = new CoffeeMachine();
        ArrayList<Integer> result = changesTest.changes(73, 35);
        List<Integer> expect = Arrays.asList(10, 10, 10, 5, 2, 1);
        assertThat(result, Matchers.is(expect));
    }
    @Test
    public void checkChangeValue35Price35() {
        CoffeeMachine changesTest = new CoffeeMachine();
        ArrayList<Integer> result = changesTest.changes(35, 35);
        List<Integer> expect = Arrays.asList();
        assertThat(result, Matchers.is(expect));
    }
}
