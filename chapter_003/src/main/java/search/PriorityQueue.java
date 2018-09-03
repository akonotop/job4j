package search;

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
        if (task != null) {
            if (this.tasks.isEmpty()
                    || this.tasks.get(this.tasks.size() -1).getPriority() <= task.getPriority()) {
                this.tasks.add(task);
            } else {
                for (int index = 0; index < this.tasks.size(); index++) {
                    if (this.tasks.get(index).getPriority() >= task.getPriority()) {
                        this.tasks.add(index, task);
                        break;
                    }
                }
            }
        }
    }


    public Task take() {
        return this.tasks.poll();
    }
}

