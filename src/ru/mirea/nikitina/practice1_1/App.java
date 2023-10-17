package ru.mirea.nikitina.practice1_1;

import java.util.List;

public class App {

    public static void main(String[] args) {

        String[] bookNames = new String[]{
                "All you need is kill", "Made in Abyss",
                "Spy x Family", "Jujutsu Kaisen", "Chainsaw Man",
                "The Best Life", "How to cook", "Beauty LifeHAcks",
                "Crime and Punishment", "Harry Potter"
        };

        String[] names = new String[]{
                "Ксюша", "Роман", "Вероника", "Никита", "Артём"
        };

        Library library = new Library();


//Добавление книг в библиотеку

        for (int i = 0; i < bookNames.length; i++) {
            String bookName = bookNames[i];

            library.addToCatalog(new Book(bookName));
        }

        for (String name : names) {
            Reader reader = new Reader(name);

            library.addReader(reader);
        }

        System.out.println("Общее кол-во книг в библиотеке:" + library.getCatalog().size() + "\n" + library.getCatalog() + "\n");

        List<Book> catalogBook = library.getCatalog();
        List<Reader> readers = library.getReaders();
        for (int i = 0; i < readers.size(); i++){
            if (!catalogBook.isEmpty()) {
                Book book = catalogBook.get(i);
                readers.get(i).takeBook(book);
                library.getBook(book.toString());
            }
        }

        int totalTakenBooks = 0;
        for (Reader reader : readers) {
            totalTakenBooks += reader.getTakenBooks().size();
        }


        System.out.println("Текущее кол-во книг в библиотеке:" + library.getCatalog().size() + "\n");
        System.out.println(library.getCatalog() + "\n");
        System.out.println("Текущее кол-во читателей в библиотеке:" + library.getReaders().size() + "\n" + library.getReaders() + "\n");
        System.out.println("Общее количество книг у читателей:" + totalTakenBooks + "\n");

    }

}
