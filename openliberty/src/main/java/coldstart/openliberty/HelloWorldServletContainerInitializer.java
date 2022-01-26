package coldstart.openliberty;

import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class HelloWorldServletContainerInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext sc) throws ServletException {
        sc.setAttribute("TIME1", System.currentTimeMillis());
    }
}
