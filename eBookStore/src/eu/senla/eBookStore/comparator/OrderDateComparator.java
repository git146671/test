package eu.senla.eBookStore.comparator;

import eu.senla.eBookStore.order.Order;

import java.util.Comparator;

public class OrderDateComparator implements Comparator<Order> {
    @Override
    public int compare(Order order1, Order order2) {
        return order2.getExecutionDate().compareTo(order1.getExecutionDate());
    }
}
