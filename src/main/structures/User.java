package main.structures;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class User {
    private String name;
    private String password;
    private ArrayList<Category> categories;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        categories = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    //todo keep?
    public void setCategories(ArrayList<Category> list) {
        categories = list;
    }

    /**
     * Retrieve a observableArrayList of the String titles of all categories
     * @return observableArrayList of Category titles
     */
    public ObservableList<String> getCategoryTitles() {
        ObservableList<String> list = FXCollections.observableArrayList();
        for (Category c : categories) {
            list.add(c.getTitle());
        }
        return list;
    }

    /**
     * Given a String title, the method returns the corresponding Category
     * @param title Category to retrieve
     * @return Desired Category, null if error
     */
    public Category getCorrespondingCategory(String title) {
        for (Category c : categories) {
            if (c.getTitle().equals(title)) {
                return c;
            }
        }
        return null;
    }

    public String getPassword() {
        return password;
    }
}
