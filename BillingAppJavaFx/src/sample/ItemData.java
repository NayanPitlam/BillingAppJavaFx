package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ItemData {
    private static final String ITEMS_FILE = "contacts.xml";

    private static final String ITEM = "item";
    private static final String ITEM_NAME = "itemName";
    private static final String QUANTITY = "quantity";
    private static final String PRICE = "price";

    private final ObservableList<Item> itemList;

    public ItemData() {
        this.itemList = FXCollections.observableArrayList();
    }

    public static String getITEM() {
        return ITEM;
    }

    public static String getItemName() {
        return ITEM_NAME;
    }

    public static String getQUANTITY() {
        return QUANTITY;
    }

    public static String getPRICE() {
        return PRICE;
    }

    public ObservableList<Item> getItemList() {
        return itemList;
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void deleteItem(Item item) {
        itemList.remove(item);
    }

}

