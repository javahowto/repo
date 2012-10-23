package test;

import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TestContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext sc = servletContextEvent.getServletContext();
        TestFilter filter = new TestFilter();
        FilterRegistration fr = sc.addFilter("TestFilter", filter);
        fr.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST),
                true, "TestServlet");
        System.out.println("## in contextInitialized, added filter " + filter);
        fr.setInitParameter("foo", "foo");


//        TestFilter filter2 = new TestFilter();
//        fr = sc.addFilter("TestFilter", filter2);
//        System.out.println("## in contextInitialized, added filter " + filter2 + ", FilterRegistration: " + fr);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
