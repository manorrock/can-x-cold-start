package coldstart.micronaut;

import io.micronaut.runtime.Micronaut;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MicronautApplication {

    public static String outputFilename = System.getenv("OUTPUT_FILENAME");

    public static long time1;

    public static long time2;

    public static long time3;

    public static void main(String[] args) {
        MicronautApplication.time1 = System.currentTimeMillis();
        Micronaut.run(MicronautApplication.class, args);
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
