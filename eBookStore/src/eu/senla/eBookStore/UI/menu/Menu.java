package eu.senla.eBookStore.UI.menu;

import eu.senla.eBookStore.UI.IAction.impl.ItemLevel;
import eu.senla.eBookStore.UI.IAction.impl.MenuItem;

import java.util.List;

public class Menu {
    String name;
    List<MenuItem> menuItems;

    public Menu(String name, List<MenuItem> menuItems) {
        this.name = name;
        this.menuItems = menuItems;
    }

    public String getName() {
        return name;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}


