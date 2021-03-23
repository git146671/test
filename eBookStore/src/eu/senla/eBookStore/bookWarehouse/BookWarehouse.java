package eu.senla.eBookStore.bookWarehouse;

import eu.senla.eBookStore.book.Book;

import java.util.HashMap;
import java.util.Map;

public class BookWarehouse { // Singleton class

    private static BookWarehouse bookWarehouse;
    private final Map<Book, Integer> mapOfBooksAndQuantity;
    private final Map<Integer, Book> mapOfBooksAndId;

    public Map<Book, Integer> getMapOfBooksAndQuantity() {
        return mapOfBooksAndQuantity;
    }

    public Map<Integer, Book> getMapOfBooksAndId() {
        return mapOfBooksAndId;
    }

    private BookWarehouse() {
        this.mapOfBooksAndQuantity = new HashMap<>();
        this.mapOfBooksAndId = new HashMap<>();
    }

    public static BookWarehouse getBookWarehouse(){
        if (bookWarehouse == null) {
            bookWarehouse = new BookWarehouse();
        }
        return bookWarehouse;
    }

    public void writeOffTheBook(Book book, int numberOfBooksToWriteOff) {
        if (mapOfBooksAndQuantity.get(book) >= numberOfBooksToWriteOff) {
            mapOfBooksAndQuantity.put(book, mapOfBooksAndQuantity.get(book) - numberOfBooksToWriteOff);
            System.out.println("*write off* The book (" + book.getTitle() + ") is write off from the warehouse in the amount of " + numberOfBooksToWriteOff + " pcs");
            if (mapOfBooksAndQuantity.get(book) == 0) {
                book.setStatus(false);
            }
        }
        else {
            System.out.println("*write off* Couldn`t write off (" + book.getTitle() + "). It`s missing on warehouse in the required quantity");
        }
    }

    public void addBookToWarehouse(Book book, Integer numberOfBooks) {
        int oldNumberOfBooks = mapOfBooksAndQuantity.getOrDefault(book, 0);
        if (oldNumberOfBooks == 0 && numberOfBooks != 0) {
            book.setStatus(true);
        }
        mapOfBooksAndQuantity.put(book, numberOfBooks + oldNumberOfBooks);
        book.setOrderRequest(Math.max(book.getOrderRequest() - numberOfBooks, 0));
        mapOfBooksAndId.put(book.getBookId(), book);
    }

}
