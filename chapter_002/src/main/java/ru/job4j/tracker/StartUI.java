package ru.job4j.tracker;

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
     * @param input ввод данных.
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
            if (ADD.equals("0")) {
                this.createItem();
            } else if (EDIT.equals("1")) {
                this.editItems();
            } else if (ALL.equals("2")) {
                this.findAllItems();
            } else if (DELETE.equals("3")) {
                this.deleteItems();
            } else if (ID.equals("4")) {
                this.findItemsById();
            } else if (NAME.equals("5")) {
                this.findItemsByName();
            } else if (EXIT.equals("6")) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }



    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Добавить новый элемент");
        System.out.println("1. Показать все элементы");
        System.out.println("2. Редактировать элемент");
        System.out.println("3. Удалить элементы");
        System.out.println("4. Найти элемент по id");
        System.out.println("5. Поиск элемента по имени");
        System.out.println("6. Выйти из программы");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
