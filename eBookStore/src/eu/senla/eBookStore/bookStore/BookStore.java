package eu.senla.eBookStore.bookStore;

import eu.senla.eBookStore.bookWarehouse.BookWarehouse;
import eu.senla.eBookStore.book.Book;
import eu.senla.eBookStore.manager.Manager;
import eu.senla.eBookStore.order.Order;
import eu.senla.eBookStore.order.OrderStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookStore {
    private static BookStore bookStore;
    private List<Order> orderList;
    private List<Manager> managerList;
    private BookWarehouse bookWarehouse;

    public static BookStore getBookStore(){
        if (bookStore == null) {
            bookStore = new BookStore();
        }
        return bookStore;
    }

    private BookStore () {
        this.orderList = new ArrayList<>();
        this.bookWarehouse = BookWarehouse.getBookWarehouse();
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void writeOffTheBook(Book book, int numberOfBooksToWriteOff) {
        System.out.println("Try write off");
        bookWarehouse.writeOffTheBook(book, numberOfBooksToWriteOff);
    }

    public void addBookToWarehouse(Book book, Integer numberOfBooks) {
        bookWarehouse.addBookToWarehouse(book,numberOfBooks);
        System.out.println("*add* The book (" + book.getTitle() + ") was add in warehouse in the amount of " + numberOfBooks + " pcs");
    }

    public void showListOfBooks() {
        bookWarehouse.showListOfBooks();
    }

    public Order createNewOrder(int orderId, Map<Book, Integer> orderMap) {
        Order order = new Order(orderId, orderMap);
        orderList.add(order);
        if (order.isAbilityComplete()) completeOrder(order);
        return order;
    }

    public void completeOrder(Order order) {
        if (order.getOrderStatus().equals(OrderStatus.CANCELED)) {
            System.out.println("*complete* Order (id " + order.getOrderId() + ") already canceled");
            return;
        }
        if (order.getOrderStatus().equals(OrderStatus.COMPLETED)) {
            System.out.println("*complete* Order (id " + order.getOrderId() + ") already completed");
            return;
        }
        System.out.println("*complete* Try complete order (id " + order.getOrderId() + ")");
        order.completeOrder();
    }

    public void cancelOrder(Order order){
        if (order.getOrderStatus().equals(OrderStatus.CANCELED)) {
            System.out.println("*cancel* Order (id " + order.getOrderId() + ") already canceled");
            return;
        }
        if (order.getOrderStatus().equals(OrderStatus.COMPLETED)) {
            System.out.println("*cancel* Order (id " + order.getOrderId() + ") already completed");
            return;
        }
        order.cancelOrder();
    }

    public void createOrderRequest(Book book, int numberOfBooks) {
        System.out.println("*req* create new order request for book " + book.getTitle());
        book.setOrderRequest(book.getOrderRequest() + numberOfBooks);
    }

    public void createStoreRequest(Book book, int numberOfBooks) {
        System.out.println("*req* create new store request for book " + book.getTitle());
        book.setStoreRequest(book.getStoreRequest() + numberOfBooks);
    }

    public void lookBookDescription(Book book) {
        System.out.println("Description of book " + book.getTitle() + ":");
        System.out.println(book.getDescription());
    }

}
