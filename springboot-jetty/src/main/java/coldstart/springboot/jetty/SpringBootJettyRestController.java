package coldstart.springboot.jetty;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringBootJettyRestController {
    
    @RequestMapping(value = "/helloworld")
    public String helloWorld() {
        String result = "Hello World!";
        SpringBootJettyApplication.time3 = System.currentTimeMillis();
        SpringBootJettyApplication.writeResults();
        return result;
    }
}
