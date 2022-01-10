package coldstart.quarkus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class QuarkusHelloWorldResource {
    
    public QuarkusHelloWorldResource() {
        QuarkusHelloWorldBean.time2 = System.currentTimeMillis();
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        QuarkusHelloWorldBean.time3 = System.currentTimeMillis();
        QuarkusHelloWorldBean.writeResults();
        return "Hello World";
    }
}
