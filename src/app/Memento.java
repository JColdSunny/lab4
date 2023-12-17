package app;

import app.expert.User;

public class Memento {
    private final User user;
    private final HidePostDecorator post;

    public Memento(User user, HidePostDecorator post) {
        this.user = user;
        this.post = post;
    }

    public void restore() {
        user.addPost(post);
    }

    public HidePostDecorator getPost() {
        return post;
    }
}
