package ru.job4j.user;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserConvertTest {

    @Test
    public void processTest() {
        UserConvert inst = new UserConvert();
        List<User> input = new ArrayList<>();
        input.add(new User(1, "Jan", "City"));
        input.add(new User(3, "Tom", "Default"));
        input.add(new User(6, "Bob", "DefaultCity"));
        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(1, new User(1, "Jan", "City"));
        expected.put(3, new User(3, "Tom", "Default"));
        expected.put(6, new User(6, "Bob", "DefaultCity"));
        assertThat(inst.process(input), is(expected));
    }
}