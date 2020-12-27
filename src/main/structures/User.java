package main.structures;

import java.util.ArrayList;

public class User {
    private String name;
    private String password;
    private ArrayList<Category> categories;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public String getPassword() {
        return password;
    }
}
