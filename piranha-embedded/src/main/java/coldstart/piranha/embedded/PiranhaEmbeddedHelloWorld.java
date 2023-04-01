package coldstart.piranha.embedded;

import cloud.piranha.embedded.EmbeddedPiranha;
import cloud.piranha.embedded.EmbeddedPiranhaBuilder;
import cloud.piranha.http.impl.DefaultHttpServer;
import cloud.piranha.http.webapp.HttpWebApplicationServerProcessor;
import coldstart.shared.Collector;

public class PiranhaEmbeddedHelloWorld {

    public static void main(String[] arguments) throws Exception {
        Collector.csvFilename = arguments[0];
        Collector.time0 = Long.parseLong(arguments[1]);
        Collector.time1 = System.currentTimeMillis();
        
        EmbeddedPiranha piranha = new EmbeddedPiranhaBuilder()
                .servlet("HelloWorld", PiranhaEmbeddedHelloWorldServlet.class)
                .servletMapping("HelloWorld", "")
                .buildAndStart();

        DefaultHttpServer server = new DefaultHttpServer(8000,
                new HttpWebApplicationServerProcessor(piranha), false);

        server.start();
        Collector.time2 = System.currentTimeMillis();
    }
}
