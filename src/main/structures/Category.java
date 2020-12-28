package main.structures;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Category {
    private String title;
    private ArrayList<Item> items;
    public int num = 5; //todo remove this

    public Category(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    //todo remove this eventually?
    public void setItems(ArrayList<Item> list) {
        items = list;
    }

    /**
     * Retrieve list of Item titles
     * @return ObservableList of Strings of Item titles
     */
    public ObservableList<String> getItemTitles() {
        ObservableList<String> list = FXCollections.observableArrayList();
        for (Item i : items) {
            list.add(i.getTitle());
        }
        return list;
    }

    /**
     * Retrieves the Item corresponding to a given String title
     * @param title The title of the desired Item
     * @return Item corresponding to title, null otherwise
     */
    public Item getCorrespondingItem(String title) {
        for (Item i : items) {
            if (i.getTitle().equals(title)) {
                return i;
            }
        }
        return null;
    }

    //todo remove this
    public int getNum() {
        return num;
    }
}
