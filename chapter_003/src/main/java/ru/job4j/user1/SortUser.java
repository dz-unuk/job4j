package ru.job4j.user1;

import java.util.*;
public class SortUser {
    /**
     * будет возвращать TreeSet пользователей,
     * отсортированных по возрасту в порядке возрастания
     * @return
     */
    public static Set<User1> sort(List<User1> list) {
        TreeSet<User1> result = new TreeSet<>();
        result.addAll(list);
        return result;
    }
}
