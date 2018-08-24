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
            range.add( actions.get( i ).key() );
        }
        return range;
    }

    public void fillActions(StartUI ui) {
        this.actions.add( new AddItem( 0, "Add item" ) );
        this.actions.add( new ShowItems( 1, "Show all items" ) );
        this.actions.add( new MenuTracker.EditItem( 2, "Edit item" ) );
        this.actions.add( new MenuTracker.DeleteItem( 3, "Delete item" ) );
        this.actions.add( new FindItemById( 4, "Find item by Id" ) );
        this.actions.add( new FindItemsByName( 5, "Find items by name" ) );
        this.actions.add( new ExitProgram( ui,6, "Exit Program" ) );
    }

    public void select(int key) {
        this.actions.get( key ).execute( this.input, this.tracker );
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println( action.info() );
            }
        }
    }

    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super( key, name );
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println( "------------ Adding new item --------------" );
            String name = input.ask( "Please, provide item name:" );
            String desc = input.ask( "Please, provide item description:" );
            Item item = new Item( name, desc );
            tracker.add( item );
            System.out.println( "------------ New Item with Id : " + item.getId() );
            System.out.println( "------------ New Item with Name : " + item.getName() );
            System.out.println( "------------ New Item with Description : " + item.getDesc() );
        }
    }

    public class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super( key, name );
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println( "------------ Список всех заявок------------ " );
            Item[] items = tracker.findAll();
            for (Item item : items) {
                System.out.println( item.toString() );
            }
        }
    }

    public class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super( key, name );
        }

        public void execute(Input input, Tracker tracker) {
            String id = input.ask( "Введите id: " );
            String name = input.ask( "Введите новое имя заявки: " );
            String desc = input.ask( "Введите новое описание заявки: " );
            Item item = new Item( name, desc );
            if (tracker.replace( id, item )) {
                System.out.println( "Заявка обновлена" );
            } else {
                System.out.println( "id введен не верный. Введите коректныый id" );
            }
        }
    }

    public class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super( key, name );
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println( "------------ Удаление заявки --------------" );
            String id = input.ask( "Введите ID заявки :" );
            if (tracker.delete( id )) {
                System.out.println( "------------ Заявка с  ID : " + id + " удалена-----------" );
            } else {
                System.out.println( "Заявки с ID:" + id + " не существует" );
            }
        }
    }

    public class FindItemById extends BaseAction {

        public FindItemById(int key, String name) {
            super( key, name );
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println( "------------ Поиск заявки по ID------------ " );
            String id = input.ask( "Введите ID заявки: " );
            Item item = tracker.findById( id );
            if (item != null) {
                System.out.println( item.toString() );
            } else {
                System.out.println( "Item not found" );
            }
        }
    }

    public class FindItemsByName extends BaseAction {

        public FindItemsByName(int key, String name) {
            super( key, name );
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println( "------------ Поиск заявки по имени------------ " );
            String name = input.ask( "Введите имя заявки: " );
            Item[] items = tracker.findByName( name );
            if (items.length > 0) {
                for (Item item : items) {
                    System.out.println( item.toString() );
                }
            } else {
                System.out.println( "Заявок с данным именем нет" );
            }
        }
    }

    public class ExitProgram extends BaseAction {
        private final StartUI ui;

        public ExitProgram(StartUI ui, int key, String name) {
            super( key, name );
            this.ui = ui;
        }

        public void execute(Input input, Tracker tracker) {
            this.ui.stop();
        }
    }
}
