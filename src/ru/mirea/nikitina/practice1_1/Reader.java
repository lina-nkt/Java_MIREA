package ru.mirea.nikitina.practice1_1;

import ru.mirea.nikitina.practice1_1.Book;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Reader {

    private int readerID;

    private String name;

    private LocalDate registrationDate;

    private Map<String, Book> takenBooks;

    public Reader(String name){
        this.name = name;
        this.readerID = ThreadLocalRandom.current().nextInt();
        this.registrationDate = LocalDate.now();
        this.takenBooks = new HashMap<>();
    }

    public List<Book> getTakenBooks(){
        return takenBooks.values().stream().toList();
    }

    public void takeBook(Book book){
        this.takenBooks.putIfAbsent(book.getName(), book);
    }

    public int getReaderID(){
        return readerID;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return getName();
    }
}
