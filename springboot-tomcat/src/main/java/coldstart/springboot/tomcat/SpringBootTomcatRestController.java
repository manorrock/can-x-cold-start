package coldstart.springboot.tomcat;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller that handles HTTP requests and provides timing metrics.
 * 
 * This controller responds to the /helloworld endpoint and returns timing information
 * about the application's cold start performance. It captures the timestamp of the
 * first request to complete the cold start timing data.
 */
@RestController
public class SpringBootTomcatRestController {
    
    /**
     * Lock object for synchronization.
     * Prevents race conditions when multiple concurrent requests try to set
     * the first request timestamp simultaneously.
     */
    private static final Object LOCK = new Object();
    
    /**
     * Handles requests to the /helloworld endpoint.
     * 
     * This method:
     * 1. Captures the timestamp of the first request in a thread-safe manner
     * 2. Returns a JSON response containing "Hello World!" message
     * 3. Includes detailed timing metrics about the application startup
     *
     * @return a Map containing the response message and timing metrics,
     *         which will be converted to JSON by Spring
     */
    @RequestMapping(value = "/helloworld")
    public Map<String, Object> helloWorld() {
        synchronized (LOCK) {
            if (SpringBootTomcatApplication.isFirstRequest) {
                SpringBootTomcatApplication.time3 = System.currentTimeMillis();
                SpringBootTomcatApplication.isFirstRequest = false;
            }
        }
        
        Map<String, Object> result = new HashMap<>();
        result.put("message", "Hello World!");
        result.put("timings", getTimings());
        
        return result;
    }
    
    /**
     * Generates a map containing all timing metrics for the application's cold start.
     * 
     * Creates a comprehensive set of timing data including:
     * - Raw timestamps for each phase of startup
     * - Duration between phases
     * - Total startup duration
     *
     * @return a Map containing all timing metrics which will be serialized to JSON
     */
    private Map<String, Object> getTimings() {
        Map<String, Object> timings = new HashMap<>();
        timings.put("startTime", SpringBootTomcatApplication.time1);
        timings.put("readyTime", SpringBootTomcatApplication.time2);
        timings.put("firstRequestTime", SpringBootTomcatApplication.time3);
        timings.put("startupDuration", SpringBootTomcatApplication.time2 - SpringBootTomcatApplication.time1);
        timings.put("firstRequestDuration", SpringBootTomcatApplication.time3 - SpringBootTomcatApplication.time2);
        timings.put("totalStartupDuration", SpringBootTomcatApplication.time3 - SpringBootTomcatApplication.time1);
        return timings;
    }
}
