package ru.job4j.array;

/**
 * @author Alex Konotop (mailto:a.konotop@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class TwoArrays {
    public static int[] twoArrays(int[] first, int[] second) {
    int[] newOne = new int[first.length + second.length];
    int i = 0, j = 0, k = 0;
    while( i < first.length && j < second.length) {
        if(first[i] < second[j]) {
            newOne[k] = first[i];
            i++;
            k++;
        } else {
            newOne[k] = second[j];
            j++;
            k++;
        }
    }
    while (i < first.length) {
        newOne[k++] = first[i++];
    }
    while (j < second.length) {
        newOne[k++] = second[j++];
    }
    return newOne;
    }
}
