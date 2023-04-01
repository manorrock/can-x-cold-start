package coldstart.piranha.micro;

import coldstart.shared.Collector;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloWorldServlet", urlPatterns = {""})
public class PiranhaMicroHelloWorldServlet extends HttpServlet {
    
    public PiranhaMicroHelloWorldServlet() {
        Collector.time2 = System.currentTimeMillis();
    }

    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) throws IOException, ServletException {
        try (PrintWriter writer = response.getWriter()) {
            writer.println("Hello World");
            writer.flush();
        }
        Collector.time3 = System.currentTimeMillis();
        Collector.writeResults();
        System.exit(0);
    }
}
