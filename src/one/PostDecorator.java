package one;

public abstract class PostDecorator {
    protected final Post post;

    public PostDecorator(Post post) {
        this.post = post;
    }

    abstract String getContent();

    @Override
    public String toString() {
        return getContent();
    }

}
