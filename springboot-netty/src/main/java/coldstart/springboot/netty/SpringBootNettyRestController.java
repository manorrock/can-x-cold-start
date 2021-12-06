package coldstart.springboot.netty;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringBootNettyRestController {
    
    @RequestMapping(value = "/helloworld")
    public String helloWorld() {
        String result = "Hello World!";
        SpringBootNettyApplication.time3 = System.currentTimeMillis();
        SpringBootNettyApplication.writeResults();
        return result;
    }
}
