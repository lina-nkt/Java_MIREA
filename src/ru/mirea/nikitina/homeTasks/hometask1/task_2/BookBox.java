package ru.mirea.nikitina.homeTasks.hometask1.task_2;

public class BookBox implements Box<Book> {
    private Book book;

    @Override
    public Book open() {
        return book;
    }

    @Override
    public void put(Book item) {
        book = item;
    }

    @Override
    public Book removeFromBox() {
        Book item = book;
        book = null;
        return item;
    }
}
