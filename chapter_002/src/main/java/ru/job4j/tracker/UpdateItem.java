package ru.job4j.tracker;

public class UpdateItem extends BaseAction {
    UpdateItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Производим замену заявки --------------");
        String id = input.ask("Введите id заявки под замену :");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        long create = 90120191420L;
        Item item = new Item(name, desc, create);
        boolean done = tracker.replace(id, item);
        if (done) {
            System.out.println("------------ Замена произведена успешно -----------");
        } else {
            System.out.println("------------ Заявки с таким ID не существует -----------");
        }
    }
}
