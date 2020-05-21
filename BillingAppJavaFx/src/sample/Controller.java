package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public ComboBox<String> comboBox;
    public ComboBox<Integer> qBox;
    //    public ComboBox<Integer> quantity;
    public DatePicker datePicker;
    public TextField bill;
    public ToggleGroup QToggleGroup;
    public TableView<Item> table;
    public ToggleGroup CToggleGroup;
    LocalDate now = LocalDate.now();
    public RadioButton grams;
    public RadioButton kgs;
    public Label price;
    public ItemData itemData;
    public Button addButton;
    public Button removeButton;
    public Label totalPrice;

    public void setKgs(ActionEvent event) {
        ObservableList<Integer> quantityList = null;
        if (grams.isSelected()) {
            quantityList = ifGrams;
        }
        if (kgs.isSelected()) {
            quantityList = ifKGrams;
        }
        qBox.setItems(quantityList);
    }

    ObservableMap<String, Double> stringDoubleObservableMap = FXCollections.observableHashMap();
    ObservableList<String> list = FXCollections.observableArrayList("Toor Dal", "Urad Dal", "GroundNut", "Sesame Seeds", "Jeera");
    ObservableList<Integer> ifGrams = FXCollections.observableArrayList(50, 100, 200, 250, 500, 750);
    ObservableList<Integer> ifKGrams = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    ObservableList<Double> prices = FXCollections.observableArrayList(120.0, 110.0, 90.0, 80.0, 200.0);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int min = 1000000;
        int max = 1000000000;
        comboBox.setItems(list);
        datePicker.setValue(now);
        bill.setText(((int) (Math.random() * (max - min + 1) + min)) + "");
        for (int i = 0; i < list.size(); i++) {
            stringDoubleObservableMap.put(list.get(i), prices.get(i));
        }
        itemData = new ItemData();
        table.setItems(itemData.getItemList());


    }

    public void setPrice(MouseEvent e) {
        String priceL = "";
        if (grams.isSelected()) {
            priceL = "" + stringDoubleObservableMap.get(comboBox.getValue()) * (new Double(qBox.getValue()) / 1000);
        }
        if (kgs.isSelected()) {
            priceL = "" + stringDoubleObservableMap.get(comboBox.getValue()) * qBox.getValue();
        }
        price.setText(priceL);
    }

    public void addItem(ActionEvent event) {
        itemData.addItem(new Item(comboBox.getValue(), qBox.getValue() + "", price.getText()));
    }

    public void removeItem(ActionEvent event) {
        itemData.deleteItem(table.getSelectionModel().getSelectedItem());
//        table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
    }


    public void setTotalPrice(MouseEvent event) {
        double price = 0.0;
        for (Item i : table.getItems()) {
            price += Double.parseDouble(i.getPrice());
        }

        totalPrice.setText(price+"");
    }
}
