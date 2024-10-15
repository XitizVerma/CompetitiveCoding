package DesignPatterns.BehavioralPatterns.IteratorDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class MyIteratorImpl implements MyIterator{

    private List<User> userList = new ArrayList<>();
    private Integer size;
    private Integer position=0;

    public MyIteratorImpl(List<User> userList){
        this.userList = userList;
        this.size=userList.size();
    }

    @Override
    public boolean hasNext() {
        return !position.equals(size);
    }

    @Override
    public Object next() {
        User user =  userList.get(position);
        position++;
        return user;
    }
}
