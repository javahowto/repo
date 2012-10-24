package test;

import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;

public class TestAsyncListener implements javax.servlet.AsyncListener {
    @PostConstruct
    private void ps() {
        System.out.println("## in PostConstruct of: " + this);
    }

    @PreDestroy
    private void pd() {
        System.out.println("## in PreDestroy of: " + this);
    }

    @Override
    public void onComplete(AsyncEvent asyncEvent) throws IOException {
    }

    @Override
    public void onTimeout(AsyncEvent asyncEvent) throws IOException {
        AsyncContext ac = asyncEvent.getAsyncContext();
        ac.getResponse().getWriter().println("Timeout!");
        ac.complete();
    }

    @Override
    public void onError(AsyncEvent asyncEvent) throws IOException {
    }

    @Override
    public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
    }
}
