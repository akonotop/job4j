package ru.job4j.tracker;
/**
 * @author Alex Konotop (mailto:a.konotop@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public int getActionsLentgh() {
        return this.actions.size();
    }

    public void fillActions() {
        this.actions.add(new AddItem(this.input, this.tracker));
        this.actions.add(new ShowItems(this.input, this.tracker));
        this.actions.add(new MenuTracker.EditItem(this.input, this.tracker));
        this.actions.add(new MenuTracker.DeleteItem(this.input, this.tracker));
        this.actions.add(new FindItemById(this.input, this.tracker));
        this.actions.add(new FindItemsByName(this.input, this.tracker));
        this.actions.add(new ExitProgram(this.input, this.tracker));
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem implements UserAction {
        public AddItem(Input input, Tracker tracker) {
        }
        @Override
        public int key() {
            return 0;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Adding new item --------------");
            String name = input.ask("Please, provide item name:");
            String desc = input.ask("Please, provide item description:");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ New Item with Id : " + item.getId());
            System.out.println("------------ New Item with Name : " + item.getName());
            System.out.println("------------ New Item with Description : " + item.getDesc());
        }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item");
        }
    }

    public class ShowItems implements UserAction {

        public ShowItems(Input input, Tracker tracker) {
        }

        public int key() {
           return 1;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Список всех заявок------------ ");
            Item[] items = tracker.findAll();
            for (Item item : items) {
                System.out.println(item.toString());
            }
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Список всех заявок");
        }
    }

    public class EditItem implements UserAction {

        public EditItem(Input input, Tracker tracker) {
        }

        public int key() {
            return 2;
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите id: ");
            String name = input.ask("Введите новое имя заявки: ");
            String desc = input.ask("Введите новое описание заявки: ");
            Item item = new Item(name, desc);
            if (tracker.replace(id, item)) {
                System.out.println("Заявка обновлена");
            } else {
                System.out.println("id введен не верный. Введите коректныый id");
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Edit item");
        }
    }

    public class DeleteItem implements UserAction {
        public DeleteItem(Input input, Tracker tracker) {
        }

        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите ID заявки :");
            if (tracker.delete(id)) {
                System.out.println("------------ Заявка с  ID : " + id + " удалена-----------");
            } else {
                System.out.println("Заявки с ID:" + id + " не существует");
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Удаление заявки");
        }
    }

    public class FindItemById implements UserAction {
        public FindItemById(Input input, Tracker tracker) {
        }

        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по ID------------ ");
            String id = input.ask("Введите ID заявки: ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(item.toString());
            } else {
                System.out.println("Item not found");
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Поиск заявки по ID");
        }
    }

    public class FindItemsByName implements UserAction {

        public FindItemsByName(Input input, Tracker tracker) {
        }

        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени------------ ");
            String name = input.ask("Введите имя заявки: ");
            Item[] items = tracker.findByName(name);
            if (items.length > 0) {
                for (Item item : items) {
                    System.out.println(item.toString());
                }
            } else {
                System.out.println("Заявок с данным именем нет");
            }
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Поиск заявки по имени");
        }
    }
    public class ExitProgram implements UserAction {

        public ExitProgram(Input input, Tracker tracker) {
        }

        public int key() {
           return 6;
        }

        public void execute(Input input, Tracker tracker) {
        }

        public String info() {
            return String.format("%s. %s", this.key(),  "Выход из программы");
        }
    }
}
