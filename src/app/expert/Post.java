package app.expert;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Post {
    private String content;
    private List<Repost> reposts = new ArrayList<>();

    public Post(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyAllReposts(); // Observer
    }

    public List<Repost> getReposts() {
        return reposts;
    }

    public void addRepost(Repost repost) {
        reposts.add(repost);
        repost.setParentPost(this);
    }

    private void notifyAllReposts() {
        for (Repost repost : reposts) {
            repost.update();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(content, post.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public String toString() {
        return "Post{" +
               "content='" + getContent() + '\'' +
               ", reposts='" + reposts + '\'' +
               '}';
    }
}