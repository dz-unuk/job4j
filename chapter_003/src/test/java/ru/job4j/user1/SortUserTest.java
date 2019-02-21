package ru.job4j.user1;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortUserTest {

    @Test
    public void sortTest() {
        List<User1> input = new ArrayList<>();
        input.add(new User1("Jan", 40));
        input.add(new User1("Tom", 30));
        input.add(new User1("Bob", 35));
        Set<User1> expected = new TreeSet<>();
        expected.add(new User1("Tom", 30));
        expected.add(new User1("Bob", 35));
        expected.add(new User1("Jan", 40));
        assertThat(SortUser.sort(input), is(expected));

    }
}