package DesignPatterns.BehavioralPatterns.IteratorDesignPattern;

public class Main {

    public static void main(String[] args) {

        UserManagement userManagement = new UserManagement();
        userManagement.addUser(new User("001","Xitiz"));
        userManagement.addUser(new User("002","Meaw"));

        MyIteratorImpl myIterator = userManagement.getIterator();
        while(myIterator.hasNext()){
            User user = (User) myIterator.next();
            System.out.println(user.getName());
        }
    }
}
