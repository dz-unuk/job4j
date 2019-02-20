package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int size = this.tasks.size();

        int index = 0;
        while (index < size
                && this.tasks.get(index).getPriority() < task.getPriority()) {
            index++;
        }
        this.tasks.add(index, task);
/*        boolean done = false;
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                if (this.tasks.get(i).getPriority() > task.getPriority()) {
                    this.tasks.add(i, task);
                    done = true;
                }
            }
            if (!done) {
                this.tasks.add(task);
            }
        } else {
            this.tasks.add(task);
        }*/
    }

    public Task take() {
        return this.tasks.poll();
    }

}
