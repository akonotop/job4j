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
        String id = this.input.ask("Введите ID: ");
        String name = this.input.ask("Введите новое имя заявки: ");
        String desc = this.input.ask("Введите новое описание заявки: ");
        Item item = new Item(name, desc);
            if (tracker.replace(id, item)) {
                System.out.println("Заявка Обновлена");
            } else {
                System.out.println("ID введен не верный. Введите коректныый ID");
            }
    }
    /**
     * Метод находит все заявки
     */
    private void findAllItems() {
        for (int i = 0; i < this.tracker.findAll().length; i++) {
            System.out.println(this.tracker.findAll()[i].getStringItem());
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
        String id = this.input.ask("Введите ID заявки: ");
        if (this.tracker.findById(id) != null) {
            System.out.println(this.tracker.findById(id).getStringItem());
        } else {
            System.out.println("Заявки с ID:" + id + " не существует");
        }
    }
    /**
     * Метод находит заявки по имени
     */
    private void findItemsByName() {
        String name = this.input.ask("Введите имя заявки: ");
        if (this.tracker.findByName(name).length != 0) {
            for (int i = 0; i < this.tracker.findByName(name).length; i++)
                System.out.println(this.tracker.findByName(name)[i].getStringItem());
        } else {
            System.out.println("Заявок с таким именем не найдено");
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


