package ru.job4j.loop;

/**
 * @author Alex Konotop (mailto:a.konotop@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Counter {
    public int add(int start, int finish) {
        int sum = 0;
        for ( ; start <= finish; start++) {
            if (start % 2 == 0) {
                sum = sum + start;
            }
        }
        return sum;
    }
}
