package user;

/**
 * @author Alex Konotop (mailto:a.konotop@gmail.com)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {

    @Test
    public void whenListOfThreeUsersByAge() {
        SortUser sortUser = new SortUser();
        User user1 = new User("Alex", 33);
        User user2 = new User("Ivan", 30);
        User user3 = new User("Rakso", 11);
        List<User> input = Arrays.asList(user1, user2, user3);
        Set<User> result = sortUser.sort(input);
        Iterator<User> iterator = result.iterator();
        assertThat(iterator.next(), is(user3));
        assertThat(iterator.next(), is(user2));
        assertThat(iterator.next(), is(user1));
    }

    @Test
    public void whenSortListByNameLength() {
        SortUser sortUser = new SortUser();
        User user1 = new User("John", 28);
        User user2 = new User("Danila", 46);
        User user3 = new User("Sasha", 17);
        List<User> input = Arrays.asList(user1, user2, user3);
        List<User> result = sortUser.sortNameLength(input);
        Iterator<User> iterator = result.iterator();
        assertThat(iterator.next(), is(user1));
        assertThat(iterator.next(), is(user3));
        assertThat(iterator.next(), is(user2));
    }

    @Test
    public void whenSortListByNameAndAge() {
        SortUser sortUser = new SortUser();
        User user1 = new User("Сергей", 25);
        User user2 = new User("Иван", 30);
        User user3 = new User("Сергей", 20);
        User user4 = new User("Иван", 25);
        List<User> input = Arrays.asList(user1, user2, user3, user4);
        List<User> result = sortUser.sortByAllFields(input);
        Iterator<User> iterator = result.iterator();
        assertThat(iterator.next(), is(user4));
        assertThat(iterator.next(), is(user2));
        assertThat(iterator.next(), is(user3));
        assertThat(iterator.next(), is(user1));
    }
}

