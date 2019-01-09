package ru.job4j.tracker;

public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для вывода всех заявок.
     */
    private static final String ALL = "1";
    /**
     * Константа для редактирования заявки.
     */
    private static final String REPLACE = "2";
    /**
     * Константа для удаления заявки.
     */
    private static final String DELETE = "3";
    /**
     * Константа для нахождения заявки по ID.
     */
    private static final String FINDID = "4";
    /**
     * Константа для нахождения заявки по Имени.
     */
    private static final String FINDNAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите число от 0 до 6:");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (ALL.equals(answer)) {
                this.findAll();
            } else if (REPLACE.equals(answer)) {
                this.replace();
            } else if (DELETE.equals(answer)) {
                this.delete();
            } else if (FINDID.equals(answer)) {
                this.findID();
            } else if (FINDNAME.equals(answer)) {
                this.findName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }
    /**
     * Ищем заявки по имени
     */
    private void findName() {
        System.out.println("------------ Ищем заявку по id--------------");
        String name = this.input.ask("Введите имя заявки :");
        Item[] items = this.tracker.findByName(name);
        if (items.length == 0) {
            System.out.println("------------ Заявок с таким именем пока нет -----------");
        } else {
            System.out.println("------------ Заявки с таким именем: --------------");
            for (int i=0; i < items.length; i++) {
                System.out.println(String.valueOf(i+1) + ") " + items[i].getName() + " -- "
                        + items[i].getCreate() + " -- " +  items[i].getDescription());
            }
        }
    }

    /**
     * Ищем заявку по ID
     */
    private void findID() {
        System.out.println("------------ Ищем заявку по id--------------");
        String id = this.input.ask("Введите id заявки :");
        Item item = this.tracker.findById(id);
        if (item == null) {
            System.out.println("------------ Заявки с таким ID не существует -----------");
        } else {
            System.out.println("------------ Вот она: --------------");
            System.out.println(item.getName() + " -- " + item.getCreate()
                    + " -- " +  item.getDescription());
        }
    }
    /**
     * Удаляем заявку
     */
    private void delete() {
        System.out.println("------------ Производим удаление заявки --------------");
        String id = this.input.ask("Введите id заявки для удаления :");
        boolean done = this.tracker.delete(id);
        if (done) {
            System.out.println("------------ Удаление произведено успешно -----------");
        } else {
            System.out.println("------------ Заявки с таким ID не существует -----------");
        }
    }
    /**
     * Делаем замену заявки
     */
    private void replace() {
        System.out.println("------------ Производим замену заявки --------------");
        String id = this.input.ask("Введите id заявки под замену :");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        long create = 90120191420L;
        Item item = new Item(name, desc, create);
        boolean done = this.tracker.replace(id, item);
        if (done) {
            System.out.println("------------ Замена произведена успешно -----------");
        } else {
            System.out.println("------------ Заявки с таким ID не существует -----------");
        }
    }
    /**
     * Выводим на консоль все заявки
     */
    private void findAll() {
        Item[] list = this.tracker.findAll();
        if (list.length == 0) {
            System.out.println("------------ Заявок пока нет -----------");
        } else {
            System.out.println("------------ Заполненные заявки: --------------");
            for (int i=0; i < list.length; i++) {
                System.out.println(String.valueOf(i+1) + ") " + list[i].getName() + " -- "
                        + list[i].getCreate() + " -- " +  list[i].getDescription());
            }
        }
    }
    /**
     * Метод реализует добавление новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        long create = 90120191420L;
        Item item = new Item(name, desc, create);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }
    /**
     * Вывод меню на консоль
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("-----------------");
        System.out.println("0. Добавить новую заявку");
        System.out.println("1. Показать все заявки");
        System.out.println("2. Редактировать заявку");
        System.out.println("3. Удалить заявку");
        System.out.println("4. Найти заявку по ID");
        System.out.println("5. Найти заявку по имени");
        System.out.println("6. Завершить работу");
    }
    /**
     * Запуск программы.
     * @param args - нет
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUI(input, new Tracker()).init();
    }
}
