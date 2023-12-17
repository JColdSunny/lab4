package app.creator;

import app.expert.User;

import java.util.ArrayList;
import java.util.List;

public class UserCreator {
    private final List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public User createUser(String name) {
        User user = new User(name);
        users.add(user);
        return user;
    }

    public void removeUser(User user) {
        users.remove(user);
    }

}
