package app;

import app.expert.Post;

import java.util.Objects;

public class HidePostDecorator {
    private final Post post;
    private boolean isHidden;

    public HidePostDecorator(Post post, boolean isHidden) {
        this.post = post;
        this.isHidden = isHidden;
    }

    public HidePostDecorator(Post post) {
        this(post, false);
    }

    public Post getPost() {
        return post;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public String getContent() {
        return isHidden ? "Пост скрыт" : post.getContent();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HidePostDecorator that = (HidePostDecorator) o;
        return Objects.equals(post, that.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(post);
    }

    @Override
    public String toString() {
        return "Post{" +
               "content=" + getContent() +
               '}';
    }
}
