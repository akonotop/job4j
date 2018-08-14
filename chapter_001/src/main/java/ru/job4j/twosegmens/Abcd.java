package ru.job4j.twosegmens;

/**
 * @author Alex Konotop (mailto:a.konotop@gmail.com)
 * @version $Id$
 * @since 0.1
 */

//Дано два отрезка на одной прямой AB(A < B) и CD(C < D) - метод определяет пересекаются ли они

public class Abcd {
    public boolean abcd(int a, int b, int c, int d) {
    boolean result = true;

    if (b < c) {
        return false;
    }
    if (d < a){
        return false;
    }
    return true;
    }
}