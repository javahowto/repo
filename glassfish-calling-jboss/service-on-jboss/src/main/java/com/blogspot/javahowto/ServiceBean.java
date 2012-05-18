package com.blogspot.javahowto;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote
public class ServiceBean implements ServiceIF {
    public String serviceHello() {
        return "In serviceHello of " + this;
    }
}
