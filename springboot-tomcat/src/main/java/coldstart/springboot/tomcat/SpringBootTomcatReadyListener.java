package coldstart.springboot.tomcat;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * An event listener that captures the timestamp when the Spring Boot application
 * is fully initialized and ready to service requests.
 * 
 * This component is automatically registered with Spring and triggered when
 * the ApplicationReadyEvent occurs, which happens after the application context
 * is refreshed and any command-line runners have been called.
 */
@Component
public class SpringBootTomcatReadyListener implements ApplicationListener<ApplicationReadyEvent> {

    /**
     * Event handler that executes when the application is ready.
     * 
     * Captures the timestamp (time2) when the application has started up and is
     * ready to service requests. This is an important metric in cold start
     * time measurement as it represents when the server can begin processing.
     *
     * @param event the application ready event
     */
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        SpringBootTomcatApplication.time2 = System.currentTimeMillis();
    }
}
