package ru.job4j.tracker;


import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class StartUITest {
    private String ln = System.lineSeparator();
    private final String menu = new StringJoiner(ln, "", ln)
                        .add("Menu.")
                        .add("-----------------")
                        .add("0) Add new item.")
                        .add("1) Show all items.")
                        .add("2) Edit item.")
                        .add("3) Delete item.")
                        .add("4) Find item by Id.")
                        .add("5) Find items by name.")
                        .toString();

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc", 777L));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "y"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }
    @Test
    public void whenDeleteFirstThenSecondBecameFirst() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 777L));
        tracker.add(new Item("test name - 2", "desc", 777L));
        Input input = new StubInput(new String[]{"3", item.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name - 2"));
    }
    @Test
    public void whenFindByIdSecondThenRightResponse() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        tracker.add(new Item("test name - 1", "desc", 777L));
        Item item = tracker.add(new Item("test name - 2", "desc", 777L));
        tracker.add(new Item("test name - 3", "desc", 777L));
        Input input = new StubInput(new String[]{"4", item.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(new StringJoiner("", "", "")
                        .add(menu)
                        .add(new StringJoiner(ln, "", ln)
                                .add("------------ Ищем заявку по id--------------")
                                .add("------------ Вот она: --------------")
                                .add("test name - 2 -- 777 -- desc")
                                .toString())
                        .toString()
                )
        );
        System.setOut(stdout);
    }
    @Test
    public void whenFindByNameRightResponse() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 777L));
        tracker.add(new Item("test name - 2", "desc", 777L));
        tracker.add(new Item("test name", "desc", 777L));
        Input input = new StubInput(new String[]{"5", item.getName(), "y"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(new StringJoiner("", "", "")
                        .add(menu)
                        .add(new StringJoiner(ln, "", ln)
                                .add("------------ Ищем заявку по Имени--------------")
                                .add("------------ Заявки с таким именем: --------------")
                                .add("1) test name -- 777 -- desc")
                                .add("2) test name -- 777 -- desc")
                                .toString())
                        .toString()
                )
        );
        System.setOut(stdout);
    }
    @Test
    public void whenFindAllRightResponse() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        tracker.add(new Item("test name", "desc", 777L));
        tracker.add(new Item("test name - 2", "desc -2", 777L));
        Input input = new StubInput(new String[]{"1", "y"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(new StringJoiner("", "", "")
                        .add(menu)
                        .add(new StringJoiner(ln, "", ln)
                                .add("------------ Заполненные заявки: --------------")
                                .add("1) test name -- 777 -- desc")
                                .add("2) test name - 2 -- 777 -- desc -2")
                                .toString())
                        .toString()
                )
        );
        System.setOut(stdout);
    }
}
