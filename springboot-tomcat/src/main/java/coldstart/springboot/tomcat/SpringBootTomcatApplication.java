package coldstart.springboot.tomcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A Spring Boot Tomcat cold start example.
 * 
 * This class captures application startup timing metrics to measure cold start performance.
 * It records three key timestamps:
 * 1. When the application code first executes
 * 2. When the application is ready to process requests
 * 3. When the first HTTP request is processed
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
@SpringBootApplication
public class SpringBootTomcatApplication {

    /**
     * Time 1 - Entering user code timestamp.
     * Captured at the beginning of the main method to measure when application code first executes.
     */
    public static long time1;

    /**
     * Time 2 - Ready for processing timestamp.
     * Set by SpringBootTomcatReadyListener when the application is ready to accept requests.
     */
    public static long time2;

    /**
     * Time 3 - 1st request server side completed timestamp.
     * Set by SpringBootTomcatRestController when processing the first HTTP request.
     */
    public static long time3;
    
    /**
     * Flag to indicate if this is the first request.
     * Used to ensure time3 is set only once for the very first request.
     */
    public static boolean isFirstRequest = true;

    /**
     * Main method that starts the Spring Boot application.
     * Records the initial timestamp for measuring cold start performance.
     *
     * @param arguments the command-line arguments.
     */
    public static void main(String[] arguments) {
        time1 = System.currentTimeMillis();
        SpringApplication.run(SpringBootTomcatApplication.class, arguments);
    }
}
