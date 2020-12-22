package main.resources;

import javafx.beans.property.ReadOnlyListWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.structures.User;

public class UserResources {
    public static ObservableList<User> getUsers() {
        ReadOnlyListWrapper<User> users = new ReadOnlyListWrapper<User>();
        users.set(FXCollections.observableArrayList());
        users.add(new User("A", "1"));
        users.add(new User("B", "2"));
        return users;
    }
}
