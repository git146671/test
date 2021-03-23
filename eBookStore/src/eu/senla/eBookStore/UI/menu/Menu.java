package eu.senla.eBookStore.UI.menu;

import eu.senla.eBookStore.UI.menu.menuItem.MenuItem;

import java.util.List;

public class Menu {
    String name;
    List<MenuItem> menuItems;
    private final int prevMenu;
    private final MenuLevel menuLevel;

    public Menu(String name, List<MenuItem> menuItems, int prevMenu, MenuLevel menuLevel) {
        this.name = name;
        this.menuItems = menuItems;
        this.prevMenu = prevMenu;
        this.menuLevel = menuLevel;
    }

    public MenuLevel getMenuLevel() {
        return menuLevel;
    }

    public String getName() {
        return name;
    }

    public int getPrevMenu() {
        return prevMenu;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

}


