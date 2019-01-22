package ru.job4j.tracker;

public class DeleteItem extends BaseAction {
    DeleteItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Производим удаление заявки --------------");
        String id = input.ask("Введите id заявки для удаления :");
        boolean done = tracker.delete(id);
        if (done) {
            System.out.println("------------ Удаление произведено успешно -----------");
        } else {
            System.out.println("------------ Заявки с таким ID не существует -----------");
        }
    }
}
