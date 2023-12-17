package app;

import app.expert.Post;

class PostFactoryImpl implements PostFactory {
    @Override
    public Post createPost(String content) {
        return new Post(content);
    }
}
