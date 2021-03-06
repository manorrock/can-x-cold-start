package coldstart.springboot.tomcat;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A Spring Boot Tomcat cold start example.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
@SpringBootApplication
public class SpringBootTomcatApplication {

    /**
     * Filename to store the results in.
     */
    private static String outputFilename;

    /**
     * Time 1 - Entering user code timestamp.
     */
    public static long time1;

    /**
     * Time 2 - Ready for processing timestamp.
     */
    public static long time2;

    /**
     * Time 3 - 1st request server side completed timestamp.
     */
    public static long time3;

    /**
     * Main method.
     *
     * @param arguments the command-line arguments.
     */
    public static void main(String[] arguments) {
        time1 = System.currentTimeMillis();
        outputFilename = arguments[0];
        SpringApplication.run(SpringBootTomcatApplication.class, arguments);
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
