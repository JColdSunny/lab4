package one;

public class UserController {
    private final Creator creator;
    private final PostHistory postHistory = new PostHistory();
    private final PostFacade postFacade = new PostFacade();

    public UserController() {
        this.creator = new Creator();
    }

    public void performUserOperations() {

        // Create User
        User bob = creator.createUser("Bob");
        User karishka = creator.createUser("Karishka");

        // Create Post
        HiddenPostDecorator post1 = creator.createPost(bob, "Hello World");
        HiddenPostDecorator post2 = creator.createPost(bob, "post2");
        HiddenPostDecorator post3 = creator.createPost(karishka, "post3");
        HiddenPostDecorator post4 = postFacade.createHiddenPost(karishka, "post4");

        // Delete Post
        creator.deletePost(bob, post1);
        postHistory.save(post2);
        postHistory.save(post3);
        postHistory.save(post4);



        // Find User
        User findBob = creator.findUser("Bob");
        if (findBob != null) {
            System.out.println(findBob.getName() + "'s Posts: " + findBob.getPosts());
        }

        // Read List of Users and their posts
        for (User user : creator.getUsers()) {
            System.out.println(user.getName() + "'s Posts: " + user.getPosts());
        }

        postHistory.revert(post2);

        // Read List of Users and their posts
        for (User user : creator.getUsers()) {
            System.out.println(user.getName() + "'s Posts: " + user.getPosts());
        }
    }
}
