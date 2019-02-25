package ru.job4j.control;

import java.util.Objects;

/**
 *
 */
public class User {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }
    public User(){}

    public String getName() {
        return name;
    }
    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getName().equals(user.getName()) &&
                getPassport().equals(user.getPassport());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPassport());
    }
}
