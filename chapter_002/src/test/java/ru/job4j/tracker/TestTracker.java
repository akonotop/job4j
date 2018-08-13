package ru.job4j.tracker;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

/**
 * @author Alex Konotop (mailto:a.konotop@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class TestTracker {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void whenTheNameIsRepeatedDeleteTheCellInTheArray() {
        Tracker tracker = new Tracker();
        Item item = new Item("test", "testDescription", 123L);
        tracker.add(item);
        Item item1 = new Item("test1", "testDescription1", 1234L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2", 12345L);
        tracker.add(item2);
        tracker.delete(item1.getId());
        Item[] result = tracker.findAll();
        Item[] expect = {item, item2};
        assertThat(result, is(expect));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription2", 123L);
        Item item3 = new Item("test3", "testDescription3", 123L);
        Item item4 = new Item("test4", "testDescription4", 123L);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.delete(item1.getId());
        Item[] testitems = new Item[]{item2, item3, item4};
        assertThat(tracker.findAll(), is(testitems));
    }
    @Test
    public void whenFindItemByName() {
        Tracker  tracker = new Tracker();
        //create three items
        Item first = new Item("name", "test", 123L);
        Item second = new Item("name2", "test2", 124L);
        Item third = new Item("name", "test3", 125L);
        //add Items to Tracker
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        //create array with expections
        Item[] expect = new Item[2];
        expect[0] = first;
        expect[1] = third;
        Item[] actual = tracker.findByName(first.getName());
        assertThat(actual, is(expect));

    }
}
