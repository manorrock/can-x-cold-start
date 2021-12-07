package coldstart.springboot.undertow;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringBootUndertowRestController {
    
    @RequestMapping(value = "/helloworld")
    public String helloWorld() {
        String result = "Hello World!";
        SpringBootUndertowApplication.time3 = System.currentTimeMillis();
        SpringBootUndertowApplication.writeResults();
        return result;
    }
}
