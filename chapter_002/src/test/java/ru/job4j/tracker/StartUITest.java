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
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() throws MenuOutException {
        final Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(0).getName(), is("test"));    }

    @Test
    public void whenUserEditItemThenTrackerShowEditItem() throws MenuOutException {
        final Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc");
        tracker.add(item);
        Input input = new StubInput(new String[]{"2", item.getId(), "test name2", "desc2", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test name2"));
    }

    @Test
    public void whenUserDeleteItemThenTrackerDeleteItem() throws MenuOutException {
        final Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc");
        tracker.add(item);
        Item item2 = new Item("test name2", "desc2");
        tracker.add(item2);
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findIndexById(item.getId()), is(-1));
        assertThat(tracker.findIndexById(item2.getId()), is(0));
    }
    public String menu() {
        String nl = System.lineSeparator();
        return new StringBuilder()
                .append("0 : Add item").append(nl)
                .append("1 : Show all items").append(nl)
                .append("2 : Edit item").append(nl)
                .append("3 : Delete item").append(nl)
                .append("4 : Find item by Id").append(nl)
                .append("5 : Find items by name").append(nl)
                .append("6 : Exit Program").append(nl)
                .toString();
    }
    @Test
    public void whenShowAll() throws MenuOutException {
        String nl = System.lineSeparator();
        final Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("name1", "that's all", 45L));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(menu() + (new StringBuilder()
                                .append("Item{")
                                .append("id=" + "'" +  item.getId() + "', ")
                                .append("name=" + "'" + item.getName() + "', ")
                                .append("desc=" + "'" + item.getDesc() + "'}"))
                                .append(nl) + menu() + (new StringBuilder())
                )
        );
    }
    @Test
    public void whenFindByNameAllItemThenTrackerShowFindItems() throws MenuOutException {
        String nl = System.lineSeparator();
        final Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 12L));
        item.setId("123");
        Item item2 = tracker.add(new Item("test name2", "desc2", 112L));
        item2.setId("457");
        Item item3 = tracker.add(new Item("test name3", "desc3", 124L));
        item3.setId("958");
        Input input = new StubInput(new String[]{"5", "test name2", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(this.out.toByteArray()), is(menu() + (new StringBuilder()
                                .append("Item{")
                                .append("id='457', name='test name2', desc='desc2" + "'}"))
                                .append(nl) + menu() + (new StringBuilder())
                )
        );
    }
}
