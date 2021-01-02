package main.structures;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class User {
    private String name;
    private String password;
    private ArrayList<Category> categories;
    private ObservableList<String> categoryTitles;

    public User(String title, String password) {
        this.name = title;
        this.password = password;
        categories = new ArrayList<>();
        categoryTitles = FXCollections.observableArrayList();
    }

    public String getName() {
        return name;
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
        if (this == other) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }

        return name.equals(((User) other).getName()); //todo replace if necessary
    }
}
