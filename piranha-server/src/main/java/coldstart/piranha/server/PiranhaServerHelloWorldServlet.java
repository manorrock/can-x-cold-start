package coldstart.piranha.server;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloWorldServlet", urlPatterns = {""})
public class PiranhaServerHelloWorldServlet extends HttpServlet {
    
    public PiranhaServerHelloWorldServlet() {
        PiranhaServerHelloWorldServletContainerInitializer.time2 = System.currentTimeMillis();
    }

    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) throws IOException, ServletException {
        try (PrintWriter writer = response.getWriter()) {
            writer.println("Hello World");
            writer.flush();
        }
        PiranhaServerHelloWorldServletContainerInitializer.time3 = System.currentTimeMillis();
        PiranhaServerHelloWorldServletContainerInitializer.writeResults();
    }
}
