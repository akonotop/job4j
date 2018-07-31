package ru.job4j.array;

/**
 * @author Alex Konotop (mailto:a.konotop@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = true;
        int i = 0;
        for (boolean dat: data) {
            if (data[0] != dat) {
                result = false;
                break;
            }
            i++;
            result = true;
        }
        return result;
    }
}
