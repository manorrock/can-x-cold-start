package coldstart.javase;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;

/**
 * A JavaSE cold start example.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class JavaSE {

    /**
     * Filename to store the results in.
     */
    private static String outputFilename;

    /**
     * Time 1 - Entering user code timestamp.
     */
    private static long time1;

    /**
     * Time 2 - Ready for processing timestamp.
     */
    private static long time2;

    /**
     * Time 3 - 1st request server side completed timestamp.
     */
    private static long time3;

    /**
     * Main method.
     * 
     * @param arguments the command line arguments.
     * @throws Exception when a serious error occurs.
     */
    public static void main(String[] arguments) throws Exception {
        time1 = System.currentTimeMillis();
        outputFilename = arguments[0];
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/helloworld", new JavaSEHandler());
        server.setExecutor(null);
        server.start();
        time2 = System.currentTimeMillis();
    }

    /**
     * The HTTP handler.
     */
    public static class JavaSEHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "Hello World!";
            t.sendResponseHeaders(200, response.length());
            try ( OutputStream os = t.getResponseBody()) {
                os.write(response.getBytes());
            }
            time3 = System.currentTimeMillis();
            try ( PrintWriter writer = new PrintWriter(new FileWriter(outputFilename, true))) {
                writer.println(time1);
                writer.println(time2);
                writer.println(time3);
            }
        }
    }
}
