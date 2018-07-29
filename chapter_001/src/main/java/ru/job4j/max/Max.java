package ru.job4j.max;

/**
 * @author Alex Konotop (mailto:a.konotop@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Max {
    public int max(int first, int second) {
        int temp;
        return temp = first > second ? first : second;
    }
    public int max(int first, int second, int third) {
        int temp = this.max(first, second);
        return temp ;
    }
}
