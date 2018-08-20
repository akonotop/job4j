package ru.job4j.tracker;

import java.sql.SQLOutput;

/**
 * @author Alex Konotop (mailto:a.konotop@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    private static final String EDIT = "1";
    private static final String ALL = "2";
    private static final String DELETE = "3";
    private static final String ID = "4";
    private static final String NAME = "5";
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
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
    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (EDIT.equals(answer)) {
                this.editItems();
            } else if (ALL.equals(answer)) {
                this.findAllItems();
            } else if (DELETE.equals(answer)) {
                this.deleteItems();
            } else if (ID.equals(answer)) {
                this.findItemsById();
            } else if (NAME.equals(answer)) {
                this.findItemsByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }
    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println( "------------ Добавление новой заявки --------------" );
        String name = this.input.ask( "Введите имя заявки :" );
        String desc = this.input.ask( "Введите описание заявки :" );
        Item item = new Item( name, desc );
        this.tracker.add( item );
        System.out.println( "------------ Новая заявка с getId : " + item.getId() + "-----------" );
    }
    /**
     * Метод редактирует заявки
     */
    private void editItems() {
        String id = this.input.ask("Введите id: ");
        String name = this.input.ask("Введите новое имя заявки: ");
        String desc = this.input.ask("Введите новое описание заявки: ");
        Item item = new Item(name, desc);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка обновлена");
        } else {
            System.out.println("id введен не верный. Введите коректныый id");
        }
    }
    /**
     * Метод находит все заявки
     */
    private void findAllItems() {
        System.out.println("------------ Список всех заявок------------ ");
        Item[] items = tracker.findAll();
        for (Item item : items) {
            System.out.println( item.toString() );
        }
    }
    /**
     * Метод удаляет заявки
     */
    private void deleteItems() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите ID заявки :");
        if (tracker.delete(id)) {
            System.out.println("------------ Заявка с  ID : " + id + " удалена-----------");
        } else {
            System.out.println("Заявки с ID:" + id + " не существует");
        }
    }
    /**
     * Метод находит заявки по id
     */
    private void findItemsById() {
        System.out.println("------------ Поиск заявки по ID------------ ");
        String id = this.input.ask( "Введите ID заявки: " );
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item.toString());
        } else {
            System.out.println("Item not found");
        }
    }
    /**
     * Метод находит заявки по имени
     */
    private void findItemsByName() {
        System.out.println("------------ Поиск заявки по имени------------ ");
        String name = this.input.ask("Введите имя заявки: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item.toString());
            }
        } else {
            System.out.println("Заявок с данным именем нет");
        }
    }

    private void showMenu() {
        System.out.println( "Меню." );
        System.out.println( "0. Добавить новый элемент" );
        System.out.println( "1. Редактировать элемент" );
        System.out.println( "2. Показать все элементы" );
        System.out.println( "3. Удалить элементы" );
        System.out.println( "4. Найти элемент по id" );
        System.out.println( "5. Поиск элемента по имени" );
        System.out.println( "6. Выйти из программы" );
    }
    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}


