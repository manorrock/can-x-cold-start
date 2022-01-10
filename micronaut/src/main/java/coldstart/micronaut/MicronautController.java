package coldstart.micronaut;

import static io.micronaut.http.MediaType.TEXT_PLAIN;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller("/")
public class MicronautController {

    public MicronautController() {
        MicronautApplication.time2 = System.currentTimeMillis();
    }

    @Get
    @Produces(TEXT_PLAIN)
    public String index() {
        MicronautApplication.time3 = System.currentTimeMillis();
        MicronautApplication.writeResults();
        return "Hello World";
    }    
}
