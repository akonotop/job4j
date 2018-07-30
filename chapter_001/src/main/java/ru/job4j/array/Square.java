package ru.job4j.array;

/**
 * @author Alex Konotop (mailto:a.konotop@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Square {
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        int power = 2;
        int value = 1;
        // заполнить массив через цикл элементами от 1 до bound возведенными в квадрат
        for (int index = 0; index != bound; index++) {
            rst[index] = (int) Math.pow(value, power);
            value++;
        }
        return rst;
    }
}
