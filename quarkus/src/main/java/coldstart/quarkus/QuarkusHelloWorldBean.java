package coldstart.quarkus;

import io.quarkus.runtime.StartupEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class QuarkusHelloWorldBean {
    
    public static String outputFilename = System.getenv("OUTPUT_FILENAME");
    
    public static long time1;
    
    public static long time2;
    
    public static long time3;
    
    public void onStart(@Observes StartupEvent ev) {               
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
