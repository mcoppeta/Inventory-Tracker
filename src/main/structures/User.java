package main.structures;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class User {
    private String title;
    private String password;
    private ArrayList<Category> categories;
    private ObservableList<String> categoryTitles;

    public User(String title, String password) {
        this.title = title;
        this.password = password;
        categories = new ArrayList<>();
        categoryTitles = FXCollections.observableArrayList();
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public ObservableList<String> getCategoryTitles() {
        return categoryTitles;
    }

    //todo keep?
    public void setCategories(ArrayList<Category> list) {
        categories = list;
        categoryTitles.clear();
        for (Category c : list) {
            categoryTitles.add(c.getTitle());
        }
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

    //todo fix this for duplicates
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
        categoryTitles.add(newCategory.getTitle());
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
