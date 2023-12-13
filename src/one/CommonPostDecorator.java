package one;

public class CommonPostDecorator extends PostDecorator {

    public CommonPostDecorator(Post post) {
        super(post);
    }

    @Override
    public String getContent() {
        return this.post.getContent();
    }

}
