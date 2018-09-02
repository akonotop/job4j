package ru.job4j.coffeeMachine;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertThat;

public class CoffeeMachineTest {
    @Test
    public void when50Change15() {
        CoffeeMachine changesTest = new CoffeeMachine();
        ArrayList<Integer> result = changesTest.changes(50, 35);
        ArrayList<Integer> expect =new ArrayList<Integer>(){{add(10); add(5);}};
        assertThat(result, Matchers.is(expect));
    }
    @Test
    public void when73Change38() {
        CoffeeMachine changesTest = new CoffeeMachine();
        ArrayList<Integer> result = changesTest.changes(73, 35);
        ArrayList<Integer> expect =new ArrayList<Integer>(){{add(10); add(10);add(10); add(5); add(2); add(1);}};
        assertThat(result, Matchers.is(expect));
    }
    @Test
    public void checkChangeValue35Price35() {
        CoffeeMachine changesTest = new CoffeeMachine();
        ArrayList<Integer> result = changesTest.changes(35, 35);
        ArrayList<Integer> expect =new ArrayList<Integer>(){};
        assertThat(result, Matchers.is(expect));
    }
}
