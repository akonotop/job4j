package user;

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
        assertThat(iterator.next().getName(), is("Rakso"));
        assertThat(iterator.next().getName(), is("Ivan"));
        assertThat(iterator.next().getName(), is("Alex"));
    }
}

