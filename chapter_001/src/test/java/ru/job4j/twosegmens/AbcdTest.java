package ru.job4j.twosegmens;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alex Konotop (mailto:a.konotop@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class AbcdTest {
    @Test
    public void whenABleftAndNotCrossing() {
        Abcd crossing = new Abcd();
        boolean result = crossing.abcd(1, 2, 3, 4);
        assertThat(result, is(false));
    }
    @Test
    public void whenCDleftAndNotCrossing() {
        Abcd crossing = new Abcd();
        boolean result = crossing.abcd(3, 4, 1, 2);
        assertThat(result, is(false));
    }
    @Test
    public void whenCDisCrossingABfromLeft() {
        Abcd crossing = new Abcd();
        boolean result = crossing.abcd(3, 5, 1, 4);
        assertThat(result, is(true));
    }
    @Test
    public void whenCDisCrossingABfromRight() {
        Abcd crossing = new Abcd();
        boolean result = crossing.abcd(3, 5, 4, 8);
        assertThat(result, is(true));
    }
    @Test
    public void whenCDisInsideAB() {
        Abcd crossing = new Abcd();
        boolean result = crossing.abcd(1, 10, 3, 8);
        assertThat(result, is(true));
    }
}
