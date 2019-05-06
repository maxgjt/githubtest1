package com.java2000.observer;

import org.junit.Test;

public class TestDemo {

    @Test
    public  void testObserver(){
        Message message = new Message();
        Observer user1 = new User("Lily");
        Observer user2 = new User("Tom");
        Observer user3 = new User("Vince");

        message.registerObserver(user1);
        message.registerObserver(user2);
        message.registerObserver(user3);

        message.setMessage("hello everyone");
    }
}
