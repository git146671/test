package eu.senla.eBookStore.UI.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuAggregator { // singleton
    private static MenuAggregator menuAggregator;
    private final Map<Integer ,Menu> menuMap;

    public MenuAggregator() {
        this.menuMap = new HashMap<>();
    }

    public static MenuAggregator getMenuAggregator(){
        if (menuAggregator == null) {
            menuAggregator = new MenuAggregator();
        }
        return menuAggregator;
    }

    public Map<Integer, Menu> getMenuMap() {
        return menuMap;
    }

    public void addMenu(Integer menuId, Menu menu) {
        menuMap.put(menuId, menu);
    }
}
