package coldstart.wildfly;

import java.util.Set;
import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

public class HelloWorldServletContainerInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext sc) throws ServletException {
        sc.setAttribute("TIME1", System.currentTimeMillis());
    }
}
