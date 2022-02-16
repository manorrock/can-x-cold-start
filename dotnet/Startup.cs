
public class Startup
{
    public void Configure(IApplicationBuilder app)
        {
            app.Run(async (context) =>
            {
                context.Response.ContentType = "text/plain";
                await context.Response
                    .WriteAsync("Hello World!");
            });
        }
}
