package ru.job4j.array;

/**
 * @author Alex Konotop (mailto:a.konotop@gmail.com)
 * @version $Id$
 * @since 0.1
 */

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenBubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = new int[]{5, 1, 2, 7, 3};
        int[] result = bubbleSort.sort( array );
        int[] expect = new int[] {1, 2, 3, 5, 7};
        assertThat( result, Matchers.is( expect ) );
    }
}

