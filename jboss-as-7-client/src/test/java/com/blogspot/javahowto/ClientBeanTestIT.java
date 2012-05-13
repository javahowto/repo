package com.blogspot.javahowto;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import static org.junit.Assert.assertNotNull;

public class ClientBeanTestIT {
    private static String lookupName;

    @BeforeClass
    public static void beforeClass() {
        lookupName = System.getProperty("lookup.name");
    }

    @Test
    public void invokeClientBean() throws NamingException {
        ClientIF clientBean = InitialContext.doLookup(lookupName);
        String result = clientBean.clientHello();
        System.out.printf("Result from clientBean.clientHello(): %s%n%n", result);
        assertNotNull(result);
    }
}
