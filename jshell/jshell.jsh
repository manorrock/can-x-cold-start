import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import coldstart.shared.Collector;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class JShell {

    public static void main(String[] args) throws Exception {
        String[] arguments = System.getenv("ARGUMENTS").split(" ");
        Collector.csvFilename = arguments[0];
        Collector.time0 = Long.parseLong(arguments[1]);
        Collector.time1 = System.currentTimeMillis();
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/helloworld", new MyHandler());
        server.setExecutor(null);
        server.start();
        Collector.time2 = System.currentTimeMillis();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "Hello World!";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
            Collector.time3 = System.currentTimeMillis();
            Collector.writeResults();
            System.exit(0);
        }
    }
}
JShell.main(new String[] {})
