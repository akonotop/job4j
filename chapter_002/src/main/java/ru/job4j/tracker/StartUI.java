package ru.job4j.tracker;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Konotop (mailto:a.konotop@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class StartUI {
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() throws MenuOutException {
        MenuTracker menu = new MenuTracker( this.input, tracker );
        menu.fillActions();
        do {
            menu.show();
            menu.select( input.ask( "Введите пункт меню :", menu.getRange() ) );
        } while (!"y".equals( this.input.ask( "Exit?(y): " ) ));
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) throws MenuOutException {
        new StartUI( new ValidateInput( new ConsoleInput() ), new Tracker() ).init();
    }
}


