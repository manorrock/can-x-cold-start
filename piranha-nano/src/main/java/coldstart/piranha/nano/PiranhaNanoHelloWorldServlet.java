package coldstart.piranha.nano;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PiranhaNanoHelloWorldServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, 
            HttpServletResponse response) throws IOException, ServletException {
        try (PrintWriter writer = response.getWriter()) {
            writer.println("Hello World");
            writer.flush();
        }
        PiranhaNanoHelloWorld.time3 = System.currentTimeMillis();
        PiranhaNanoHelloWorld.writeResults();
    }
}
