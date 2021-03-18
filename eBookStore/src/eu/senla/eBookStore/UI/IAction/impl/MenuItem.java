package eu.senla.eBookStore.UI.IAction.impl;

import eu.senla.eBookStore.UI.IAction.IAction;
import eu.senla.eBookStore.UI.menu.Menu;

public class MenuItem implements IAction {
    String title;
    Menu nextMenu;
    ItemLevel itemLevel;

    public MenuItem(String title, Menu nextMenu, Menu prevMenu, ItemLevel itemLevel) {
        this.title = title;
        this.nextMenu = nextMenu;
        this.itemLevel = itemLevel;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNextMenu(Menu nextMenu) {
        this.nextMenu = nextMenu;
    }

    public void setItemLevel(ItemLevel itemLevel) {
        this.itemLevel = itemLevel;
    }

    public String getTitle() {
        return title;
    }

    public Menu getNextMenu() {
        return nextMenu;
    }

    public ItemLevel getItemLevel() {
        return itemLevel;
    }

    @Override
    public void execute() {

    }
}
