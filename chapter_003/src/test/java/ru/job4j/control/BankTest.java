package ru.job4j.control;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankTest {

    @Test
    public void addUserTest() {
        Bank bank = new Bank();
        User user = new User("Jon", "QW1234567890");
        bank.addUser(user);
        Map<User, List<Account>> expected = new HashMap();
        expected.put(user, new ArrayList<>());
        String expectedStr = "Bank{userMap=" + expected.toString() + '}';
        assertThat(bank.toString(), is(expectedStr));
    }

    @Test
    public void deleteUser() {
        Bank bank = new Bank();
        User user1 = new User("Jon", "QW1234567890");
        User user2 = new User("Bob", "PO0987654321");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.deleteUser(user2);
        Map<User, List<Account>> expected = new HashMap();
        expected.put(user1, new ArrayList<>());
        String expectedStr = "Bank{userMap=" + expected.toString() + '}';
        assertThat(bank.toString(), is(expectedStr));
    }

    @Test
    public void addAccountToUser() {
        Bank bank = new Bank();
        User user1 = new User("Jon", "QW1234567890");
        User user2 = new User("Bob", "PO0987654321");
        bank.addUser(user1);
        bank.addUser(user2);
        Account account = new Account(111, "Bob-account1");
        bank.addAccountToUser("PO0987654321", account);
        Map<User, List<Account>> expected = new HashMap();
        expected.put(user1, new ArrayList<>());
        expected.put(user2, new ArrayList<>(Collections.singletonList(account)));
        String expectedStr = "Bank{userMap=" + expected.toString() + '}';
        assertThat(bank.toString(), is(expectedStr));

    }

    @Test
    public void deleteAccountFromUser() {
        Bank bank = new Bank();
        User user1 = new User("Jon", "QW1234567890");
        User user2 = new User("Bob", "PO0987654321");
        bank.addUser(user1);
        bank.addUser(user2);
        Account account = new Account(111, "Bob-account1");
        bank.addAccountToUser("PO0987654321", account);
        bank.addAccountToUser("QW1234567890", account);
        bank.deleteAccountFromUser("QW1234567890", account);
        Map<User, List<Account>> expected = new HashMap();
        expected.put(user1, new ArrayList<>());
        expected.put(user2, new ArrayList<>(Collections.singletonList(account)));
        String expectedStr = "Bank{userMap=" + expected.toString() + '}';
        assertThat(bank.toString(), is(expectedStr));
    }

    @Test
    public void transferMoney() {
        Bank bank = new Bank();
        User user1 = new User("Jon", "QW1234567890");
        User user2 = new User("Bob", "PO0987654321");
        bank.addUser(user1);
        bank.addUser(user2);
        Account account1 = new Account(111, "Bob-account1");
        Account account2 = new Account(332, "Jon-acc");
        bank.addAccountToUser("PO0987654321", account1);
        bank.addAccountToUser("QW1234567890", account2);
        bank.transferMoney("QW1234567890", "Jon-acc",
                "PO0987654321", "Bob-account1", 110);
        List<Account> expected1 = new ArrayList<>(Collections.singletonList(
                new Account(221, "Bob-account1")));
        List<Account> expected2 = new ArrayList<>(Collections.singletonList(
                new Account(222, "Jon-acc")));
//        System.out.println(expected1.toString() + expected2.toString());
        assertThat(expected1.toString() + expected2.toString(),
                is(bank.getUserAccToStr("PO0987654321")
                + bank.getUserAccToStr("QW1234567890")));
    }
}