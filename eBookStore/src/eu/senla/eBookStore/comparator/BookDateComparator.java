package eu.senla.eBookStore.comparator;

import eu.senla.eBookStore.book.Book;

import java.util.Comparator;

public class BookDateComparator implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return book1.getDateOfReceipt().compareTo(book2.getDateOfReceipt());
    }
}
