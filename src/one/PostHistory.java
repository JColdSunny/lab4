package one;

import java.util.Stack;

public class PostHistory {
    private final Stack<PostMemento> history = new Stack<>();

    public void save(HiddenPostDecorator post) {
        history.push(post.save());
    }

    public void revert(HiddenPostDecorator post) {
        if (!history.empty()) {
            post.restore(history.pop());
        } else {
            System.out.println("Cannot undo");
        }
    }
}
