package helloworld;

import io.inverno.core.annotation.Bean;
import io.inverno.core.v1.Application;
import io.inverno.mod.web.annotation.WebController;
import io.inverno.mod.web.annotation.WebRoute;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Bean
@WebController
public class HelloWorld {

    public static String outputFilename = System.getenv("OUTPUT_FILENAME");

    public static long time1;

    public static long time2;

    public static long time3;

    @WebRoute(path = "/")
    public String hello() {
        time2 = System.currentTimeMillis();
        writeResults();
        return "Hello World";
    }

    public static void main(String[] args) {
        time1 = System.currentTimeMillis();
        Application.run(new Helloworld.Builder());
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
