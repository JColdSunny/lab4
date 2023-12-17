package app;

public class CreateHiddenPostFacade {
    private final PostFactory postFactory = new PostFactoryImpl();

    public HidePostDecorator createHiddenPost(String content) {
        return new HidePostDecorator(postFactory.createPost(content), true);
    }

}
