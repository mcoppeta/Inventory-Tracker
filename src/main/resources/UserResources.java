package main.resources;

import javafx.beans.property.ReadOnlyListWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.structures.User;

public class UserResources {
    private static ReadOnlyListWrapper<User> users;

    /**
     * A temporary init method until there users are stored in memory
     */
    public static void init() {
        users = new ReadOnlyListWrapper<>();
        users.set(FXCollections.observableArrayList());
        users.add(new User("A", "1"));
        users.add(new User("B", "2"));
    }

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
            if (u.getName().equals(name)) {
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
            if (u.getName().equals(username)) {
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
