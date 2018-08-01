package ru.job4j.array;

/**
 * @author Alex Konotop (mailto:a.konotop@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            if ((data[i][i] != data[1][1]) && (data[data.length - 1][i]) != data[1][1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
