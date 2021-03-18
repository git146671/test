package eu.senla.eBookStore.UI.menuController;

import eu.senla.eBookStore.UI.builder.Builder;
import eu.senla.eBookStore.UI.navigator.Navigator;

import java.util.Scanner;

public class MenuController {   //singleton
    private static MenuController menuController;
    private Builder builder;
    private Navigator navigator;


    public static MenuController getMenuController() {
        if (menuController == null) {
            menuController = new MenuController();
        }
        return menuController;
    }


    public void run() {
        Builder.getBuilder().buildMenu();
        Navigator.getNavigator().setCurrMenu(Builder.getBuilder().getRootMenu());
        Navigator.getNavigator().printMenu();
        Scanner in = new Scanner(System.in);
    }
}
