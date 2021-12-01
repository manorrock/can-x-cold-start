package coldstart.springboot.tomcat;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SpringBootTomcatReadyListener implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        SpringBootTomcatApplication.time2 = System.currentTimeMillis();
    }
}
