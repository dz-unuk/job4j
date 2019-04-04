package ru.job4j.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserConvert {
    /**
     * принимает в себя список пользователей
     * и конвертирует его в Map с ключом Integer id
     * и соответствующим ему User
     * @param list список пользователей
     * @return Map с ключом Integer id
     */
    public Map<Integer, User> process(List<User> list) {
        Map<Integer, User> result = list.stream()
                .collect(Collectors.toMap(User::getId, user->user));
        return result;
    }
}
