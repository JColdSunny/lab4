package app.expert;

public class Repost {
    private User reposter;
    private Post parentPost;
    private String content;

    public Repost(User reposter, Post parentPost) {
        this.reposter = reposter;
        this.parentPost = parentPost;
        this.content = parentPost.getContent();
    }

    public void setParentPost(Post parentPost) {
        this.parentPost = parentPost;
        this.content = parentPost.getContent();
    }

    public void update() {
        this.content = parentPost.getContent();
    }

    @Override
    public String toString() {
        return "Repost{" +
               "reposter='" + reposter.getName() + '\'' +
               ", content='" + content + '\'' +
               '}';
    }
}