package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alex Konotop (mailto:a.konotop@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class StartUITest {

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private final Tracker tracker = new Tracker();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }
    @Test
    public void whenUserEditItemThenTrackerShowEditItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc");
        tracker.add(item);
        Input input = new StubInput(new String[]{"2", item.getId(), "test name2", "desc2", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name2"));
    }

    @Test
    public void whenUserDeleteItemThenTrackerDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc");
        tracker.add(item);
        Item item2 = new Item("test name2", "desc2");
        tracker.add(item2);
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name2"));
    }
    public String menu() {
        String nl = System.lineSeparator();
        return new StringBuilder()
                .append("Меню.").append(nl)
                .append("0. Добавить новый элемент").append(nl)
                .append("1. Показать все элементы").append(nl)
                .append("2. Редактировать элемент").append(nl)
                .append("3. Удалить элементы").append(nl)
                .append("4. Найти элемент по id").append(nl)
                .append("5. Поиск элемента по имени").append(nl)
                .append("6. Выйти из программы").append(nl)
                .toString();
    }
    @Test
    public void whenShowAll() {
        String nl = System.lineSeparator();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name1", "that's all", 45L));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(menu() + (new StringBuilder()
                                .append("------------ Список всех заявок------------ ").append(nl)
                                .append("Item{")
                                .append("id=" + "'" +  item.getId() + "', ")
                                .append("name=" + "'" + item.getName() + "', ")
                                .append("desc=" + "'" + item.getDesc()+ "'}"))
                                .append(nl) + menu() + (new StringBuilder())
                )
        );
    }
    @Test
    public void whenFindByNameAllItemThenTrackerShowFindItems() {
        String nl = System.lineSeparator();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 12L));
        item.setId("123");
        Item item2 = tracker.add(new Item("test name2", "desc2", 112L));
        item2.setId("457");
        Item item3 = tracker.add(new Item("test name3", "desc3", 124L));
        item3.setId("958");
        Input input = new StubInput(new String[]{"5", "test name2", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(menu() + (new StringBuilder()
                                .append("------------ Поиск заявки по имени------------ ").append(nl)
                                .append("Item{")
                                .append("id='457', name='test name2', desc='desc2" + "'}"))
                                .append(nl) + menu() + (new StringBuilder())
                )
        );
    }
}
