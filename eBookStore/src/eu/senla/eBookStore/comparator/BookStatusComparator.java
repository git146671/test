package eu.senla.eBookStore.comparator;

import eu.senla.eBookStore.book.Book;

import java.util.Comparator;

public class BookStatusComparator implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        if (book1.isStatus() == book2.isStatus()) return 0;
        else if (book1.isStatus() && !book2.isStatus()) return -1;
        else return 1;
    }
}
