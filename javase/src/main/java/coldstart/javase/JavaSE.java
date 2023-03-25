package coldstart.javase;

import coldstart.shared.Collector;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 * A JavaSE cold start example.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class JavaSE {

    /**
     * Main method.
     * 
     * @param arguments the command line arguments.
     * @throws Exception when a serious error occurs.
     */
    public static void main(String[] arguments) throws Exception {
        Collector.csvFilename = arguments[0];
        Collector.time0 = Long.parseLong(arguments[1]);
        Collector.time1 = System.currentTimeMillis();
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/helloworld", new JavaSEHandler());
        server.setExecutor(null);
        server.start();
        Collector.time2 = System.currentTimeMillis();
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
            Collector.time3 = System.currentTimeMillis();
            Collector.writeResults();
            System.exit(0);
        }
    }
}
