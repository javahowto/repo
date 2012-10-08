package com.blogspot.javahowto;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

@Stateless
@Remote
@TransactionManagement(TransactionManagementType.BEAN)
public class ServiceBean implements ServiceIF {
    public String serviceHello() {
        return "In serviceHello of " + this;
    }
}
