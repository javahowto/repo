package com.blogspot.javahowto;

import javax.ejb.EJBException;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.String;
import java.util.Properties;

@Stateless
@Remote
@TransactionManagement(TransactionManagementType.BEAN)
public class ClientBean implements ClientIF {
    private static final String glassFishJndiPropertiesPath = "/glassfish-jndi.properties";

    public String clientHello(String targetEjbJndi) {
        String result = null;
        try {
            InitialContext ic = new InitialContext(getGlassFishJndiProperties());
            System.out.printf("About to look up ServiceBean by jndi %s%n", targetEjbJndi);
            ServiceIF serviceBean = (ServiceIF) ic.lookup(targetEjbJndi);
            result = serviceBean.serviceHello();
        } catch (NamingException e) {
            throw new EJBException(e);
        }
        return result;
    }

    private Properties getGlassFishJndiProperties() {
        Properties props = new Properties();
        InputStream is = null;
        try {
            is = getClass().getResourceAsStream(glassFishJndiPropertiesPath);
            props.load(is);
        } catch (IOException e) {
            System.out.println("Failed to load " + glassFishJndiPropertiesPath);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                //ignore
            }
        }
        System.out.println("Got glassfish-jndi.properties: " + props);
        return props;
    }
}
