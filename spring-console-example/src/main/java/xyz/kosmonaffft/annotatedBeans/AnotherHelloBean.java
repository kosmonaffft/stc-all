package xyz.kosmonaffft.annotatedBeans;

import xyz.kosmonaffft.beans.AnotherHello;

public class AnotherHelloBean implements AnotherHello {

    @Override
    public void sayHello() {
        System.out.println("Another hello!!!");
    }
}
