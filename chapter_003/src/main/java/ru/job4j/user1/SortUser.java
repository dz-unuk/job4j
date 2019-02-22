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

    /**
     *в этом методе необходимо определить Comparator
     * для метода Collections.sort
     * и отсортировать List<User> по длине имени
     *
     */
    public static void sortNameLength(List<User1> list) {
        list.sort(new Comparator<User1>() {
            @Override
            public int compare(User1 o1, User1 o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });
    }

    /**
     * в этом методе необходимо определить Comparator
     * для метода Collections.sort
     * и отсортировать List<User> по обоим полям,
     * сначала сортировка по имени в лексикографическом порядке,
     * потом по возрасту
     */
    public static void sortByAllFields(List<User1> list) {
        list.sort(new Comparator<User1>() {
            @Override
            public int compare(User1 o1, User1 o2) {
                int result = o1.getName().compareTo(o2.getName());
                if (result == 0) {
                    result = o1.getAge() - o2.getAge();
                }
                return result;
            }
        });
    }
}
