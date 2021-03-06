package main.structures;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Category {
    private String title;
    private ArrayList<Item> items;
    private ObservableList<String> itemTitles;

    public Category(String title) {
        this.title = title;
        items = new ArrayList<>();
        itemTitles = FXCollections.observableArrayList();
    }

    public String getTitle() {
        return title;
    }

    public ObservableList<String> getItemTitles() {
        return itemTitles;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    //todo remove this eventually?
    public void setItems(ArrayList<Item> list) {
        items = list;
        itemTitles.clear();
        for (Item i : items) {
            itemTitles.add(i.getTitle());
        }
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

    /**
     * Adds new item to category
     * @param newItem The item to add
     * @return true if successful, false otherwise
     */
    public boolean addItem(Item newItem) {
        if (newItem.getTitle().trim().equals("")) {
            return false;
        }

        for (Item i : items) {
            if (i.equals(newItem)) {
                return false;
            }
        }

        items.add(newItem);
        itemTitles.add(newItem.getTitle());
        return true;
    }

    /**
     * Removes Item from Category
     * @param toRemove The Item to remove
     * @return The removed Item on success, null otherwise
     */
    public Item removeItem(Item toRemove) {
        if (items.contains(toRemove)) {
            Item tr = items.get(items.indexOf(toRemove));
            items.remove(toRemove);
            itemTitles.remove(toRemove.getTitle());
            return tr;
        }
        return null;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (other == this) {
            return true;
        } else if (other instanceof Category) {
            if (this.title.equals(((Category) other).getTitle())) {
                return true;
            }
        }
        return false;
    }
}
