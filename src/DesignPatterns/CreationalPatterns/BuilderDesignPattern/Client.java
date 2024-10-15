package DesignPatterns.CreationalPatterns.BuilderDesignPattern;

public class Client {

    public static void main(String[] args) {
        User user = new User.UserBuilder().
                        setUserId("1001").
                        setUserName("Xitiz").
                        setEmail("xitiz@gmail.com").
                        build();
        //Method chaining

        System.out.println(user);
    }
}
