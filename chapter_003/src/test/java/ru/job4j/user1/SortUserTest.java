package ru.job4j.user1;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortUserTest {

    @Test
    public void sortTest() {
        User1 user1 = new User1("Jan", 40);
        User1 user2 = new User1("Tom", 30);
        User1 user3 = new User1("Bob", 35);
        List<User1> input = new ArrayList<>(Arrays.asList(user1, user2, user3));
        List<User1> expected = new ArrayList<>(Arrays.asList(user2, user3, user1));

        List<User1> result = new ArrayList<>(SortUser.sort(input));
        assertThat(result, is(expected));
    }
}