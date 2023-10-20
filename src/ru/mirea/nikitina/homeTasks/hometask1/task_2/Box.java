package ru.mirea.nikitina.homeTasks.hometask1.task_2;

public interface Box<T> {
    T open();

    void put(T item);

    T removeFromBox();
}
