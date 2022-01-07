package coldstart.piranha.server;

import java.util.Set;
import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PiranhaServerHelloWorldServletContainerInitializer implements ServletContainerInitializer {

    public static String outputFilename = System.getenv("OUTPUT_FILENAME");

    public static long time1;

    public static long time2;

    public static long time3;

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext sc) throws ServletException {
        time1 = System.currentTimeMillis();
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
