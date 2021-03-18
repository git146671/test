package eu.senla.eBookStore.comparator;

import eu.senla.eBookStore.book.Book;

import java.util.Comparator;

public class BookPriceComparator implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return Integer.compare(book1.getPrice(), book2.getPrice());
    }
}
