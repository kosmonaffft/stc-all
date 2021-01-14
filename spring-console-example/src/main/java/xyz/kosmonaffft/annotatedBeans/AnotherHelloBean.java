package xyz.kosmonaffft.annotatedBeans;

import xyz.kosmonaffft.beans.AnotherHello;

import javax.annotation.PostConstruct;

public class AnotherHelloBean implements AnotherHello {

    @PostConstruct
    public void init() {
        System.out.println("AnotherHello bean initialized!!!");
    }

    @Override
    public void sayHello() {
        System.out.println("Another hello!!!");
    }
}
