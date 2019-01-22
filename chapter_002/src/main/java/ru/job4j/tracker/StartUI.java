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
/*        UserAction AddItem = new UserAction() {

            @Override
            public int key() {
                return 0;
            }

            @Override
            public void execute(Input input, Tracker tracker) {
                System.out.println("------------ Adding new item --------------");
                String name = input.ask("Please, provide item name:");
                String desc = input.ask("Please, provide item description:");
                long create = 150119L;
                Item item = new Item(name, desc, create);
                tracker.add(item);
                System.out.println("------------ New Item with Id : " + item.getId());
                System.out.println("------------ New Item with Name : " + item.getName());
                System.out.println("------------ New Item with Description : " + item.getDescription());
            }

            @Override
            public String info() {
                return "Add new item";
            }
        };
        menu.addAction(AddItem);*/
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
