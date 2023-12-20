package app;

import app.controller.UserController;
import app.creator.UserCreator;
import app.expert.User;

public class Main {

    public static void main(String[] args) {
        UserController userController = new UserController(new UserCreator());
        PostFactory postFactory = new PostFactoryImpl();
        CreateHiddenPostFacade createHiddenPostFacade = new CreateHiddenPostFacade();
        PostHistory postHistory = new PostHistory();

        User karishka = userController.createUser("Karishka");
        HidePostDecorator post = new HidePostDecorator(postFactory.createPost("1"));
        postHistory.push(karishka, post);
        karishka.addPost(post);

        HidePostDecorator post2 = new HidePostDecorator(postFactory.createPost("2"));
        postHistory.push(karishka, post2);
        karishka.addPost(post2);
        System.out.println(karishka);

        User lera = userController.createUser("Lera");
        HidePostDecorator post3 = new HidePostDecorator(postFactory.createPost("3"));
        postHistory.push(lera, post3);
        lera.addPost(post3);
        System.out.println(lera);

        System.out.println("Find user by name: " + userController.findUserByName("Karishka"));

        System.out.println("Get All users: " + userController.getAllUses());

        karishka.removePost(post);

        System.out.println("Get All users after delete post: " + userController.getAllUses());

        userController.removeUser(lera);

        System.out.println("Get All users after delete user: " + userController.getAllUses());

        HidePostDecorator hiddenPost = createHiddenPostFacade.createHiddenPost("111");
        System.out.println("Create hidden post using facade: " + hiddenPost);
        karishka.addPost(hiddenPost);

        System.out.println("Add hidden post to the user: " + userController.getAllUses());

        postHistory.popByContent("1");
        System.out.println("Restore karishka the first post: " + karishka);

        /////// New
        User karishkaClone = karishka.clone();
        System.out.println("Cloned Karishka: " + karishkaClone);

        User ladybird = userController.createUser("Ladybird");
        ladybird.repost(karishka.getPosts().get(0));

        System.out.println("Add repost: " + karishka);

        karishka.getPosts().get(0).getPost().setContent("updated post");

        System.out.println("Updated repost: " + karishka);
    }

}
