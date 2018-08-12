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
    public void whenABcrossingCD()  {
        Abcd crossing = new Abcd();
        boolean result = crossing.abcd(1, 2, 3, 4);
        assertThat(result, is(false));

    }
}
