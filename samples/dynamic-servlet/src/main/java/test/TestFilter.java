package test;

import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String foo = filterConfig.getInitParameter("foo");
        System.out.println("## in TestFilter.init, foo=" + foo + ", " + this);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("## in doFilter: " + this);
    }

    @Override
    public void destroy() {
        System.out.println("## in TestFilter.destroy: " + this);
    }

    @PostConstruct
    public void ps() {
        System.out.println("## in ps: " + this);
    }

    @PreDestroy
    public void pd() {
        System.out.println("## in pd: " + this);
    }
}
