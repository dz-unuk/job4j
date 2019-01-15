package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    private final int delete;
    private final String info;

    DeleteItem(int key, String info) {
        this.delete = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.delete;
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

    @Override
    public String info() {
        return String.format("%s) %s.", Long.toString(this.delete), this.info);
    }
}
