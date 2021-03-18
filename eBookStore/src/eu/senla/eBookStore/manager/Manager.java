package eu.senla.eBookStore.manager;

import eu.senla.eBookStore.book.Book;
import eu.senla.eBookStore.bookStore.BookStore;
import eu.senla.eBookStore.bookWarehouse.BookWarehouse;
import eu.senla.eBookStore.comparator.*;
import eu.senla.eBookStore.order.Order;
import eu.senla.eBookStore.order.OrderStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Manager {
    private int id;
    private String name;
    private int accessLevel;
    private String login;
    private String password;

    public void outBooksByTitle(){
        List<Book> bookList = new ArrayList<>(BookWarehouse.getBookWarehouse().getMapOfBooks().keySet());
        System.out.println("Sort books by title:");
        bookList.sort(new BookTitleComparator());
        outBookList(bookList);
    }

    public void outBooksByPublicationYear(){
        List<Book> bookList = new ArrayList<>(BookWarehouse.getBookWarehouse().getMapOfBooks().keySet());
        System.out.println("Sort books by publication year:");
        bookList.sort(new BookPublicationYearComparator());
        outBookList(bookList);
    }

    public void outBooksByPrice(){
        List<Book> bookList = new ArrayList<>(BookWarehouse.getBookWarehouse().getMapOfBooks().keySet());
        System.out.println("Sort books by price:");
        bookList.sort(new BookPriceComparator());
        outBookList(bookList);
    }

    public void outBooksByStatus(){
        List<Book> bookList = new ArrayList<>(BookWarehouse.getBookWarehouse().getMapOfBooks().keySet());
        System.out.println("Sort books by status:");
        bookList.sort(new BookStatusComparator());
        outBookList(bookList);
    }

    public void outStaleBooksByDate(){
        List<Book> bookList = new ArrayList<>(BookWarehouse.getBookWarehouse().getMapOfBooks().keySet());
        System.out.println("Sort stale books (more 6 month) by date of receipt:");
        List<Book> receiptBookList = new ArrayList<>();
        for (int i = 0; i < bookList.size(); i++) {
            if (LocalDate.now().minusMonths(6).compareTo(bookList.get(i).getDateOfReceipt()) > 0) {
                receiptBookList.add(bookList.get(i));
            }
        }
        receiptBookList.sort(new BookDateComparator());
        outBookList(receiptBookList);
    }

    public void outStaleBooksByPrice(){
        List<Book> bookList = new ArrayList<>(BookWarehouse.getBookWarehouse().getMapOfBooks().keySet());
        System.out.println("Sort stale books (more 6 month) by price:");
        List<Book> receiptBookList = new ArrayList<>();
        for (int i = 0; i < bookList.size(); i++) {
            if (LocalDate.now().minusMonths(6).compareTo(bookList.get(i).getDateOfReceipt()) > 0) {
                receiptBookList.add(bookList.get(i));
            }
        }
        receiptBookList.sort(new BookPriceComparator());
        outBookList(receiptBookList);
    }

    public void outOrdersByTotalPrice(){
        List<Order> orderList = BookStore.getBookStore().getOrderList();
        System.out.println("Sort books by total price:");
        orderList.sort(new OrderPriceComparator());
        outOrderList(orderList);
    }

    public void outOrdersByStatus(){
        List<Order> orderList = BookStore.getBookStore().getOrderList();
        System.out.println("Sort books by status:");
        orderList.sort(new OrderStatusComparator());
        outOrderList(orderList);
    }

    public void outOrdersByExecutionDate(){
        List<Order> orderList = BookStore.getBookStore().getOrderList();
        System.out.println("Sort orders by execution date:");
        orderList.sort(new OrderDateComparator());
        outOrderList(orderList);
    }

    public void outCompletedOrdersByExecutionDate(LocalDate firstDate, LocalDate lastDate){
        List<Order> orderList = BookStore.getBookStore().getOrderList();
        ArrayList<Order> completedOrderListInSetDate = new ArrayList<>();
        System.out.println("Sort completed orders by execution date (from " + firstDate + " to " + lastDate + "):");
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderStatus().equals(OrderStatus.COMPLETED) &&
                    orderList.get(i).getExecutionDate().compareTo(firstDate) >= 0 && orderList.get(i).getExecutionDate().compareTo(lastDate) <= 0) {
                completedOrderListInSetDate.add(orderList.get(i));
            }
        }
        completedOrderListInSetDate.sort(new OrderDateComparator());
        outOrderList(completedOrderListInSetDate);
    }

    public void outCompletedOrdersByTotalPrice(LocalDate firstDate, LocalDate lastDate){
        List<Order> orderList = BookStore.getBookStore().getOrderList();
        ArrayList<Order> completedOrderListInSetDate = new ArrayList<>();
        System.out.println("Sort completed orders by total price (from " + firstDate + " to " + lastDate + "):");
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderStatus().equals(OrderStatus.COMPLETED) &&
                    orderList.get(i).getExecutionDate().compareTo(firstDate) >= 0 && orderList.get(i).getExecutionDate().compareTo(lastDate) <= 0) {
                completedOrderListInSetDate.add(orderList.get(i));
            }
        }
        completedOrderListInSetDate.sort(new OrderPriceComparator());
        outOrderList(completedOrderListInSetDate);
    }

    public void outTotalProfitInPeriod (LocalDate firstDate, LocalDate lastDate){
        List<Order> orderList = BookStore.getBookStore().getOrderList();
        ArrayList<Order> completedOrderListInSetDate = new ArrayList<>();
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderStatus().equals(OrderStatus.COMPLETED) &&
                    orderList.get(i).getExecutionDate().compareTo(firstDate) >= 0 && orderList.get(i).getExecutionDate().compareTo(lastDate) <= 0) {
                completedOrderListInSetDate.add(orderList.get(i));
            }
        }
        int totalProfit = 0;
        for (int i = 0; i < completedOrderListInSetDate.size(); i++) {
            totalProfit += completedOrderListInSetDate.get(i).getTotalPrice();
        }
        System.out.println("from " + firstDate + " to " + lastDate + " = " + totalProfit);
    }

    public void outCompletedOrdersInPeriod (LocalDate firstDate, LocalDate lastDate){
        List<Order> orderList = BookStore.getBookStore().getOrderList();
        ArrayList<Order> completedOrderListInSetDate = new ArrayList<>();
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderStatus().equals(OrderStatus.COMPLETED) &&
                    orderList.get(i).getExecutionDate().compareTo(firstDate) >= 0 && orderList.get(i).getExecutionDate().compareTo(lastDate) <= 0) {
                completedOrderListInSetDate.add(orderList.get(i));
            }
        }
        System.out.println("from " + firstDate + " to " + lastDate + " = " + completedOrderListInSetDate.size());
    }

    public void outRequestsByBookTitle(){
        List<Book> bookList = new ArrayList<>(BookWarehouse.getBookWarehouse().getMapOfBooks().keySet());
        List<Book> bookWithReqList = new ArrayList<>();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getOrderRequest() > 0) {
                bookWithReqList.add(bookList.get(i));
            }
        }
        System.out.println("Sort requests by book title:");
        bookWithReqList.sort(new RequestNameComparator());
        outBookList(bookWithReqList);
    }

    public void outRequestsByQuantity(){
        List<Book> bookList = new ArrayList<>(BookWarehouse.getBookWarehouse().getMapOfBooks().keySet());
        List<Book> bookWithReqList = new ArrayList<>();
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getOrderRequest() > 0) {
                bookWithReqList.add(bookList.get(i));
            }
        }
        System.out.println("Sort requests by quantity:");
        bookWithReqList.sort(new RequestQuantityComparator());
        outBookList(bookWithReqList);
    }

    public void outOrderDetails(Order order) {
        System.out.println("Order client: " + order.getClient());
        for (Map.Entry<Book, Integer> pair: order.getMapOfBooksInOrder().entrySet()
        ) {
            System.out.println(" * " + pair.getKey().getTitle() + " - " + pair.getValue() + " pcs"    );
        }
    }

    public void outBookList(List<Book> bookList) {
        for (Book book: bookList
        ) {
            System.out.println("* " + book.getTitle() + " " + book.getAuthor() + " " + book.getPrice() + " " + book.getPublicationYear() + " " + book.isStatus() + " " + book.getDateOfReceipt());
        }
    }

    public void outOrderList(List<Order> orderList) {
        for (Order order: orderList
        ) {
            String exDate = order.getExecutionDate().equals(LocalDate.of(2000,1,1)) ? "ex.date: not completed" : order.getExecutionDate().toString();
            System.out.println("* " + order.getOrderId() + " " + order.getOrderStatus() + " " + order.getTotalPrice() + " " + exDate);
        }
    }

}
