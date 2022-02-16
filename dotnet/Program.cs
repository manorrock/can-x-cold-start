using System;
using System.Net;
using Microsoft.AspNetCore;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Server.Kestrel.Core;
using Microsoft.Extensions.Hosting;

public class Program
{
    public static void Main(string[] args)
    {
        Console.WriteLine("TIME1: " + DateTimeOffset.UtcNow.ToUnixTimeMilliseconds());
        Task task = CreateHostBuilder(args).Build().RunAsync();
        Console.WriteLine("TIME2: " + DateTimeOffset.UtcNow.ToUnixTimeMilliseconds());
        task.Wait();
    }

    public static IHostBuilder CreateHostBuilder(string[] args) =>
        Host.CreateDefaultBuilder(args)
            .ConfigureWebHostDefaults(webBuilder =>
            {
                webBuilder.ConfigureKestrel(serverOptions =>
                {
                    serverOptions.Listen(IPAddress.Loopback, 8080);
                }).UseStartup<Startup>();
            });
}
