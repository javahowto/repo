package test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/*", asyncSupported = true)
public class TestServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        AsyncContext ac = request.startAsync();
        PrintWriter out = response.getWriter();
        ac.setTimeout(2000);
        ac.addListener(ac.createListener(TestAsyncListener.class));

//        ac.addListener(new TestAsyncListener());

//        ac.addListener(new AsyncListener() {
//            public void onComplete(AsyncEvent event) {
//                System.out.println("AsyncListener.onComplete");
//            }
//
//            public void onError(AsyncEvent event) {
//                System.out.println("AsyncListener.onError");
//            }
//
//            public void onStartAsync(AsyncEvent event) {
//                System.out.println("AsyncListener.onStartAsync");
//            }
//
//            public void onTimeout(AsyncEvent event) {
//                System.out.println("AsyncListener.onTimeout");
//            }
//        });

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
}
        
