package coldstart.piranha.embedded;

import coldstart.shared.Collector;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PiranhaEmbeddedHelloWorldServlet extends HttpServlet {
    
    public PiranhaEmbeddedHelloWorldServlet() {
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
