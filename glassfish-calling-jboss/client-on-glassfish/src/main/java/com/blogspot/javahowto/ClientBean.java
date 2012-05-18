package com.blogspot.javahowto;

import javax.ejb.EJBException;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Stateless
@Remote
public class ClientBean implements ClientIF {
    private static final String jbossJndiPropertiesPath = "/jboss-jndi.properties";

    public String clientHello(String targetEjbJndi) {
        String result = null;
        try {
            InitialContext ic = new InitialContext(getJBossJndiProperties());
            System.out.printf("About to look up ServiceBean by jndi %s%n", targetEjbJndi);
            ServiceIF serviceBean = (ServiceIF) ic.lookup(targetEjbJndi);
            result = serviceBean.serviceHello();
        } catch (NamingException e) {
            throw new EJBException(e);
        }
        return result;
    }

    private Properties getJBossJndiProperties() {
        Properties props = new Properties();
        InputStream is = null;
        try {
            is = getClass().getResourceAsStream(jbossJndiPropertiesPath);
            props.load(is);
        } catch (IOException e) {
            System.out.println("Failed to load " + jbossJndiPropertiesPath);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                //ignore
            }
        }
        System.out.println("Got jboss-jndi.properties: " + props);
        return props;
    }
}
