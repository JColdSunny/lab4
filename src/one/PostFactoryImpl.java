package one;

class PostFactoryImpl implements PostFactory {
    @Override
    public Post createPost(User user, String content) {
        return new Post(user, content);
    }
}
