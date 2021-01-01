package main.resources;

import javafx.beans.property.ReadOnlyListWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.structures.Category;
import main.structures.Item;
import main.structures.User;

import java.util.ArrayList;

public class UserResources {
    private static ReadOnlyListWrapper<User> users;

    /**
     * A temporary init method until there users are stored in memory
     */
    public static void init() {
        users = new ReadOnlyListWrapper<>();
        users.set(FXCollections.observableArrayList());
        User a = new User("A", "1");
        ArrayList<Category> aCat = new ArrayList<>();
        Category ac1 = new Category("C1");
        aCat.add(ac1);
        Category ac2 = new Category("C2");
        aCat.add(ac2);
        a.setCategories(aCat);
        ArrayList<Item> a1Items = new ArrayList<>();
        a1Items.add(new Item("C1I1"));
        a1Items.add(new Item("C1I2"));
        ArrayList<Item> a2Items = new ArrayList<>();
        a2Items.add(new Item("C2I1"));
        a2Items.add(new Item("C2I2"));
        ac1.setItems(a1Items);
        ac2.setItems(a2Items);
        users.add(a);
        users.add(new User("B", "2"));
    }

    //todo this needs to be redone later
    /**
     * Returns list of all Users
     * @return ObservableList of Users
     */
    public static ObservableList<User> getUsers() {
        return users;
    }

    /**
     * Checks if a given profile name is not currently being used
     * @param name Name to check
     * @return True if profile name not used, false otherwise
     */
    public static boolean validUsername(String name) {
        for (User u : users) {
            if (u.getTitle().equals(name)) {
                return false;
            }
        }
        return true;
    }

    /**
     * If given proper login info, it returns the User
     * @param username Given username
     * @param password Given password
     * @return User associated with the login information, null if invalid
     */
    public static User validLogin(String username, String password) {
        for (User u : users) {
            if (u.getTitle().equals(username)) {
                if (u.getPassword().equals(password)) {
                    return u;
                }
            }
        }
        return null;
    }

    /**
     * Method adds a new user to the arraylist
     */
    public static void addUser(User u) {
        users.add(u);
    }
}
