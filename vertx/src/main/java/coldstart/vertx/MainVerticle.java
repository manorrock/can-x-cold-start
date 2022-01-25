package coldstart.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainVerticle extends AbstractVerticle {

    private String outputFilename;

    private long time1;

    private long time2;

    private long time3;    
    
    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        time1 = System.currentTimeMillis();
        vertx.createHttpServer().requestHandler(req -> {
            req.response()
                    .putHeader("content-type", "text/plain")
                    .end("Hello World!");
            time3 = System.currentTimeMillis();
        }).listen(8888, http -> {
            if (http.succeeded()) {
                startPromise.complete();
                time2 = System.currentTimeMillis();
            } else {
                startPromise.fail(http.cause());
            }
        });
    }

    /**
     * Write the results asynchronously.
     */
    public void writeResults() {
        Thread thread = new Thread() {

            @Override
            public void run() {
                try ( PrintWriter writer = new PrintWriter(new FileWriter(outputFilename, true))) {
                    writer.println(time1);
                    writer.println(time2);
                    writer.println(time3);
                } catch (IOException ioe) {
                    // nothing to do here.
                }
            }
        };
        thread.start();
    }    
}
