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

    public ArrayList<Integer> getRange() {
        ArrayList<Integer> range = new ArrayList<>();
        for (int i = 0; i < actions.size(); i++) {
            range.add(actions.get(i).key());
        }
        return range;
    }

    private void printItems(List<Item> items) {
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }

    private Item getItemById() {
        String id = this.input.ask("Ввведите идентификатор заявки.");
        return this.tracker.findById(id);
    }

    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "Add item"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new MenuTracker.EditItem(2, "Edit item"));
        this.actions.add(new MenuTracker.DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(ui, 6, "Exit Program"));
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

    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
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
    }

    public class ShowItems extends BaseAction {
        public ShowItems(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            printItems(tracker.findAll());
        }
    }

    public class EditItem extends BaseAction {
        public EditItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            Item item = getItemById();
            if (item == null) {
                System.out.println("Заявка не найдена.");
            } else {
                String name = input.ask("Введите новое имя заявки :");
                String desc = input.ask("Введите новое описание заявки :");
                Item newItem = new Item(name, desc);
                newItem.setId(item.getId());
                tracker.replace(item.getId(), newItem);
            }
        }
    }

    public class DeleteItem extends BaseAction {
        public DeleteItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            Item item = getItemById();
            if (item == null) {
                System.out.println("Заявка не найдена.");
            } else {
                tracker.delete(item.getId());
            }
        }
    }

    public class FindItemById extends BaseAction {
        public FindItemById(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            Item item = getItemById();
            if (item != null) {
                System.out.println(item.toString());
            }
        }
    }

    public class FindItemsByName extends BaseAction {

        public FindItemsByName(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            String key = input.ask("Ввведите имя заявки.");
            List<Item> items = tracker.findByName(key);
            printItems(items);
        }
    }

    public class ExitProgram extends BaseAction {
        private final StartUI ui;

        public ExitProgram(StartUI ui, int key, String name) {
            super(key, name);
            this.ui = ui;
        }

        public void execute(Input input, Tracker tracker) {
            this.ui.stop();
        }
    }
}
