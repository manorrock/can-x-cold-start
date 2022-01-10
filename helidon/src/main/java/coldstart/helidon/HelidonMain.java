package coldstart.helidon;

import io.helidon.config.Config;
import io.helidon.webserver.Routing;
import io.helidon.webserver.WebServer;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public final class HelidonMain {

    public static String outputFilename = System.getenv("OUTPUT_FILENAME");

    public static long time1;

    public static long time2;

    public static long time3;

    public static void main(final String[] args) {
        time1 = System.currentTimeMillis();

        Config config = Config.create().get("server");

        WebServer server = WebServer.create(
                Routing.builder()
                        .get("", (request, response) -> {
                            time3 = System.currentTimeMillis();
                            writeResults();
                            response.send("Hello World");
                        })
                        .build(),
                config);

        server.start().thenRun(() -> {
            time2 = System.currentTimeMillis();
        });
    }
    
    /**
     * Write the results asynchronously.
     */
    public static void writeResults() {
        Thread thread = new Thread() {

            @Override
            public void run() {
                try ( PrintWriter writer = new PrintWriter(new FileWriter(outputFilename, true))) {
                    writer.println(time1);
                    writer.println(time2);
                    writer.println(time3);
                } catch (IOException ioe) {
                    // nothing to do here.
                }
            }
        };
        thread.start();
    }      
}
