package test;

import javax.ejb.Singleton;

@Singleton
public class TestBean {
    public String hello() {
        String s = null;
        s = String.format("Hello from %s", this);
        return s;
    }
}
