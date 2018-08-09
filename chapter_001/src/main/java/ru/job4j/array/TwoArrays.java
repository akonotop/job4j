package ru.job4j.array;

/**
 * @author Alex Konotop (mailto:a.konotop@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class TwoArrays {
    public static int[] twoArrays(int[] first, int[] second) {
        // при соединение двух отсортированных массивов first и second получаем новый отсортированный newOne
    int[] newOne = new int[first.length + second.length];
    int firstIndex = 0;
    int secondIndex = 0;

    for (int i = 0; i < newOne.length; i++){
        newOne[i] = first[firstIndex] < second[secondIndex] ? first[firstIndex++] : second[secondIndex++];
        if (firstIndex == first.length) {
            System.arraycopy(second, secondIndex, newOne, ++i, second.length - secondIndex);
            break;
        }
        if (secondIndex == second.length) {
            System.arraycopy(first, firstIndex, newOne, ++i, first.length - firstIndex);
            break;
        }
    }
    return newOne;
}
}
