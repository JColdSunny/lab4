package one;

// Post class (Low Coupling - GRASP's Low Coupling pattern)
class Post {

    private final User user;
    private String content;

    public Post(User user, String content) {
        this.user = user;
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
