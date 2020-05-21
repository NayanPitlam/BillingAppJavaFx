package sample;

import javafx.beans.property.SimpleStringProperty;

public class Item {
    private final SimpleStringProperty itemName = new SimpleStringProperty("");
    private final SimpleStringProperty quantity = new SimpleStringProperty("");
    private final SimpleStringProperty price = new SimpleStringProperty("");

    //    private final SimpleStringProperty notes = new SimpleStringProperty("");


    public Item() {

    }
    public Item(String itemName ,String quantity, String price) {
        this.itemName.set(itemName);
        this.quantity.set(quantity);
        this.price.set(price);
    }

    public String getItemName() {
        return itemName.get();
    }

    public SimpleStringProperty itemNameProperty() {
        return itemName;
    }

    public String getQuantity() {
        return quantity.get();
    }

    public SimpleStringProperty quantityProperty() {
        return quantity;
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setItemName(String itemName) {
        this.itemName.set(itemName);
    }

    public void setQuantity(String quantity) {
        this.quantity.set(quantity);
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName=" + itemName +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
