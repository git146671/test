package eu.senla.eBookStore.UI.painter;

import eu.senla.eBookStore.UI.menu.Menu;
import eu.senla.eBookStore.UI.menu.MenuAggregator;
import eu.senla.eBookStore.book.Book;
import eu.senla.eBookStore.bookStore.BookStore;
import eu.senla.eBookStore.bookWarehouse.BookWarehouse;
import eu.senla.eBookStore.order.Order;
import eu.senla.eBookStore.order.OrderStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static eu.senla.eBookStore.order.OrderStatus.COMPLETED;

public class Painter { // singleton
    private static Painter painter;

    public static Painter getPainter() {
        if (painter == null) {
            painter = new Painter();
        }
        return painter;
    }

    public void paintMenu(int index) {
        Menu menu = MenuAggregator.getMenuAggregator().getMenuMap().get(index);
        System.out.println(menu.getName());
        for (int i = 0; i < menu.getMenuItems().size(); i++) {
            System.out.println(menu.getMenuLevel().menuLevel + menu.getMenuItems().get(i).getTitle());
        }
        if (index != 1) {
            System.out.println("   Back (9)");
        }
        System.out.println("   Exit (0)");
    }

    public void outBooksByTitle(){
        List<Book> bookList = new ArrayList<>(BookWarehouse.getBookWarehouse().getMapOfBooksAndQuantity().keySet());
        System.out.println("Sort books by title:");
        bookList.sort((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
        outBookList(bookList);
    }

    public void outBooksByPublicationYear(){
        List<Book> bookList = new ArrayList<>(BookWarehouse.getBookWarehouse().getMapOfBooksAndQuantity().keySet());
        System.out.println("Sort books by publication year:");
        bookList.sort((b1, b2) -> Integer.compare(b1.getPublicationYear(), b2.getPublicationYear()));
        outBookList(bookList);
    }

    public void outBooksByPrice(){
        List<Book> bookList = new ArrayList<>(BookWarehouse.getBookWarehouse().getMapOfBooksAndQuantity().keySet());
        System.out.println("Sort books by price:");
        bookList.sort((b1, b2) -> Integer.compare(b1.getPrice(), b2.getPrice()));
        outBookList(bookList);
    }

    public void outBooksByStatus(){
        List<Book> bookList = new ArrayList<>(BookWarehouse.getBookWarehouse().getMapOfBooksAndQuantity().keySet());
        System.out.println("Sort books by status:");
        bookList.sort((b1, b2) -> {
            if (b1.isStatus() == b2.isStatus()) return 0;
            else if (b1.isStatus() && !b2.isStatus()) return -1;
            else return 1;
        });
        outBookList(bookList);
    }

    public void outTotalProfitInPeriod (LocalDate firstDate, LocalDate lastDate){
        List<Order> orderList = BookStore.getBookStore().getOrderList();
        int totalProfit = orderList.stream().filter(o -> o.getOrderStatus().equals(COMPLETED) && o.getExecutionDate().compareTo(firstDate) >= 0 &&
                o.getExecutionDate().compareTo(lastDate) <= 0).collect(Collectors.toList()).stream().mapToInt(o -> o.getTotalPrice()).sum();
        System.out.println("from " + firstDate + " to " + lastDate + " = " + totalProfit);
    }

    public void lookBookDescription(int bookId) {
        System.out.println("Description of book " + BookWarehouse.getBookWarehouse().getMapOfBooksAndId().get(bookId).getTitle() + ":");
        System.out.println(BookWarehouse.getBookWarehouse().getMapOfBooksAndId().get(bookId).getDescription());
    }

    public void outStaleBooksByDate(){
        List<Book> bookList = new ArrayList<>(BookWarehouse.getBookWarehouse().getMapOfBooksAndQuantity().keySet());
        System.out.println("Sort stale books (more 6 month) by date of receipt:");
        List<Book> receiptBookList = bookList.stream().filter(b -> LocalDate.now().minusMonths(6).compareTo(b.getDateOfReceipt()) > 0).
                sorted((b1, b2) -> b1.getDateOfReceipt().compareTo(b2.getDateOfReceipt())).collect(Collectors.toList());
        outBookList(receiptBookList);
    }

    public void outStaleBooksByPrice(){
        List<Book> bookList = new ArrayList<>(BookWarehouse.getBookWarehouse().getMapOfBooksAndQuantity().keySet());
        System.out.println("Sort stale books (more 6 month) by price:");
        List<Book> receiptBookList = bookList.stream().filter(b -> LocalDate.now().minusMonths(6).compareTo(b.getDateOfReceipt()) > 0).
                sorted((b1, b2) -> Integer.compare(b1.getPrice(), b2.getPrice())).collect(Collectors.toList());
        outBookList(receiptBookList);
    }

    public void showListOfBooks() {
        System.out.println("    List of books and their quantity in warehouse:");
        for (Map.Entry<Book, Integer> pair: BookWarehouse.getBookWarehouse().getMapOfBooksAndQuantity().entrySet()
        ) {
            System.out.println("(id " + pair.getKey().getBookId() + ") " + pair.getKey().getAuthor() + " " + pair.getKey().getTitle() + " " + pair.getValue());
        }
    }

    public void showNewOrderInfo(Order order){
        System.out.println("*order* create new order(id " + order.getOrderId() + "):");
        for (Map.Entry<Book, Integer> pair: order.getMapOfBooksInOrder().entrySet()
        ) {
            System.out.println(" * " + pair.getKey().getTitle() + " - " + pair.getValue() + " pcs"    );
        }
        System.out.println("*order* order(id " + order.getOrderId() + ") was create");
    }

    public void outOrderDetails(Order order) {
        System.out.println("Order client: " + order.getClient());
        for (Map.Entry<Book, Integer> pair: order.getMapOfBooksInOrder().entrySet()
        ) {
            System.out.println(" * " + pair.getKey().getTitle() + " - " + pair.getValue() + " pcs"    );
        }
    }

    public void outOrdersByExecutionDate(){
        List<Order> orderList = BookStore.getBookStore().getOrderList();
        System.out.println("Sort orders by execution date:");
        orderList.sort((o1, o2) -> o1.getExecutionDate().compareTo(o2.getExecutionDate()));
        outOrderList(orderList);
    }

    public void outOrdersByPrice(){
        List<Order> orderList = BookStore.getBookStore().getOrderList();
        System.out.println("Sort orders by price:");
        orderList.sort((o1, o2) -> Integer.compare(o1.getTotalPrice(), o2.getTotalPrice()));
        outOrderList(orderList);
    }

    public void outOrdersByStatus(){
        List<Order> orderList = BookStore.getBookStore().getOrderList();
        System.out.println("Sort orders by status:");
        orderList.sort((o1, o2) -> o1.getOrderStatus().compareTo(o2.getOrderStatus()));
        outOrderList(orderList);
    }

    public void outCompletedOrdersInPeriod (LocalDate firstDate, LocalDate lastDate){
        List<Order> orderList = BookStore.getBookStore().getOrderList();
        long numberOfCompletedOrder = orderList.stream().filter(o -> o.getOrderStatus().equals(COMPLETED) && o.getExecutionDate().compareTo(firstDate) >= 0 &&
                o.getExecutionDate().compareTo(lastDate) <= 0).count();
        System.out.println("from " + firstDate + " to " + lastDate + " = " + numberOfCompletedOrder);
    }

    public void outCompletedOrdersInPeriodByDate (LocalDate firstDate, LocalDate lastDate){
        List<Order> orderList = BookStore.getBookStore().getOrderList();
        List<Order> completedOrderListInSetDate = orderList.stream().filter(o -> o.getOrderStatus().equals(COMPLETED) && o.getExecutionDate().compareTo(firstDate) >= 0 &&
                o.getExecutionDate().compareTo(lastDate) <= 0).sorted((o1, o2) -> o1.getExecutionDate().compareTo(o2.getExecutionDate())).collect(Collectors.toList());
        outOrderList(completedOrderListInSetDate);
    }

    public void outCompletedOrdersInPeriodByPrice (LocalDate firstDate, LocalDate lastDate){
        List<Order> orderList = BookStore.getBookStore().getOrderList();
        List<Order> completedOrderListInSetDate = orderList.stream().filter(o -> o.getOrderStatus().equals(COMPLETED) && o.getExecutionDate().compareTo(firstDate) >= 0 &&
                o.getExecutionDate().compareTo(lastDate) <= 0).sorted((o1, o2) -> Integer.compare(o1.getTotalPrice(), o2.getTotalPrice())).collect(Collectors.toList());
        outOrderList(completedOrderListInSetDate);
    }

    public void outRequestsByQuantity(){
        List<Book> bookList = new ArrayList<>(BookWarehouse.getBookWarehouse().getMapOfBooksAndQuantity().keySet());
        System.out.println("Sort requests by quantity");
        List<Book> bookWithReqList = bookList.stream().filter(b -> b.getOrderRequest() > 0 || b.getStoreRequest() > 0).
                sorted((b1, b2) -> Integer.compare(b1.getOrderRequest() + b1.getStoreRequest(), b2.getOrderRequest() + b2.getStoreRequest())).collect(Collectors.toList());
        outReqList(bookWithReqList);
    }

    public void outRequestsByBookTitle(){
        List<Book> bookList = new ArrayList<>(BookWarehouse.getBookWarehouse().getMapOfBooksAndQuantity().keySet());
        System.out.println("Sort requests by book title");
        List<Book> bookWithReqList = bookList.stream().filter(b -> b.getOrderRequest() > 0 || b.getStoreRequest() > 0).
                sorted((b1, b2) -> b1.getTitle().compareTo(b2.getTitle())).collect(Collectors.toList());
        outReqList(bookWithReqList);
        outReqList(bookWithReqList);
    }

    public void outReqList(List<Book> bookList) {
        for (Book book: bookList
        ) {
            System.out.println("(id " + book.getBookId() + ") " + book.getTitle() + " order request - " + book.getOrderRequest() + ", store request - " + book.getStoreRequest());
        }
    }

    public void outBookList(List<Book> bookList) {
        for (Book book: bookList
        ) {
            System.out.println("(id " + book.getBookId() + ") " + book.getTitle() + " " + book.getAuthor() + " " + book.getPrice() + " " + book.getPublicationYear() + " " + book.isStatus() + " " + book.getDateOfReceipt());
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
