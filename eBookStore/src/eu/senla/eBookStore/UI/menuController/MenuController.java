package eu.senla.eBookStore.UI.menuController;

import eu.senla.eBookStore.UI.painter.Painter;
import eu.senla.eBookStore.UI.builder.Builder;
import eu.senla.eBookStore.UI.menu.MenuAggregator;
import eu.senla.eBookStore.book.Book;
import eu.senla.eBookStore.bookStore.BookStore;
import eu.senla.eBookStore.bookWarehouse.BookWarehouse;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuController {   //singleton
    private static MenuController menuController;
    private final Builder builder;
    private final Painter painter;

    public MenuController() {
        this.builder = Builder.getBuilder();
        this.painter = Painter.getPainter();
    }

    public static MenuController getMenuController() {
        if (menuController == null) {
            menuController = new MenuController();
        }
        return menuController;
    }


    public void run() {
        int menuIndex = 1;
        Scanner in = new Scanner(System.in);
        MenuAggregator.getMenuAggregator().addMenu(menuIndex, builder.buildMenu(menuIndex));
        painter.paintMenu(menuIndex);
        int choice = in.nextInt();
        while (choice != 0) {
            if (choice == 9) {
                menuIndex = MenuAggregator.getMenuAggregator().getMenuMap().get(menuIndex).getPrevMenu();
            }
            else {
                int prevMenuIndex = menuIndex;
                menuIndex = MenuAggregator.getMenuAggregator().getMenuMap().get(menuIndex).getMenuItems().get(choice - 1).getNextMenu();
                if (menuIndex != 0) {
                    if (!MenuAggregator.getMenuAggregator().getMenuMap().containsKey(menuIndex)) {
                        MenuAggregator.getMenuAggregator().addMenu(menuIndex, builder.buildMenu(menuIndex));
                    }
                }
                else {
                    delegateModule(MenuAggregator.getMenuAggregator().getMenuMap().get(prevMenuIndex).getMenuItems().get(choice - 1).getId());
                    menuIndex = prevMenuIndex;
                }
            }
            painter.paintMenu(menuIndex);
            choice = in.nextInt();
        }
    }

    private void delegateModule(int indexOfMenuItem){
        switch (indexOfMenuItem) {
            case (3):
            case(9):
                painter.showListOfBooks();
                break;
            case(4):
                BookStore.getBookStore().createNewOrder(enterId(), enterOrderMap());
                break;
            case(5):
                BookStore.getBookStore().cancelOrder(BookStore.getBookStore().getMapOfOrderAndId().get(enterId()));
                break;
            case(6):
                BookStore.getBookStore().completeOrder(BookStore.getBookStore().getMapOfOrderAndId().get(enterId()));
                break;
            case(7):
                BookStore.getBookStore().addBookToWarehouse(BookWarehouse.getBookWarehouse().getMapOfBooksAndId().get(enterId()), enterNumber());
                break;
            case(8):
                BookStore.getBookStore().writeOffTheBook(BookWarehouse.getBookWarehouse().getMapOfBooksAndId().get(enterId()), enterNumber());
                break;
            case(10):
                BookStore.getBookStore().createStoreRequest(BookWarehouse.getBookWarehouse().getMapOfBooksAndId().get(enterId()), enterNumber());
                break;
            case (15):
                painter.outTotalProfitInPeriod(enterDate(), enterDate());
                break;
            case (16):
                painter.outBooksByTitle();
                break;
            case(17):
                painter.outBooksByPublicationYear();
                break;
            case(18):
                painter.outBooksByPrice();
                break;
            case(19):
                painter.outBooksByStatus();
                break;
            case(21):
                painter.lookBookDescription(enterId());
                break;
            case(22):
                painter.outOrderDetails(BookStore.getBookStore().getMapOfOrderAndId().get(enterId()));
                break;
            case(23):
                painter.outOrdersByExecutionDate();
                break;
            case(24):
                painter.outOrdersByPrice();
                break;
            case(25):
                painter.outOrdersByStatus();
                break;
            case(27):
                painter.outCompletedOrdersInPeriod(enterDate(), enterDate());
                break;
            case(28):
                painter.outRequestsByQuantity();
                break;
            case(29):
                painter.outRequestsByBookTitle();
                break;
            case(30):
                painter.outStaleBooksByDate();
                break;
            case(31):
                painter.outStaleBooksByPrice();
                break;
            case(32):
                painter.outCompletedOrdersInPeriodByDate(enterDate(), enterDate());
                break;
            case(33):
                painter.outCompletedOrdersInPeriodByPrice(enterDate(), enterDate());
                break;
        }
    }

    private LocalDate enterDate() {
        System.out.println("Enter date YYYY (enter), MM (enter), DD (enter) ");
        Scanner in = new Scanner(System.in);
        return LocalDate.of(in.nextInt(), in.nextInt(), in.nextInt());
    }

    private int enterId(){
        System.out.print("Enter ID: ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    private int enterNumber(){
        System.out.print("Enter number: ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    private Map<Book, Integer> enterOrderMap(){
        Map<Book, Integer> orderMap = new HashMap<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 1. book ID, 2. book quantity in order (for exit enter ID = 0): ");
        int id = in.nextInt();
        while (id != 0) {
            int quantity = in.nextInt();
            orderMap.put(BookWarehouse.getBookWarehouse().getMapOfBooksAndId().get(id), quantity);
            System.out.print("Add next book in order: ");
            id = in.nextInt();
        }
        return orderMap;
    }

}
