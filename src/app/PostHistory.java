package app;

import app.expert.User;

import java.util.ArrayList;
import java.util.List;

public class PostHistory {
    private final List<Memento> postHistory = new ArrayList<>();

    public void push(User user, HidePostDecorator post) {
        postHistory.add(new Memento(user, post));
    }

    public void popByContent(String content) {
        postHistory.forEach(memento -> {
            if (memento.getPost().getContent().equals(content)) {
                memento.restore();
            }
        });
    }

}
