package ru.job4j.tracker;

import java.util.function.Consumer;

public class StartUI {

    /**
     * Получение данных в программу
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
    /**
     * стратегия для обработки выходных данных (либо в консоль, либо в PrintStream на тестах)
     */
    private final Consumer<String> output;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     * @param output стратегия вывода
     */
    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }
    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
        menu.fillActions();
        do {
            menu.showMenu();
            menu.select(input.ask("select:", menu.keys()));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    /**
     * Запуск программы.
     * @param args - нет
     */
    public static void main(String[] args) {
        Consumer<String> output = System.out::println;
        Input input = new ValidInput(new ConsoleInput(), output);
//        Input input = new StubInput();
        new StartUI(input, new Tracker(), output).init();
    }
}
