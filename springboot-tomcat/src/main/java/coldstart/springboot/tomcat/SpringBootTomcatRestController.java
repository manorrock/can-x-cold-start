package coldstart.springboot.tomcat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringBootTomcatRestController {
    
    @RequestMapping(value = "/helloworld")
    public String helloWorld() {
        String result = "Hello World!";
        SpringBootTomcatApplication.time3 = System.currentTimeMillis();
        SpringBootTomcatApplication.writeResults();
        return result;
    }
}
