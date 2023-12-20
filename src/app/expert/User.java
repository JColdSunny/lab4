package app.expert;

import app.HidePostDecorator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User implements Cloneable {
    private final String name;
    private final List<HidePostDecorator> posts = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<HidePostDecorator> getPosts() {
        return posts;
    }

    public void addPost(HidePostDecorator post) {
        posts.add(post);
    }

    public void removePost(HidePostDecorator post) {
        posts.remove(post);
    }

    public void repost(HidePostDecorator post) {
        post.getPost().addRepost(new Repost(this, post.getPost()));
    }

    @Override
    public User clone() {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException ignore) {
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "User{" +
               "name='" + name + '\'' +
               ", posts=" + posts +
               '}';
    }
}