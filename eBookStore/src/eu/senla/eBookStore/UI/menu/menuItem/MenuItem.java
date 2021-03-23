package eu.senla.eBookStore.UI.menu.menuItem;

public class MenuItem{
    int id;
    String title;
    int nextMenu;

    public MenuItem(int id, String title, int nextMenu) {
        this.id =id;
        this.title = title;
        this.nextMenu = nextMenu;

    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getNextMenu() {
        return nextMenu;
    }

}
