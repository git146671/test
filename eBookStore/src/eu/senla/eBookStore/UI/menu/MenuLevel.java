package eu.senla.eBookStore.UI.menu;

public enum MenuLevel {
    ONE("* "),
    TWO("** "),
    THREE("*** "),
    FOUR("**** "),
    FIVE("***** ");

    public final String menuLevel;

    MenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

}
