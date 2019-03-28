package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MenuTracker {

    private Input input;

    private Tracker tracker;
    private final Consumer<String> output;

    private List<UserAction> actions = new ArrayList<>();
    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }
//    /**
//     * Метод для получения массива меню.
//     *
//     * @return длину массива
//     */
//    public int getActionsLength() {
//        return this.actions.size();
//    }
    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Add new item"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new UpdateItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        /*        this.actions.add(new ExitProgram(6, "Exit Program")); */
    }
//    public void addAction(UserAction action) {
//        this.actions.add(action);
//    }
    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }
    /**
     * Метод выводит на экран меню.
     */
    public void showMenu() {
        output.accept("Menu.");
        output.accept("-----------------");
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }
    /**
     * Метод возвращает массив ключей существующих действий
     */
    public ArrayList<Integer> keys() {
        ArrayList<Integer> arr = new ArrayList<>();
        for (UserAction action : this.actions) {
            arr.add(action.key());
        }
        return arr;
    }
    class AddItem extends BaseAction {
        AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Adding new item --------------");
            String name = input.ask("Please, provide item name:");
            String desc = input.ask("Please, provide item description:");
            long create = 150119L;
            Item item = new Item(name, desc, create);
            tracker.add(item);
            output.accept("------------ New Item with Id : " + item.getId());
            output.accept("------------ New Item with Name : " + item.getName());
            output.accept("------------ New Item with Description : " + item.getDescription());
        }
    }
    class ShowItems extends BaseAction {
        ShowItems(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            List<Item> list = tracker.findAll();
            if (list.size() == 0) {
                output.accept("------------ Заявок пока нет -----------");
            } else {
                output.accept("------------ Заполненные заявки: --------------");
                for (int i = 0; i < list.size(); i++) {
                    output.accept((i + 1) + ") " + list.get(i).toString());
                }
            }
        }
    }
    class UpdateItem extends BaseAction {
        UpdateItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Производим замену заявки --------------");
            String id = input.ask("Введите id заявки под замену :");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            long create = 90120191420L;
            Item item = new Item(name, desc, create);
            boolean done = tracker.replace(id, item);
            if (done) {
                output.accept("------------ Замена произведена успешно -----------");
            } else {
                output.accept("------------ Заявки с таким ID не существует -----------");
            }
        }
    }
    class DeleteItem extends BaseAction {
        DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Производим удаление заявки --------------");
            String id = input.ask("Введите id заявки для удаления :");
            boolean done = tracker.delete(id);
            if (done) {
                output.accept("------------ Удаление произведено успешно -----------");
            } else {
                output.accept("------------ Заявки с таким ID не существует -----------");
            }
        }
    }
    class FindItemById extends BaseAction {
        FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Ищем заявку по id--------------");
            String id = input.ask("Введите id заявки :");
            Item item = tracker.findById(id);
            if (item == null) {
                output.accept("------------ Заявки с таким ID не существует -----------");
            } else {
                output.accept("------------ Вот она: --------------");
                output.accept(item.toString());
            }
        }
    }
    class FindItemsByName extends BaseAction {
        FindItemsByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Ищем заявку по Имени--------------");
            String name = input.ask("Введите имя заявки :");
            List<Item> items = tracker.findByName(name);
            if (items.size() == 0) {
                output.accept("------------ Заявок с таким именем пока нет -----------");
            } else {
                output.accept("------------ Заявки с таким именем: --------------");
                for (int i = 0; i < items.size(); i++) {
                    output.accept((i + 1) + ") " + items.get(i).toString());
                }
            }
        }
    }
}
