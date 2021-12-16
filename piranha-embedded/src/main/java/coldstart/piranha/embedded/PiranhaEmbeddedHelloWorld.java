package coldstart.piranha.embedded;

import cloud.piranha.embedded.EmbeddedPiranha;
import cloud.piranha.embedded.EmbeddedPiranhaBuilder;
import cloud.piranha.http.impl.DefaultHttpServer;
import cloud.piranha.http.webapp.HttpWebApplicationServerProcessor;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PiranhaEmbeddedHelloWorld {

    public static String outputFilename = System.getenv("OUTPUT_FILENAME");

    public static long time1;

    public static long time2;

    public static long time3;

    public static void main(String[] arguments) throws Exception {
        time1 = System.currentTimeMillis();
        EmbeddedPiranha piranha = new EmbeddedPiranhaBuilder()
                .servlet("HelloWorld", PiranhaEmbeddedHelloWorldServlet.class)
                .build();

        DefaultHttpServer server = new DefaultHttpServer(8080,
                new HttpWebApplicationServerProcessor(piranha), false);

        server.start();
        time2 = System.currentTimeMillis();
    }

    /**
     * Write the results asynchronously.
     */
    public static void writeResults() {
        Thread thread = new Thread() {

            @Override
            public void run() {
                try (PrintWriter writer = new PrintWriter(new FileWriter(outputFilename, true))) {
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
