package ru.job4j.array;

/**
 * @author Alex Konotop (mailto:a.konotop@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ArrayChar {

    /**
     * Массив Char.
     */

    private char[] data;

    /*
    Конструктор класса.
     */

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинаеться с префикса
     */

    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        // проверяет что массив data имеет первые элементы одинаковые с value
        for (int i = 0; i < value.length; i++) {
            if (value[i] != this.data[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}