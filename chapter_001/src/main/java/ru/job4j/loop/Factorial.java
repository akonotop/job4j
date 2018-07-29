package ru.job4j.loop;

/**
 * @author Alex Konotop (mailto:a.konotop@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Factorial {
    public int calc(int n) {
        int factorial = 1;
        for (int j = 1; j <= n; j++) {
            factorial = factorial * j;
        }
        return factorial;
    }
}
