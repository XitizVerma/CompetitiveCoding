package DesignPatterns.BehavioralPatterns.IteratorDesignPattern;

import java.util.ArrayList;

public class UserManagement {

    private ArrayList<User> userList = new ArrayList<>();

    public void addUser(User user){
        userList.add(user);
    }

    public void getUser(Integer index){
        userList.get(index);
    }

    public MyIteratorImpl getIterator(){
        return new MyIteratorImpl(userList);
    }
}
