package one;

public class PostMemento {
    private final String postState;

    public PostMemento(String postState) {
        this.postState = postState;
    }

    public String getSavedState() {
        return this.postState;
    }
}
