package eu.senla.eBookStore.comparator;

import eu.senla.eBookStore.book.Book;
import eu.senla.eBookStore.order.Order;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class OrderPriceComparator implements Comparator<Order> {
    public int compare(Order order1, Order order2) {
        return Integer.compare(order1.getTotalPrice(), order2.getTotalPrice());
    }
}
