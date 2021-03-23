package eu.senla.eBookStore;

import eu.senla.eBookStore.UI.menuController.MenuController;
import eu.senla.eBookStore.book.Book;
import eu.senla.eBookStore.bookWarehouse.BookWarehouse;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        // create books
        Book b1 = new Book(1, "Сказки Пушкина", "А.С.Пушкин", 500, 2015,LocalDate.of(2020,1,1));
        Book b2 = new Book(2, "Война и Мир", "Л.Н.Толстой", 1500, 2010, LocalDate.of(2020,3,1));
        Book b3 = new Book(3, "Холодные Берега", "С.Лукьяненко", 1100, 2013,LocalDate.of(2020,5,1));
        Book b4 = new Book(4, "Стихи-детям", "А.Барто", 400, 1994, LocalDate.of(2020,7,1));
        Book b5 = new Book(5, "451 градус по фарингейту", "Р.Брэдбери", 1400, 2000, LocalDate.of(2020,9,1));
        Book b6 = new Book(6, "Сборник рассказов Чехова", "А.П.Чехов", 1255, 2015, LocalDate.of(2020,11,1));
        Book b7 = new Book(7, "Будущее", "Д.Глуховский", 1980, 2020, LocalDate.of(2021,1,1));
        Book b8 = new Book(8, "Метро 2033", "Д.Глуховский", 1600, 2008, LocalDate.of(2021,2,1));
        Book b9 = new Book(9, "Русские народные сказки", "нет", 920, 2001, LocalDate.of(2019,5,1));
        Book b10 = new Book(10, "Энциклопедия про жуков", "Кто-то", 3300, 2021, LocalDate.of(2019,10,1));
        b1.setDescription("This book of famous russian writer and poet Alex Pushkin.");
        // loading books and their quantity on the warehouse
        BookWarehouse.getBookWarehouse().addBookToWarehouse(b1, 10);
        BookWarehouse.getBookWarehouse().addBookToWarehouse(b2, 10);
        BookWarehouse.getBookWarehouse().addBookToWarehouse(b3, 10);
        BookWarehouse.getBookWarehouse().addBookToWarehouse(b4, 10);
        BookWarehouse.getBookWarehouse().addBookToWarehouse(b5, 10);
        BookWarehouse.getBookWarehouse().addBookToWarehouse(b6, 10);
        BookWarehouse.getBookWarehouse().addBookToWarehouse(b7, 10);
        BookWarehouse.getBookWarehouse().addBookToWarehouse(b8, 10);
        BookWarehouse.getBookWarehouse().addBookToWarehouse(b9, 10);
        BookWarehouse.getBookWarehouse().addBookToWarehouse(b10, 10);
        MenuController.getMenuController().run();
    }

}
