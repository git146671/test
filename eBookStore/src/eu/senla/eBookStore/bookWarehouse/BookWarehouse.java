package eu.senla.eBookStore.bookWarehouse;

import eu.senla.eBookStore.book.Book;

import java.util.HashMap;
import java.util.Map;

public class BookWarehouse { // Singleton class

    private static BookWarehouse bookWarehouse;
    private Map<Book, Integer> mapOfBooks;

    public Map<Book, Integer> getMapOfBooks() {
        return mapOfBooks;
    }

    private BookWarehouse() {
        this.mapOfBooks = new HashMap<>();
    }

    public static BookWarehouse getBookWarehouse(){
        if (bookWarehouse == null) {
            bookWarehouse = new BookWarehouse();
        }
        return bookWarehouse;
    }

    public void writeOffTheBook(Book book, int numberOfBooksToWriteOff) {
        if (mapOfBooks.get(book) >= numberOfBooksToWriteOff) {
            mapOfBooks.put(book, mapOfBooks.get(book) - numberOfBooksToWriteOff);
            System.out.println("*write off* The book (" + book.getTitle() + ") is write off from the warehouse in the amount of " + numberOfBooksToWriteOff + " pcs");
            if (mapOfBooks.get(book) == 0) {
                book.setStatus(false);
            }
        }
        else {
            System.out.println("*write off* Couldn`t write off (" + book.getTitle() + "). It`s missing on warehouse in the required quantity");
        }
    }

    public void addBookToWarehouse(Book book, Integer numberOfBooks) {
        int oldNumberOfBooks = mapOfBooks.getOrDefault(book, 0);
        if (oldNumberOfBooks == 0 && numberOfBooks != 0) {
            book.setStatus(true);
        }
        mapOfBooks.put(book, numberOfBooks + oldNumberOfBooks);
        book.setOrderRequest(Math.max(book.getOrderRequest() - numberOfBooks, 0));
    }

    public void showListOfBooks() {
        System.out.println("    List of books and their quantity in warehouse:");
        for (Map.Entry<Book, Integer> pair: mapOfBooks.entrySet()
        ) {
            System.out.println("* " + pair.getKey().getAuthor() + " " + pair.getKey().getTitle() + " " + pair.getValue());
        }
    }
}
