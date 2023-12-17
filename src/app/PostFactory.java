package app;

import app.expert.Post;

interface PostFactory {
    Post createPost(String content);

}
