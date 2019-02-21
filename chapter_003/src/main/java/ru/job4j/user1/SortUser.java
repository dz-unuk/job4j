package ru.job4j.user1;

import java.util.*;
public class SortUser {
    /**
     * будет возвращать TreeSet пользователей,
     * отсортированных по возрасту в порядке возрастания
     * @return TreeSet пользователей
     */
    public static Set<User1> sort(List<User1> list) {

        return new TreeSet<>(list);
    }
}
