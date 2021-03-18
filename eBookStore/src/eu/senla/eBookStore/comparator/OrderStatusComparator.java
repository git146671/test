package eu.senla.eBookStore.comparator;

import eu.senla.eBookStore.order.Order;

import java.util.Comparator;

public class OrderStatusComparator implements Comparator<Order> {
    public int compare(Order order1, Order order2) {
        return order1.getOrderStatus().compareTo(order2.getOrderStatus());
    }
}
