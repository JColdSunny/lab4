package one;

import java.util.ArrayList;
import java.util.List;

// User class represents Information Expert (GRASP's Information Expert pattern)
class User {

    private final String name;
    private final List<HiddenPostDecorator> posts = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public HiddenPostDecorator addPost(HiddenPostDecorator post) {
        posts.add(post);
        return post;
    }

    public void removePost(HiddenPostDecorator post) {
        posts.remove(post);
    }

    public List<HiddenPostDecorator> getPosts() {
        return posts;
    }
}
