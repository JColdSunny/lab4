package one;

public class HiddenPostDecorator extends PostDecorator {
    private boolean isHidden;

    public HiddenPostDecorator(Post post, boolean isHidden) {
        super(post);
        this.isHidden = isHidden;
    }

    @Override
    String getContent() {
        return isHidden ? "Пост закрыт для просмотра" : this.post.getContent();
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public PostMemento save() {
        return new PostMemento(getContent());
    }

    public void restore(PostMemento memento) {
        post.setContent(memento.getSavedState());
    }


}
