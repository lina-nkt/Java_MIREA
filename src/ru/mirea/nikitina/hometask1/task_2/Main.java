package ru.mirea.nikitina.hometask1.task_2;

public class Main {
    public static void main(String[] args) {
        // Создаем обувную коробку
        Box<Shoe> shoeBox = new ShoeBox();

        // Создаем обувь и помещаем ее в коробку
        Shoe shoe = new Shoe("Nike");
        shoeBox.put(shoe);

        // Открываем коробку и получаем обувь
        Shoe openedShoe = shoeBox.open();
        System.out.println("Обувь: " + openedShoe.getType());

        // Удаляем обувь из коробки
        Shoe removedShoe = shoeBox.removeFromBox();
        System.out.println("Удаленная обувь: " + removedShoe.getType());

        // Создаем книжную коробку
        Box<Book> bookBox = new BookBox();

        // Создаем книгу и помещаем ее в коробку
        Book book = new Book("Капитанская дочка");
        bookBox.put(book);

        // Открываем коробку и получаем книгу
        Book openedBook = bookBox.open();
        System.out.println("Книги: " + openedBook.getTitle());

        // Удаляем книгу из коробки
        Book removedBook = bookBox.removeFromBox();
        System.out.println("Удаленная книга: " + removedBook.getTitle());

        // Создаем пивную коробку
        Box<Beer> beerBox = new BeerBox();

        // Создаем пиво и помещаем его в коробку
        Beer beer = new Beer("Amsterdam");
        beerBox.put(beer);

        // Открываем коробку и получаем пиво
        Beer openedBeer = beerBox.open();
        System.out.println("Пиво: " + openedBeer.getBrand());

        // Удаляем пиво из коробки
        Beer removedBeer = beerBox.removeFromBox();
        System.out.println("Удаленное пиво: " + removedBeer.getBrand());
    }
}
