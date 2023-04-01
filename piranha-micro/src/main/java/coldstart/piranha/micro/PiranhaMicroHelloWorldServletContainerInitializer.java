package coldstart.piranha.micro;

import coldstart.shared.Collector;
import java.util.Set;
import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

public class PiranhaMicroHelloWorldServletContainerInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext sc) throws ServletException {
        Collector.csvFilename = System.getProperty("csvFilename");
        Collector.time0 = Long.parseLong(System.getProperty("time0"));
        Collector.time1 = System.currentTimeMillis();
    }
}
