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

    @Test
    public void sortNameLengthTest() {
        User1 user1 = new User1("Сергей", 25);
        User1 user2 = new User1("Иван", 30);
        User1 user3 = new User1("Сергей", 20);
        User1 user4 = new User1("Иван", 25);
        List<User1> input = new ArrayList<>(Arrays.asList(user1, user2, user3, user4));
        List<User1> expected = new ArrayList<>(Arrays.asList(user2, user4, user1, user3));
        SortUser.sortNameLength(input);
        assertThat(input, is(expected));
    }

    @Test
    public void sortByAllFieldsTest() {
        User1 user1 = new User1("Сергей", 25);
        User1 user2 = new User1("Иван", 30);
        User1 user3 = new User1("Сергей", 20);
        User1 user4 = new User1("Иван", 25);
        List<User1> input = new ArrayList<>(Arrays.asList(user1, user2, user3, user4));
        List<User1> expected = new ArrayList<>(Arrays.asList(user4, user2, user3, user1));
        SortUser.sortByAllFields(input);
        assertThat(input, is(expected));
    }
}