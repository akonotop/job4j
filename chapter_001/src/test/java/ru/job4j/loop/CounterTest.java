package ru.job4j.loop;

import org.junit.Test;
import ru.job4j.loop.CounterTest;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    @Test
    public void sumEvenNumbers() {
        Counter sum = new Counter();
        int result = sum.add(1, 10);
        assertThat(result, is(30));
    }
}
