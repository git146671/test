package eu.senla.eBookStore.UI.IAction.impl;

public enum ItemLevel {
    ONE("* "),
    TWO("** "),
    THREE("*** "),
    FOUR("***** "),
    FIVE("****** ");

    public final String itemLevel;

    ItemLevel(String itemLevel) {
        this.itemLevel = itemLevel;
    }

}
