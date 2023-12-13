package one;

public class PostFacade {
    private final Creator creator = new Creator();

    public HiddenPostDecorator createHiddenPost(User user, String content) {
        HiddenPostDecorator post = creator.createPost(user, content);
        post.setHidden(true);
        return post;
    }

}
