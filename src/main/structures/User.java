package main.structures;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class User {
    private String title;
    private String password;
    private ArrayList<Category> categories;

    public User(String title, String password) {
        this.title = title;
        this.password = password;
        categories = new ArrayList<>();
    }

    public String getTitle() {
        return title;
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

    /**
     * Adds new category to the categories collection
     * @param newCategory The category to be added
     * @return true if successful, false otherwise
     */
    public boolean addCategory(Category newCategory) {
        for (Category c : categories) {
            if (newCategory.equals(c)) {
                return false;
            }
        }
        categories.add(newCategory);
        return true;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (this == other) {
            return true;
        } else if (other instanceof Category) {
            if (this.title.equals(((Category) other).getTitle())) {
                return true;
            }
        }
        return false;
    }
}
