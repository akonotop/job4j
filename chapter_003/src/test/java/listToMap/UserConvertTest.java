package listtomap;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;

import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenListTohMap() {
        UserConvert userConvert = new UserConvert();
        User user1 = new User(1, "Ivan", "Chelyabinsk");
        User user2 = new User(2, "Igor", "Moscow");
        List<User> users = Arrays.asList(user1, user2);
        HashMap<Integer, User> expect = new HashMap<Integer, User>();
        expect.put(user1.getId(), user1);
        expect.put(user2.getId(), user2);
        HashMap<Integer, User> result = userConvert.process(users);
        assertThat(expect, is(result));
    }
}