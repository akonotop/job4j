package ru.job4j.array;

/**
 * @author Alex Konotop (mailto:a.konotop@gmail.com)
 * @version $Id$
 * @since 0.1
 */

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class TwoArraysTest {
    @Test
    public void whenFirstPlusTwo() {
        TwoArrays twoArrays = new TwoArrays();
        int[] first = new int[]{1, 2, 3, 5, 7};
        int[] second = new int[]{4, 6, 10, 25, 34};
        int[] result = twoArrays.twoArrays(first, second);
        int[] expect = new int[]{1, 2, 3, 4, 5, 6, 7, 10, 25, 34};
        assertThat(result, Matchers.is(expect));
    }
}
