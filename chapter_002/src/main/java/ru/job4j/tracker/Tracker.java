package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Alex Konotop (mailto:a.konotop@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Tracker {

    private final List<Item> items = new ArrayList<>();

    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public void replace(String id, Item item) {
        int index = findIndexById(id);
        if (index != -1) {
            item.setId(id);
            items.set(index, item);
        }
    }

    public void delete(String id) {
        int index = findIndexById(id);
        if (index != -1) {
            items.remove(index);
        }
    }

    public int findIndexById(String id) {
        int result = -1;
        for (Item item : this.items) {
            if (item.getId().equals(id)) {
                result = this.items.indexOf(item);
                break;
            }
        }
        return result;
    }

    public List<Item> findAll() {
        return this.items;
    }

    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        for (Item item : this.items) {
            if (item.getName().equals(key)) {
                items.add(item);
            }
        }
        return items;
    }

    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}