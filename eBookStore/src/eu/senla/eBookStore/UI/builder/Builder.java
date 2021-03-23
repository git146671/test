package eu.senla.eBookStore.UI.builder;

import eu.senla.eBookStore.UI.menu.MenuLevel;
import eu.senla.eBookStore.UI.menu.menuItem.MenuItem;
import eu.senla.eBookStore.UI.menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class Builder { //singleton
    private static Builder builder;

    public static Builder getBuilder(){
        if (builder == null) {
            builder = new Builder();
        }
        return builder;
    }

    public Menu buildMenu(int index) {
        if (index == 1) {
            List<MenuItem> menu1ItemList = new ArrayList<>(2);
            menu1ItemList.add(new MenuItem(1,"Buyer   (1)", 2));
            menu1ItemList.add(new MenuItem(2,"Manager (2)", 3));
            return new Menu(" <Role choice>", menu1ItemList, 0, MenuLevel.ONE);
        }
        if (index == 2) {
            List<MenuItem> menu2ItemList = new ArrayList<>(4);
            menu2ItemList.add(new MenuItem(3,"Show books in warehouse (1)", 0));
            menu2ItemList.add(new MenuItem(4,"Create order            (2)", 0));
            menu2ItemList.add(new MenuItem(5,"Cancel order            (3)", 0));
            menu2ItemList.add(new MenuItem(6,"Complete order          (4)", 0));
            return new Menu("  <Buyer action choice>", menu2ItemList, 1, MenuLevel.TWO);
        }
        if (index == 3) {
            List<MenuItem> menu3ItemList = new ArrayList<>(5);
            menu3ItemList.add(new MenuItem(7,"Add book in warehouse   (1)", 0));
            menu3ItemList.add(new MenuItem(8,"Write off the book      (2)", 0));
            menu3ItemList.add(new MenuItem(9,"Show books in warehouse (3)", 0));
            menu3ItemList.add(new MenuItem(10,"Create store request    (4)", 0));
            menu3ItemList.add(new MenuItem(11,"Show info               (5)", 4));
            return new Menu("  <Manager action choice>", menu3ItemList, 1, MenuLevel.TWO);
        }
        if (index == 4) {
            List<MenuItem> menu4ItemList = new ArrayList<>(4);
            menu4ItemList.add(new MenuItem(12,"Show book list              (1)", 5));
            menu4ItemList.add(new MenuItem(13,"Show order list             (2)", 6));
            menu4ItemList.add(new MenuItem(14,"Show request list           (3)", 7));
            menu4ItemList.add(new MenuItem(15,"Show total profit in period (4)", 0));
            return new Menu("   <Manager show menu>", menu4ItemList, 3, MenuLevel.THREE);
        }
        if (index == 5) {
            List<MenuItem> menu5ItemList = new ArrayList<>(6);
            menu5ItemList.add(new MenuItem(16,"Sort books in warehouse by alphabet (1)", 0));
            menu5ItemList.add(new MenuItem(17,"Sort books in warehouse by date     (2)", 0));
            menu5ItemList.add(new MenuItem(18,"Sort books in warehouse by price    (3)", 0));
            menu5ItemList.add(new MenuItem(19,"Sort books in warehouse by status   (4)", 0));
            menu5ItemList.add(new MenuItem(20,"Show stale books                    (5)", 8));
            menu5ItemList.add(new MenuItem(21,"Show book description               (6)", 0));
            return new Menu("   <Manager books menu>", menu5ItemList, 4, MenuLevel.FOUR);
        }
        if (index == 6) {
            List<MenuItem> menu6ItemList = new ArrayList<>(6);
            menu6ItemList.add(new MenuItem(22,"Show order details                       (1)", 0));
            menu6ItemList.add(new MenuItem(23,"Sort orders by execution date            (2)", 0));
            menu6ItemList.add(new MenuItem(24,"Sort orders by price                     (3)", 0));
            menu6ItemList.add(new MenuItem(25,"Sort orders by status                    (4)", 0));
            menu6ItemList.add(new MenuItem(26,"Show complete orders in period           (5)", 9));
            menu6ItemList.add(new MenuItem(27,"Show quantity completed orders in period (6)", 0));
            return new Menu("   <Manager orders menu>", menu6ItemList, 4, MenuLevel.FOUR);
        }
        if (index == 7) {
            List<MenuItem> menu7ItemList = new ArrayList<>(2);
            menu7ItemList.add(new MenuItem(28,"Show requests by quantity (1)", 0));
            menu7ItemList.add(new MenuItem(29,"Show requests by alphabet (2)", 0));
            return new Menu("   <Manager requests menu>", menu7ItemList, 4, MenuLevel.FOUR);
        }
        if (index == 8) {
            List<MenuItem> menu8ItemList = new ArrayList<>(2);
            menu8ItemList.add(new MenuItem(30,"Sort stale books by date  (1)", 0));
            menu8ItemList.add(new MenuItem(31,"Sort stale books by price (2)", 0));
            return new Menu("   <Sort stale books>", menu8ItemList, 5, MenuLevel.FIVE);
        }
        if (index == 9) {
            List<MenuItem> menu9ItemList = new ArrayList<>(2);
            menu9ItemList.add(new MenuItem(32,"Sort complete orders in period by date  (1)", 0));
            menu9ItemList.add(new MenuItem(33,"Sort complete orders in period by price (2)", 0));
            return new Menu("   <Sort complete orders in period>", menu9ItemList, 6, MenuLevel.FIVE);
        }
        return null;
    }

}
