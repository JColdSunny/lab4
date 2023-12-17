package app.controller;

import app.creator.UserCreator;
import app.expert.User;

import java.util.List;

public class UserController {
    private final UserCreator userCreator;

    public UserController(UserCreator userCreator) {
        this.userCreator = userCreator;
    }

    public List<User> getAllUses() {
        return userCreator.getUsers();
    }

    public User findUserByName(String name) {
        return userCreator.getUsers().stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public User createUser(String name) {
        return userCreator.createUser(name);
    }

    public void removeUser(User user) {
        userCreator.removeUser(user);
    }

}
