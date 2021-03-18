package eu.senla.eBookStore.UI.builder;

import eu.senla.eBookStore.UI.IAction.impl.ItemLevel;
import eu.senla.eBookStore.UI.IAction.impl.MenuItem;
import eu.senla.eBookStore.UI.menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class Builder { //singleton
    private Menu rootMenu;
    private static Builder builder;

    public static Builder getBuilder(){
        if (builder == null) {
            builder = new Builder();
        }
        return builder;
    }

    public void buildMenu() {
        MenuItem rootItem1 = new MenuItem("Buyer (1)", null, null, ItemLevel.ONE);
        MenuItem rootItem2 = new MenuItem("Manager (2)", null, null, ItemLevel.ONE);
        List<MenuItem> rootMenuItemList = new ArrayList<>();
        rootMenuItemList.add(rootItem1);
        rootMenuItemList.add(rootItem2);
        rootMenu = new Menu("<Role choice>", rootMenuItemList);
    }

    public Menu getRootMenu() {
        return rootMenu;
    }
}
