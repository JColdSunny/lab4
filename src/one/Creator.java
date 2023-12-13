package one;

import java.util.ArrayList;
import java.util.List;

// Creator class (GRASP's Creator pattern)
class Creator {
    private final PostFactory postFactory = new PostFactoryImpl();
    private final List<User> users = new ArrayList<>();

    public User createUser(String name) {
        User user = new User(name);
        users.add(user);
        return user;
    }

    public void deleteUser(User user) {
        users.remove(user);
    }

    public User findUser(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getUsers() {
        return users;
    }

    public HiddenPostDecorator createPost(User user, String content) {
        return user.addPost(new HiddenPostDecorator(postFactory.createPost(user, content), false));
    }

    public void deletePost(User user, HiddenPostDecorator post) {
        user.removePost(post);
    }
}