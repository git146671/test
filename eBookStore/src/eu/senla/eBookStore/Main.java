package eu.senla.eBookStore;

import eu.senla.eBookStore.UI.menuController.MenuController;
import eu.senla.eBookStore.bookStore.BookStore;
import eu.senla.eBookStore.book.Book;
import eu.senla.eBookStore.bookWarehouse.BookWarehouse;
import eu.senla.eBookStore.comparator.*;
import eu.senla.eBookStore.manager.Manager;
import eu.senla.eBookStore.order.Order;
import eu.senla.eBookStore.order.OrderStatus;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //BookStore bookStore = BookStore.getBookStore();
        // create books
        Book b1 = new Book(1, "Сказки Пушкина", "А.С.Пушкин", 500, 2015);
        Book b2 = new Book(2, "Война и Мир", "Л.Н.Толстой", 1500, 2010);
        Book b3 = new Book(3, "Холодные Берега", "С.Лукьяненко", 1100, 2013);
        Book b4 = new Book(4, "Стихи-детям", "А.Барто", 400, 1994);
        Book b5 = new Book(5, "451 градус по фарингейту", "Р.Брэдбери", 1400, 2000);
        Book b6 = new Book(6, "Сборник рассказов Чехова", "А.П.Чехов", 1255, 2015);
        Book b7 = new Book(7, "Будущее", "Д.Глуховский", 1980, 2020);
        Book b8 = new Book(8, "Метро 2033", "Д.Глуховский", 1600, 2008);
        Book b9 = new Book(9, "Русские народные сказки", "нет", 920, 2001);
        Book b10 = new Book(10, "Энциклопедия про жуков", "Кто-то", 3300, 2021);
        b1.setDateOfReceipt(LocalDate.of(2020,1,1));
        b2.setDateOfReceipt(LocalDate.of(2020,3,1));
        b3.setDateOfReceipt(LocalDate.of(2020,5,1));
        b4.setDateOfReceipt(LocalDate.of(2020,7,1));
        b5.setDateOfReceipt(LocalDate.of(2020,9,1));
        b6.setDateOfReceipt(LocalDate.of(2020,11,1));
        b7.setDateOfReceipt(LocalDate.of(2021,1,1));
        b8.setDateOfReceipt(LocalDate.of(2021,2,1));
        b9.setDateOfReceipt(LocalDate.of(2019,5,1));
        b10.setDateOfReceipt(LocalDate.of(2019,10,1));
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
        //bookStore.showListOfBooks();
        //bookStore.writeOffTheBook(b10, 2);
       // Map<Book, Integer> booksInOrder1 = new HashMap<>();
       // booksInOrder1.put(b1, 2);
       // booksInOrder1.put(b3, 1);
       // booksInOrder1.put(b4, 1);
       // booksInOrder1.put(b5, 1);
      /*  Order order1 = bookStore.createNewOrder(1, booksInOrder1);
        Map<Book, Integer> booksInOrder2 = new HashMap<>();
        booksInOrder2.put(b1, 7);
        booksInOrder2.put(b8, 2);
        booksInOrder2.put(b9, 3);
        Order order2 = bookStore.createNewOrder(2, booksInOrder2);
        outRequests(new ArrayList<>(BookWarehouse.getBookWarehouse().getMapOfBooks().keySet()));
        Map<Book, Integer> booksInOrder3 = new HashMap<>();
        booksInOrder3.put(b1, 1);
        booksInOrder3.put(b2, 2);
        booksInOrder3.put(b3, 1);
        Order order3 = bookStore.createNewOrder(3, booksInOrder3);
        outRequests(new ArrayList<>(BookWarehouse.getBookWarehouse().getMapOfBooks().keySet()));
        Map<Book, Integer> booksInOrder4 = new HashMap<>();
        booksInOrder4.put(b6, 2);
        booksInOrder4.put(b4, 2);
        booksInOrder4.put(b10, 3);
        Order order4 = bookStore.createNewOrder(4, booksInOrder4);
        outRequests(new ArrayList<>(BookWarehouse.getBookWarehouse().getMapOfBooks().keySet()));
        Map<Book, Integer> booksInOrder5 = new HashMap<>();
        booksInOrder5.put(b2, 1);
        booksInOrder5.put(b6, 1);
        booksInOrder5.put(b8, 1);
        Order order5 = bookStore.createNewOrder(5, booksInOrder5);
        outRequests(new ArrayList<>(BookWarehouse.getBookWarehouse().getMapOfBooks().keySet()));
        bookStore.completeOrder(order1);
        bookStore.addBookToWarehouse(b1, 100);
        bookStore.addBookToWarehouse(b5, 4);
        bookStore.addBookToWarehouse(b8, 1);
        bookStore.completeOrder(order2);
        outRequests(new ArrayList<>(BookWarehouse.getBookWarehouse().getMapOfBooks().keySet()));
        bookStore.completeOrder(order1);
        outRequests(new ArrayList<>(BookWarehouse.getBookWarehouse().getMapOfBooks().keySet()));
        bookStore.completeOrder(order3);
        bookStore.completeOrder(order4);
        bookStore.completeOrder(order5);
        outRequests(new ArrayList<>(BookWarehouse.getBookWarehouse().getMapOfBooks().keySet()));
        bookStore.showListOfBooks();
        order1.setExecutionDate(LocalDate.of(2020, 1,10));
        order2.setExecutionDate(LocalDate.of(2020, 5,20));
        order3.setExecutionDate(LocalDate.of(2021, 3,1));
        order4.setExecutionDate(LocalDate.of(2020, 12,23));
        order5.setExecutionDate(LocalDate.of(2021, 1,15));
        System.out.println("            ******************** task4 ********************");
        LocalDate firstDate = LocalDate.of(2020,1,11);
        LocalDate lastDate = LocalDate.of(2021,2,1);
        Manager manager = new Manager();
        System.out.println("    ** sort books **");
        manager.outBooksByTitle();
        manager.outBooksByPublicationYear();
        manager.outBooksByPrice();
        manager.outBooksByStatus();
        System.out.println("    ** sort orders **");
        manager.outOrdersByTotalPrice();
        manager.outOrdersByStatus();
        manager.outOrdersByExecutionDate();
        System.out.println("    ** sort requests **");
        manager.outRequestsByBookTitle();
        manager.outRequestsByQuantity();
        System.out.println("    ** list of completed requests for the date period **");
        manager.outCompletedOrdersByExecutionDate(firstDate, lastDate);
        manager.outCompletedOrdersByTotalPrice(firstDate, lastDate);
        System.out.println("    ** Total profit for the date period **");
        manager.outTotalProfitInPeriod(firstDate, lastDate);
        System.out.println("    ** Completed orders for the date period **");
        manager.outCompletedOrdersInPeriod(firstDate, lastDate);
        System.out.println("    ** Sort stale books **");
        manager.outStaleBooksByDate();
        manager.outStaleBooksByPrice();
        System.out.println("    ** Out order details **");
        manager.outOrderDetails(order2);
        System.out.println("    ** Look book description **");
        bookStore.lookBookDescription(b1); */
    }

   /* public static void outRequests(List<Book> bookList) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getOrderRequest() != 0) {
                System.out.println("* request for a book " + bookList.get(i).getTitle() + " in the amount of " + bookList.get(i).getOrderRequest());
            }
        }
    } */

}
