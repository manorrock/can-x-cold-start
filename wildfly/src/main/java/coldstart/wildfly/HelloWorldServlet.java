package coldstart.wildfly;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = {""})
public class HelloWorldServlet extends HttpServlet {

    private String outputFilename;

    private long time1;

    private long time2;

    private long time3;

    @Override
    public void init(ServletConfig config) throws ServletException {
        time2 = System.currentTimeMillis();
        outputFilename = System.getenv("OUTPUT_FILENAME");
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/plain");
        try ( PrintWriter out = response.getWriter()) {
            out.println("Hello World!");
        }
        time3 = System.currentTimeMillis();
        writeResults(request.getServletContext());
    }

    /**
     * Write the results asynchronously.
     *
     * @param context the servlet context.
     */
    public void writeResults(ServletContext context) {
        time1 = (long) context.getAttribute("TIME1");
        Thread thread = new Thread() {

            @Override
            public void run() {
                try ( PrintWriter writer = new PrintWriter(new FileWriter(outputFilename, true))) {
                    writer.println(time1 + "," + time2 + "," + time3);
                } catch (IOException ioe) {
                    // nothing to do here.
                }
            }
        };
        thread.start();
    }
}
