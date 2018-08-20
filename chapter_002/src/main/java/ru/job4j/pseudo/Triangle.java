package ru.job4j.pseudo;

/**
 * @author Alex Konotop (mailto:a.konotop@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Triangle implements Shape {
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   *   ");
        pic.append("  *** ");
        pic.append(" ***** ");
        pic.append("*******");
        return pic.toString();
    }
}
