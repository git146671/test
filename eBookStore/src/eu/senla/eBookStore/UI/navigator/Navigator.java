package eu.senla.eBookStore.UI.navigator;

import eu.senla.eBookStore.UI.menu.Menu;

public class Navigator { //singleton
    private static Navigator navigator;
    private Menu currMenu;
    private int index;

    public static Navigator getNavigator(){
        if (navigator == null) {
            navigator = new Navigator();
        }
        return navigator;
    }

    public void setCurrMenu(Menu currMenu) {
        this.currMenu = currMenu;
    }

    public void printMenu(){
        System.out.println(currMenu.getName());
        for (int i = 0; i < currMenu.getMenuItems().size(); i++) {
            System.out.println(currMenu.getMenuItems().get(i).getItemLevel().itemLevel + currMenu.getMenuItems().get(i).getTitle());
        }
        System.out.println("   Exit (0)");
    }
}
