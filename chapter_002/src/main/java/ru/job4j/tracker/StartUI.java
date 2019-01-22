package ru.job4j.tracker;

public class StartUI {


    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
/*        ArrayList<Integer> range = new ArrayList<>();
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range.add(i);
        } */
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
        Input input = new ValidInput(new ConsoleInput());
//        Input input = new StubInput();
        new StartUI(input, new Tracker()).init();
    }
}
