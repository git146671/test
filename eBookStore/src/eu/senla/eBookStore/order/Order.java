package eu.senla.eBookStore.order;

import eu.senla.eBookStore.UI.painter.Painter;
import eu.senla.eBookStore.bookStore.BookStore;
import eu.senla.eBookStore.bookWarehouse.BookWarehouse;
import eu.senla.eBookStore.book.Book;
import java.time.LocalDate;
import java.util.Map;

public class Order {
    private final int orderId;
    private OrderStatus orderStatus;
    private final Map<Book, Integer> mapOfBooksInOrder;
    private LocalDate executionDate;
    private final int totalPrice;
    private boolean isAbilityComplete;
    private final String client;

    public Order(int orderId, Map<Book, Integer> mapOfBooksInOrder) {
        this.orderId = orderId;
        this.mapOfBooksInOrder = mapOfBooksInOrder;
        this.orderStatus = OrderStatus.NEW;
        this.executionDate = LocalDate.of(2000, 1,1);
        this.totalPrice = setTotalPrice();
        this.client = "Some client";
        Painter.getPainter().showNewOrderInfo(this);
        checkAbilityCompleteAndCreateRequests();
    }

    public String getClient() {
        return client;
    }

    public Map<Book, Integer> getMapOfBooksInOrder() {
        return mapOfBooksInOrder;
    }

    public boolean isAbilityComplete() {
        return isAbilityComplete;
    }

    public int setTotalPrice() {
        int result = 0;
        for (Map.Entry<Book, Integer> pair: mapOfBooksInOrder.entrySet()
        ) {
            result += pair.getKey().getPrice() * pair.getValue();
        }
        return result;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void completeOrder() {
        checkAbilityComplete();
        if (!isAbilityComplete) {
            System.out.println("*order* order (id " + orderId + ") cannot be completed. Some books are missing");
            setOrderStatus(OrderStatus.WAIT);
        }
        else {
            for (Map.Entry<Book, Integer> pair: mapOfBooksInOrder.entrySet()
            ) {
                BookStore.getBookStore().writeOffTheBook(pair.getKey(), pair.getValue());
            }
            System.out.println("*order* order (id " + orderId + ") was complete.");
            executionDate = LocalDate.now();
            setOrderStatus(OrderStatus.COMPLETED);
        }
    }

    private void checkAbilityComplete(){
        isAbilityComplete = true;
        for (Map.Entry<Book, Integer> pair: mapOfBooksInOrder.entrySet()
        ) {
            if (pair.getValue() > BookWarehouse.getBookWarehouse().getMapOfBooksAndQuantity().get(pair.getKey())) {
                isAbilityComplete = false;
                orderStatus = OrderStatus.WAIT;
                return;
            }
        }
    }

    private void checkAbilityCompleteAndCreateRequests(){
        checkAbilityComplete();
        for (Map.Entry<Book, Integer> pair: mapOfBooksInOrder.entrySet()
        ) {
            if (pair.getKey().getOrderRequest() > 0) {
                pair.getKey().setOrderRequest(pair.getKey().getOrderRequest() + pair.getValue()); // если в новом заказе есть книга, на которую открыт запрос, то плюсуем к запросу на эту книгу ее кол-во в новом заказе
            }
            else if (pair.getValue() > BookWarehouse.getBookWarehouse().getMapOfBooksAndQuantity().get(pair.getKey())) {
                BookStore.getBookStore().createOrderRequest(pair.getKey(), pair.getValue() - BookWarehouse.getBookWarehouse().getMapOfBooksAndQuantity().get(pair.getKey()));
            }
        }
    }

    public void cancelOrder() {
        System.out.println("    Cancel order (order id " + getOrderId() + ")");
        for (Map.Entry<Book, Integer> pair: mapOfBooksInOrder.entrySet()
        ) {
            if (pair.getKey().getOrderRequest() > 0) {
                pair.getKey().setOrderRequest(Math.max(pair.getKey().getOrderRequest() - pair.getValue(),0));
            }
        }
        setOrderStatus(OrderStatus.CANCELED);
    }

    public int getOrderId() {
        return orderId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

}
