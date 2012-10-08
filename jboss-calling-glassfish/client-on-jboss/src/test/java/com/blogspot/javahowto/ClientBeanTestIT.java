package com.blogspot.javahowto;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import static org.junit.Assert.assertNotNull;

public class ClientBeanTestIT {
    private static String lookupName;
    private static String targetEjbJndi;

    @BeforeClass
    public static void beforeClass() {
        lookupName = System.getProperty("lookup.name");
        targetEjbJndi = System.getProperty("target.ejb.jndi");
    }

    @Test
    public void invokeClientBean() throws NamingException {
        ClientIF clientBean = InitialContext.doLookup(lookupName);
        System.out.printf("Look up ClientBean by name %s, got %s%n", lookupName, clientBean);
        String result = clientBean.clientHello(targetEjbJndi);
        System.out.printf("Result from clientBean.clientHello(): %s%n%n", result);
        assertNotNull(result);
    }
}
