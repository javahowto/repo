package com.blogspot.javahowto;

import javax.ejb.*;

@Stateless
@Remote
public class ClientBean implements ClientIF {
    public String clientHello() {
        return "In clientHello of " + this;
    }
}
